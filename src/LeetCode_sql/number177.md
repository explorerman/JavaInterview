```mysql
BEGIN
      # Write your MySQL query statement below.
      if N < 0 then 
      return (select min(Salary) from Emplyee);
      else
      set N = N - 1
      return(select ifnull((select distinct Salary from Employee order by Salary desc limit N,1),null) as NthHighestSalay );
      end if;
END
```

IFNULL(expression, alt_value)
如果第一个参数的表达式 expression 为 NULL，则返回第二个参数的备用值(此题中是返回null)。
expression是table的时候要加括号

distinct：
去重一样的Salary

limit：限时返回的个数
offset：跳过几个
limit 1 offset 1:返回一个结果，跳过一个
例如返回第三高就是：limit 1 offset 2

返回第二高就是：limit 1 offset 1

