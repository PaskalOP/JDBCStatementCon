SELECT
    CASE
        WHEN birthday = youngest_birthday THEN 'YOUNGEST'
        WHEN birthday = oldest_birthday THEN 'OLDEST'
    END AS TYPE,
    name,
    birthday
FROM
    worker,
    (
        SELECT
            MIN(birthday) as youngest_birthday,
            MAX(birthday) as oldest_birthday
        FROM
            worker
    ) AS type_age
WHERE
    birthday = youngest_birthday OR birthday = oldest_birthday;