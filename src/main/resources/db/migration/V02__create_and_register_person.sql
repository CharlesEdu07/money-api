CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    person_name VARCHAR(255) NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    street VARCHAR(255),
    address_number VARCHAR(255),
    complement VARCHAR(255),
    district VARCHAR(255),
    zip_code VARCHAR(255),
    city VARCHAR(255),
    address_state VARCHAR(255)
);

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'João Silva',
        TRUE,
        'Rua do Abacaxi',
        '10',
        null,
        'Brasil',
        '38.400-12',
        'Uberlândia',
        'MG'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Maria Rita',
        TRUE,
        'Rua do Sabiá',
        '110',
        'Apto 101',
        'Colina',
        '11.400-12',
        'Ribeirão Preto',
        'SP'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Pedro Santos',
        TRUE,
        'Rua da Bateria',
        '23',
        null,
        'Morumbi',
        '54.212-12',
        'Goiânia',
        'GO'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Ricardo Pereira',
        TRUE,
        'Rua do Motorista',
        '123',
        'Apto 302',
        'Aparecida',
        '38.400-12',
        'Salvador',
        'BA'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Josué Mariano',
        TRUE,
        'Av Rio Branco',
        '321',
        null,
        'Jardins',
        '56.400-12',
        'Natal',
        'RN'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Pedro Barbosa',
        TRUE,
        'Av Brasil',
        '100',
        null,
        'Tubalina',
        '77.400-12',
        'Porto Alegre',
        'RS'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Henrique Medeiros',
        TRUE,
        'Rua do Sapo',
        '1120',
        'Apto 201',
        'Centro',
        '12.400-12',
        'Rio de Janeiro',
        'RJ'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Carlos Santana',
        TRUE,
        'Rua da Manga',
        '433',
        null,
        'Centro',
        '31.400-12',
        'Belo Horizonte',
        'MG'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Leonardo Oliveira',
        TRUE,
        'Rua do Músico',
        '566',
        null,
        'Segismundo Pereira',
        '38.400-00',
        'Uberlândia',
        'MG'
    );

INSERT INTO
    person (
        person_name,
        active,
        street,
        address_number,
        complement,
        district,
        zip_code,
        city,
        address_state
    )
VALUES
    (
        'Isabela Martins',
        TRUE,
        'Rua da Terra',
        '1233',
        'Apto 10',
        'Vigilato',
        '99.400-12',
        'Manaus',
        'AM'
    );