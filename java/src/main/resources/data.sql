INSERT INTO fees
    (math_expression)
VALUES
    ('year / month'),
    ('day * default_value'),
    ('month * default_value');

INSERT INTO argument_expression
    (name, default_value, id_fee)
VALUES
    ('year', NULL, 1),
    ('month', NULL, 1),
    ('day', NULL, 2),
    ('default_value', 0.5, 2),
    ('month', NULL, 3),
    ('default_value', 0.1, 3);



INSERT INTO brand_card (name, id_fee) VALUES ('VISA', 1);
INSERT INTO brand_card (name, id_fee) VALUES ('NARA', 2);
INSERT INTO brand_card (name, id_fee) VALUES ('AMEX', 3);

INSERT INTO cards (id_brand, number, card_holder, due_date) VALUES (1, '1111 1111 1111 1111', 'Juan Perez', '2022-09-11');
INSERT INTO cards (id_brand, number, card_holder, due_date) VALUES (2, '2222 2222 2222 2222', 'Maria Almeria', '2026-09-11');
INSERT INTO cards (id_brand, number, card_holder, due_date) VALUES (3, '3333 3333 3333 3333', 'Alfonso Ortiz', '2026-09-11');