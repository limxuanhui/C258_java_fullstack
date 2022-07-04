USE PersonalTrainer;
SHOW TABLES;

# Activity 1
# Select all columns from ExerciseCategory and Exercise.

# The tables should be joined on ExerciseCategoryId.
# This query returns all Exercises and their associated ExerciseCategory.
# 64 rows
SELECT *
FROM Exercise
INNER JOIN ExerciseCategory ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId;

# Activity 2
# Select ExerciseCategory.Name and Exercise.Name where the ExerciseCategory does not have a ParentCategoryId (it is null).

# Again, join the tables on their shared key (ExerciseCategoryId).
# 9 rows
SELECT ExerciseCategory.Name, Exercise.Name
FROM Exercise
INNER JOIN ExerciseCategory ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
WHERE ExerciseCategory.ParentCategoryId IS NULL;


# Activity 3
# The query above is a little confusing. At first glance, 
# it's hard to tell which Name belongs to ExerciseCategory and which belongs to Exercise.

# Rewrite the query using aliases:

# Alias ExerciseCategory.Name as 'CategoryName'.
# Alias Exercise.Name as 'ExerciseName'.
# 9 rows
SELECT ExerciseCategory.Name CategoryName, Exercise.Name ExerciseName
FROM Exercise
INNER JOIN ExerciseCategory ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
WHERE ExerciseCategory.ParentCategoryId IS NULL;


# Activity 4
# Select FirstName, LastName, and BirthDate from Client and EmailAddress from Login where Client.BirthDate is in the 1990s.

# Join the tables by their key relationship.

# What is the primary-foreign key relationship?
# 35 rows
SELECT Client.FirstName, Client.LastName, Client.BirthDate, Login.EmailAddress
FROM Client 
INNER JOIN Login ON Client.ClientId = Login.ClientId
WHERE Client.BirthDate LIKE '199%';


# Activity 5
# Select Workout.Name, Client.FirstName, and Client.LastName for Clients with LastNames starting with 'C'?

# How are Clients and Workouts related?
# 25 rows
SELECT Workout.Name, Client.FirstName, Client.LastName
FROM Client 
INNER JOIN ClientWorkout ON Client.ClientId = ClientWorkout.ClientId
INNER JOIN Workout ON ClientWorkout.WorkoutId = Workout.WorkoutId
WHERE Client.LastName LIKE 'C%';


# Activity 6
# Select Names from Workouts and their Goals.

# This is a many-to-many relationship with a bridge table.
# Use aliases appropriately to avoid ambiguous columns in the result.
# 78 rows
SELECT Workout.Name WorkoutName, Goal.Name GoalName
FROM Workout
INNER JOIN WorkoutGoal ON Workout.WorkoutId = WorkoutGoal.WorkoutId
INNER JOIN Goal ON WorkoutGoal.GoalId = Goal.GoalId;


# Activity 7
# Step 1
# Select client names and email addresses.

# Select FirstName and LastName from Client.
# Select ClientId and EmailAddress from Login.
# Join the tables, but make Login optional.
# 500 rows
SELECT Client.FirstName, Client.LastName, Login.ClientId, Login.EmailAddress
FROM Client
LEFT OUTER JOIN Login ON Client.ClientId = Login.ClientId;

# Step 2
# Using the query above as a foundation, select Clients who do not have a Login.

# 200 rows
SELECT Client.FirstName, Client.LastName, Login.ClientId, Login.EmailAddress
FROM Client
LEFT OUTER JOIN Login ON Client.ClientId = Login.ClientId
WHERE Login.ClientId IS NULL;


# Activity 8
# Does the Client, Romeo Seaward, have a Login?

# Decide using a single query.
# Depending on how this query is set up, it will return 1 row or 0 rows.
SELECT *
FROM Client
INNER JOIN Login ON Login.ClientId = Client.ClientId
WHERE CONCAT(Client.FirstName, ' ', Client.LastName) = 'Romeo Seaward';

SELECT *
FROM Client
LEFT OUTER JOIN Login ON Login.ClientId = Client.ClientId
WHERE CONCAT(Client.FirstName, ' ', Client.LastName) = 'Romeo Seaward'; # This query shows all columns together, where login details are null.


# Activity 9
# Select ExerciseCategory.Name and its parent ExerciseCategory's Name.

# This requires a self-join.
# 12 rows
SELECT child.Name, parent.Name
FROM ExerciseCategory child
INNER JOIN ExerciseCategory parent ON child.ParentCategoryId = parent.ExerciseCategoryId;


# Activity 10
# Rewrite the query above so that every ExerciseCategory.Name is included, even if it doesn't have a parent.

# 16 rows
SELECT child.Name, parent.Name
FROM ExerciseCategory child
LEFT OUTER JOIN ExerciseCategory parent ON child.ParentCategoryId = parent.ExerciseCategoryId;


# Activity 11
# Are there Clients who are not signed up for a Workout?

# 50 rows
SELECT *
FROM Client
LEFT OUTER JOIN ClientWorkout ON Client.ClientId = ClientWorkout.ClientId
WHERE ClientWorkout.ClientId IS NULL;


# Activity 12
# Which Beginner-Level Workouts satisfy at least one of Shell Creane's Goals?

# Goals are associated to Clients through ClientGoal.
# Goals are associated to Workouts through WorkoutGoal.
# 6 rows, 4 unique rows
SELECT Workout.Name
FROM Client
INNER JOIN ClientGoal ON Client.ClientId = ClientGoal.ClientId
INNER JOIN WorkoutGoal ON ClientGoal.GoalId = WorkoutGoal.GoalId
INNER JOIN Workout ON WorkoutGoal.WorkoutId = Workout.WorkoutId
WHERE CONCAT(Client.FirstName, ' ', Client.LastName) = 'Shell Creane'
AND Workout.LevelId = 1;


# Activity 13
# Select all Workouts having the goal "Core Strength" OR having no goal specified.
# If you filter on Goal.Name in a WHERE clause, too few rows will be returned. Why?
# 26 rows
SELECT *
FROM Workout
INNER JOIN WorkoutGoal ON Workout.WorkoutId = WorkoutGoal.WorkoutId
INNER JOIN Goal ON WorkoutGoal.GoalId = Goal.GoalId
ORDER BY Workout.WorkoutId;

SELECT * FROM ExerciseCategory;
SELECT * FROM Exercise;
SELECT * FROM Workout;
SELECT * FROM WorkoutGoal ORDER BY WorkoutId;
SELECT * FROM Goal;

# Activity 14
# The relationship between Workouts and Exercises is... complicated:

# Workout links to WorkoutDay (one day in a Workout routine) which links to 
# WorkoutDayExerciseInstance (Exercises can be repeated in a day so a bridge table is required) which links to 
# ExerciseInstance (Exercises can be done with different weights, repetitions, laps, etc...) which finally links to Exercise.
# Select Workout.Name and Exercise.Name for related Workouts and Exercises.
# 744 rows
SELECT Workout.Name WorkoutName, Exercise.Name ExerciseName
FROM Workout
INNER JOIN WorkoutDay ON Workout.WorkoutId = WorkoutDay.WorkoutId
INNER JOIN WorkoutDayExerciseInstance ON WorkoutDay.WorkoutDayId = WorkoutDayExerciseInstance.WorkoutDayId
INNER JOIN ExerciseInstance ON WorkoutDayExerciseInstance.ExerciseInstanceId = ExerciseInstance.ExerciseInstanceId
INNER JOIN Exercise ON ExerciseInstance.ExerciseId = Exercise.ExerciseId;


# Activity 15
# An ExerciseInstance is configured with ExerciseInstanceUnitValue.

# It contains a Value and UnitId that links to Unit.

# Example Unit/Value combos include 10 laps, 15 minutes, 200 pounds.
# Select Exercise.Name, ExerciseInstanceUnitValue.Value, and Unit.Name for the 'Plank' exercise.

# How many Planks are configured, which Units apply, and what are the configured Values?
# 4 rows, 1 Unit, and 4 distinct Values
SELECT * FROM Exercise;
SELECT * FROM ExerciseInstance;
SELECT * FROM ExerciseInstanceUnitValue;
SELECT * FROM Unit;

SELECT Exercise.Name ExerciseName, ExerciseInstanceUnitValue.Value Reps, Unit.Name UnitName
FROM Exercise
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
INNER JOIN ExerciseInstanceUnitValue ON ExerciseInstance.ExerciseInstanceId = ExerciseInstanceUnitValue.ExerciseInstanceId
INNER JOIN Unit ON ExerciseInstanceUnitValue.UnitId = Unit.UnitId
WHERE Exercise.Name = 'Plank';



# ----- PersonalTrainer Exercise -----
USE PersonalTrainer;

# Activity 1
# Use an aggregate to count the number of Clients.
# 1 row
SELECT COUNT(*)
FROM Client;

# Activity 2
# Use an aggregate to count Client.BirthDate.
# The number is different than total Clients. Why? NULL values not included
# 1 row
SELECT COUNT(Client.BirthDate)
FROM Client;

# Activity 3
# Group Clients by City and count them.
# Sort by the number of Clients desc.
# Include both City and the client count in the results.
SELECT City, COUNT(City) NumberOfClients
FROM Client
GROUP BY City
ORDER BY COUNT(City) DESC;

# Activity 4
# Calculate a total per invoice using only the InvoiceLineItem table.
# Group by InvoiceId.
# You'll need an expression for the line item total: Price * Quantity.
# Aggregate per group using SUM().
# 1000 rows
SELECT * FROM InvoiceLineItem;
SELECT InvoiceId, SUM(Price*Quantity)
FROM InvoiceLineItem
GROUP BY InvoiceId;


# Activity 5
# Modify the previous query:
# Only include totals greater than $500.00.
# Sort from lowest total to highest.
# 234 rows
SELECT InvoiceId, SUM(Price*Quantity) Total
FROM InvoiceLineItem
GROUP BY InvoiceId
HAVING SUM(Price*Quantity) > 500.00
ORDER BY Total;


# Activity 6
# Calculate the average line item total, grouped by InvoiceLineItem.Description.
# 3 rows
SELECT Description, AVG(Price*Quantity) Average
FROM InvoiceLineItem
GROUP BY DESCRIPTION;


# Activity 7
# Select ClientId, FirstName, and LastName from Client for clients who have paid over $1000 total.
# Paid is Invoice.InvoiceStatus = 2.
# Sort by LastName, then FirstName.
# 146 rows
select * from client;
select * from invoice;
select * from invoiceLineItem;

SELECT Client.ClientId, Client.FirstName, Client.LastName, SUM(InvoiceLineItem.Price*InvoiceLineItem.Quantity) TotalPaid
FROM Client
INNER JOIN Invoice ON Client.ClientId = Invoice.ClientId
INNER JOIN InvoiceLineItem ON Invoice.InvoiceId = InvoiceLineItem.InvoiceId
WHERE Invoice.InvoiceStatus = 2
GROUP BY Client.ClientId, Client.FirstName, Client.LastName
HAVING TotalPaid >= 1000
ORDER BY Client.LastName, Client.FirstName;


# Activity 8
# Count exercises by category.
# Group by ExerciseCategory.Name.
# Sort by exercise count descending.
# 13 rows
SELECT * FROM Exercise;
SELECT * FROM ExerciseCategory;

SELECT ExerciseCategory.Name, COUNT(ExerciseCategory.Name) ExerciseCount
FROM Exercise
INNER JOIN ExerciseCategory ON Exercise.ExerciseCategoryId = ExerciseCategory.ExerciseCategoryId
GROUP BY ExerciseCategory.Name
ORDER BY COUNT(ExerciseCategory.Name) DESC;


# Activity 9
# Select Exercise.Name along with the minimum, maximum, and average ExerciseInstance.Sets.
# Sort by Exercise.Name.
# 64 rows
SELECT * FROM ExerciseInstance;
SELECT * FROM Exercise ORDER BY Exercise.Name;
SELECT Exercise.ExerciseId ExerciseId,
	   Exercise.Name ExerciseName,
       MIN(ExerciseInstance.Sets) MinSets,
       MAX(ExerciseInstance.Sets) MaxSets,
       AVG(ExerciseInstance.Sets) AvgSets
FROM Exercise
INNER JOIN ExerciseInstance ON Exercise.ExerciseId = ExerciseInstance.ExerciseId
GROUP BY Exercise.ExerciseId, Exercise.Name
ORDER BY Exercise.Name;


# Activity 10
# Find the minimum and maximum Client.BirthDate per Workout.
# Sort by workout name.
# 26 rows
SELECT Workout.Name WorkoutName, MIN(Client.BirthDate), MAX(Client.BirthDate)
FROM Workout
INNER JOIN ClientWorkout ON Workout.WorkoutId = ClientWorkout.WorkoutId
INNER JOIN Client ON ClientWorkout.ClientId = Client.ClientId
GROUP BY Workout.Name
ORDER BY Workout.Name; 


# Activity 11
# Count client goals.
# Be careful not to exclude rows for clients without goals.
# 500 rows total; 50 rows with no goals
SELECT * FROM Client;
SELECT * FROM ClientGoal;

SELECT Client.ClientId, COUNT(ClientGoal.GoalId) GoalCount
FROM Client
LEFT OUTER JOIN ClientGoal ON Client.ClientId = ClientGoal.ClientId
LEFT OUTER JOIN Goal ON ClientGoal.GoalId = Goal.GoalId
GROUP BY Client.ClientId
ORDER BY GoalCount;


# Activity 12
# Select Exercise.Name, Unit.Name, and minimum and maximum ExerciseInstanceUnitValue.Value
# for all exercises with a configured ExerciseInstanceUnitValue.
# Sort by Exercise.Name, then Unit.Name.
# 82 rows
SELECT * FROM Exercise;
SELECT * FROM ExerciseInstance;
SELECT * FROM ExerciseInstanceUnitValue;

SELECT E.Name ExerciseName, U.Name UnitName, MIN(EIUV.Value) MinVal, MAX(EIUV.Value) MaxVal
FROM Exercise E
INNER JOIN ExerciseInstance EI ON E.ExerciseId = EI.ExerciseId
INNER JOIN ExerciseInstanceUnitValue EIUV ON EI.ExerciseInstanceId = EIUV.ExerciseInstanceId
INNER JOIN Unit U ON EIUV.UnitId = U.UnitId
GROUP BY E.Name
ORDER BY E.Name, U.Name;


# Activity 13
# Modify the query above to include ExerciseCategory.Name.
# Order by ExerciseCategory.Name, then Exercise.Name, then Unit.Name.
# 82 rows
SELECT * FROM Exercise;
SELECT * FROM ExerciseCategory;

SELECT EC.Name CategoryName, E.Name ExerciseName, U.Name UnitName, MIN(EIUV.Value) MinVal, MAX(EIUV.Value) MaxVal
FROM Exercise E
INNER JOIN ExerciseCategory EC ON E.ExerciseCategoryId = EC.ExerciseCategoryId
INNER JOIN ExerciseInstance EI ON E.ExerciseId = EI.ExerciseId
INNER JOIN ExerciseInstanceUnitValue EIUV ON EI.ExerciseInstanceId = EIUV.ExerciseInstanceId
INNER JOIN Unit U ON EIUV.UnitId = U.UnitId
GROUP BY EC.Name, E.Name
ORDER BY EC.Name, E.Name, U.Name;


# Activity 14
# Select the minimum and maximum age in years for each Level.
# To calculate age in years, use the MySQL function DATEDIFF. (Do online research to see how this function works.)
# 4 rows
SELECT * FROM Client;
SELECT * FROM Level;
SELECT * FROM Workout;

SELECT L.Name LevelName,
	   MIN(DATEDIFF(CURRENT_DATE(), C.BirthDate)%365%30) MinAge,
	   MAX(DATEDIFF(CURRENT_DATE(), C.BirthDate)%365%30) MaxAge
FROM Client C
INNER JOIN ClientWorkout CW ON C.ClientId = CW.ClientId
INNER JOIN Workout W ON CW.WorkoutId = W.WorkoutId
INNER JOIN Level L ON W.LevelId = L.LevelId
GROUP BY L.Name;


# Activity 15
# Stretch Goal!
# Count logins by email extension (.com, .net, .org, etc...).
# Research SQL functions to isolate a very specific part of a string value.
# 27 rows (27 unique email extensions)
SELECT * FROM Login;

SELECT SUBSTRING_INDEX(EmailAddress, '.', -1) EmailExt, COUNT(EmailAddress)
FROM Login
GROUP BY EmailExt;


# Activity 16
# Stretch Goal! Match client goals to workout goals.
# Select Client FirstName and LastName and Workout.Name for all workouts that match at least 2 of a client's goals.
# Sort by the client's last name, then first name.
# 139 rows
SELECT * FROM Client;
SELECT * FROM ClientWorkout;
SELECT * FROM ClientGoal;
SELECT * FROM Workout;
SELECT * FROM WorkoutGoal;
SELECT * FROM Goal;

SELECT W.Name WorkoutName,
       CONCAT(C.FirstName, ' ', C.LastName) ClientName,
       COUNT(*) GoalCount
FROM Workout W
INNER JOIN WorkoutGoal WG ON W.WorkoutId = WG.WorkoutId
INNER JOIN ClientGoal CG ON WG.GoalId = CG.GoalId
INNER JOIN Client C ON CG.ClientId = C.ClientId
GROUP BY W.Name
ORDER BY C.LastName, C.FirstName;

# What goals do client have
SELECT * FROM Client; # 500 Client
SELECT * FROM ClientGoal; # 663 ClientGoal
SELECT * FROM Goal; # 17 Goal

SELECT G.Name GoalName, CONCAT(C.FirstName, ' ', C.LastName) ClientName, COUNT(C.ClientId)
FROM Client C
LEFT OUTER JOIN ClientGoal CG ON C.ClientId = CG.ClientId
LEFT OUTER JOIN Goal G ON CG.GoalId = G.GoalId
GROUP BY GoalName
ORDER BY GoalName;



