# N-th Highest Salary
​
```
SELECT e1.salary AS SecondHighestSalary
FROM   employee e1
WHERE  1 = (SELECT Count(DISTINCT( id ))
FROM   employee e2
WHERE  e2.salary > e1.salary)
```