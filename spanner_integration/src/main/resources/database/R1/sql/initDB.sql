START
BATCH DDL;

create table addresses
(
    id           STRING(36) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    city         STRING(255) not null,
    country      STRING(255) not null,
    flat_number  INT64     not null,
    house_number INT64     not null,
    street       STRING(255) not null,
    zipcode      INT64     not null
) PRIMARY KEY (id);

create table cities
(
    id           STRING(36) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    name         STRING(255) not null,
    country_id   STRING(36)
) PRIMARY KEY (id);

create table countries
(
    id           STRING(36) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    iso          STRING(2) not null,
    capital      STRING(255) not null,
    continent    STRING(255) not null,
    name         STRING(255) not null
) PRIMARY KEY (id);

create table roles
(
    id           STRING(36) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    name         STRING(255) not null
) PRIMARY KEY (id);

create unique index UK_1pyiwrqimi3hnl3vtgsypj5r on countries (name);
create unique index UK_ofx66keruapi6vyqpv6f2or37 on roles (name);

alter table cities
    add constraint FK6gatmv9dwedve82icy8wrkdmk foreign key (country_id) references countries (id);

RUN
BATCH;