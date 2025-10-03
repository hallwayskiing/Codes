-- Author: Ethan Nie
-- Assignment# HW03 / Part 3
-- Date due: Oct 12
-- I pledge that I have completed this assignment without collaborating
-- with anyone else, in conformance with the NYU School of Engineering
-- Policies and Procedures on Academic Misconduct.

ALTER TABLE room
ALTER roomtype SET DEFAULT 'N';

ALTER TABLE hotel
ADD COLUMN hotelphone VARCHAR(15);

ALTER TABLE guest
ADD COLUMN guestemail VARCHAR(25);

ALTER TABLE hotel
MODIFY hotelname VARCHAR(35);