drop table if exists warehouse cascade;
CREATE table warehouse(
  id bigserial primary key,
  name varchar(50) not null,
  status integer
);

drop table if exists customer cascade;
create table customer(
  id bigserial primary key,
  pesel varchar(12) not null,
  name varchar(20) not null ,
  surname varchar(30) not null ,
  address varchar(40) not null,
  status integer
);

drop table if exists employee cascade;
create table employee(
  id bigserial primary key ,
  pesel varchar(12) not null ,
  name varchar(20) not null ,
  surname varchar(30) not null ,
  address varchar(40) not null,
  date date not null,
  salary numeric(10,2) check (salary>0),
  status integer
);

drop table if exists producer cascade;
create table producer(
  id bigserial primary key ,
  name varchar(40) not null,
  status integer
);

drop table if exists brand cascade;
create table brand(
  id bigserial primary key ,
  name varchar(40) not null,
  producer_id bigserial constraint brand_producer_fk references producer(id) on DELETE set null,
  status integer
);

drop table if exists car cascade;
create table car(
  id bigserial primary key ,
  color varchar(40) not null ,
  price numeric(10,2) check(price>0),
  body varchar(40),
  gearBox varchar(40),
  warehouse_id bigserial constraint car_warehouse_fk references warehouse(id) on DELETE set null,
  brand_id bigserial constraint car_brand_fk references brand(id) on DELETE set null,
  status integer
);


drop table if exists insurance cascade;
create table insurance(
  id bigserial primary key ,
  name varchar(40)not null ,
  starting date not null default current_date,
  ending date not null default current_date,
  price numeric(10,2) check (price>0),
  status integer
);

drop table if exists transaction cascade;
create table transaction(
  id bigserial primary key ,
  date date not null default current_date,
  payment varchar(40) not null ,
  place varchar(40) not null ,
  sum numeric(10,2) check (sum>0),
  customer_id bigserial constraint transaction_customer_fk references customer(id) on DELETE set null,
  employee_id bigserial constraint transaction_employee_fk references employee(id) on DELETE set null,
  car_id bigserial constraint transaction_car_fk references car(id) on DELETE set null,
  insurance_id bigserial constraint transaction_insurance_fk references insurance(id) on DELETE set null,
  status integer
);


drop table if exists testDrive cascade;
create table testDrive(
  id bigserial primary key ,
  date date not null default current_date,
  customer_id bigserial constraint testDrive_customer_fk references customer(id) on DELETE set null,
  employee_id bigserial constraint testDrive_employee_fk references employee(id) on DELETE set null,
  car_id bigserial constraint testDrive_car_fk references car(id) on DELETE set null,
  status integer
);

drop table if exists repair cascade;
create table repair(
  id bigserial primary key ,
  name varchar(40) not null ,
  price numeric(10,2) check(price>0),
  employee_id bigserial constraint repair_employee_fk references employee(id) on DELETE set null,
  car_id bigserial constraint repair_car_fk references car(id) on DELETE set null,
  status integer
);

drop table if exists users cascade;
create table users(username varchar(40) primary key,password varchar);
