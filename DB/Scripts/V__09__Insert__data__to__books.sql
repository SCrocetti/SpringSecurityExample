
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

INSERT INTO roles
(
	book_name,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'Mil y una noches'
	now()::TIMESTAMP,
	3,
	TRUE
);

INSERT INTO roles
(
	book_name,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'La llamada de cthulu'
	now()::TIMESTAMP,
	3,
	TRUE
);
INSERT INTO roles
(
	book_name,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	'Fundacion'
	now()::TIMESTAMP,
	3,
	TRUE
);