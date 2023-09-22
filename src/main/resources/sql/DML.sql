INSERT INTO location(country, city, street)
VALUES ('Japan', 'Wakkanai', '2 Chome-5 Noshappu'),
       ('Republic of Korea', 'Haenam-gun', 'Songji-myeon 1127-16 Songho-ri'),
       ('New Zealand', 'Collingwood', '14-Tasman Street'),
       ('Denmark', 'Bindslev', 'Gl Skovvej 1'),
       ('Iceland', 'Reykjavik', 'Fiskislod 22');

INSERT INTO administrator(first_name, last_name, phone, login, password)
VALUES ('Admin', 'First', 01234567, 'firstadmin', 'adminpass1'),
       ('Admin', 'Second', 9876543, 'secondadmin', 'adminpass2');

INSERT INTO manufacturer("name", country, origination_year)
VALUES ('Toyota Motor Corporation', 'Japan', 1937),
       ('Suzuki Motor Corporation', 'Japan', 1909),
       ('Subaru Corporation', 'Japan', 1953);

INSERT INTO consultant(first_name, last_name, phone, login, password, rate, manufacturer_id)
VALUES ('Consultant', 'First', 12468, 'firstcons', 'conspass1', 750.0, 1),
       ('Consultant', 'Second', 02368, 'secondcons', 'conspass1', 720.0, 1),
       ('Consultant', 'Third', 02264, 'thirdcons', 'conspass1', 920.0, 1),
       ('Consultant', 'Fourth', 22468, 'fourthcons', 'conspass1', 940.0, 1),
       ('Consultant', 'Fifth', 04268, 'fifthcons', 'conspass1', 760.0, 2),
       ('Consultant', 'Sixth', 03218, 'sixthcons', 'conspass1', 710.0, 2),
       ('Consultant', 'Seventh', 03368, 'seventhcons', 'conspass1', 880.0, 3),
       ('Consultant', 'Eighth', 023368, 'eighthcons', 'conspass1', 890.0, 3),
       ('Consultant', 'Ninth', 047778, 'ninthcons', 'conspass1', 970.0, 3),
       ('Consultant', 'Zeroth', 02438, 'zerothcons', 'conspass1', 960.0, 3);

INSERT INTO dealer(location_id, hours)
VALUES (1, '08:00 - 20:00'),
       (2, '09:00 - 20:00'),
       (3, '08:30 - 20:30'),
       (4, '10:00 - 19:00'),
       (5, '10:00 - 18:00');

INSERT INTO offer(amount, description)
VALUES (15, 'Limited-time promo offer!'),
       (5, 'Limited-time sale!');

INSERT INTO car(engine, color, brand, country, price, is_available)
VALUES ('{
  "Engine type": "K15B"
}', 'Medium Gray', 'Suzuki Jimny GL', 'Japan', 880000, true),
       ('{
         "Engine type": "K15B"
       }', 'Silky Silver Metallic', 'Suzuki Jimny GLX', 'Japan', 1080000, false),
       ('{
         "Engine type": "EJ207 H4-T"
       }', 'Crystal Black Silica', 'Subaru WRX STI', 'Japan', 2240000, true),
       ('{
         "Engine type": "2GD-FTV"
       }', 'Bronze Metallic', 'Toyota Hilux', 'Japan', 1425570, true),
       ('{
         "Engine type": "8NR-FTS VVT-iW turbo I4"
       }', 'White', 'Toyota C-HR', 'Japan', 1220000, true);

INSERT INTO dealer_consultant(dealer_id, consultant_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10);

INSERT INTO administrator_dealer(administrator_id, dealer_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (2, 5);

INSERT INTO offer_location(offer_id, location_id)
VALUES (1, 1),
       (2, 3),
       (2, 5);

INSERT INTO dealer_car(dealer_id, car_id)
VALUES (1, 4),
       (1, 5),
       (3, 1),
       (3, 2),
       (4, 3)