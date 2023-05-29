package com.onlydan.od.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlydan.od.dto.custom.TopCustomersDTO;
import com.onlydan.od.enums.Gender;
import com.onlydan.od.entities.security.RoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(
        name = "Accounts.getTopCustomersFromDateRange",
        query = """
                    WITH top_customers AS (
                        SELECT DISTINCT a.account_id, a.account_name,
                        CONCAT(a.first_name || ' ' || a.last_name) as customer_name,
                        o.order_id
                        FROM order_details od, orders o, payment_details pd, accounts a
                        WHERE od.order_id =  o.order_id
                        AND o.payment_details_id = pd.payment_details_id
                        AND pd.account_id = a.account_id
                        AND od.order_date BETWEEN :startDate AND :endDate
                    )
                    SELECT tc.customer_name, count(tc.order_id) AS number_of_purchases
                    FROM top_customers tc
                    GROUP BY tc.customer_name
                    ORDER BY number_of_purchases desc
                    LIMIT :topN
                """,
        resultSetMapping = "TopCustomersDTOMapping")

@SqlResultSetMapping(
        name = "TopCustomersDTOMapping",
        classes = @ConstructorResult(
                targetClass = TopCustomersDTO.class,
                columns = {
                        @ColumnResult(name = "customer_name", type = String.class),
                        @ColumnResult(name = "number_of_purchases", type = Integer.class)
                }
        )
)

public class Accounts {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    @UpdateTimestamp
    @Column
    private LocalDateTime creationDate;

    @Column
    private String accountName;

    @Column
    @JsonIgnore
    private String accountPassword;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoleAssignment> roles;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
