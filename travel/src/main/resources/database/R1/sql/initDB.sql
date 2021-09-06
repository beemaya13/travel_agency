create table if not exists countries
(
    id uuid not null DEFAULT uuid_generate_v1(),
    constraint countries_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    iso varchar(3) not null,
    capital varchar(255) not null,
    continent varchar(255) not null,
    name varchar(255) not null
    constraint uk_m7xlqsndengqp2kpd5nux2s4i
    unique
    );

alter table countries owner to postgres;

create table if not exists cities
(
    id uuid not null DEFAULT uuid_generate_v1(),
    constraint cities_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    name varchar(255) not null
    constraint uk_m7xlqsndengqp2kpd5nux2s5i
    unique,
    country_id uuid
    constraint fkkwysadtw35u6s83fllwubvkiw
    references countries (id) ON DELETE CASCADE
    );

alter table cities owner to postgres;

create table if not exists hotels
(
    id uuid not null DEFAULT uuid_generate_v1(),
    constraint hotels_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    stars integer not null,
    square double precision not null,
    name varchar(255) not null
    constraint uk_m7xlqsndengqp2kpd5nux2s3i
    unique,
    city_id uuid
    constraint fkkwysadtw45u6s82fllwubvkiw
    references cities (id) ON DELETE CASCADE
    );

alter table hotels owner to postgres;

create table if not exists roles
(
    id uuid not null DEFAULT uuid_generate_v1(),
    constraint roles_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    name varchar(255) not null
    constraint uk_6dotkott2kjsp8vw4d0m25fb8
    unique
    );

alter table roles owner to postgres;

create table if not exists rooms
(
    id uuid not null DEFAULT uuid_generate_v1(),
    constraint rooms_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    price double precision not null,
    room_number integer not null,
    room_type varchar(255),
    hotel_id uuid
    constraint fkp5lufxy0ghq53ugm93hdc941k
    references hotels (id) ON DELETE CASCADE
    );

alter table rooms owner to postgres;

create table if not exists users
(
    id uuid not null DEFAULT uuid_generate_v1(),
    constraint users_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    email varchar(255) not null
    constraint uk_6dotkott2kjsp8vw4d0m25fb7
    unique,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    sex varchar(255) not null,
    role_id uuid
    constraint fkp56c1712k691lhsyewcssf40f
    references roles (id) ON DELETE CASCADE
    );

alter table users owner to postgres;

create table if not exists orders
(
    id uuid not null  DEFAULT uuid_generate_v1(),
    constraint orders_pkey
    primary key (id),
    date_created timestamp not null DEFAULT CURRENT_TIMESTAMP,
    date_deleted timestamp,
    date_updated timestamp,
    arrival_date date not null,
    departure_date date not null,
    order_date date not null DEFAULT CURRENT_DATE,
    room_id uuid
    constraint fkmvji5dgxi79luuluamunmw73h
    references rooms (id) ON DELETE CASCADE,
    user_id uuid
    constraint fk32ql8ubntj5uh44ph9659tiih
    references users (id) ON DELETE CASCADE
);

alter table orders owner to postgres;

