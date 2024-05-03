INSERT INTO fees (operator, base_value, use_day, use_month, use_year) VALUES ('DIVIDE', NULL, FALSE, TRUE, TRUE);
INSERT INTO fees (operator, base_value, use_day, use_month, use_year) VALUES ('MULTIPLY', 0.5, TRUE, FALSE, FALSE);
INSERT INTO fees (operator, base_value, use_day, use_month, use_year) VALUES ('MULTIPLY', 0.5, FALSE, TRUE, FALSE);


INSERT INTO brand_card (name, id_fee) VALUES ('VISA', 1);
INSERT INTO brand_card (name, id_fee) VALUES ('NARA', 2);
INSERT INTO brand_card (name, id_fee) VALUES ('AMEX', 3);

INSERT INTO cards (id_brand, number, card_holder, due_date) VALUES (1, '1111 1111 1111 1111', 'Perez Juan', '2026-09-11');
INSERT INTO cards (id_brand, number, card_holder, due_date) VALUES (2, '2222 2222 2222 2222', 'Maria Almeria', '2026-09-11');
INSERT INTO cards (id_brand, number, card_holder, due_date) VALUES (3, '3333 3333 3333 3333', 'Alfonso Ortiz', '2026-09-11');