```mysql
update salary set sex = (case sex when 'm' then 'f' else 'm' end)
```

学习了case when

```mysql
case 班级
     when 1 then 2    #将1换为2
     when 2 then 1    #将2换为1
     else 3            #剩下值（0）换为3
end

```

