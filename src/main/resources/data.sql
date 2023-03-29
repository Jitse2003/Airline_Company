INSERT INTO Airport (id, name, city, country)
VALUES (1, 'John F. Kennedy International Airport', 'New York', 'United States');
INSERT INTO Airport (id, name, city, country)
VALUES (2, 'Heathrow Airport', 'London', 'United Kingdom');
INSERT INTO Airport (id, name, city, country)
VALUES (3, 'Charles de Gaulle Airport', 'Paris', 'France');
INSERT INTO Airport (id, name, city, country)
VALUES (4, 'Sydney Airport', 'Sydney', 'Australia');
INSERT INTO Airport (id, name, city, country)
VALUES (5, 'Dubai International Airport', 'Dubai', 'United Arab Emirates');

INSERT INTO Aircraft (id, capacity, manufacturer, model, airport_id)
VALUES (1, 150, 'Boeing', '737-800', 1);
INSERT INTO Aircraft (id, capacity, manufacturer, model, airport_id)
VALUES (2, 200, 'Airbus', 'A320', 2);
INSERT INTO Aircraft (id, capacity, manufacturer, model, airport_id)
VALUES (3, 300, 'Boeing', '777-300ER', 3);
INSERT INTO Aircraft (id, capacity, manufacturer, model, airport_id)
VALUES (4, 100, 'Embraer', 'E175', 4);
INSERT INTO Aircraft (id, capacity, manufacturer, model, airport_id)
VALUES (5, 250, 'Airbus', 'A350', 5);
INSERT INTO Aircraft (id, capacity, manufacturer, model, airport_id)
VALUES (6, 220, 'Airbus', 'A320', 2);

INSERT INTO flight (flight_number, origin, omschrijving, departure_date, return_date, aircraft_id, airport_id)
VALUES (123, 'London', 'Flight from London to New York', '2023-04-01', '2023-04-02', 1, 1);

INSERT INTO flight (flight_number, origin, omschrijving, departure_date, return_date, aircraft_id, airport_id)
VALUES (456, 'New York', 'Flight from New York to Paris', '2023-04-03', '2023-04-04', 2, 2);

INSERT INTO flight (flight_number, origin, omschrijving, departure_date, return_date, aircraft_id, airport_id)
VALUES (789, 'Paris', 'Flight from Paris to Tokyo', '2023-04-05', '2023-04-06', 3, 3);

INSERT INTO flight (flight_number, origin, omschrijving, departure_date, return_date, aircraft_id, airport_id)
VALUES (234, 'Tokyo', 'Flight from Tokyo to Sydney', '2023-04-07', '2023-04-08', 4, 4);

INSERT INTO flight (flight_number, origin, omschrijving, departure_date, return_date, aircraft_id, airport_id)
VALUES (567, 'Sydney', 'Flight from Sydney to Dubai', '2023-04-09', '2023-04-10', 5, 5);

INSERT INTO flight (flight_number, origin, omschrijving, departure_date, return_date, aircraft_id, airport_id)
VALUES (890, 'Dubai', 'Flight from Dubai to London', '2023-04-11', '2023-04-12', 6, 1);

