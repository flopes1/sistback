CREATE TABLE dbo.condominium 
(
	id SERIAL,
	name TEXT NOT NULL UNIQUE,
	active BOOLEAN DEFAULT TRUE,
	PRIMARY KEY (id)
);

CREATE TABLE dbo.employee 
(
	id SERIAL,
	condominium_id INTEGER,
	name TEXT NOT NULL,
	cpf TEXT NOT NULL UNIQUE,
	local_adm BOOLEAN DEFAULT FALSE,
	system_adm BOOLEAN DEFAULT FALSE,
	email TEXT NOT NULL,
	password TEXT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (condominium_id) REFERENCES dbo.condominium (id) 
	ON DELETE CASCADE
);

CREATE TABLE dbo.userr
(
	id SERIAL,
	name TEXT NOT NULL,	
	cpf TEXT NOT NULL UNIQUE,
	email TEXT NOT NULL,
	password TEXT NOT NULL,
	apartment_identifier TEXT NOT NULL,
	condominium_id INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (condominium_id) REFERENCES dbo.condominium (id)
	ON DELETE CASCADE 
);

CREATE TABLE dbo.visitor
(
	id SERIAL,
	condominium_id INTEGER,
	name TEXT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (condominium_id) REFERENCES dbo.condominium (id)
	ON DELETE CASCADE
);

CREATE TABLE dbo.condominium_address 
(
	id SERIAL,
	condominium_id INTEGER,
	street TEXT NOT NULL,
	number_ INTEGER NOT NULL,
	complement TEXT NULL,
	district TEXT NOT NULL,
	state_ TEXT NOT NULL,
	city TEXT NOT NULL,
	zip_code INTEGER NOT NULL,
	country TEXT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (condominium_id) REFERENCES dbo.condominium (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.phone_number_condominium
(
	id SERIAL,
	condominium_id INTEGER,
	country_code SMALLINT NOT NULL,
	state_code SMALLINT NOT NULL,
	number_ INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (condominium_id) REFERENCES dbo.condominium (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.phone_number_userr
(
	id SERIAL,
	userr_id INTEGER,
	country_code SMALLINT NOT NULL,
	state_code SMALLINT NOT NULL,
	number_ INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (userr_id) REFERENCES dbo.userr (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.phone_number_employee
(
	id SERIAL,
	employee_id INTEGER,
	country_code SMALLINT NOT NULL,
	state_code SMALLINT NOT NULL,
	number_ INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (employee_id) REFERENCES dbo.employee (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.phone_number_visitor
(
	id SERIAL,
	visitor_id INTEGER,
	country_code SMALLINT NOT NULL,
	state_code SMALLINT NOT NULL,
	number_ INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (visitor_id) REFERENCES dbo.visitor (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.vehicle
(
	id SERIAL,
	userr_id INTEGER,
	model TEXT NOT NULL,
	color TEXT NOT NULL,
	license_plate TEXT NOT NULL UNIQUE,
	PRIMARY KEY (id),
	FOREIGN KEY (userr_id) REFERENCES dbo.userr (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.enum_status_kind 
(
	id SERIAL,
	name TEXT NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

INSERT INTO dbo.enum_status_kind (name) VALUES ('Finalizado');
INSERT INTO dbo.enum_status_kind (name) VALUES ('Cancelado');
INSERT INTO dbo.enum_status_kind (name) VALUES ('Em aberto');

CREATE TABLE dbo.autentication_history
(
	id SERIAL,
	condominium_id INTEGER REFERENCES dbo.condominium (id),
	userr_id INTEGER REFERENCES dbo.userr (id),
	employee_id INTEGER REFERENCES dbo.employee (id),
	accepted BOOLEAN DEFAULT FALSE,
	reason TEXT NULL,
	date_ TIMESTAMP NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE dbo.scheduled_visit
(
	id SERIAL NOT NULL UNIQUE,
	condominium_id INTEGER REFERENCES dbo.condominium (id) ON DELETE CASCADE,
	userr_requester_id INTEGER REFERENCES dbo.userr (id) ON DELETE CASCADE,
	visitor_id INTEGER REFERENCES dbo.visitor (id) ON DELETE CASCADE,
	visit_date TIMESTAMP NOT NULL,
	kind TEXT NULL,
	has_vehicle BOOLEAN NULL,
	status INTEGER NULL REFERENCES dbo.enum_status_kind (id), 
	PRIMARY KEY (id)
);

CREATE TABLE dbo.service_provision
(
	id SERIAL,
	scheduled_visit_id INTEGER,
	company TEXT NOT NULL,
	description TEXT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (scheduled_visit_id) REFERENCES dbo.scheduled_visit (id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dbo.access_request
(
     id SERIAL,
     condominium_id INTEGER REFERENCES dbo.condominium (id) ON DELETE CASCADE,
     userr_id INTEGER REFERENCES dbo.userr (id) ON DELETE CASCADE,
     request_date TIMESTAMP NOT NULL,
     PRIMARY KEY (id)
);


--GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA dbo TO ssladmin
--GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA dbo to ssladmin;