create database hr;
use hr;

drop table employees;
drop table jobs;


create table jobs 
( 
  id varchar(5) primary key,
  title varchar(30),
  minsal int
);

insert into jobs values('jpro','Java Programmer', 400000);
insert into jobs values('ppro','Python Programmer', 350000);
insert into jobs values('odba','Oracle DBA', 500000);
insert into jobs values('adev','Angular Developer', 450000);


CREATE TABLE employees(
  id INT primary key auto_increment,
  fullname VARCHAR(35) not NULL,
  salary INT not NULL,
  job  VARCHAR(5) NULL,
  foreign key(job) REFERENCES jobs(id)
);


insert into employees(fullname,salary,job) values('Jason Hunter',500000,'adev');
insert into employees(fullname,salary,job) values('Stephen Walther',700000,'jpro');
insert into employees(fullname,salary,job) values('Jessy Liberty',800000,'ppro');
insert into employees(fullname,salary,job) values('Kevin Loney',1000000,'odba');
insert into employees(fullname,salary,job) values('Bob Tabour',900000,'ppro');





create table job_history(
 empid int not null, 
 jobid varchar(5) not null ,
 startdate date,
 enddate date,
 foreign key (empid) references employees(id),
 foreign key (jobid) references jobs(id),
 primary key(empid,startdate)
) 


insert into job_history values(1,'jpro','2015-10-02','2017-01-03');
insert into job_history values(1,'ppro','2017-02-01','2019-11-15');
insert into job_history values(2,'ppro','2016-01-02','2019-01-03');
insert into job_history values(3,'odba','2018-05-01','2019-12-31');


