```mysql
因为 Employee 表包含 Salary 和 DepartmentId 字段，我们可以以此在部门内查询最高工资。
SELECT
    DepartmentId, MAX(Salary)
FROM
    Employee
GROUP BY DepartmentId;

SELECT
    Department.name AS 'Department',
    Employee.name AS 'Employee',
    Salary
FROM
    Employee
        JOIN
    Department ON Employee.DepartmentId = Department.Id
WHERE
    (Employee.DepartmentId , Salary) IN
    (   SELECT
            DepartmentId, MAX(Salary)
        FROM
            Employee
        GROUP BY DepartmentId
	)
;



Select d1.`Name` as Department,e1.`Name` as Employee,e1.Salary
from Employee e1,department d1
where e1.Salary = (Select MAX(Salary) from Employee where DepartmentId = e1.DepartmentId)
and e1.DepartmentId = d1.Id


```