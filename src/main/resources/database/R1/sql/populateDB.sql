insert into roles (name)
values ('ADMIN'),
       ('USER'),
       ('GUEST');

insert into users (email, first_name, last_name, sex, role_id)
VALUES ('petro@gmail.com', 'Petr', 'Petrov', 'MALE', (select id from roles where name = 'USER')),
       ('irina@gmail.com', 'Irina', 'Ivanova', 'FEMALE', (select id from roles where name = 'ADMIN')),
       ('aleksey@gmail.com', 'Aleksey', 'Alekseev', 'MALE', (select id from roles where name = 'USER')),
       ('anna@gmail.com', 'Anna', 'Karenina', 'FEMALE', (select id from roles where name = 'USER'));

insert into countries (name, ISO, capital, continent)
values ('United States of America', 'USA', 'Washington', 'North America'),
       ('Ukraine', 'UKR', 'Kiev', 'Europe'),
       ('France', 'FRA', 'Paris', 'Europe'),
       ('Egypt', 'EGP', 'Cairo', 'Africa'),
       ('Turkey', 'TRK', 'Ankara', 'Asia');

insert into hotels (name, city, country_id)
values ('Rixos', 'Kemer', (select id from countries where countries.name = 'Turkey')),
       ('Hilton', 'Florida', (select id from countries where countries.name = 'United States of America')),
       ('Hilton Sharm', 'Sharm', (select id from countries where countries.name = 'Egypt')),
       ('Hayat', 'Paris', (select id from countries where countries.name = 'France')),
       ('Pegas', 'Antaliya', (select id from countries where countries.name = 'Turkey')),
       ('Rixos Zakarpattya', 'Chernivtsi', (select id from countries where countries.name = 'Ukraine'));

insert into rooms (room_number, room_type, price, hotel_id)
values (1, 'SINGLE', 100.0, (select id from hotels where name = 'Rixos')),
       (2, 'DOUBLE', 200.0, (select id from hotels where name = 'Hilton')),
       (3, 'FAMILY', 300.0, (select id from hotels where name = 'Hilton Sharm')),
       (4, 'DELUXE', 400.0, (select id from hotels where name = 'Hayat')),
       (5, 'SINGLE', 150.0, (select id from hotels where name = 'Pegas')),
       (6, 'DOUBLE', 250.0, (select id from hotels where name = 'Rixos Zakarpattya'));

insert into orders (user_id, hotel_id, room_id, arrival_date, departure_date)
values ((select id from users where first_name = 'Petr'),
        (select id from hotels where name = 'Rixos'),
        (select id from rooms where room_number = 1),
        '01/10/2021', '01/20/2021'),
       ((select id from users where first_name = 'Irina'),
        (select id from hotels where name = 'Hilton'),
        (select id from rooms where room_number = 2),
        '02/10/2021', '02/20/2021'),
       ((select id from users where first_name = 'Aleksey'),
        (select id from hotels where name = 'Hayat'),
        (select id from rooms where room_number = 3),
        '03/10/2021', '03/20/2021'),
       ((select id from users where first_name = 'Anna'),
        (select id from hotels where name = 'Rixos Zakarpattya'),
        (select id from rooms where room_number = 4),
        '04/10/2021', '04/20/2021');