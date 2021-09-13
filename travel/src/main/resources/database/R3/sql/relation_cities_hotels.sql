update hotels
set city_id = random_values.city_id
FROM hotels h
         CROSS JOIN LATERAL (
    SELECT cities.id as city_id
    FROM cities
    where h.id is not null
    order by RANDOM()
    limit 1
    ) random_values
WHERE hotels.city_id is null;