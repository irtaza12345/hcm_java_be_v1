-- SEQUENCE: public.seq_id_branch

CREATE SEQUENCE public.seq_id_branch INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
ALTER SEQUENCE public.seq_id_branch OWNER TO postgres;

-- SEQUENCE: public.seq_id_city

CREATE SEQUENCE public.seq_id_city INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;
ALTER SEQUENCE public.seq_id_city OWNER TO postgres;

-- SEQUENCE: public.seq_id_country

CREATE SEQUENCE public.seq_id_country
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_country OWNER TO postgres;

-- SEQUENCE: public.seq_id_departments_id_seq

CREATE SEQUENCE public.seq_id_department
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_department OWNER TO postgres;

-- SEQUENCE: public.seq_id_error_code

CREATE SEQUENCE public.seq_id_error_code
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_error_code OWNER TO postgres;

-- SEQUENCE: public.seq_id_lookup_query

CREATE SEQUENCE public.seq_id_lookup_query
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_lookup_query OWNER TO postgres;

-- SEQUENCE: public.seq_id_menu

CREATE SEQUENCE public.seq_id_menu
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_menu OWNER TO postgres;

-- SEQUENCE: public.seq_id_organization

CREATE SEQUENCE public.seq_id_organization
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_organization OWNER TO postgres;

-- SEQUENCE: public.seq_id_persistent_login

CREATE SEQUENCE public.seq_id_persistent_login
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_persistent_login OWNER TO postgres;

-- SEQUENCE: public.seq_id_preference

CREATE SEQUENCE public.seq_id_preference
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_preference OWNER TO postgres;

-- SEQUENCE: public.seq_id_privilege

CREATE SEQUENCE public.seq_id_privilege
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_privilege OWNER TO postgres;

-- SEQUENCE: public.seq_id_role_privilege

CREATE SEQUENCE public.seq_id_role_privilege
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_role_privilege OWNER TO postgres;

-- SEQUENCE: public.seq_id_role

CREATE SEQUENCE public.seq_id_role
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_role OWNER TO postgres;

-- SEQUENCE: public.seq_id_state

CREATE SEQUENCE public.seq_id_state
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_state OWNER TO postgres;

-- SEQUENCE: public.seq_id_user_activity

CREATE SEQUENCE public.seq_id_user_activity
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user_activity OWNER TO postgres;

-- SEQUENCE: public.seq_id_user_login

CREATE SEQUENCE public.seq_id_user_login
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user_login OWNER TO postgres;

-- SEQUENCE: public.seq_id_user_privilege

CREATE SEQUENCE public.seq_id_user_privilege
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user_privilege OWNER TO postgres;

-- SEQUENCE: public.seq_id_user_role

CREATE SEQUENCE public.seq_id_user_role
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user_role OWNER TO postgres;

-- SEQUENCE: public.seq_id_user_type

CREATE SEQUENCE public.seq_id_user_type
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user_type OWNER TO postgres;

-- SEQUENCE: public.seq_id_user

CREATE SEQUENCE public.seq_id_user
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_user OWNER TO postgres;

-- SEQUENCE: public.seq_id_attendance

CREATE SEQUENCE public.seq_id_attendance
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_attendance OWNER TO postgres;

-- SEQUENCE: public.seq_id_attendance_policy

CREATE SEQUENCE public.seq_id_attendance_policy
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.seq_id_attendance_policy OWNER TO postgres;
