```mysql
select weather.id as 'Id' from weather join weather w on DATEDIFF(weather.RecordDate,w.RecordDate) = 1 and weather.Temperature > w.Temperature
```

