# Lim Xuan Hui
# 290622

# Create database
DROP DATABASE IF EXISTS booksdatabaseddl;
CREATE DATABASE booksdatabaseddl;
USE booksdatabaseddl;
SHOW DATABASES;
SHOW TABLES;

# Create author table
DROP TABLE IF EXISTS author;
CREATE TABLE author (
	authorId INT AUTO_INCREMENT,
    firstName VARCHAR(25) NOT NULL,
    middleName VARCHAR(25),
    lastName VARCHAR(50) NOT NULL,
    gender CHAR(1),
    dateOfBirth DATETIME NOT NULL,
    dateOfDeath DATETIME,
    CONSTRAINT PK_authorId 
		PRIMARY KEY (authorId)
);
DESCRIBE author;

# Create book table
DROP TABLE IF EXISTS book;
CREATE TABLE book (
	bookId INT AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    publicationDate DATETIME,
    CONSTRAINT PK_bookId
		PRIMARY KEY (bookId)
);
DESCRIBE book;

# Create format table
DROP TABLE IF EXISTS format;
CREATE TABLE format (
	formatId INT AUTO_INCREMENT,
    formatName VARCHAR(12) NOT NULL,
    CONSTRAINT PK_formatId
		PRIMARY KEY (formatId)
);
DESCRIBE format;

# Create genre table
DROP TABLE IF EXISTS genre;
CREATE TABLE genre (
	genreId INT AUTO_INCREMENT,
    genreName VARCHAR(25) NOT NULL,
    CONSTRAINT PK_genreId
		PRIMARY KEY (genreId)
);
DESCRIBE genre;

SHOW TABLES;
# Create authorBook table
DROP TABLE IF EXISTS authorBook;
CREATE TABLE authorBook (
	authorId INT,
    bookId INT,
    CONSTRAINT PK_authorBook
		PRIMARY KEY (authorId, bookId),
	CONSTRAINT FK_authorBook_author
		FOREIGN KEY (authorId)
        REFERENCES author (authorId),
	CONSTRAINT FK_authorBook_book
		FOREIGN KEY (bookId)
        REFERENCES book (bookId)
);
DESCRIBE authorBook;

# Create bookFormat table
DROP TABLE IF EXISTS bookFormat;
CREATE TABLE bookFormat (
	bookId INT,
    formatId INT,
    price DECIMAL(5,2),
    quantityOnHand INT,
    CONSTRAINT PK_bookFormat
		PRIMARY KEY (bookId, formatId),
	CONSTRAINT FK_bookFormat_book
		FOREIGN KEY (bookId)
        REFERENCES book (bookId),
	CONSTRAINT FK_bookFormat_format
		FOREIGN KEY (formatId)
        REFERENCES format (formatId)
);
DESCRIBE bookFormat;

# Create bookGenre table
DROP TABLE IF EXISTS bookGenre;
CREATE TABLE bookGenre (
	bookId INT,
    genreId INT,
    CONSTRAINT PK_bookGenre
		PRIMARY KEY (bookId, genreId),
	CONSTRAINT FK_bookGenre_book
		FOREIGN KEY (bookId)
        REFERENCES book (bookId),
	CONSTRAINT FK_bookGenre_genre
		FOREIGN KEY (genreId)
        REFERENCES genre (genreId)
);
DESCRIBE bookGenre;

SHOW TABLES;
