--liquibase formatted sql

--changeset Bakulin:reports_tables_inserts splirtStatements:true endDelimeter:;

CREATE TABLE report
(
    id int generated always as identity PRIMARY KEY,
    report_title VARCHAR(128),
    report_body VARCHAR(256),
    report_date timestamp,
    report_status int,
    reporter_uid bigint,
    time_cost decimal,
    update_date timestamp,
    uid bigint
);

CREATE TABLE report_status
(
    id int generated always as identity PRIMARY KEY,
    report_status_name VARCHAR(64)
);