-- Author: Ethan Nie
-- Assignment# HW03 / Part 4
-- Date due: Oct 12
-- I pledge that I have completed this assignment without collaborating
-- with anyone else, in conformance with the NYU School of Engineering
-- Policies and Procedures on Academic Misconduct.

-- 1)
UPDATE room r
JOIN hotel h ON r.hotelno=h.hotelno
SET r.roomtype='S'
WHERE r.roomno=313 AND h.hotelname='Marriot';

UPDATE room r
JOIN hotel h ON r.hotelno=h.hotelno
SET r.roomtype='S'
WHERE r.roomno in (876,898) AND h.hotelname='Kempinsk';

UPDATE room r
JOIN hotel h ON r.hotelno=h.hotelno
SET r.roomtype='S'
WHERE r.roomno=1001 AND h.hotelname='Ramada Encore';

-- 2)
UPDATE guest
SET guestemail='123@abc.com';

-- 3)
UPDATE hotel
SET hotelphone='+1 9876543210';

-- 4)
UPDATE room r
JOIN hotel h ON r.hotelno = h.hotelno
SET r.roomprice = r.roomprice * 1.05
WHERE h.hotelname = 'Marriott';

-- 5)
DELETE FROM guest
WHERE guestno='G190';

-- 6)
-- DELETE statement failed. There was a reference of guestno in the table booking, 
-- and unfortunately there was a record associated with guestno G190. 
-- So the DELETE attempt failed because of the foreign key constraint.