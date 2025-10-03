-- Author: Ethan Nie
-- Assignment# HW03 / Part 5
-- Date due: Oct 12
-- I pledge that I have completed this assignment without collaborating
-- with anyone else, in conformance with the NYU School of Engineering
-- Policies and Procedures on Academic Misconduct.

-- 1)
SELECT *
FROM hotel;

-- 2)
SELECT *
FROM hotel
WHERE hotelcity='Istanbul';

-- 3)
SELECT guestname,guestcity
FROM guest
ORDER BY guestcity;

-- 4)
SELECT *
FROM room
WHERE roomtype='N'
ORDER BY roomprice;

-- 5)
SELECT COUNT(*)
FROM hotel;

-- 6)
SELECT DISTINCT guestcity 
FROM guest;

-- 7)
SELECT AVG(roomprice)
FROM room;

-- 8)
SELECT h.hotelname, r.roomno, r.roomtype
FROM room r
JOIN hotel h ON r.hotelno = h.hotelno;

-- 9)
SELECT h.hotelname,b.datefrom,b.dateto,b.roomno
FROM booking b
JOIN hotel h ON h.hotelno=b.hotelno
WHERE h.hotelcity='New York';

-- 10)
SELECT COUNT(*)
FROM booking
WHERE datefrom LIKE '_____09%';

-- 11)
SELECT g.guestname,g.guestcity
FROM booking b
JOIN guest g ON b.guestno=g.guestno
JOIN hotel h ON b.hotelno=h.hotelno
WHERE h.hotelcity='New York' AND b.datefrom LIKE '_____08%';

-- 12)
SELECT h.hotelname, r.roomno
FROM room r
JOIN hotel h ON r.hotelno = h.hotelno
WHERE NOT EXISTS (
    SELECT 1
    FROM booking b
    WHERE b.roomno = r.roomno AND b.hotelno = r.hotelno);

-- 13)
SELECT h.hotelname, h.hotelcity
FROM room r
JOIN hotel h ON r.hotelno = h.hotelno
WHERE r.roomprice = (SELECT MAX(roomprice) FROM room);

-- 14)
SELECT h.hotelname,r.roomno,h.hotelcity,r.roomprice
FROM hotel h
JOIN room r ON h.hotelno=r.hotelno
WHERE r.roomprice < (SELECT MIN(r.roomprice) 
					 FROM room r
                     JOIN hotel h ON r.hotelno=h.hotelno
                     WHERE hotelcity='Cancun');
                     
-- 15)
SELECT h.hotelcity, AVG(r.roomprice) AS avg_price
FROM room r
JOIN hotel h ON r.hotelno = h.hotelno
GROUP BY h.hotelcity
					