update orders
set room_id = random_values.room_id,
    user_id = random_values.user_id
FROM orders o
         CROSS JOIN LATERAL (
    SELECT rooms.id as room_id,
           users.id as user_id
    FROM rooms, users
    where o.id is not null
    order by RANDOM()
    limit 1
    ) random_values
WHERE orders.room_id is null or orders.user_id is null;