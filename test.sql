drop table if exists warehouse cascade;
CREATE table warehouse(
  id bigserial primary key ,
  name varchar(50) not null
);

drop table if exists person cascade;
CREATE table person(
  pesel bigserial primary key ,
  name varchar(20) not null ,
  surname varchar(30) not null ,
  adress varchar(40) not null
);

drop table if exists customer cascade;
create table customer(
  id bigserial primary key
)inherits (person);

drop table if exists employee cascade;
create table employee(
  id bigserial primary key ,
  dateOfEmployment date not null default current_date,
  salary float check (salary>0)
)inherits (person);

drop table if exists transaction cascade;
create table transaction(
  id bigserial primary key ,
  date date not null default current_date,
  payment varchar(40) not null ,
  place varchar(40) not null ,
  sum float check (sum>0),
  customer_id bigserial constraint transaction_customer_fk references customer(id),
  employee_id bigserial constraint transaction_employee_fk references employee(id),
  car_id bigserial constraint transaction_car_fk references car(id),
  insurance_id bigserial constraint transaction_insurance_fk references insurance(id)
);

drop table if exists insurance cascade;
create table insurance(
  id bigserial primary key ,
  name varchar(40)not null ,
  dateFrom date not null default current_date,
  dateTo date not null default current_date,
  price float check (price>0)
);

drop table if exists brand cascade;
create table brand(
  id bigserial primary key ,
  name varchar(40) not null,
  producer_id bigserial constraint brand_producer_fk references producer(id)
);

drop table if exists producer cascade;
create table producer(
  id bigserial primary key ,
  name varchar(40) not null
);

drop table if exists car cascade;
create table car(
  id bigserial primary key ,
  color varchar(40) not null ,
  price float check(price>0),
  body varchar(40),
  gearbox varchar(40),
  warehouse_id bigserial constraint car_warehouse_fk references warehouse(id),
  brand_id bigserial constraint car_brand_fk references brand(id)

);

drop table if exists testDrive cascade;
create table testDrive(
  id bigserial primary key ,
  date date not null default current_date,
  customer_id bigserial constraint testDrive_customer_fk references customer(id),
  employee_id bigserial constraint testDrive_employee_fk references employee(id),
  car_id bigserial constraint testDrive_car_fk references car(id)
);

drop table if exists repair cascade;
create table repair(
  id bigserial primary key ,
  name varchar(40) not null ,
  price float check(price>0),
  employee_id bigserial constraint repair_employee_fk references employee(id),
  car_id bigserial constraint repair_car_fk references car(id)
);

insert into producer values (10,opel);
insert into brand values(100,astra,10);
insert into car values (200,'black',150000,'kombi','manual',300,100);
insert into person values (12345678911,'Jula','dz','poz');
insert into customer values (400);

