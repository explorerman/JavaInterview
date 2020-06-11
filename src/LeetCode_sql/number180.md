```mysql
select distinct a.Num as ConsecutiveNums from Logs a, Logs b, Logs c where a.Id = b.Id - 1 and b.Id = c.Id - 1 and a.Num = b.Num and b.Num = c.Num;
```

[参考猴子的讲解](https://leetcode-cn.com/problems/consecutive-numbers/solution/tu-jie-mian-shi-ti-zhao-chu-lian-xu-chu-xian-nci-d/)