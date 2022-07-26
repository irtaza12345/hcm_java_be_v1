-- Table: public.hcm_countries

-- DROP TABLE public.hcm_countries;

CREATE TABLE IF NOT EXISTS public.hcm_countries
(
    id bigint NOT NULL DEFAULT nextval('seq_id_country'::regclass),
    str_name character varying(50) NOT NULL,
    str_code character varying(10) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_country PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_countries OWNER to postgres;

-- Table: public.hcm_states

-- DROP TABLE public.hcm_states;

CREATE TABLE IF NOT EXISTS public.hcm_states
(
    id bigint NOT NULL DEFAULT nextval('seq_id_state'::regclass),
    id_country bigint,
    str_name character varying(50) ,
    str_code character varying(10) ,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_state PRIMARY KEY (id),
    CONSTRAINT fk_id_country FOREIGN KEY (id_country)
        REFERENCES public.hcm_countries (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_states OWNER to postgres;

-- Table: public.hcm_cities

-- DROP TABLE public.hcm_cities;

CREATE TABLE IF NOT EXISTS public.hcm_cities
(
    id bigint NOT NULL DEFAULT nextval('seq_id_city'::regclass),
    id_state bigint,
    str_name character varying(50) NOT NULL,
    str_code character varying(10) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_city PRIMARY KEY (id),
    CONSTRAINT fk_id_state FOREIGN KEY (id_state)
        REFERENCES public.hcm_states (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_cities OWNER to postgres;

-- Table: public.hcm_organizations

-- DROP TABLE public.hcm_organizations;

CREATE TABLE IF NOT EXISTS public.hcm_organizations
(
    id bigint NOT NULL DEFAULT nextval('seq_id_organization'::regclass),
    id_country bigint,
    id_state bigint,
    id_city bigint,
    str_name character varying(80) NOT NULL,
    str_address character varying(200) NOT NULL,
    str_email character varying(50),
    str_phone_1 character varying(20) NOT NULL,
    str_phone_2 character varying(20),
    str_postal_address character varying(30),
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_organization PRIMARY KEY (id),
    CONSTRAINT fk_id_city FOREIGN KEY (id_city)
        REFERENCES public.hcm_cities (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_country FOREIGN KEY (id_country)
        REFERENCES public.hcm_countries (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_state FOREIGN KEY (id_state)
        REFERENCES public.hcm_states (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_organizations OWNER to postgres;

-- Table: public.hcm_branches

-- DROP TABLE public.hcm_branches;

CREATE TABLE IF NOT EXISTS public.hcm_branches
(
    id bigint NOT NULL DEFAULT nextval('seq_id_branch'::regclass),
    id_organization bigint NOT NULL,
    id_country bigint,
    id_state bigint,
    id_city bigint,
    str_name character varying(255) NOT NULL,
    str_branch_code character varying(255) NOT NULL,
    str_address character varying(255) NOT NULL,
    str_email character varying(255),
    str_phone_1 character varying(255) NOT NULL,
    str_phone_2 character varying(255),
    str_postal_address character varying(255),
    str_region character varying(255),
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_branch PRIMARY KEY (id),
    CONSTRAINT fk_id_state FOREIGN KEY (id_state)
        REFERENCES public.hcm_states (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_city FOREIGN KEY (id_city)
        REFERENCES public.hcm_cities (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_country FOREIGN KEY (id_country)
        REFERENCES public.hcm_countries (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_branches OWNER to postgres;

-- Table: public.hcm_departments

-- DROP TABLE public.hcm_departments;

CREATE TABLE IF NOT EXISTS public.hcm_departments
(
    id bigint NOT NULL DEFAULT nextval('seq_id_department'::regclass),
    id_organization bigint NOT NULL,
    id_branch bigint,
    str_department_code character varying(20) NOT NULL,
    str_department_name character varying(80) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_department PRIMARY KEY (id),
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_departments OWNER to postgres;

-- Table: public.hcm_error_codes

-- DROP TABLE public.hcm_error_codes;

CREATE TABLE IF NOT EXISTS public.hcm_error_codes
(
    id bigint NOT NULL DEFAULT nextval('seq_id_error_code'::regclass),
    int_error_code integer NOT NULL,
    str_error_level character varying(80) NOT NULL,
    str_information character varying(200) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_error_code PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_error_codes OWNER to postgres;

-- Table: public.hcm_lookup_queries

-- DROP TABLE public.hcm_lookup_queries;

CREATE TABLE IF NOT EXISTS public.hcm_lookup_queries
(
    id bigint NOT NULL DEFAULT nextval('seq_id_lookup_query'::regclass),
    str_query_name character varying(100) NOT NULL,
    str_query character varying(2048) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_lookup_query PRIMARY KEY (id),
    CONSTRAINT uk_str_query_name UNIQUE (str_query_name)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_lookup_queries OWNER to postgres;

-- Table: public.hcm_preferences

-- DROP TABLE public.hcm_preferences;

CREATE TABLE IF NOT EXISTS public.hcm_preferences
(
    id bigint NOT NULL DEFAULT nextval('seq_id_preference'::regclass),
    id_organization bigint,
    id_branch bigint,
    str_name character varying(50) NOT NULL,
    str_value character varying(200) NOT NULL,
    str_description character varying(200) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_preference PRIMARY KEY (id),
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_preferences OWNER to postgres;

-- Table: public.hcm_roles

-- DROP TABLE public.hcm_roles;

CREATE TABLE IF NOT EXISTS public.hcm_roles
(
    id bigint NOT NULL DEFAULT nextval('seq_id_role'::regclass),
    id_organization bigint NOT NULL,
    id_branch bigint,
    str_name character varying(255),
    str_description character varying(255),
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_role PRIMARY KEY (id),
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_roles OWNER to postgres;

-- Table: public.hcm_privileges

-- DROP TABLE public.hcm_privileges;

CREATE TABLE IF NOT EXISTS public.hcm_privileges
(
    id bigint NOT NULL DEFAULT nextval('seq_id_privilege'::regclass),
    str_name character varying(50),
    str_description character varying(200),
    bol_page boolean,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_privilege PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_privileges OWNER to postgres;


-- Table: public.hcm_menus

-- DROP TABLE public.hcm_menus;

CREATE TABLE IF NOT EXISTS public.hcm_menus
(
    id bigint NOT NULL DEFAULT nextval('seq_id_menu'::regclass),
    id_organization bigint,
    id_parent_menu bigint,
    id_privilege bigint,
    str_menu_name character varying(80),
    str_menu_icon character varying(20),
    str_menu_css_class character varying(30),
    str_menu_href character varying(20),
    str_menu_type character varying(20),
    int_menu_sequence integer,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_menu PRIMARY KEY (id),
    CONSTRAINT fk_id_parent_menu FOREIGN KEY (id_parent_menu)
        REFERENCES public.hcm_menus (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_privilege FOREIGN KEY (id_privilege)
        REFERENCES public.hcm_privileges (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_menus OWNER to postgres;

-- Table: public.hcm_role_privileges

-- DROP TABLE public.hcm_role_privileges;

CREATE TABLE IF NOT EXISTS public.hcm_role_privileges
(
    id bigint NOT NULL DEFAULT nextval('seq_id_role_privilege'::regclass),
    id_organization bigint NOT NULL,
    id_branch bigint,
    id_role bigint,
    id_privilege bigint,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_role_privilege PRIMARY KEY (id),
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_privilege FOREIGN KEY (id_privilege)
        REFERENCES public.hcm_privileges (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_role FOREIGN KEY (id_role)
        REFERENCES public.hcm_roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_role_privileges OWNER to postgres;

-- Table: public.hcm_user_types

-- DROP TABLE public.hcm_user_types;

CREATE TABLE IF NOT EXISTS public.hcm_user_types
(
    id bigint NOT NULL DEFAULT nextval('seq_id_user_type'::regclass),
    id_organization bigint NOT NULL,
    id_branch bigint,
    id_role bigint,
    str_name character varying(80) NOT NULL,
    str_description character varying(200) NOT NULL,
    bol_internal_user boolean NOT NULL,
    bol_system_user boolean NOT NULL,
    bol_read_only boolean NOT NULL,
    bol_super_user boolean NOT NULL,
    bol_organization_admin boolean NOT NULL,
    bol_branch_admin boolean NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_user_type PRIMARY KEY (id),
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_role FOREIGN KEY (id_role)
        REFERENCES public.hcm_roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_user_types OWNER to postgres;

-- Table: public.hcm_users

-- DROP TABLE public.hcm_users;

CREATE TABLE IF NOT EXISTS public.hcm_users
(
    id bigint NOT NULL DEFAULT nextval('seq_id_user'::regclass),
    id_organization bigint NOT NULL,
    id_department bigint NOT NULL,
    id_user_type bigint,
    str_first_name character varying(80) NOT NULL,
    str_last_name character varying(80) NOT NULL,
    str_designation character varying(50) ,
    str_email_address character varying(80) NOT NULL,
    str_mobile_number character varying(20) NOT NULL,
    id_country bigint,
    id_state bigint,
    id_city bigint,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    int_modified_by bigint,
    dat_modified_date timestamp without time zone,
    CONSTRAINT pk_id_user PRIMARY KEY (id),
    CONSTRAINT fk_id_user_type FOREIGN KEY (id_user_type)
        REFERENCES public.hcm_user_types (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_country FOREIGN KEY (id_country)
        REFERENCES public.hcm_countries (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_state FOREIGN KEY (id_state)
        REFERENCES public.hcm_states (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_city FOREIGN KEY (id_city)
        REFERENCES public.hcm_cities (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_department FOREIGN KEY (id_department)
        REFERENCES public.hcm_departments (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_users OWNER to postgres;

-- Table: public.hcm_user_logins

-- DROP TABLE public.hcm_user_logins;

CREATE TABLE IF NOT EXISTS public.hcm_user_logins
(
    id bigint NOT NULL DEFAULT nextval('seq_id_user_login'::regclass),
    id_user bigint NOT NULL,
    str_credential character varying(80) NOT NULL,
    int_wrong_credentials integer,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_user_login PRIMARY KEY (id),
    CONSTRAINT fk_id_user FOREIGN KEY (id_user)
        REFERENCES public.hcm_users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_user_logins OWNER to postgres;

-- Table: public.hcm_user_privileges

-- DROP TABLE public.hcm_user_privileges;

CREATE TABLE IF NOT EXISTS public.hcm_user_privileges
(
    id bigint NOT NULL DEFAULT nextval('seq_id_user_privilege'::regclass),
    id_branch bigint NOT NULL,
    id_privilege bigint NOT NULL,
    id_user bigint NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_user_privilege PRIMARY KEY (id),
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_privilege FOREIGN KEY (id_privilege)
        REFERENCES public.hcm_privileges (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_user FOREIGN KEY (id_user)
        REFERENCES public.hcm_users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_user_privileges OWNER to postgres;

-- Table: public.hcm_user_roles

-- DROP TABLE public.hcm_user_roles;

CREATE TABLE IF NOT EXISTS public.hcm_user_roles
(
    id bigint NOT NULL DEFAULT nextval('seq_id_user_role'::regclass),
    id_organization bigint NOT NULL,
    id_branch bigint,
    id_role bigint NOT NULL,
    id_user bigint NOT NULL,
    id_user_type bigint NOT NULL,
    str_designation character varying(50) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_user_role PRIMARY KEY (id),
    CONSTRAINT fk_id_user_type FOREIGN KEY (id_user_type)
        REFERENCES public.hcm_user_types (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_role FOREIGN KEY (id_role)
        REFERENCES public.hcm_roles (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_user FOREIGN KEY (id_user)
        REFERENCES public.hcm_users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_organization FOREIGN KEY (id_organization)
        REFERENCES public.hcm_organizations (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_id_branch FOREIGN KEY (id_branch)
        REFERENCES public.hcm_branches (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_user_roles OWNER to postgres;

-- Table: public.hcm_persistent_logins

-- DROP TABLE public.hcm_persistent_logins;

CREATE TABLE IF NOT EXISTS public.hcm_persistent_logins
(
    id bigint NOT NULL DEFAULT nextval('seq_id_persistent_login'::regclass),
    id_user bigint NOT NULL,
    str_type character varying(20),
    str_origin character varying(20) NOT NULL,
    dat_last_used timestamp without time zone,
    dat_logoff timestamp without time zone,
    dat_logon timestamp without time zone,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_persistent_login PRIMARY KEY (id),
    CONSTRAINT fk_id_user FOREIGN KEY (id_user)
        REFERENCES public.hcm_users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_persistent_logins OWNER to postgres;

-- Table: public.hcm_user_activities

-- DROP TABLE public.hcm_user_activities;

CREATE TABLE IF NOT EXISTS public.hcm_user_activities
(
    id bigint NOT NULL DEFAULT nextval('seq_id_user_activity'::regclass),
    id_user bigint NOT NULL,
    str_service_name character varying(200) NOT NULL,
    str_request character varying(200) NOT NULL,
    str_request_data character varying(4096) NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_user_activity PRIMARY KEY (id),
    CONSTRAINT fk_id_user FOREIGN KEY (id_user)
        REFERENCES public.hcm_users (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_user_activities OWNER to postgres;

-- Table: public.hcm_attendance

-- DROP TABLE public.hcm_attendance;

CREATE TABLE IF NOT EXISTS public.hcm_attendance
(
    id bigint NOT NULL DEFAULT nextval('seq_id_attendance'::regclass),
    str_enroll_number character varying(80) NOT NULL,
    str_event_type character varying(20) NOT NULL,
    int_sign_in integer,
    int_sign_out integer,
    int_invalid integer,
    int_att_state integer,
    int_verify_method integer,
    int_year integer,
    int_month integer,
    int_day integer,
    int_hour integer,
    int_minute integer,
    int_second integer,
    int_work_code integer,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_attendance PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_attendance OWNER to postgres;

-- Table: public.hcm_attendance_policy

-- DROP TABLE public.hcm_attendance_policy;

CREATE TABLE IF NOT EXISTS public.hcm_attendance_policy
(
    id bigint NOT NULL DEFAULT nextval('seq_id_attendance_policy'::regclass),
    str_enroll_number character varying(80) NOT NULL,
    bol_partially boolean NOT NULL,
    int_status integer NOT NULL,
    int_created_by bigint,
    dat_created_date timestamp without time zone,
    dat_modified_date timestamp without time zone,
    int_modified_by bigint,
    CONSTRAINT pk_id_attendance_policy PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hcm_attendance_policy OWNER to postgres;
