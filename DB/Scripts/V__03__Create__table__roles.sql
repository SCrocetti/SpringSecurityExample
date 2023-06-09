
\connect -reuse-previous=on "dbname='spring-security-demo'"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

CREATE TABLE IF NOT EXISTS public.roles (
    role_id INTEGER PRIMARY KEY,
    role_name character varying(100) NOT NULL UNIQUE
);
ALTER TABLE public.roles OWNER TO postgres;


CREATE SEQUENCE IF NOT EXISTS public.role_id_roles_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.role_id_roles_seq OWNER TO postgres;

ALTER TABLE public.roles ALTER COLUMN role_id SET DEFAULT nextval('public.role_id_roles_seq');

ALTER SEQUENCE public.role_id_roles_seq OWNED BY public.roles.role_id;

