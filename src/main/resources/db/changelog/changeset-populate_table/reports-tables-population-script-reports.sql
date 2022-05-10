--liquibase formatted sql

--changeset Bakulin:reports_table_population splirtStatements:true endDelimeter:;

INSERT INTO report VALUES (2, 'Initialized microservice database', 'Initialized microservice database for reports', '2022-05-03 00:00:00', 1, 786784177, 2, NULL, 314235235);
INSERT INTO report VALUES (3, 'Initialized Java Project', 'Initialized Spring Boot Project for users', '2022-05-03 00:00:00', 1, 786786787, 2, NULL, 1354235125);
INSERT INTO report VALUES (4, 'Initialized Java project', 'Initialized Spring Boot Project for reports', '2022-05-03 00:00:00', 1, 786786877, 2, NULL, 32543254325);
INSERT INTO report VALUES (5, 'Add users service implementaion', 'Add users service implementaion, repositroy, controller, entities and etc', '2022-05-03 00:00:00', 1, 786486841, 2, NULL, 3344524542);
INSERT INTO report VALUES (1, 'Added database schema', 'Initialized microservice db for users, and test update', '2022-05-03 00:00:00', 1, 786486841, 2.5, '2022-05-05 10:02:23.984', 12312343);