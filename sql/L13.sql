show databases;

use hr;

# 1) WAQ to display information about Nancy.
# 2) WAQ to display employees whose name starts with letter "N".
# 3) WAQ to display employees in department 90.
# 4) WAQ to display employees in department 60 in descending order.
select * from employees;

select * from employees where department_id = 90;

select * from employees where first_name like "N%";
select * from employees where position("N" in first_name) = 1;

select * from employees where first_name = "Nancy";

select * from employees where department_id = 60 order by salary desc;

select * from employees where first_name like "%n" or department_id = 30;

# Return all employees working where Bruce is working
# 1) subquery return where Bruce works
select *
from employees
where department_id = (select department_id from employees where first_name like "Bruce");

select * from employees where department_id in (select department_id from employees where first_name like "David");

# Join -> display data from multiple tables
# 6) display employee with their department name.
select employees.first_name, departments.department_name
from employees, departments
where employees.department_id = departments.department_id;

# aliasing -> nickname for table, as keyword is optional
select e.first_name as Name, d.department_name as Department
from employees as e, departments as d
where e.department_id = d.department_id;

# Aggregate data -> calculate one output from a group of data
# e.g. count, sum, avg, min, max
# Number of people in department 60, 
select department_id as Department_ID, count(*) as Count
from employees
# where department_id = 60;
# where Department_ID in (50,80,100)
group by Department_ID;
#having Count >= 5
#order by Count desc, Department_ID desc;

# where vs having

#### Practice
### 1) WAQ to display each employee name with location.
select employees.first_name as First_Name, locations.city as City
from employees, locations, departments
where (employees.department_id = departments.department_id) 
and (departments.location_id = locations.location_id);

select employees.first_name, locations.city
from employees
join departments on employees.department_id = departments.department_id
join locations on departments.location_id = locations.location_id;

### 2) WAQ to display employee information who joined in 1999
select *
from employees
# where employees.hire_date >= "1999-01-01" and employees.hire_date <= "1999-12-31";
where employees.hire_date like "2000%";

# FC
SELECT * FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN CAST('2000-01-01' AS DATE ) AND CAST('2000-12-31' AS DATE);

# Deb
select * from employees
where hire_date between '2000-01-04' and '2000-04-21';

# Wenhao
SELECT * 
FROM employees
WHERE YEAR(hire_date) = 2000;

# Praveen
select employees.first_name, employees.hire_date, date_format(employees.hire_date, "%Y") as Hire_Date
from employees
where date_format(employees.hire_date, "%Y") like "2000";

### 3) WAQ to display maximum salary department wise.
select departments.department_name as Department, 
	   max(employees.salary) as Highest_Salary,
       min(employees.salary) as Lowest_Salary,
       avg(employees.salary) as Average_Salary,
       sum(employees.salary) as Total_Salary_Expense,
       count(employees.salary) as Number_Of_Employees
from departments, employees
where employees.department_id = departments.department_id
group by Department
order by Highest_Salary desc;

### Step 1 (Cross product of two tables)
select *
from departments, employees;

### Step 2 (Filter get only employees.department = departments.department_id)
select *
from departments, employees
where employees.department_id = departments.department_id;

### Step 3 (Filter get only employees.department = departments.department_id)
select departments.department_name, employees.salary
from departments, employees
where employees.department_id = departments.department_id
group by departments.department_name, employees.salary;

### Test 2
select departments.department_name, count(employees.department_id)
from departments, employees
where employees.department_id = departments.department_id
group by departments.department_name;


### Number of people working in each department
select departments.department_id as ID,
	   departments.department_name as Department, 
	   count(employees.department_id) as Number_of_Employees
from departments, employees
where employees.department_id = departments.department_id
group by ID, Department;


### 4) WAQ to display employees who joined before Bruce.
select employees.first_name as First_Name, employees.hire_date as Hire_Date
from employees
where employees.hire_date <= (select employees.hire_date from employees where first_name like "Bruce")
order by Hire_Date asc;


### 5) WAQ to display employees who joined from June 2004 to December 2004.
select employees.first_name as First_Name, employees.hire_date as Hire_Date
from employees
# where Hire_Date >= "1999-06-01" and Hire_Date <= "1999-12-31";
where Hire_Date between "1999-06-01" and "1999-12-31"
order by Hire_Date asc;