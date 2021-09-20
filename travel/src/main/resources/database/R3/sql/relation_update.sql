CREATE OR REPLACE FUNCTION get_random(t regclass, f VARCHAR(40), OUT ret_uuid UUID)
    LANGUAGE plpgsql
AS
$$
-- DECLARE
begin
    EXECUTE format('SELECT %I FROM %s tablesample system_rows(10) order by random() limit 1', f, t)
    into ret_uuid;
end;
$$;

update users
set role_id    = get_random('roles', 'id'),
    address_id = get_random('addresses', 'id')
WHERE role_id is null
   or address_id is null;


update cities
set country_id  = get_random('countries', 'id')
WHERE country_id is null;


update hotels
set city_id  = get_random('cities', 'id')
WHERE city_id is null;


update rooms
set hotel_id  = get_random('hotels', 'id')
WHERE hotel_id is null;


update orders
set room_id  = get_random('rooms', 'id'),
    user_id  = get_random('users', 'id')
WHERE room_id is null or user_id is null;