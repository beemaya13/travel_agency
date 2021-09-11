update cities
set country_id = random_values.country_id
FROM cities c
CROSS JOIN LATERAL (
    SELECT countries.id as country_id
    FROM countries
    where c.id is not null
    order by RANDOM()
    limit 1
    ) random_values
WHERE cities.country_id is null;

-- update cities
-- set country_id = null
-- where true;