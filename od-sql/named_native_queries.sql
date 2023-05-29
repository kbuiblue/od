WITH daily_revenue AS (
    SELECT DISTINCT  od.order_date, pi2.product_name, od.product_price, od.product_quantity
    FROM order_details od, product_info pi2, inventory i, stock_changes sc
    WHERE od.product_id =  pi2.product_id
    AND i.product_id = pi2.product_id
    AND i.stock_change_id = sc.stock_change_id
    AND sc.change_type = 'OUTGOING'
    AND od.order_date BETWEEN '2022-04-01' AND '2022-07-01'
)
SELECT dr.order_date, SUM(dr.product_price * dr.product_quantity) AS daily_revenue
FROM daily_revenue dr
GROUP BY dr.order_date
ORDER BY order_date ASC;


WITH daily_orders AS (
	select distinct od.order_date, od.order_id
	from order_details od, product_info pi2, inventory i, stock_changes sc
	where od.product_id =  pi2.product_id
	and i.product_id = pi2.product_id
	and i.stock_change_id = sc.stock_change_id
	and sc.change_type = 'OUTGOING'
	and od.order_date between '2022-04-01' and '2022-07-01'
	order by order_date asc
)
SELECT do2.order_date, count(do2.order_id) AS daily_orders
FROM daily_orders do2
group by do2.order_date
ORDER BY order_date ASC;

WITH top_sales AS (
    SELECT DISTINCT pi2.product_name, od.product_price, od.product_quantity
    FROM order_details od, product_info pi2, inventory i, stock_changes sc
    WHERE od.product_id =  pi2.product_id
    AND i.product_id = pi2.product_id
    AND i.stock_change_id = sc.stock_change_id
    AND sc.change_type = 'OUTGOING'
    AND od.order_date BETWEEN '2022-04-01' AND '2022-07-01'
)
SELECT ts.product_name, SUM(ts.product_quantity) AS sales_amount
FROM top_sales ts
GROUP BY ts.product_name
ORDER BY sales_amount DESC
LIMIT 3;

WITH worst_sales AS (
    SELECT DISTINCT pi2.product_name, od.product_price, od.product_quantity
    FROM order_details od, product_info pi2, inventory i, stock_changes sc
    WHERE od.product_id =  pi2.product_id
    AND i.product_id = pi2.product_id
    AND i.stock_change_id = sc.stock_change_id
    AND sc.change_type = 'OUTGOING'
    AND od.order_date BETWEEN '2022-04-01' AND '2022-07-01'
)
SELECT ws.product_name, SUM(ws.product_quantity) AS sales_amount
FROM worst_sales ws
GROUP BY ws.product_name
ORDER BY sales_amount asc
LIMIT 3;