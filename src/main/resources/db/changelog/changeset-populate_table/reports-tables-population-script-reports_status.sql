--liquibase formatted sql

--changeset Bakulin:reports_statuses_inserts splitStatements:true endDelimeter:;

INSERT INTO report_status OVERRIDING SYSTEM VALUE VALUES (1, 'STARTED');
INSERT INTO report_status OVERRIDING SYSTEM VALUE VALUES (2, 'FINISHED');