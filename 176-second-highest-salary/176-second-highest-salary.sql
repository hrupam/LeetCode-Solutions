/* Write your T-SQL query statement below */
SELECT Max(salary) AS SecondHighestSalary
FROM   employee
WHERE  salary <> (SELECT Max(salary)
                  FROM   employee) 