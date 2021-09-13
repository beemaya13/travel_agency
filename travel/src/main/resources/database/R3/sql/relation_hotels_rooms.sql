update rooms
set hotel_id = random_values.hotel_id
FROM rooms r
         CROSS JOIN LATERAL (
    SELECT hotels.id as hotel_id
    FROM hotels
    where r.id is not null
    order by RANDOM()
    limit 1
    ) random_values
WHERE rooms.hotel_id is null;