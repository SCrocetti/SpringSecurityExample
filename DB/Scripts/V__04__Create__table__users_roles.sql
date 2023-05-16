
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


CREATE TABLE IF NOT EXISTS public.users_roles (
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
	creation_date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	creation_user INTEGER NOT NULL,
	modification_date_time TIMESTAMP WITHOUT TIME ZONE,
	modification_user INTEGER,
	enabled BOOLEAN NOT NULL DEFAULT TRUE,
	PRIMARY KEY (user_id, role_id)
);
ALTER TABLE public.users_roles OWNER TO postgres;

ALTER TABLE public.users_roles ADD CONSTRAINT fk_users_roles_user_id
    FOREIGN KEY (user_id)
    REFERENCES public.users (user_id);

ALTER TABLE public.users_roles ADD CONSTRAINT fk_users_roles_role_id
    FOREIGN KEY (role_id)
    REFERENCES public.roles (role_id);