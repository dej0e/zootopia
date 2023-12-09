--  For a given day, a report of the revenue by source, with detail lines and subtotals.
SELECT
    re.dateTime AS eventDate,
    rt.name AS event,
    re.ticketsSold AS ticketsSold,
    re.revenue AS totalRevenue
FROM
    Revenue_Events re
        JOIN
    Revenue_Types rt ON re.revenueId = rt.revenueTypeId
        JOIN
    Concession cn ON rt.revenueTypeId = cn.revenueId
WHERE
        re.dateTime = '15-SEP-2023';

--- Produce a report of the animal population by species, including totals by status, total monthly food cost and costs for assigned veterinarians and animal care specialists (assume a 40 hour work week).
SELECT
    s.name AS species,
    a.status,
    COUNT(a.id) AS animalCount,
    SUM(s.foodCost) AS totalFoodCost,
    SUM(CASE WHEN e.jobType = 'Veterinarian' THEN hr.RATE * 40 * 4 ELSE 0 END) AS VetCost,
    SUM(CASE WHEN e.jobType = 'Animal Care Specialist' THEN hr.RATE * 40 * 4 ELSE 0 END) AS ACSpecialistCost
FROM
    ANIMAL a
        JOIN
    SPECIES s ON a.speciesId = s.id
        JOIN
    Cares_For cf ON a.speciesId = cf.speciesId
        JOIN
    EMPLOYEE e ON cf.employeeId = e.id
        JOIN
    AA3577.HOURLYRATE hr ON e.HOURLYRATEID = hr.ID
GROUP BY
    s.name,
    a.status;

--Top 3 Attractions
SELECT r.name AS attraction, SUM(revenue) AS totalRevenue
FROM Revenue_Events re
         JOIN Revenue_Types r ON re.revenueId = r.revenueTypeId
WHERE re.datetime  BETWEEN '2-JAN-23' AND '05-DEC-23'
GROUP BY r.name
ORDER BY totalRevenue DESC
    FETCH FIRST 3 ROWS ONLY;


--5 Best Days
SELECT dateTime , SUM(revenue) AS totalRevenue
FROM Revenue_Events
WHERE TRUNC(dateTime) BETWEEN '2-JAN-23' AND '05-DEC-23'
GROUP BY dateTime
ORDER BY totalRevenue DESC
    FETCH FIRST 5 ROWS ONLY;

--For a given time period (begin date and end date) compute the average revenue for each attraction, concession, and total attendance.
SELECT
    rt.name AS revenueSource,
    ROUND(AVG(re.revenue), 2) AS averageRevenue,
    SUM(re.ticketsSold) AS totalAttendance
FROM
    Revenue_Types rt
        JOIN
    Revenue_Events re ON rt.revenueTypeId = re.revenueId
WHERE
    re.dateTime BETWEEN '15-JAN-23' AND '15-DEC-23'
GROUP BY
    rt.name
ORDER BY
    AverageRevenue DESC;

