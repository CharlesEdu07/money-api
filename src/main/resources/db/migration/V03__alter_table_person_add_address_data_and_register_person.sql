ALTER TABLE
    person
ADD
    COLUMN street_address VARCHAR(255),
ADD
    COLUMN number_address INTEGER,
ADD
    COLUMN complement VARCHAR(255),
ADD
    COLUMN neighborhood VARCHAR(255),
ADD
    COLUMN cep VARCHAR(255),
ADD
    COLUMN city VARCHAR(255),
ADD
    COLUMN state_address VARCHAR(255);

INSERT INTO
    person (
        person_name,
        active,
        street_address,
        number_address,
        complement,
        neighborhood,
        cep,
        city,
        state_address
    )
VALUES
    (
        'John Doe',
        TRUE,
        '123 Main St',
        10,
        'Apt 101',
        'Downtown',
        '12345-678',
        'Metropolis',
        'NY'
    );

INSERT INTO
    person (
        person_name,
        active,
        street_address,
        number_address,
        complement,
        neighborhood,
        cep,
        city,
        state_address
    )
VALUES
    (
        'Jane Smith',
        TRUE,
        '456 Elm St',
        20,
        NULL,
        'Suburbia',
        '98765-432',
        'Smalltown',
        'CA'
    );

INSERT INTO
    person (
        person_name,
        active,
        street_address,
        number_address,
        complement,
        neighborhood,
        cep,
        city,
        state_address
    )
VALUES
    (
        'Alice Johnson',
        TRUE,
        '789 Oak St',
        30,
        'Suite 201',
        'Uptown',
        '54321-876',
        'Megacity',
        'TX'
    );

INSERT INTO
    person (
        person_name,
        active,
        street_address,
        number_address,
        complement,
        neighborhood,
        cep,
        city,
        state_address
    )
VALUES
    (
        'Michael Brown',
        TRUE,
        '101 Pine St',
        40,
        NULL,
        'Rural',
        '24680-135',
        'Villageville',
        'WA'
    );

INSERT INTO
    person (
        person_name,
        active,
        street_address,
        number_address,
        complement,
        neighborhood,
        cep,
        city,
        state_address
    )
VALUES
    (
        'Emily Davis',
        TRUE,
        '222 Maple St',
        50,
        'Unit B',
        'Midtown',
        '86420-369',
        'Citytown',
        'FL'
    );