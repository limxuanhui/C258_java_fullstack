USE PersonalTrainer;

SHOW TABLES;

# Activity 1) Select all rows and columns from the Exercise table. (64 rows)
SELECT * FROM Exercise;

# Activity 2) Select all rows and columns from the Client table. (500 rows)
SELECT * FROM Client;

# Activity 3) Select all columns from Client where the City is Metairie. (29 rows)
SELECT *
FROM Client
WHERE City = 'Metairie';

# Activity 4) Is there a Client with the ClientId '818u7faf-7b4b-48a2-bf12-7a26c92de20c'? (0 rows)
SELECT *
FROM Client
WHERE ClientId = '818u7faf-7b4b-48a2-bf12-7a26c92de20c';

# Activity 5) How many rows are in the Goal table? (17 rows)
SELECT * FROM Goal;

# Activity 6) Select Name and LevelId from the Workout table. (26 rows)
SELECT Name, LevelId
FROM Workout;

# Activity 7) Select Name, LevelId, and Notes from Workout where LevelId is 2. (11 rows)
SELECT Name, LevelId, Notes
FROM Workout
WHERE LevelId = 2;

# Activity 8) Select FirstName, LastName, and City from Client where City is Metairie, Kenner, or Gretna. (77 rows)
SELECT FirstName, LastName, City
FROM Client
WHERE City in ('Metairie', 'Kenner', 'Gretna');

# Activity 9) Select FirstName, LastName, and BirthDate from Client for Clients born in the 1980s. (72 rows)
SELECT FirstName, LastName, BirthDate
FROM Client
WHERE BirthDate LIKE '198_-__-__';

# Activity 10) Write the query above in a different way.
## If you used BETWEEN, you can't use it again.
## If you didn't use BETWEEN, use it!
## The results should be the same as for the previous query, with 72 rows.
SELECT FirstName, LastName, BirthDate
FROM Client
WHERE BirthDate BETWEEN '1980-01-01' AND '1989-12-31';

# Activity 11) How many rows in the Login table have a .gov EmailAddress? (17 rows)
SELECT *
FROM Login
WHERE EmailAddress LIKE '%.gov';

SELECT COUNT(*)
FROM Login
WHERE EmailAddress LIKE '%.gov';

# Activity 12) How many Logins do NOT have a .com EmailAddress? (122 rows)
SELECT COUNT(*)
FROM Login
WHERE EmailAddress NOT LIKE '%.com';

# Activity 13) Select first and last name of Clients without a BirthDate. (37 rows)
SELECT FirstName, LastName
FROM Client
WHERE BirthDate IS NULL;

# Activity 14) Select the Name of each ExerciseCategory that has a parent (ParentCategoryId value is not null). (12 rows)
SELECT Name
FROM ExerciseCategory
WHERE ParentCategoryId IS NOT NULL;

# Activity 15) Select Name and Notes of each level 3 Workout that contains the word 'you' in its Notes. (4 rows)
SELECT Name, Notes
FROM Workout
WHERE LevelId = 3
AND Notes LIKE '%you%';

# Activity 16) Select FirstName, LastName, City from Client whose LastName starts with L,M, or N and who live in LaPlace. (5 rows)
SELECT FirstName, LastName, City
FROM Client
WHERE (LastName LIKE 'L%' OR LastName LIKE 'M%' OR LastName LIKE 'N%')
AND City = 'LaPlace';

# Activity 17) Select InvoiceId, Description, Price, Quantity, ServiceDate and the line item total,
# a calculated value, from InvoiceLineItem, where the line item total is between 15 and 25 dollars. (667 rows)
SELECT InvoiceId, Description, Price, Quantity, Servicedate, (Price * Quantity) AS LineItemTotal
FROM InvoiceLineItem
WHERE (Price * Quantity) BETWEEN 15 AND 25;

# Activity 18)
## Does the database include an email address for the Client, Estrella Bazely?
## This requires two queries:
## Select a Client record for Estrella Bazely. Does it exist?
## If it does, select a Login record that matches its ClientId.
SELECT *
FROM Login
WHERE ClientId = (
	SELECT ClientId
	FROM Client
	WHERE FirstName = 'Estrella' AND LastName = 'Bazely'
);


# Activity 19
## What are the Goals of the Workout with the Name 'This Is Parkour'?
## You need three queries!
## Select the WorkoutId from Workout where Name equals 'This Is Parkour'. (1 row)
## Select GoalId from WorkoutGoal where the WorkoutId matches the WorkoutId from your first query. (3 rows)
## Select the goal name from Goal where the GoalId is one of the GoalIds from your second query. (3 rows)
### Results:
## Endurance
## Muscle Bulk
## Focus: Shoulders

SELECT Name
FROM Goal
WHERE GoalId IN (
	SELECT GoalId
	FROM WorkoutGoal
	WHERE WorkoutId = (
		SELECT WorkoutId FROM Workout
		WHERE Name = 'This Is Parkour'
	)
);

