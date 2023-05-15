
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

--
-- TOC entry 210 (class 1259 OID 16396)
-- Name: categorias; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE IF NOT EXISTS public.roles_permissions (
    role_id INTEGER NOT NULL,
    permission_id INTEGER NOT NULL,
	creation_date_time TIMESTAMP WITHOUT TIME ZONE NOT NULL,
	creation_user INTEGER NOT NULL,
	modification_date_time TIMESTAMP WITHOUT TIME ZONE,
	modification_user INTEGER,
	enabled BOOLEAN NOT NULL DEFAULT TRUE,
	PRIMARY KEY (role_id, permission_id)
);
ALTER TABLE public.roles_permissions OWNER TO postgres;

ALTER TABLE public.roles_permissions ADD CONSTRAINT fk_roles_permissions_role_id
    FOREIGN KEY (role_id)
    REFERENCES public.roles (role_id);

ALTER TABLE public.roles_permissions ADD CONSTRAINT fk_roles_permissions_permission_id
    FOREIGN KEY (permission_id)
    REFERENCES public.permissions (permission_id);