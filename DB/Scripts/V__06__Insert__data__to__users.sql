
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

CREATE EXTENSION IF NOT EXISTS pgcrypto SCHEMA public;



INSERT INTO public.users
(
	user_name,
	PASSWORD,
	first_name,
	last_name,
	email,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'sysadmin',
	public.crypt('sysadmin2020', public.gen_salt('bf')),
	'system',
	'administrator',
	'sysadmin@gmail.com',
	now()::TIMESTAMP,
	1,
	TRUE
);
INSERT INTO public.users
(
	user_name,
	PASSWORD,
	first_name,
	last_name,
	email,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'sofi',
	public.crypt('sofi2020', public.gen_salt('bf')),
	'Sofia',
	'Crocetti',
	'sofia.17.crocetti@gmail.com',
	now()::TIMESTAMP,
	1,
	TRUE
);
INSERT INTO public.users
(
	user_name,
	PASSWORD,
	first_name,
	last_name,
	email,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'juan',
	public.crypt('juan2020', public.gen_salt('bf')),
	'Juan',
	'Gonzales',
	'juan.gonzalez@gmail.com',
	now()::TIMESTAMP,
	2,
	TRUE
);

INSERT INTO public.users
(
	user_name,
	PASSWORD,
	first_name,
	last_name,
	email,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'emily',
	public.crypt('emily2020', public.gen_salt('bf')),
	'Emily',
	'Echagues',
	'emily.Echagues@gmail.com',
	now()::TIMESTAMP,
	2,
	TRUE
);

INSERT INTO public.users
(
	user_name,
	PASSWORD,
	first_name,
	last_name,
	email,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'yaqui',
	public.crypt('yaqui2020', public.gen_salt('bf')),
	'Yaqui',
	'Velazquez',
	'sieras.yaqui94@gmail.com',
	now()::TIMESTAMP,
	2,
	TRUE
);