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

CREATE MATERIALIZED VIEW room_rent_cost AS --
    SELECT flat_id, --
           room_id, --
           cost_per_surface*(room_surface + common_part_surface/room_amount) as room_cost --
    FROM (SELECT --
              f.id as flat_id, --
              r.id as room_id, --
              (f.surface - (SELECT sum(surface) FROM room WHERE flat_id = f.id)) as common_part_surface, --
              (SELECT count(*) FROM room WHERE flat_id = f.id) as room_amount, --
              r.surface as room_surface, --
              (f.cost/f.surface) as cost_per_surface --
          FROM  flat f JOIN room r on f.id = r.flat_id) AS help_table;

CREATE OR REPLACE FUNCTION refresh_room_rent_cost_view() --
    RETURNS trigger AS --
$$ --
BEGIN --
    REFRESH MATERIALIZED VIEW room_rent_cost; --
    RETURN null; --
END; --
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER refresh_room_rent_cost_room --
    AFTER INSERT OR UPDATE OR DELETE --
    ON room --
EXECUTE FUNCTION refresh_room_rent_cost_view();

CREATE TRIGGER refresh_room_rent_cost_flat --
    AFTER UPDATE OR DELETE --
    ON flat --
EXECUTE FUNCTION refresh_room_rent_cost_view(); --