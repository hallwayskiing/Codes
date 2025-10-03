-- Author: Ethan Nie
-- Assignment# HW03 / Part 1
-- Date due: Oct 12
-- I pledge that I have completed this assignment without collaborating
-- with anyone else, in conformance with the NYU School of Engineering
-- Policies and Procedures on Academic Misconduct.

CREATE TABLE hotel(
	hotelno CHAR(4) PRIMARY KEY,
    hotelname VARCHAR(50),
    hotelcity VARCHAR(50));

CREATE TABLE room(
	roomno INT,
	hotelno CHAR(4),
    roomtype CHAR(1),
    roomprice DECIMAL(8,2),
    CONSTRAINT pk_rm PRIMARY KEY (roomno,hotelno),
    CONSTRAINT fk_rm_hn FOREIGN KEY (hotelno) REFERENCES hotel(hotelno));
   
CREATE TABLE guest(
	guestno CHAR(4) PRIMARY KEY,
    guestname VARCHAR(50),
    guestcity VARCHAR(50));

CREATE TABLE booking(
	hotelno CHAR(4),
    roomno INT,
    guestno CHAR(4),
    datefrom Date,
    dateto Date,
    CONSTRAINT pk_bk PRIMARY KEY (hotelno,roomno,guestno,datefrom),
    CONSTRAINT fk_bk_rm FOREIGN KEY (roomno,hotelno) REFERENCES room(roomno,hotelno),
    CONSTRAINT fk_bk_gn FOREIGN KEY (guestno) REFERENCES guest(guestno));
    

	
