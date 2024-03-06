CREATE TABLE posting (
    id BIGSERIAL PRIMARY KEY,
    posting_description VARCHAR(255) NOT NULL,
    due_date DATE NOT NULL,
    payment_date DATE,
    posting_value DECIMAL(10, 2) NOT NULL,
    note VARCHAR(100),
    posting_type VARCHAR(20) NOT NULL,
    category_id BIGSERIAL NOT NULL,
    person_id BIGSERIAL NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id),
    FOREIGN KEY (person_id) REFERENCES person(id)
);

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Lazer" para a pessoa "John Doe"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Ingresso para o parque de diversões',
        '2024-03-10',
        50.00,
        'expense',
        1,
        11
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Alimentação" para a pessoa "Jane Smith"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Compras no mercado',
        '2024-03-08',
        100.00,
        'expense',
        2,
        12
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Investimento" para a pessoa "Alice Johnson"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Compra de ações',
        '2024-03-15',
        500.00,
        'investment',
        10,
        13
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Impostos" para a pessoa "Michael Brown"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Pagamento de IPTU',
        '2024-03-31',
        200.00,
        'expense',
        11,
        14
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Outros" para a pessoa "Emily Davis"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Presente de aniversário',
        '2024-03-20',
        30.00,
        'expense',
        5,
        15
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Farmácia" para a pessoa "Hally"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Medicamentos',
        '2024-03-12',
        80.00,
        'expense',
        4,
        16
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Conta de Internet" para a pessoa "Mário"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Pagamento da conta de internet',
        '2024-03-15',
        50.00,
        'expense',
        14,
        17
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Financiamento" para a pessoa "Jorge"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Parcela do financiamento do carro',
        '2024-03-20',
        300.00,
        'expense',
        7,
        24
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Empréstimo" para a pessoa "João Vitor"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Pagamento da parcela do empréstimo',
        '2024-03-25',
        150.00,
        'expense',
        8,
        18
    );

-- Exemplo de insert para um lançamento financeiro relacionado à categoria "Entregas de aplicativo" para a pessoa "Agnaldo"
INSERT INTO
    posting (
        posting_description,
        due_date,
        posting_value,
        posting_type,
        category_id,
        person_id
    )
VALUES
    (
        'Taxa de entrega de comida',
        '2024-03-18',
        20.00,
        'expense',
        13,
        19
    );