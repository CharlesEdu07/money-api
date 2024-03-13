CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    person_name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO
    person (person_name, active)
VALUES
    ('João', TRUE),
    ('Maria', TRUE),
    ('José', TRUE),
    ('Ana', TRUE),
    ('Carlos', TRUE);