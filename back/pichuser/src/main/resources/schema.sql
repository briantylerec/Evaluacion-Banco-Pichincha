-- public.persona definition

-- Drop table

-- DROP TABLE public.persona;

CREATE TABLE public.persona (
	id_persona varchar(255) NOT NULL,
	direccion varchar(255) NULL,
	edad int4 NULL,
	genero varchar(255) NULL,
	nombre varchar(255) NULL,
	telefono varchar(255) NULL,
	CONSTRAINT persona_pkey PRIMARY KEY (id_persona)
);


-- public.cliente definition

-- Drop table

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente (
	id_cliente varchar(255) NOT NULL,
	contrasena varchar(255) NULL,
	estado bool NULL,
	persona_id varchar(255) NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id_cliente),
	CONSTRAINT fkmc52upywn8gona2iiwwwphb92 FOREIGN KEY (persona_id) REFERENCES public.persona(id_persona)
);


-- public.cuenta definition

-- Drop table

-- DROP TABLE public.cuenta;

CREATE TABLE public.cuenta (
	id_cuenta varchar(255) NOT NULL,
	estado bool NULL,
	saldo_inicial float4 NULL,
	tipo_cuenta varchar(255) NULL,
	cliente_id varchar(255) NULL,
	CONSTRAINT cuenta_pkey PRIMARY KEY (id_cuenta),
	CONSTRAINT fk4p224uogyy5hmxvn8fwa2jlug FOREIGN KEY (cliente_id) REFERENCES public.cliente(id_cliente)
);


-- public.movimientos definition

-- Drop table

-- DROP TABLE public.movimientos;

CREATE TABLE public.movimientos (
	id_movimiento varchar(255) NOT NULL,
	fecha date NULL,
	saldo float4 NULL,
	tipo_movimiento varchar(255) NULL,
	valor float4 NULL,
	cuenta_id varchar(255) NULL,
	CONSTRAINT movimientos_pkey PRIMARY KEY (id_movimiento),
	CONSTRAINT fkof0364849tnpw8nw69v8m1vq4 FOREIGN KEY (cuenta_id) REFERENCES public.cuenta(id_cuenta)
);