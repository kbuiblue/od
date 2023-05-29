package com.onlydan.od.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "OrderDetails.getDailyRevenueFromDateRange",
                query = """
                            WITH daily_revenue AS (
                                SELECT DISTINCT  od.order_date, pi2.product_name, od.product_price, od.product_quantity
                                FROM order_details od, product_info pi2, inventory i, stock_changes sc
                                WHERE od.product_id =  pi2.product_id
                                AND i.product_id = pi2.product_id
                                AND i.stock_change_id = sc.stock_change_id
                                AND sc.change_type = 'OUTGOING'
                                AND od.order_date BETWEEN :startDate AND :endDate
                            )
                            SELECT dr.order_date AS order_date, SUM(dr.product_price * dr.product_quantity) AS daily_revenue
                            FROM daily_revenue dr
                            GROUP BY dr.order_date
                            ORDER BY dr.order_date ASC
                        """,
                resultSetMapping = "DailyRevenueDTOMapping"
        ),
        @NamedNativeQuery(
                name = "OrderDetails.getDailyOrdersFromDateRange",
                query = """
                            WITH daily_orders AS (
                                select distinct od.order_date, od.order_id
                                from order_details od, product_info pi2, inventory i, stock_changes sc
                                where od.product_id =  pi2.product_id
                                and i.product_id = pi2.product_id
                                and i.stock_change_id = sc.stock_change_id
                                and sc.change_type = 'OUTGOING'
                                and od.order_date between :startDate and :endDate
                                order by order_date asc
                            )
                            SELECT do2.order_date, count(do2.order_id) AS daily_orders
                            FROM daily_orders do2
                            group by do2.order_date
                            ORDER BY order_date ASC
                        """,
                resultSetMapping = "DailyOrdersDTOMapping"
        ),
        @NamedNativeQuery(
                name = "OrderDetails.getBestSellingProductsFromDateRange",
                query = """
                            WITH best_selling AS (
                                SELECT DISTINCT pi2.product_name, od.product_price, od.product_quantity
                                FROM order_details od, product_info pi2, inventory i, stock_changes sc
                                WHERE od.product_id =  pi2.product_id
                                AND i.product_id = pi2.product_id
                                AND i.stock_change_id = sc.stock_change_id
                                AND sc.change_type = 'OUTGOING'
                                AND od.order_date BETWEEN :startDate AND :endDate
                            )
                            SELECT bs.product_name, SUM(bs.product_quantity) AS sales_amount
                            FROM best_selling bs
                            GROUP BY bs.product_name
                            ORDER BY sales_amount DESC
                            LIMIT :topN
                        """,
                resultSetMapping = "BestSellingProductsDTOMapping"
        ),
        @NamedNativeQuery(
                name = "OrderDetails.getWorstSellingProductsFromDateRange",
                query = """
                        WITH worst_sales AS (
                            SELECT DISTINCT pi2.product_name, od.product_price, od.product_quantity\s
                            FROM order_details od, product_info pi2, inventory i, stock_changes sc \s
                            WHERE od.product_id =  pi2.product_id\s
                            AND i.product_id = pi2.product_id
                            AND i.stock_change_id = sc.stock_change_id
                            AND sc.change_type = 'OUTGOING'
                            AND od.order_date BETWEEN :startDate AND :endDate
                        )
                        SELECT ws.product_name, SUM(ws.product_quantity) AS sales_amount
                        FROM worst_sales ws
                        GROUP BY ws.product_name
                        ORDER BY sales_amount ASC
                        LIMIT :topN
                    """,
                resultSetMapping = "WorstSellingProductsDTOMapping"
        )}
)

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "DailyRevenueDTOMapping",
                classes = @ConstructorResult(
                        targetClass = com.onlydan.od.dto.DailyRevenueDTO.class,
                        columns = {
                                @ColumnResult(name = "order_date", type = LocalDate.class),
                                @ColumnResult(name = "daily_revenue", type = Double.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "DailyOrdersDTOMapping",
                classes = @ConstructorResult(
                        targetClass = com.onlydan.od.dto.DailyOrdersDTO.class,
                        columns = {
                                @ColumnResult(name = "order_date", type = LocalDate.class),
                                @ColumnResult(name = "daily_orders", type = Integer.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "BestSellingProductsDTOMapping",
                classes = @ConstructorResult(
                        targetClass = com.onlydan.od.dto.BestSellingProductsDTO.class,
                        columns = {
                                @ColumnResult(name = "product_name", type = String.class),
                                @ColumnResult(name = "sales_amount", type = Integer.class)
                        }
                )
        ),
        @SqlResultSetMapping(
                name = "WorstSellingProductsDTOMapping",
                classes = @ConstructorResult(
                        targetClass = com.onlydan.od.dto.WorstSellingProductsDTO.class,
                        columns = {
                                @ColumnResult(name = "product_name", type = String.class),
                                @ColumnResult(name = "sales_amount", type = Integer.class)
                        }
                )
        )}
)

public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDetailsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private ProductInfo productInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;

    @Column(precision = 10, scale = 2)
    private Double productPrice;

    @Column
    private Boolean isOnSale;

    @Column
    private Double salePercentage;

    @Column
    private Integer productQuantity;

    @Column
    private LocalDate orderDate;
}
