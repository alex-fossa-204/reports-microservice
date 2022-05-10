--liquibase formatted sql

--changeset Bakulin:reports_tables_constraints splitStatements:true endDelimeter:;

ALTER TABLE report
ADD CONSTRAINT status_statuses_fk FOREIGN KEY (report_status)
REFERENCES report_status (id);
