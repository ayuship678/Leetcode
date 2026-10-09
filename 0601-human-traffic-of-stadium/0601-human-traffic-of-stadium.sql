WITH rankedvisits AS
(
SELECT id, visit_date, people,
LEAD(people,1) OVER() AS LEAD1, LEAD(people,2) OVER() AS LEAD2,
LEAD(people,3) OVER() AS LEAD3,
LAG(people,1) OVER() AS LAG1, LAG(people,2) OVER() AS LAG2,
LAG(people,3) OVER() AS LAG3
FROM Stadium
)
SELECT id, visit_date, people
FROM rankedvisits
WHERE 
(people >=100 AND LEAD1 >=100 AND LEAD2 >=100) 
OR
(LAG1>=100 AND people >=100 AND LEAD1>=100)    
OR
(LAG1>=100 and LAG2>=100 AND people >=100)     