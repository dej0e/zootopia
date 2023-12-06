
UPDATE EMPLOYEE SET startDate= '6-DEC-06', jobType = 'Manager', first='chris', minit= 'a', last= 'evans', street='1st st', city='harrison', state=' tamil nadu'  WHERE id = 1;

UPDATE HourlyRate SET rate = 17.00 WHERE id = 1;

UPDATE SPECIES SET foodCost = 1200.00 WHERE id = 1;

UPDATE ENCLOSURE SET sqft = 5500.00 WHERE id = 1;

UPDATE ANIMAL SET status = 'Available', birthYear = '20-MAR-15', enclosureId = 1 WHERE id = 1;

UPDATE BUILDING SET name = 'Center', type= 'attraction' WHERE id = 1;

UPDATE Revenue_Types SET name = 'Entrance', type= 'ticket' WHERE revenueTypeId = 1;

UPDATE Revenue_Events SET ticketsSold = 120, revenue = 1800.00 WHERE dateTime = '05-DEC-23' AND revenueId = 1;

UPDATE Animal_Show SET seniorPrice = 12.00, adultPrice = 25.00, childPrice = 7.00, numberPerDay = 3 WHERE revenueId = 1;

UPDATE CONCESSION SET product = 'Candy' WHERE revenueId = 1;

UPDATE Zoo_Admission SET seniorPrice = 15.00, adultPrice = 30.00, childPrice = 10.00 WHERE revenueId = 1;

UPDATE Participates_In SET numberRequired = 3 WHERE speciesId = 1 AND animalShowRevenueId = 1;
