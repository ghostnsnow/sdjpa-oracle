drop table if exists countries cascade;
drop table if exists customers cascade;

create table countries (
    country_id bigint not null,
    country_region_id bigint,
    country_subregion_id bigint,
    country_total_id bigint,
    country_iso_code varchar(255),
    country_name varchar(255),
    country_name_hist varchar(255),
    country_region varchar(255),
    country_subregion varchar(255),
    country_total varchar(255),
    primary key (country_id)
);

create table customers (
    cust_eff_from date,
    cust_eff_to date,
    cust_year_of_birth integer,
    country_id bigint,
    cust_city_id bigint,
    cust_credit_limit bigint,
    cust_id bigint not null,
    cust_src_id bigint,
    cust_state_province_id bigint,
    cust_total_id bigint,
    cust_city varchar(255),
    cust_email varchar(255),
    cust_first_name varchar(255),
    cust_gender varchar(255),
    cust_income_level varchar(255),
    cust_last_name varchar(255),
    cust_main_phone_number varchar(255),
    cust_marital_status varchar(255),
    cust_postal_code varchar(255),
    cust_state_province varchar(255),
    cust_street_address varchar(255),
    cust_total varchar(255),
    cust_valid varchar(255),
    primary key (cust_id)
);