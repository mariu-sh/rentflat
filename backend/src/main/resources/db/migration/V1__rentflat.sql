CREATE TABLE flat (
    id BIGINT PRIMARY KEY,
    uuid VARCHAR(255) NOT NULL,
    surface DOUBLE PRECISION  NOT NULL,
    cost DOUBLE PRECISION NOT NULL
);

CREATE TABLE room (
    id BIGINT PRIMARY KEY,
    uuid VARCHAR(255) NOT NULL,
    surface DOUBLE PRECISION NOT NULL,
    flat_id BIGINT NOT NULL,
    FOREIGN KEY (flat_id) REFERENCES flat(id)
);

CREATE VIEW room_rent_cost AS
    SELECT
        r.id as room_id,
        f.id as flat_id,
        (
            f.cost/f.surface
        )*(
            r.surface + (
                f.surface - (SELECT sum(surface) FROM room WHERE flat_id = f.id)
                )/(
                    SELECT count(*) FROM room WHERE flat_id = f.id
                    )
        ) as room_cost
    FROM  flat f JOIN room r on f.id = r.flat_id
    GROUP BY f.id, r.id
    ORDER BY f.id;;
