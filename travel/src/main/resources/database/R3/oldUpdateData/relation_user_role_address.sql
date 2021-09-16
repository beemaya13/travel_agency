update users
set role_id = random_values.role_id,
    address_id = random_values.address_id
FROM users u
CROSS JOIN LATERAL (
    SELECT roles.id as role_id,
           addresses.id as address_id
    FROM roles, addresses
    where u.id is not null
    order by RANDOM()
    limit 1
    ) random_values
WHERE users.role_id is null or users.address_id is null;


-- doesn't work with big numbers of rows!!!!!



-- update users
-- set address_id = null,
--     role_id = null
-- where true;
--

