# Created by Lim Xuan Hui
# On 280622

# Drop existing database
DROP DATABASE IF EXISTS vinylrecordshop;

# Create database
CREATE DATABASE vinylrecordshop;
SHOW DATABASES;
USE vinylrecordshop;

# Create album table
CREATE TABLE album (
	albumId INT AUTO_INCREMENT,
    CONSTRAINT PK_album PRIMARY KEY (albumId),
    albumTitle VARCHAR(100) NOT NULL,
    label VARCHAR(50),
    releaseDate DATE,
    price DECIMAL(5,2)
);
DESCRIBE album;

# Create artist table
CREATE TABLE artist (
	artistId INT AUTO_INCREMENT,
    CONSTRAINT PK_artistId PRIMARY KEY (artistId),
    artistFirstName VARCHAR(25),
    artistLastName VARCHAR(50) NOT NULL
);
DESCRIBE artist;

# Create band table
CREATE TABLE band (
	bandId INT AUTO_INCREMENT,
    CONSTRAINT PK_bandId PRIMARY KEY (bandId),
    bandName VARCHAR(50) NOT NULL
);
DESCRIBE band;

# Create song table
CREATE TABLE song (
	songId INT NOT NULL AUTO_INCREMENT,    
    songTitle VARCHAR(100) NOT NULL,
    videoUrl VARCHAR(100),
    bandId INT NOT NULL,
    CONSTRAINT PK_songId
		PRIMARY KEY (songId),
    CONSTRAINT FK_song_band 
		FOREIGN KEY (bandId)
		REFERENCES band (bandId)
);
DESCRIBE song;

# Create songAlbum table
CREATE TABLE songAlbum (
	songId INT,
    albumId INT,
    CONSTRAINT PK_songAlbum 
		PRIMARY KEY (songId, albumId)	
);

# Create bandArtist table

SHOW TABLES;