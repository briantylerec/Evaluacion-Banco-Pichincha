INSERT INTO public.persona (id_persona,direccion,edad,genero,nombre,telefono) VALUES
	 ('0105686737','Otavalo sn y principal',20,'masculino','Jose Lema','098254785'),
	 ('0105686738','Amazonas y NNUU ',20,'femenino','Marianela Montalvo','097548965'),
	 ('0105686739','13 junio y Equinoccial ',20,'femenino','Juan Osorio','098874587'),
	 ('0102030201','13 junio y Equinoccial ',20,'femenino','Juan Osorio','098874587');

INSERT INTO public.cliente (id_cliente,contrasena,estado,persona_id) VALUES
	 ('0105686737','1234',true,'0105686737'),
	 ('0105686738','5678',true,'0105686738'),
	 ('0105686739','1245',true,'0105686739'),
	 ('0102030201','1245',true,'0102030201');

INSERT INTO public.cuenta (id_cuenta,estado,saldo_inicial,tipo_cuenta,cliente_id) VALUES
	 ('585545',true,1000.0,'corriente','0105686737'),
	 ('478758',true,1425.0,'ahorros','0105686737'),
	 ('225487',true,700.0,'corriente','0105686738'),
	 ('495878',true,150.0,'ahorros','0105686739'),
	 ('496825',true,0.0,'ahorros','0105686738');

INSERT INTO public.movimientos (id_movimiento,fecha,saldo,tipo_movimiento,valor,cuenta_id) VALUES
	 ('18','2022-05-15',275.0,'debito',575.0,'478758'),
	 ('19','2022-05-15',1425.0,'debito',575.0,'478758'),
	 ('20','2022-05-15',200.0,'credito',100.0,'225487'),
	 ('21','2022-05-15',100.0,'debito',100.0,'225487'),
	 ('23','2022-05-15',150.0,'credito',150.0,'495878'),
	 ('24','2022-05-15',0.0,'debito',540.0,'496825'),
	 ('22','2022-05-13',700.0,'credito',600.0,'225487');