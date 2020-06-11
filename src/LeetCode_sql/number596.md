```mysql
select class from courses  group by class having count(distinct  student) >= 5

1.获得每门课程的学生数量
select class,count(distinct student) from courses group by class
2.使用上面查询结果的临时表进行子查询，筛选学生数量超过 5 的课程。
select class from (select class,count(distinct student) as num from courses group by class) as temp_table where num > 5

```

