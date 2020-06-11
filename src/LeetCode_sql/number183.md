```mysql
select c.name as 'Customers' from customers c where c.id not in (select customerid from orders)
select a.name as 'Customers' from customers a left join Orders b on a.id = b.CustomerId where b.CustomerId is null;
```

