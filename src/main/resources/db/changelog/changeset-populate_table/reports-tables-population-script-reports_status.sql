--liquibase formatted sql

--changeset Bakulin:reports_statuses_inserts splirtStatements:true endDelimeter:;

INSERT INTO report_status VALUES (1, 'STARTED');
INSERT INTO report_status VALUES (2, 'FINISHED');