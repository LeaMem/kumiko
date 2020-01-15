# 175

select

    Person.FirstName, Person.LastName, Address.City, Address.State

from Person left join Address on Person.PersonId = Address.PersonId


# 176

select (select distinct Salary from Employee order by Salary desc limit 1, 1) SecondHighestSalary;
