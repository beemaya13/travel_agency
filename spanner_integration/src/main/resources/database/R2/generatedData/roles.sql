INSERT INTO roles (id,
                   date_created,
                   date_deleted,
                   date_updated,
                   name)
VALUES ('1',
        '2021-06-09',
        NULL,
        CURRENT_TIMESTAMP(),
        'ADMIN');

INSERT INTO roles (id,
                   date_created,
                   name)
VALUES ('2',
        CURRENT_TIMESTAMP(),
        'USER');

INSERT INTO roles (id,
                   date_created,
                   name)
VALUES ('3',
        CURRENT_TIMESTAMP(),
        'GUEST');

SELECT *
FROM roles;


