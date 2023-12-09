
--Daily Zoo Activity
SELECT dateTime, COUNT(*) AS ActivityCount
FROM Revenue_Events
WHERE dateTime = '05-DEC-23'
GROUP BY dateTime;

--Daily Revenue
SELECT R.dateTime, RT.name AS RevenueSource, SUM(R.revenue) AS TotalRevenue
FROM Revenue_Events R
JOIN Revenue_Types RT ON R.revenueId = RT.revenueTypeId
WHERE R.dateTime = '05-DEC-23'
GROUP BY R.dateTime, RT.name;

--Animal Population by Species
SELECT s.name AS Species, COUNT(*) AS Population
FROM ANIMAL a
JOIN SPECIES s ON a.speciesId = s.id
WHERE a.birthYear <= '01-DEC-23'
GROUP BY s.name

  
--Top 3 Attractions
SELECT r.name AS attraction, SUM(revenue) AS totalRevenue
FROM Revenue_Events re
JOIN Revenue_Types r ON re.revenueId = r.revenueTypeId
WHERE re.datetime = '05-DEC-23'
GROUP BY r.name
ORDER BY totalRevenue DESC
FETCH FIRST 3 ROWS ONLY;


--5 Best Days
SELECT dateTime , SUM(revenue) AS totalRevenue
FROM Revenue_Events
WHERE TRUNC(dateTime)= '05-DEC-23'
GROUP BY dateTime
ORDER BY totalRevenue DESC
FETCH FIRST 5 ROWS ONLY;

--avg revenue
SELECT AVG(revenue) AS averageRevenue
FROM Revenue_Events
WHERE dateTime = '05-DEC-23'





