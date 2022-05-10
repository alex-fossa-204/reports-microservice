--liquibase formatted sql

--changeset Bakulin:reports_statuses_inserts splitStatements:true endDelimeter:;

INSERT INTO report_status (report_status_name)
VALUES
('STARTED'),
('FINISHED');
