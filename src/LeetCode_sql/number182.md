```mysql
select DISTINCT  a.Email from Person a, Person b where a.Email = b.Email and a.id != b.id

select a.Email from Person a group by a.Email having count(a.Email) > 1

select Email from (select Email, count(Email) as num from Person group by Email) as statistic where num > 1 
```

