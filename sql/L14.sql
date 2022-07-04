### L14
use hr;

# 1) WAQ to display the number of hiring per year.
select date_format(employees.hire_date, "%Y") as Hire_Year,
	   count(employees.hire_date) as Number_Of_Hires
from employees
group by Hire_Year
order by Hire_Year asc;


# 2) WAQ to display in which month maximum hiring happened?
select date_format(employees.hire_date, "%M") as Hire_Month,
		   max(count(*)) as Number_Of_Hires
	from employees
	group by Hire_Month, Month(employees.hire_date)
	order by Month(employees.hire_date);    

## Deborah solution
select date_format(hire_date, '%M') as month_year, count(*)
from employees
group by month_year
having count(*) = 
(select max(mcount)
from 
(select count(*) mcount, date_format(hire_date, '%M') as month_year
from employees
group by month_year) as t1);

## Solution using Max
select B.Hire_Month, B.Number_Of_Hires
from (
	select date_format(employees.hire_date, "%M") as Hire_Month,
		   count(employees.hire_date) as Number_Of_Hires
			from employees
			group by Hire_Month, Month(employees.hire_date)
			order by Month(employees.hire_date)    
		) as B
where B.Number_Of_Hires = (
	select max(T.Number_Of_Hires) as Max_Hire_Qty
		from (
			select date_format(employees.hire_date, "%M") as Hire_Month,
				   count(employees.hire_date) as Number_Of_Hires
			from employees
			group by Hire_Month, Month(employees.hire_date)
			order by Month(employees.hire_date)    
		) as T);
            
        
        
########        
# select T.Hire_Month as candiate_Month, max(Number_Of_Hires) as Max_Hire_Qty
# 		from (
# 			select date_format(employees.hire_date, "%M") as Hire_Month,
# 				   count(employees.hire_date) as Number_Of_Hires
# 			from employees
# 			group by Hire_Month, Month(employees.hire_date)
# 			-- order by Month(employees.hire_date
#             ) as T;
# ----- SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));        
########


## Returns me max
select max(T.Number_Of_Hires) as Max_Hire_Qty
		from (
			select date_format(employees.hire_date, "%M") as Hire_Month,
				   count(employees.hire_date) as Number_Of_Hires
			from employees
			group by Hire_Month, Month(employees.hire_date)
			order by Month(employees.hire_date)    
		) as T;


## Solution using Limit
select date_format(employees.hire_date, "%M") as Hire_Month,
	   count(employees.hire_date) as Number_Of_Hires
from employees
group by Hire_Month #, Month(employees.hire_date)
order by Number_Of_Hires desc # Month(employees.hire_date)
limit 1;

# FC solution
SELECT  A.hire_month, MAX(A.HiredCount) as MaxCount from (
select date_format(hire_date,'%M') as hire_month, count(first_name) as HiredCount
from employees
group by hire_month
) A
group by A.hire_month;

# Deborah solution
select max(mcount) as max_count
from (select count(*) as mcount, 
	date_format(hire_date, '%M%Y') as month_year
	from employees 
	group by month_year) as a;

# Vaitesswar solution
select total.mon, max(total.num) 
from (select date_format(employees.hire_date,'%M') as mon, count(*) as num
		from employees
		group by MONTH(employees.hire_date)
		order by count(*) DESC) total;
        
        

# 3) WAQ to display in which month maximum hiring happened in department 60?
select date_format(employees.hire_date, "%M") as Hire_Month,
	   count(employees.hire_date) as Number_Of_Hires
from employees
where employees.department_id = 60
group by Hire_Month
order by Number_Of_Hires desc # Month(employees.hire_date)
limit 1;


# 4) WAQ to display highest paid employee information in each department.
select employees.department_id, departments.department_name, employees.first_name, employees.salary
from employees
left join departments 
on employees.department_id = departments.department_id;


# 5) WAQ to calculate the second highest salary department wise.




### All department names
select departments.department_name
from departments
order by departments.department_name asc;

### Number of departments (27)
select count(departments.department_name) as Number_Of_Departments
from departments;

### Number of employees (107)
select count(employees.employee_id) as Number_of_Employees
from employees;

### Employee without department (Kimberely)
select employees.department_id, employees.first_name
from employees
where employees.department_id is null;

### All employees info with department
select employees.department_id, departments.department_name, employees.first_name
from employees
left join departments
on employees.department_id = departments.department_id; 

### All department names with number of employees
select departments.department_name as Department, count(employees.employee_id) as Number_Of_Employees
from employees 
right join departments
on employees.department_id = departments.department_id
#or employees.department_id is null
group by Department
order by Department asc;






