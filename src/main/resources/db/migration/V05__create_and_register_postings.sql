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
        'Electricity bill',
        '2024-03-20',
        100.00,
        'expense',
        1,
        1
    ),
    (
        'Groceries',
        '2024-03-15',
        200.00,
        'expense',
        3,
        2
    ),
    (
        'Medicine',
        '2024-03-10',
        50.00,
        'expense',
        4,
        3
    ),
    (
        'Rent',
        '2024-03-01',
        1500.00,
        'expense',
        5,
        4
    ),
    (
        'Salary',
        '2024-03-25',
        3000.00,
        'income',
        2,
        5
    );