
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


CREATE TABLE IF NOT EXISTS public.users (
    user_id INTEGER PRIMARY KEY,
    user_name character varying(100) UNIQUE NOT NULL,
    password character varying(60) NOT NULL,
	first_name character varying(200) ,
	last_name character varying(200),
	email character varying(200) NOT NULL,
	creation_date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	creation_user_id INTEGER,
	modification_date_time TIMESTAMP WITHOUT TIME ZONE,
	modification_user_id INTEGER,
	enabled BOOLEAN NOT NULL  DEFAULT TRUE
);
ALTER TABLE public.users OWNER TO postgres;


CREATE SEQUENCE IF NOT EXISTS public.user_id_users_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_users_seq OWNER TO postgres;

ALTER TABLE public.users ALTER COLUMN user_id SET DEFAULT nextval('public.user_id_users_seq');

ALTER SEQUENCE public.user_id_users_seq OWNED BY public.users.user_id;


ALTER TABLE public.users ADD CONSTRAINT fk_users_creation_user_id
    FOREIGN KEY (creation_user_id)
    REFERENCES public.users (user_id);
	
ALTER TABLE public.users ADD CONSTRAINT fk_users_modification_user_id
    FOREIGN KEY (modification_user_id)
    REFERENCES public.users (user_id);

