INSERT INTO ORDERS (user_id, hotel_id, room_id)
VALUES ((SELECT USER_ID FROM users order by random() limit 1),
        (SELECT hotel_id FROM hotels order by random() limit 1),
        (SELECT room_id FROM rooms order by random() limit 1));


INSERT INTO ORDERS (user_id, hotel_id, room_id)
VALUES ((SELECT id FROM users order by random() limit 1),
        (SELECT id FROM hotels order by random() limit 1),
        (SELECT id FROM rooms order by random() limit 1))
    WHERE ()