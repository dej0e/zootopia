-- Insert data into EMPLOYEE table
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(1, TO_DATE('2010-01-15', 'YYYY-MM-DD'), 'Maintenance', 'John', 'D', 'Doe', '123 Main St', 'Cityville', 'CA', 12345, 1, NULL, 2, 3);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(2, TO_DATE('2015-03-20', 'YYYY-MM-DD'), 'Maintenance', 'Jane', 'M', 'Smith', '456 Oak Ave', 'Townburg', 'NY', 56789, 2, 1, 1, NULL);

INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES (3, TO_DATE('2018-07-10', 'YYYY-MM-DD'), 'Maintenance', 'Robert', 'L', 'Johnson', '789 Pine Blvd', 'Villagetown', 'TX', 98765, 3, 1, NULL, 4);

INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(4, TO_DATE('2012-05-28', 'YYYY-MM-DD'), 'Maintenance', 'Emily', 'R', 'Williams', '101 Cedar Ln', 'Hamletville', 'FL', 54321, 4, NULL, 6, 5);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(5, TO_DATE('2017-11-12', 'YYYY-MM-DD'), 'Customer Service', 'Michael', 'J', 'Brown', '222 Elm St', 'Citytown', 'AZ', 67890, 5, 1, 7, 6);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(6, TO_DATE('2013-08-22', 'YYYY-MM-DD'), 'Maintenance', 'Sarah', 'A', 'Jones', '333 Birch Ave', 'Ruraltown', 'GA', 13579, 6, 1, 8, 7);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(7, TO_DATE('2016-09-05', 'YYYY-MM-DD'), 'Customer Service', 'Daniel', 'P', 'Miller', '444 Maple Dr', 'Suburbville', 'WA', 24680, 7, 1, 4, NULL);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(8, TO_DATE('2014-04-14', 'YYYY-MM-DD'), 'Ticket Seller', 'Olivia', 'S', 'Davis', '555 Pine Ln', 'Countryside', 'OH', 97531, 8, 1 , 4 , 8);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(9, TO_DATE('2019-01-18', 'YYYY-MM-DD'), 'Veterinarian', 'James', 'K', 'Taylor', '666 Oak Dr', 'Villageville', 'NC', 35791, 9, 1, 2, 9);
INSERT INTO EMPLOYEE (id, startDate, jobType, first, minit, last, street, city, state, zip, hourlyrateID, supervisorID, concessionRevenueID, zooAdmissionRevenueID)
VALUES(10, TO_DATE('2011-12-01', 'YYYY-MM-DD'), 'Animal Care Specialist', 'Emma', 'F', 'Wilson', '777 Cedar Blvd', 'Cityland', 'MI', 80234, 10, 1, 1, 10);

-- Insert data into HourlyRate table
INSERT INTO HourlyRate (id, rate) VALUES(1, 15.5);
INSERT INTO HourlyRate (id, rate) VALUES(2, 18.0);
INSERT INTO HourlyRate (id, rate) VALUES(3, 20.25);
INSERT INTO HourlyRate (id, rate) VALUES(4, 22.0);
INSERT INTO HourlyRate (id, rate) VALUES(5, 25.5);
INSERT INTO HourlyRate (id, rate) VALUES(6, 19.75);
INSERT INTO HourlyRate (id, rate) VALUES(7, 21.0);
INSERT INTO HourlyRate (id, rate) VALUES(8, 23.5);
INSERT INTO HourlyRate (id, rate) VALUES(9, 26.0);
INSERT INTO HourlyRate (id, rate) VALUES(10, 24.75);

-- Insert data into SPECIES table
INSERT INTO SPECIES (id, name, foodCost) VALUES(1, 'Lion', 150.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(2, 'Tiger', 120.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(3, 'Elephant', 200.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(4, 'Giraffe', 100.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(5, 'Penguin', 50.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(6, 'Kangaroo', 80.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(7, 'Zebra', 110.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(8, 'Panda', 180.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(9, 'Leopard', 130.0);
INSERT INTO SPECIES (id, name, foodCost) VALUES(10, 'Gorilla', 160.0);

-- Insert data into BUILDING table
INSERT INTO BUILDING (id, name, type) VALUES(1, 'Building A', 'Exhibit');
INSERT INTO BUILDING (id, name, type) VALUES(2, 'Building B', 'Enclosure');
INSERT INTO BUILDING (id, name, type) VALUES(3, 'Building C', 'Theater');
INSERT INTO BUILDING (id, name, type) VALUES(4, 'Building D', 'Cafeteria');
INSERT INTO BUILDING (id, name, type) VALUES(5, 'Building E', 'Entrance');
INSERT INTO BUILDING (id, name, type) VALUES(6, 'Building F', 'Gift Shop');
INSERT INTO BUILDING (id, name, type) VALUES(7, 'Building G', 'Restrooms');
INSERT INTO BUILDING (id, name, type) VALUES(8, 'Building H', 'Play Area');
INSERT INTO BUILDING (id, name, type) VALUES(9, 'Building I', 'Admin');
INSERT INTO BUILDING (id, name, type) VALUES(10, 'Building J', 'Park Lot');

-- Insert data into ENCLOSURE table
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(1, 2, 5000.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(2, 2, 4500.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(3, 2, 6000.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(4, 2, 5500.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(5, 2, 4800.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(6, 2, 5200.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(7, 2, 4700.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(8, 2, 5100.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(9, 2, 5800.0);
INSERT INTO ENCLOSURE (id, buildingId, sqft) VALUES(10, 2, 5300.0);

-- Insert data into ANIMAL table
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(1, 2, 1, 'Healthy', TO_DATE('2015-05-20', 'YYYY-MM-DD'), 1);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(2, 2, 2, 'Sick', TO_DATE('2018-10-15', 'YYYY-MM-DD'), 2);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(3, 2, 3, 'Healthy', TO_DATE('2016-07-03', 'YYYY-MM-DD'), 3);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(4, 2, 4, 'Healthy', TO_DATE('2019-02-28', 'YYYY-MM-DD'), 4);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(5, 2, 5, 'Sick', TO_DATE('2017-12-10', 'YYYY-MM-DD'), 5);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(6, 2, 6, 'Healthy', TO_DATE('2014-08-22', 'YYYY-MM-DD'), 6);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(7, 2, 7, 'Healthy', TO_DATE('2015-11-05', 'YYYY-MM-DD'), 7);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(8, 2, 8, 'Sick', TO_DATE('2018-04-14', 'YYYY-MM-DD'), 8);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(9, 2, 9, 'Healthy', TO_DATE('2016-09-18', 'YYYY-MM-DD'), 9);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(10, 2, 10, 'Healthy', TO_DATE('2013-12-01', 'YYYY-MM-DD'), 10);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(11, 2, 3, 'Healthy', TO_DATE('2019-06-12', 'YYYY-MM-DD'), 3);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(12, 2, 7, 'Sick', TO_DATE('2018-04-05', 'YYYY-MM-DD'), 7);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(13, 2, 2, 'Healthy', TO_DATE('2017-11-28', 'YYYY-MM-DD'), 2);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(14, 2, 8, 'Healthy', TO_DATE('2015-10-20', 'YYYY-MM-DD'), 8);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(15, 2, 1, 'Sick', TO_DATE('2016-09-03', 'YYYY-MM-DD'), 1);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(16, 2, 5, 'Healthy', TO_DATE('2014-07-15', 'YYYY-MM-DD'), 5);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(17, 2, 4, 'Healthy', TO_DATE('2018-02-10', 'YYYY-MM-DD'), 4);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(18, 2, 6, 'Sick', TO_DATE('2017-05-22', 'YYYY-MM-DD'), 6);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(19, 2, 9, 'Healthy', TO_DATE('2016-08-18', 'YYYY-MM-DD'), 9);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(20, 2, 10, 'Healthy', TO_DATE('2013-11-25', 'YYYY-MM-DD'), 10);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(21, 2, 6, 'Sick', TO_DATE('2017-05-22', 'YYYY-MM-DD'), 9);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(22, 2, 9, 'Healthy', TO_DATE('2016-08-18', 'YYYY-MM-DD'), 9);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(23, 2, 10, 'Healthy', TO_DATE('2013-11-25', 'YYYY-MM-DD'), 1);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(24, 2, 8, 'Healthy', TO_DATE('2015-10-20', 'YYYY-MM-DD'), 1);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(25, 2, 1, 'Sick', TO_DATE('2016-09-03', 'YYYY-MM-DD'), 1);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(26, 2, 5, 'Healthy', TO_DATE('2014-07-15', 'YYYY-MM-DD'), 5);
INSERT INTO ANIMAL (id, buildingId, speciesId, status, birthYear, enclosureId) VALUES(27, 2, 4, 'Healthy', TO_DATE('2018-02-10', 'YYYY-MM-DD'), 4);

-- Insert data into Revenue_Types table
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(1, 'Ticket Sales', 'Zoo Admission', 5);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(2, 'Concess Sales', 'Concession', 4);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(3, 'Show sales', 'Animal Show', 3);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(4, 'Gift Shop', 'Concession', 6);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(5, 'Parking Fees', 'Concession', 10);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(6, 'Memberships', 'Zoo Admission', 5);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(7, 'Donations', 'Concession', 9);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(8, 'Rentals', 'Zoo Admission', 1);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(9, 'Education show', 'Animal Show', 3);
INSERT INTO Revenue_Types (revenueTypeId, name, type, buildingId) VALUES(10, 'Special Events', 'Animal Show', 2);

-- Insert data into Revenue_Events table
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-01-15', 'YYYY-MM-DD'), 1, 200.0, 1500.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-02-20', 'YYYY-MM-DD'), 2, 50.0, 300.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-03-10', 'YYYY-MM-DD'), 3, 100.0, 1000.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-04-05', 'YYYY-MM-DD'), 4, NULL, 800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-05-12', 'YYYY-MM-DD'), 5, NULL, 200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-06-28', 'YYYY-MM-DD'), 6, 120.0, 900.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-07-15', 'YYYY-MM-DD'), 7, NULL, 400.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-08-22', 'YYYY-MM-DD'), 8, 30.0, 600.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-09-10', 'YYYY-MM-DD'), 9, NULL, 1200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-10-18', 'YYYY-MM-DD'), 10, 15.0, 250.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-01-14', 'YYYY-MM-DD'), 1, 200.0, 1500.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2023-02-21', 'YYYY-MM-DD'), 2, 50.0, 300.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-03-10', 'YYYY-MM-DD'), 3, 100.0, 1000.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-04-05', 'YYYY-MM-DD'), 4, NULL, 800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-05-12', 'YYYY-MM-DD'), 5, NULL, 200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-06-28', 'YYYY-MM-DD'), 6, 120.0, 900.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-07-15', 'YYYY-MM-DD'), 7, NULL, 400.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-08-22', 'YYYY-MM-DD'), 8, 30.0, 600.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-09-10', 'YYYY-MM-DD'), 9, NULL, 1200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES(TO_DATE('2022-10-18', 'YYYY-MM-DD'), 10, 15.0, 250.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-11-01', 'YYYY-MM-DD'), 3, 50.0, 500.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-12-15', 'YYYY-MM-DD'), 4, 80.0, 800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-01-20', 'YYYY-MM-DD'), 5, 120.0, 1200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-02-10', 'YYYY-MM-DD'), 6, 90.0, 900.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-03-05', 'YYYY-MM-DD'), 7, 150.0, 1500.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-04-18', 'YYYY-MM-DD'), 8, 100.0, 1000.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-05-22', 'YYYY-MM-DD'), 9, 70.0, 700.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-06-28', 'YYYY-MM-DD'), 10, 110.0, 1100.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-07-15', 'YYYY-MM-DD'), 1, 180.0, 1800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2024-08-08', 'YYYY-MM-DD'), 2, 40.0, 400.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-02-15', 'YYYY-MM-DD'), 1, 150.0, 1200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 2, 30.0, 250.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 3, 75.0, 800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 4, NULL, 650.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-01-15', 'YYYY-MM-DD'), 5, NULL, 300.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-02-15', 'YYYY-MM-DD'), 6, 45.0, 500.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-02-15', 'YYYY-MM-DD'), 7, NULL, 200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-02-15', 'YYYY-MM-DD'), 8, 18.0, 350.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-03-15', 'YYYY-MM-DD'), 9, NULL, 900.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-03-15', 'YYYY-MM-DD'), 10, 10.0, 120.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-07-15', 'YYYY-MM-DD'), 1, 180.0, 1800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-08-15', 'YYYY-MM-DD'), 2, 40.0, 400.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-04-15', 'YYYY-MM-DD'), 1, 150.0, 1200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-05-15', 'YYYY-MM-DD'), 2, 30.0, 250.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-06-15', 'YYYY-MM-DD'), 3, 75.0, 800.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-07-15', 'YYYY-MM-DD'), 4, NULL, 650.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-08-15', 'YYYY-MM-DD'), 5, NULL, 300.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-09-15', 'YYYY-MM-DD'), 6, 45.0, 500.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-10-15', 'YYYY-MM-DD'), 7, NULL, 200.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-11-15', 'YYYY-MM-DD'), 8, 18.0, 350.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-12-15', 'YYYY-MM-DD'), 9, NULL, 900.0);
INSERT INTO Revenue_Events (dateTime, revenueId, ticketsSold, revenue) VALUES (TO_DATE('2023-03-1', 'YYYY-MM-DD'), 10, 10.0, 120.0);




-- Insert data into Animal_Show table
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(1, 10.0, 15.0, 8.0, 2);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(2, 12.0, 18.0, 10.0, 1);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(3, 8.0, 12.0, 6.0, 3);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(4, 11.0, 16.0, 9.0, 2);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(5, 13.0, 20.0, 11.0, 1);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(6, 9.0, 14.0, 7.0, 2);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(7, 15.0, 22.0, 12.0, 1);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(8, 14.0, 21.0, 10.0, 3);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(9, 10.0, 15.0, 8.0, 2);
INSERT INTO Animal_Show (revenueId, seniorPrice, adultPrice, childPrice, numberPerDay) VALUES(10, 12.0, 18.0, 10.0, 1);

-- Insert data into CONCESSION table
INSERT INTO CONCESSION (revenueId, product) VALUES(2, 'Popcorn');
INSERT INTO CONCESSION (revenueId, product) VALUES(1, 'Soda');
INSERT INTO CONCESSION (revenueId, product) VALUES(3, 'Candy');
INSERT INTO CONCESSION (revenueId, product) VALUES(4, 'Hot Dog');
INSERT INTO CONCESSION (revenueId, product) VALUES(5, 'Nachos');
INSERT INTO CONCESSION (revenueId, product) VALUES(6, 'Pretzel');
INSERT INTO CONCESSION (revenueId, product) VALUES(7, 'Ice Cream');
INSERT INTO CONCESSION (revenueId, product) VALUES(8, 'Chips');
INSERT INTO CONCESSION (revenueId, product) VALUES(9, 'Burger');
INSERT INTO CONCESSION (revenueId, product) VALUES(10, 'Fries');

-- Insert data into Zoo_Admission table
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(1, 10.0, 20.0, 10.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(2, 12.0, 25.0, 15.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(3, 15.0, 30.0, 18.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(4, 10.0, 18.0, 8.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(5, 13.0, 22.0, 12.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(6, 14.0, 28.0, 14.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(7, 12.0, 24.0, 10.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(8, 11.0, 23.0, 11.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(9, 14.0, 26.0, 16.0);
INSERT INTO Zoo_Admission (revenueId, seniorPrice, adultPrice, childPrice) VALUES(10, 15.0, 32.0, 20.0);

-- Insert data into Participates_In table
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(1, 3, 2);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(2, 3, 1);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(3, 3, 3);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(4, 3, 2);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(5, 3, 1);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(6, 6, 1);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(7, 6, 2);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(8, 6, 1);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(9, 6, 3);
INSERT INTO Participates_In (speciesId, animalShowRevenueId, numberRequired) VALUES(10, 6, 2);

-- Insert data into Cares_For table
INSERT INTO Cares_For (speciesId, employeeId) VALUES(1, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(2, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(3, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(4, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(5, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(6, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(7, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(8, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(9, 9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(10,9);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(1, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(2, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(3, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(4, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(5, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(6, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(7, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(8, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(9, 10);
INSERT INTO Cares_For (speciesId, employeeId) VALUES(10,10);

