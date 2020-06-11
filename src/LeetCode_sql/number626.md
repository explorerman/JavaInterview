```mysql
select a.name AS 'Employee' from  Employee a, Employee b where a.ManagerId = b.Id and a.Salary > b.Salary

select a.name AS 'Employee' from Employee a join Employee b on (a.ManagerId = b.Id and a.Salary > b.Salary)
```