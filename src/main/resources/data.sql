INSERT INTO DRIVERS(document, birth_Date) VALUES ('12345', '2023-03-23'), ('67890', '2023-03-22');

INSERT INTO CUSTOMER(name, age, insurance_claim, driver_id) VALUES ('Kaique', 28, false, 1);
INSERT INTO CUSTOMER(name, age, insurance_claim, driver_id) VALUES ('Oliveira', 25, true, 1);

INSERT INTO CARS(model, manufacturer, year_car, fipe_value, insurance_claim) VALUES ('Uno', 'Fiat', '2000', 15000, true);
INSERT INTO CARS(model, manufacturer, year_car, fipe_value, insurance_claim) VALUES ('Gol', 'Volkswagen', '2015', 20000, false);

INSERT INTO INSURANCES(id, customer_id, creation_dt, car_id, is_active, safe_budget) VALUES (999, 1, '2023-03-22', 1, true, 0);
INSERT INTO INSURANCES(id, customer_id, creation_dt, car_id, is_active, safe_budget) VALUES (998, 1, '2023-03-22', 1, true, 0);
INSERT INTO INSURANCES(id, customer_id, creation_dt, car_id, is_active, safe_budget) VALUES (997, 1, '2023-03-22', 1, true, 0);
INSERT INTO INSURANCES(id, customer_id, creation_dt, car_id, is_active, safe_budget) VALUES (996, 1, '2023-03-22', 1, true, 0);