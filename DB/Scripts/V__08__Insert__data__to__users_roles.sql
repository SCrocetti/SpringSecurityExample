
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

INSERT INTO users_roles
(
	user_id,
	role_id,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	1,
	1,
	now()::TIMESTAMP,
	2,
	TRUE
);

INSERT INTO users_roles
(
	user_id,
	role_id,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	2,
	2,
	now()::TIMESTAMP,
	2,
	TRUE
);

INSERT INTO users_roles
(
	user_id,
	role_id,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	3,
	3,
	now()::TIMESTAMP,
	2,
	TRUE
);

INSERT INTO users_roles
(
	user_id,
	role_id,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	4,
	4,
	now()::TIMESTAMP,
	2,
	TRUE
);

INSERT INTO users_roles
(
	user_id,
	role_id,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	5,
	2,
	now()::TIMESTAMP,
	2,
	TRUE
);
INSERT INTO users_roles
(
	user_id,
	role_id,
	creation_date_time,
	creation_user,
	enabled
)
VALUES
(
	5,
	4,
	now()::TIMESTAMP,
	2,
	TRUE
);