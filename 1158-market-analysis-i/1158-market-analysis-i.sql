with new as (select order_id ,order_date ,buyer_id ,count(buyer_id ) as c
from Orders 
where YEAR(order_date )='2019'
group by buyer_id )

select u.user_id as buyer_id  ,  u.join_date  ,
IFNULL(n.c, 0) as orders_in_2019 
from Users u left join new n
on u.user_id =  n.buyer_id
