USE TrackIt;
SHOW TABLES;

SELECT *
FROM TaskStatus
WHERE IsResolved = 1;

SELECT *
FROM Task
WHERE TaskStatusId BETWEEN 5 AND 8;

# If we want both the Task title and status name displayed together, 
# we have to combine results from the two queries manually. With 276 tasks, that's a lot of copying and pasting.
# Our second query may change each time we run it. 
# If the resolved statuses change, where statuses are added, removed, or edited, we have to adjust our task query.
# We can't write our queries once and then run them whenever we like.
# Worst of all, the approach is error-prone. It's easy to make a mistake. 
# What happens if we miss a status ID while copying or include an ID that doesn't belong?

SELECT * FROM TaskStatus;
SELECT * FROM Task;

# Combine both tables into one table with all columns from both tables
SELECT *
FROM TaskStatus
INNER JOIN Task;

SELECT *
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE IsResolved = 1;

# Error Code: 1052. Column 'TaskStatusId' in field list is ambiguous
SELECT 
    TaskId,
    Title,
    `Name`,
    TaskStatusId -- This will cause problems.
FROM TaskStatus
INNER JOIN Task ON TaskStatus.TaskStatusId = Task.TaskStatusId
WHERE TaskStatus.IsResolved = 1;

# Test if both tables have same column name
CREATE TABLE test1(testId int);
CREATE TABLE test2(testId int);
select * from test1;
select * from test1 inner join test2;


SELECT Project.Name, Worker.FirstName, Worker.LastName
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE Project.ProjectId = 'game-goodboy';


DESCRIBE Project;
SELECT * FROM Project;
DESCRIBE ProjectWorker;
SELECT * FROM ProjectWorker;
DESCRIBE Worker;
DESCRIBE Task;

### -------------- INNER JOIN -----------------------
### 1) All columns and rows combined into one table
SELECT *
FROM Project
INNER JOIN ProjectWorker
INNER JOIN Worker
INNER JOIN Task;

### 2) First ON Clause
SELECT *
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker
INNER JOIN Task;

### 3) Second ON clause
SELECT *
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task;

### 4) Third ON clause
SELECT *
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId;


### 5) Third ON clause with second AND
SELECT *
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId AND ProjectWorker.WorkerId = Task.WorkerId;

### 6) Where Clause
SELECT * 
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId AND ProjectWorker.WorkerId = Task.WorkerId
WHERE Project.ProjectId = 'game-goodboy';

### 7) Choose columns
SELECT Project.Name, Worker.FirstName, Worker.LastName, Task.Title
FROM Project
INNER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
INNER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
INNER JOIN Task ON ProjectWorker.ProjectId = Task.ProjectId AND ProjectWorker.WorkerId = Task.WorkerId
WHERE Project.ProjectId = 'game-goodboy';


### -------------- OUTER JOIN -----------------------
SELECT * FROM TaskStatus;

# 543 rows
SELECT * FROM Task;

# 532 rows
SELECT *
FROM Task
INNER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusId;

# 11 rows --- An INNER JOIN requires a match, so those tasks are eliminated from the result.
SELECT * 
FROM Task
WHERE TaskStatusId IS NULL;

SELECT *
FROM Task
LEFT OUTER JOIN TaskStatus ON Task.TaskStatusId = TaskStatus.TaskStatusId;

SELECT
    Task.TaskId,
    Task.Title,
    IFNULL(Task.TaskStatusId, 0) AS TaskStatusId,
    IFNULL(TaskStatus.Name, '[None]') AS StatusName
FROM Task
LEFT OUTER JOIN TaskStatus 
    ON Task.TaskStatusId = TaskStatus.TaskStatusId;


SELECT *
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
LEFT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL; -- Throws out projects with workers.


-- Projects without workers, we only need the bridge table to confirm.
SELECT
    Project.Name ProjectName
FROM Project
LEFT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
WHERE ProjectWorker.WorkerId IS NULL;

SELECT Project.Name, Worker.FirstName, Worker.LastName
FROM Project
RIGHT OUTER JOIN ProjectWorker ON Project.ProjectId = ProjectWorker.ProjectId
RIGHT OUTER JOIN Worker ON ProjectWorker.WorkerId = Worker.WorkerId
# WHERE ProjectWorker.ProjectId IS NULL;
WHERE ProjectWorker.WorkerId IS NULL;


SELECT Worker.FirstName, Worker.LastName
FROM Worker
LEFT OUTER JOIN ProjectWorker ON Worker.WorkerId = ProjectWorker.WorkerId
WHERE ProjectWorker.WorkerId IS NULL;


# Error Code: 1066. Not unique table/alias: 'Task'
SELECT *
FROM Task
INNER JOIN Task ON Task.TaskId = Task.ParentTaskId;


SELECT parent.TaskId ParentTaskId, child.TaskId ChildTaskId, CONCAT(parent.Title, ' : ', child.Title) Title  
FROM Task parent
INNER JOIN Task child ON parent.TaskId = child.ParentTaskId;


# --- Cross Join
SELECT CONCAT(w.FirstName, ' ', w.LastName) WorkerName, p.Name ProjectName
FROM Worker w
CROSS JOIN Project p
WHERE w.WorkerId = 1
AND p.ProjectId NOT LIKE 'game-%';



# ----- ORDER BY -----
SELECT *
FROM Worker
ORDER BY LastName ASC;

SELECT *
FROM Worker
ORDER BY LastName DESC;

SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC;

SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName ASC, p.Name ASC;


SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY p.Name ASC, w.LastName ASC;


SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY s.Name ASC;


SELECT
    t.Title,
    s.Name StatusName
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY ISNULL(s.Name), s.Name ASC;


SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 0, 10;

SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 10;

SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 10, 10;

SELECT *
FROM Worker
ORDER BY LastName DESC
LIMIT 200, 10;

-- Skip the first 100 records and show the next 25.
SELECT
    w.FirstName,
    w.LastName,
    p.Name ProjectName
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Project p ON pw.ProjectId = p.ProjectId
ORDER BY w.LastName DESC, p.Name ASC
LIMIT 100, 25;

SELECT
    p.Name ProjectName,
    p.ProjectId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;

SELECT DISTINCT
    p.Name ProjectName,
    p.ProjectId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;

USE TrackIt;

-- Count TaskIds, 543 values
SELECT COUNT(TaskId)
FROM Task;

-- Count everything, 543 values
SELECT COUNT(*)
FROM Task;

-- 532
SELECT COUNT(TaskStatusId)
FROM Task;

SELECT
    COUNT(t.TaskId)
FROM Task t
INNER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
WHERE s.IsResolved = 1;


SELECT
    IFNULL(s.Name, '[None]') StatusName,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.Name
ORDER BY s.Name;


SELECT
    IFNULL(s.Name, '[None]') StatusName,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
ORDER BY s.Name;

-- Should not work.
SELECT
    IFNULL(s.Name, '[None]') StatusName,
    s.IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.Name
ORDER BY s.Name;

SELECT
    IFNULL(s.Name, '[None]') StatusName,
    IFNULL(s.IsResolved, 0) IsResolved,
    COUNT(t.TaskId) TaskCount
FROM Task t
LEFT OUTER JOIN TaskStatus s ON t.TaskStatusId = s.TaskStatusId
GROUP BY s.Name, s.IsResolved -- IsResolved is now part of the GROUP.
ORDER BY s.Name;

SELECT DISTINCT
    p.Name ProjectName,
    p.ProjectId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
ORDER BY p.Name;

SELECT
    p.Name ProjectName,
    p.ProjectId
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
GROUP BY p.Name
ORDER BY p.Name;


SELECT
    CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    SUM(t.EstimatedHours) TotalHours
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Task t ON pw.WorkerId = t.WorkerId
    AND pw.ProjectId = t.ProjectId
GROUP BY w.WorkerId, w.FirstName, w.LastName;

SELECT
    CONCAT(w.FirstName, ' ', w.LastName) WorkerName,
    SUM(t.EstimatedHours) TotalHours
FROM Worker w
INNER JOIN ProjectWorker pw ON w.WorkerId = pw.WorkerId
INNER JOIN Task t ON pw.WorkerId = t.WorkerId
    AND pw.ProjectId = t.ProjectId
GROUP BY w.WorkerId, w.FirstName, w.LastName
HAVING SUM(t.EstimatedHours) >= 100
ORDER BY SUM(t.EstimatedHours) DESC;


SELECT
    p.Name ProjectName,
    MIN(t.DueDate) MinTaskDueDate
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
WHERE p.ProjectId LIKE 'game-%'
    AND t.ParentTaskId IS NOT NULL
GROUP BY p.ProjectId, p.Name
ORDER BY p.Name;

# What if we want an overview of each Project: first and last Task due date,
# total estimated hours, total number of Tasks, and average Task hours estimate? We can do it in one query.
SELECT * FROM Task;
SELECT * FROM Project;

SELECT 
	p.Name ProjectName,
    MIN(t.DueDate) MinTaskDueDate,
    MAX(t.DueDate) MaxTaskDueDate, 
    SUM(t.EstimatedHours) TotalEstimatedHours,
    COUNT(t.TaskId) NumberOfTasks, 
    AVG(t.EstimatedHours) AverageEstimatedHours
FROM Project p
INNER JOIN Task t ON p.ProjectId = t.ProjectId
WHERE t.ParentTaskId IS NOT NULL
GROUP BY p.ProjectId, p.Name
HAVING COUNT(t.TaskId) >= 10
ORDER BY COUNT(t.TaskId) DESC, p.Name;























