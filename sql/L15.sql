use hr;

select e.first_name, d.department_name
from employees e, departments d;

select e.first_name, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

select *
from employees e
where e.department_id is null;

select e.first_name, d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id;

select e.first_name, d.department_name
from employees e
left outer join departments d
on e.department_id = d.department_id;

select e.first_name, d.department_name
from employees e
right outer join departments d
on e.department_id = d.department_id;

##########------
use hr;

select e.first_name, d.department_name 
from employees e,departments d
where e.department_id = d.department_id;

select * from employees where department_id is null;

select e.first_name, d.department_name 
from employees e inner join departments d
on e.department_id = d.department_id;

select e.first_name, d.department_name 
from employees e right outer join departments d
on e.department_id = d.department_id;

select e.first_name as Employees , m.first_name as Managers
from employees e join employees m
on e.manager_id = m.employee_id;
###########-------




### 1) WAQ to display employee name and his manager name.
select e1.first_name Employee, e2.first_name Manager
from employees e1 left join employees e2
on e1.manager_id = e2.employee_id;


select * from A;
select * from B;
# INSERT INTO B (idB, Bcol)
# VALUES (5, 1);

#--- join without condition (25 rows)
select A.Acol, B.Bcol
from A
join B;

#--- inner join without condition (25 rows)
select A.Acol, B.Bcol
from A
inner join B;

#--- inner join with condition (13 rows)
select A.Acol, B.Bcol
from A
inner join B
on A.Acol = B.Bcol;

#--- left join with condition (13 rows)
select A.Acol, B.Bcol
from A
left join B
on A.Acol = B.Bcol;

#--- left outer join with condition (13 rows)
select A.Acol, B.Bcol
from A
left outer join B
on A.Acol = B.Bcol;

#--- right join with condition (13 rows)
select A.Acol, B.Bcol
from A
right join B
on A.Acol = B.Bcol;

#--- right outer join with condition (13 rows)
select A.Acol, B.Bcol
from A
right outer join B
on A.Acol = B.Bcol;

#--- self join A with condition (13 rows)
select A1.Acol as A1col, A2.Acol as A2col
from A as A1
join A as A2
on A1.Acol = A2.Acol;

#--- full join (25 rows)
select Acol, Bcol
from A
full join B;