CREATE DATABASE IF NOT EXISTS Hotel;

CREATE TABLE `Room` (
  `roomNumber` int,
  `type` varchar(50),
  `standardOccup` int,
  `maxOccup` int,
  `ada` boolean,
  `available` boolean,
  PRIMARY KEY (`roomNumber`)
);

CREATE TABLE `RoomPrice` (
  `roomPriceID` int,
  `roomNumber` int,
  `price` double,
  `fromDate` date,
  `toDate` date,
  `extraPerson` int,
  PRIMARY KEY (`roomPriceID`)
);

CREATE TABLE `Guest` (
  `guestID` int,
  `reservationID` int,
  `roomNumber` int,
  `firstName` varchar(50),
  `lastName` varchar(50),
  `address` varchar(50),
  `city` varchar(50),
  `state` varchar(50),
  `zip` int,
  `phone` varchar(50),
  `paymentInfo` varchar(50),
  PRIMARY KEY (`guestID`)
);

CREATE TABLE `Reservation` (
  `reservationID` int,
  `roomNumber` int,
  `guestID` int,
  `totalCost` double,
  `adults` int,
  `children` int,
  `startDate` date,
  `endDate` date,
  PRIMARY KEY (`reservationID`)
);

CREATE TABLE `GetRoom` (
  `roomNumber` int,
  `reservationID` int,
  PRIMARY KEY (`roomNumber`, `reservationID`)
);

CREATE TABLE `Amenity` (
  `roomNumber` int,
  `amenityTypeID` int,
  PRIMARY KEY (`roomNumber`, `amenityTypeID`)
);

CREATE TABLE `AmenityType` (
  `amenityTypeID` int,
  `amenity` varchar(50),
  PRIMARY KEY (`amenityTypeID`)
);