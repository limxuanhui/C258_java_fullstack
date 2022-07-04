# Lim Xuan Hui
# 290622

# Create database 
DROP DATABASE IF EXISTS moviesdatabaseddl;
CREATE DATABASE moviesdatabaseddl;
USE moviesdatabaseddL;
SHOW TABLES;

# Create actor table
DROP TABLE IF EXISTS actor;
CREATE TABLE actor (
	actorId INT AUTO_INCREMENT,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    birthDate DATE,
    CONSTRAINT PK_actorId
		PRIMARY KEY (actorId)
);
DESCRIBE actor;

# Create director table
DROP TABLE IF EXISTS director;
CREATE TABLE director (
	directorId INT AUTO_INCREMENT,
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    birthDate DATE,
    CONSTRAINT PK_directorId
		PRIMARY KEY (directorId)
);
DESCRIBE director;

# Create genre table
DROP TABLE IF EXISTS genre;
CREATE TABLE genre (
	genreId INT AUTO_INCREMENT,
    genreName VARCHAR(30) NOT NULL,
	CONSTRAINT PK_genreId
		PRIMARY KEY (genreId)
);
DESCRIBE genre;

# Create rating table
DROP TABLE IF EXISTS rating;
CREATE TABLE rating (
	ratingId INT AUTO_INCREMENT,
    ratingName CHAR(5) NOT NULL,
    CONSTRAINT PK_ratingId
		PRIMARY KEY (ratingId)
);
DESCRIBE rating;

# Create movie table
DROP TABLE IF EXISTS movie;
CREATE TABLE movie (
	movieId INT AUTO_INCREMENT,
    genreId INT NOT NULL,
    directorId INT,
    ratingId INT,
    title VARCHAR(128) NOT NULL,
    releaseDate DATE,
    CONSTRAINT PK_movieId
		PRIMARY KEY (movieId),
	CONSTRAINT FK_movie_genre
		FOREIGN KEY (genreId)
        REFERENCES genre (genreId),
	CONSTRAINT FK_movie_director
		FOREIGN KEY (directorId)
        REFERENCES director (directorId),
	CONSTRAINT FK_movie_rating
		FOREIGN KEY (ratingId)
        REFERENCES rating (ratingId)
);
DESCRIBE movie;

# Create castMembers table
DROP TABLE IF EXISTS castMembers;
CREATE TABLE castMembers (
	castMemberId INT AUTO_INCREMENT,
    actorId INT NOT NULL,
    movieId INT NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINT PK_castMemberId
		PRIMARY KEY (castMemberId),
	CONSTRAINT FK_castMembers_actor
		FOREIGN KEY (actorId)
        REFERENCES actor (actorId),
	CONSTRAINT FK_castMembers_movie
		FOREIGN KEY (movieId)
        REFERENCES movie (movieId)
);
DESCRIBE castMembers;

SHOW TABLES;