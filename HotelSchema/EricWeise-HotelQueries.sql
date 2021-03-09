-- 1.

SELECT guest.firstName, guest.lastName, Reservation.roomNumber, Reservation.startDate, Reservation.endDate
FROM Reservation INNER JOIN guest
ON Reservation.guestID = guest.guestID
WHERE endDate LIKE '2023-07%';

-- 2.

SELECT guest.firstName, guest.lastName,Reservation.roomNumber, Reservation.startDate, Reservation.endDate
FROM Reservation INNER JOIN amenity
ON Reservation.roomNumber = amenity.roomNumber
INNER JOIN guest
ON Reservation.guestID = guest.guestID
WHERE amenity.amenityTypeID = 4;

-- 3.

SELECT guest.firstName, guest.lastName, Reservation.roomNumber, Reservation.startDate, SUM(Reservation.adults + Reservation.children) AS totalGuest
FROM Reservation INNER JOIN guest
ON Reservation.guestID = guest.guestID
WHERE guest.firstName = 'Duane' AND guest.lastName = 'Cullison'
GROUP BY Reservation.roomNumber;

-- 4.

SELECT * FROM(
	(	SELECT room.roomNumber, reservation.reservationID, roomprice.price as 'Per Room Cost'
		FROM room, reservation, roomprice
		WHERE  room.roomNumber = reservation.roomNumber AND room.roomNumber = roomprice.roomNumber
	)
    UNION ALL
    (	SELECT room.roomNumber, 'null', roomprice.price
		FROM room, roomprice
        WHERE (room.roomNumber NOT IN (SELECT roomNumber FROM reservation) AND room.roomNumber = roomprice.roomNumber)
    )
)t_union;

-- 5.

SELECT roomNumber 
FROM reservation 
WHERE startDate BETWEEN '2023-04-01' AND '2023-04-30' OR endDate BETWEEN '2023-04-01' AND '2023-04-30';

-- 6. 

SELECT reservation.guestID, COUNT(reservation.guestID) as count,
guest.lastName
FROM Reservation
	INNER JOIN guest on reservation.guestID = guest.guestID
GROUP BY reservation.guestID
ORDER BY count DESC, guest.lastName ASC;


-- 7.

SELECT firstName, lastName, address, phone
FROM guest
WHERE phone = '(291) 553-0508'; -- expect Mack Slimmer