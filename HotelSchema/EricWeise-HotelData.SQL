USE Hotel;

	-- Reservation Table

INSERT INTO reservation (`reservationID`, `roomNumber`, `guestID`,  `totalCost`, `adults`, `children`, `startDate`, `endDate`) VALUES
    (1, 308, 2, '299.98', 1, 0, '2023-02-02', '2023-02-04'),
    (2, 203, 3, 999.95, 2, 1, '2023-02-05', '2023-02-10'),
    (3, 305, 4, 349.98, 2, 0, '2023-02-22', '2023-02-24'),
    (4, 201, 5, 199.99, 2, 2, '2023-03-06', '2023-03-07'),
    (5, 307, 1, 524.97, 1, 1, '2023-03-17', '2023-03-20'),
    (6, 302, 6, 924.95, 3, 0, '2023-03-18', '2023-03-23'),
    (7, 202, 7, 349.98, 2, 2, '2023-03-29', '2023-03-31'),
    (8, 304, 8, 874.95, 2, 0, '2023-03-31', '2023-04-05'),
    (9, 301, 9, 799.96, 1, 0, '2023-04-09', '2023-04-13'),
    (10, 207, 10, 174.99, 1, 1, '2023-04-23', '2023-04-24'),
    (11, 401, 11, 1199.97, 2, 4, '2023-05-30', '2023-06-02'),
    (12, 206, 12, 599.96, 2, 0, '2023-06-10', '2023-06-14'),
    (13, 208, 12, 599.96, 1, 0, '2023-06-10', '2023-06-14'),
    (14, 304, 6, 184.99, 3, 0, '2023-06-17', '2023-06-18'),
    (15, 205, 1, 699.96, 2, 0, '2023-06-28', '2023-07-02'),
    (16, 204, 9, 184.99, 3, 1, '2023-07-13', '2023-07-14'),
    (17, 401, 10, 1259.97, 2, 4, '2023-07-18', '2023-07-21'),
    (18, 303, 3, 199.99, 2, 1, '2023-07-28', '2023-07-29'),
    (19, 305, 3, 349.98, 1, 0, '2023-08-30', '2023-09-01'),
    (20, 208, 2, 149.99, 2, 0, '2023-09-16', '2023-09-17'),
    (21, 203, 5, 399.98, 2, 2, '2023-09-13', '2023-09-15'),
    (22, 401, 4, 1199.97, 2, 2, '2023-11-22', '2023-11-25'),
    (23, 206, 2, 449.97, 2, 0, '2023-11-22', '2023-11-25'),
    (24, 301, 2, 599.97, 2, 2, '2023-11-22', '2023-11-25'),
    (25, 302, 11, 699.96, 2, 0, '2023-12-24', '2023-12-28');


	-- GetRoom Table

USE Hotel;
INSERT INTO getRoom (`reservationID`, `roomNumber`) VALUES
    (1, 308),
    (2, 203),
    (3, 305),
    (4, 201),
    (5, 307),
    (6, 302),
    (7, 202),
    (8, 304),
    (9, 301),
    (10, 207),
    (11, 401),
    (12, 206),
    (13, 208),
    (14, 304),
    (15, 205),
    (16, 204),
    (17, 401),
    (18, 303),
    (19, 305),
    (20, 208),
    (21, 203),
    (22, 401),
    (23, 206),
    (24, 301),
    (25, 302);
SELECT *
FROM getRoom;


	-- Guest Table

INSERT INTO guest (guestID, reservationID, roomNumber, firstName, lastName, address, city, state, zip, phone, paymentInfo) values
(001,null,null,'Juan', 'Dupuy','123 Abbey Lane','New York','NY',12345,'(555)-555-5555','paymentInfo'),
(002,null,null,'Mack', 'Simmer','379 Old Shore Street','Council Bluffs','IA',51501,'(291) 553-0508', 'paymentInfo'),
(003,null,null,'Bettyann', 'Seery','750 Wintergreen Dr.','Wasilla','AK',99654,'(478) 277-9632','paymentInfo'),
(004,null,null,'Duane' ,'Cullison','9662 Foxrun Lane','Harlingen','TX',78552,'(308) 494-0198','paymentInfo'),
(005,null,null,'Karie', 'Yang','9378 W. Augusta Ave.','West Deptford','NJ',08096,'(214) 730-0298','paymentInfo'),
(006,null,null,'Aurore', 'Lipton','762 Wild Rose Street','Saginaw','MI',48601,'(377) 507-0974','paymentInfo'),
(007,null,null,'Zachery', 'Luechtefeld','7 Poplar Dr.','Arvada','CO',80003,'(814) 485-2615','paymentInfo'),
(008,null,null,'Jeremiah', 'Pendergrass','70 Oakwood St.','Zion','IL',60099,'(279) 491-0960','paymentInfo'),
(009,null,null,'Walter', 'Holaway','7556 Arrowhead St.','Cumberland','RI',02864,'(446) 396-6785','paymentInfo'),
(010,null,null,'Wilfred', 'Vise','77 West Surrey Street','Oswego','NY',13126,'(834) 727-1001','paymentInfo'),
(011,null,null,'Maritza','Tilton','939 Linda Rd.','Burke','VA',22015,'(446) 351-6860','paymentInfo'),
(012,null,null,'Joleen', 'Tison','87 Queen St.','Drexel Hill','PA',19026,'(231) 893-2755','paymentInfo');


	-- Room

INSERT INTO room(`roomNumber`, `type`, `standardOccup`, `maxOccup`,`ada`,`available`)VALUES
(201,"Double", 2, 4, false, true),
(202, "Double", 2, 4, true, true),
(203, "Double", 2, 4, false, true),
(204, "Double", 2, 4, true, true),
(205, "Single", 2, 2, false, true),
(206, "Single", 2, 2, true, true),
(207, "Single", 2, 2, false, true),
(208, "Single", 2, 2, true, true),
(301, "Double", 2, 4, false, true),
(302, "Double", 2, 4, true, true),
(303, "Double", 2, 4, false, true),
(304, "Double", 2, 4, true, true),
(305, "Single", 2, 2, false, true),
(306, "Single", 2, 2, true, true),
(307, "Single", 2, 2, false, true),
(308, "Single", 2, 2, true, true),
(401, "Suite", 3, 8, true, true),
(402, "Suite", 3, 8, true, true);


	-- roomPrice

INSERT INTO roomPrice(`roomPriceID`, `roomNumber`, `price`, `fromDate`, `toDate`,`extraPerson`)VALUES
(01, 201, 199.99, '2021-02-28' ,'2021-03-28', NULL),
(02, 202, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(03, 203, 199.99, '2021-02-28' ,'2021-03-28', NULL),
(04, 204, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(05, 205, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(06, 206, 149.99, '2021-02-28' ,'2021-03-28', NULL),
(07, 207, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(08, 208, 149.99, '2021-02-28' ,'2021-03-28', NULL),
(09, 301, 199.99, '2021-02-28' ,'2021-03-28', NULL),
(10, 302, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(11, 303, 199.99, '2021-02-28' ,'2021-03-28', NULL),
(12, 304, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(13, 305, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(14, 306, 149.99, '2021-02-28' ,'2021-03-28', NULL),
(15, 307, 174.99, '2021-02-28' ,'2021-03-28', NULL),
(16, 308, 149.99, '2021-02-28' ,'2021-03-28', NULL),
(17, 401, 399.99, '2021-02-28' ,'2021-03-28', NULL),
(18, 402, 399.99, '2021-02-28' ,'2021-03-28', NULL);


	-- Amenity

INSERT INTO amenity (roomNumber, amenityTypeID) values
(201,1),
(201,4),
(202,2),
(203,1),
(203,4),
(204,2),
(205,1),
(205,2),
(205,4),
(206,1),
(206,2),
(207,1),
(207,2),
(207,4),
(208,1),
(208,2),
(301,1),
(301,4),
(302,2),
(303,1),
(303,4),
(304,2),
(305,1),
(305,2),
(305,4),
(306,1),
(306,2),
(307,1),
(307,2),
(307,4),
(308,1),
(308,2),
(401,1),
(401,2),
(401,3),
(402,1),
(402,2),
(402,3);


	-- amenityType

INSERT INTO amenityType(amenityTypeID,amenity) values
(1,'Microwave'),
(2,'Refrigerator'),
(3,'Oven'),
(4,'Jacuzzi');