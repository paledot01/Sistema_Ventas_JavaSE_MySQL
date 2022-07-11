DROP DATABASE IF EXISTS ShoesForMen;
CREATE DATABASE  ShoesForMen;
USE ShoesForMen;


CREATE TABLE distrito(
cod_distrito    char(5),
descripcion     varchar(25),
primary key (cod_distrito)
);

CREATE TABLE estado(
cod_estado int(1),
descripcion varchar(25),
primary key(cod_estado)
);

CREATE TABLE cargo(
cod_cargo       char(5),
descripcion     varchar(25),
primary key (cod_cargo)
);

CREATE TABLE marca(
cod_marca      char(5),
nombre_marca   varchar(25),
primary key (cod_marca)
);

CREATE TABLE categoria(
cod_categoria   char(5),
descripcion     varchar(25),
primary key (cod_categoria)
);

CREATE TABLE modelo(
cod_modelo     char(5),
nombre_modelo  varchar(25),
precio_compra  double,
precio_venta   double,
cod_marca      char(5),
cod_categoria  char(5),
primary key (cod_modelo),
foreign key (cod_marca) references marca(cod_marca),
foreign key (cod_categoria) references categoria(cod_categoria)
);

CREATE TABLE empleado(
cod_empleado    char(5),
nombre          varchar(25),
apellidos       varchar(25),
dni             char(8),
direccion       varchar(45),
telefono        varchar(12),
email           varchar(45),
cod_distrito    char(5),
cod_cargo       char(5),
usuario         varchar(25),
contraseña      varchar(25),
cod_estado      int(1), 
primary key (cod_empleado),
foreign key (cod_distrito) references distrito(cod_distrito),
foreign key (cod_cargo) references cargo(cod_cargo),
foreign key (cod_estado) references estado(cod_estado)
);

CREATE TABLE cliente(
cod_cliente    char(7),
nombre         varchar(25),
apellidos      varchar(25),
dni            char(8),
direccion      varchar(45),
telefono       varchar(12),
email          varchar(45),
cod_distrito   char(5),
primary key (cod_cliente),
foreign key (cod_distrito) references distrito(cod_distrito)
);

CREATE TABLE calzado(
cod_calzado    char(7),
cod_modelo     char(5),
talla          int,
color          varchar(15),
stock          int,
primary key (cod_calzado),
foreign key (cod_modelo) references modelo(cod_modelo)
);

CREATE TABLE boleta(
cod_boleta     char(7),
fecha_emision  datetime,
cod_cliente    char(7),
cod_empleado   char(5),
primary key (cod_boleta),
foreign key (cod_cliente) references cliente(cod_cliente),
foreign key (cod_empleado) references empleado(cod_empleado)
);

CREATE TABLE detalle_boleta(
cod_boleta     char(7),
cod_calzado    char(7),
cantidad       int,
importe        double,
primary key (cod_boleta, cod_calzado),
foreign key (cod_boleta) references boleta(cod_boleta),
foreign key (cod_calzado) references calzado(cod_calzado)
);

############################################### ESTADO ################################################

insert estado (cod_estado, descripcion) value ('0','INACTIVO');
insert estado (cod_estado, descripcion) value ('1','ACTIVO');

select * from estado;

############################################### DISTRITO ################################################

DELIMITER // 
create procedure pa_listar_distrito()
begin
	select * from distrito;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_distrito(
	in p_valor varchar(50)
)
begin
	select * from distrito where descripcion = p_valor or  cod_distrito = p_valor;
end;
//DELIMITER ;

insert distrito (cod_distrito,descripcion) value ('DI001','Comas');
insert distrito (cod_distrito,descripcion) value ('DI002','Lince');
insert distrito (cod_distrito,descripcion) value ('DI003','Miraflores');
insert distrito (cod_distrito,descripcion) value ('DI004','Los olivos');
insert distrito (cod_distrito,descripcion) value ('DI005','S.J.L');
insert distrito (cod_distrito,descripcion) value ('DI006','Independencia');

############################################### CARGO ################################################

DELIMITER // 
create procedure pa_listar_cargo()
begin
	select * from cargo;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_cargo(
	in p_valor varchar(50)
)
begin
	select * from cargo where cod_cargo = p_valor or  descripcion = p_valor;
end;
//DELIMITER ;

insert cargo (cod_cargo,descripcion) value ('CAR01','Administrador');
insert cargo (cod_cargo,descripcion) value ('CAR02','Vendedor');

############################################### EMPLEADO ################################################

drop procedure if exists pa_validar_empleado;
DELIMITER // 
create procedure pa_validar_empleado(
	in p_usuario varchar(25),
    in p_contraseña varchar(25)
)
begin
	select * from empleado where usuario = p_usuario and contraseña = p_contraseña and cod_estado = 1;
end;
//DELIMITER ;

drop procedure if exists pa_listar_empleado_original;
DELIMITER // 
create procedure pa_listar_empleado_original()
begin
	select * from empleado;
end;
//DELIMITER ;


drop procedure if exists pa_listar_empleado;
DELIMITER // 
create procedure pa_listar_empleado()
begin
	select e.cod_empleado, e.nombre, e.apellidos, e.dni, e.direccion, e.telefono, e.email, d.descripcion, c.descripcion, e.usuario, e.contraseña, et.descripcion from empleado as e
    inner join distrito as d on d.cod_distrito = e.cod_distrito
    inner join cargo as c on c.cod_cargo = e.cod_cargo
    inner join estado as et on et.cod_estado = e.cod_estado
    order by 1 asc;
end;
//DELIMITER ;


drop procedure if exists pa_insertar_empleado;
DELIMITER //
create procedure pa_insertar_empleado(
	in p_cod_empleado char(5),
    in p_nombre varchar(25),
    in p_apellidos varchar(25),
    in p_dni char(8),
    in p_direccion varchar(45),
    in p_telefono varchar(12),
    in p_email varchar(45),
    in p_cod_distrito char(5),
    in p_cod_cargo char(5),
    in p_usuario varchar(25),
    in p_contraseña varchar(25),
    in p_cod_estado int(1)
)
begin
	insert into empleado(cod_empleado,nombre,apellidos,dni,direccion,telefono,email,cod_distrito,cod_cargo,usuario,contraseña,cod_estado)
    values(p_cod_empleado,p_nombre,p_apellidos,p_dni,p_direccion,p_telefono,p_email,p_cod_distrito,p_cod_cargo,p_usuario,p_contraseña,p_cod_estado);
end;
//DELIMITER ;

/*DELIMITER // 
create procedure pa_eliminar_empleado(
	in p_cod_empleado char(5)
)
begin
	delete FROM empleado WHERE cod_empleado = p_cod_empleado;
end;
//DELIMITER ;*/

DELIMITER // 
create procedure pa_actualizar_empleado(
	in p_cod_empleado char(5),
    in p_nombre varchar(25),
    in p_apellidos varchar(25),
    in p_dni char(8),
    in p_direccion varchar(45),
    in p_telefono varchar(12),
    in p_email varchar(45),
    in p_cod_distrito char(5),
    in p_cod_cargo char(5),
    in p_usuario varchar(25),
    in p_contraseña varchar(25),
    in p_cod_estado int(1)
)
begin
	update empleado 
    SET nombre          = p_nombre,
		apellidos       = p_apellidos,
        dni             = p_dni,
        direccion       = p_direccion,
        telefono        = p_telefono,
        email           = p_email,
        cod_distrito    = p_cod_distrito,
        cod_cargo       = p_cod_cargo,
        usuario         = p_usuario,
        contraseña      = p_contraseña,
        cod_estado      = p_cod_estado
    where cod_empleado = p_cod_empleado;
end;
//DELIMITER ;


DELIMITER //
create procedure pa_buscar_ultimo_codigo_empleado()
begin
	select substring(max(cod_empleado),3) from empleado;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_empleado_original_por_codigo;
DELIMITER //
create procedure pa_buscar_empleado_original_por_codigo(
	in p_valor varchar(50)
)
begin
	select * from empleado where cod_empleado like concat('%',p_valor,'%');
end;
//DELIMITER ;


drop procedure if exists pa_buscar_empleado_por_codigo_exacto;
DELIMITER //
create procedure pa_buscar_empleado_por_codigo_exacto(
	in p_valor varchar(50)
)
begin
	select e.cod_empleado, e.nombre, e.apellidos, e.dni, e.direccion, e.telefono, e.email, d.descripcion, c.descripcion, e.usuario, e.contraseña, et.descripcion from empleado as e
    inner join distrito as d on d.cod_distrito = e.cod_distrito
    inner join cargo as c on c.cod_cargo = e.cod_cargo
    inner join estado as et on et.cod_estado = e.cod_estado
    having e.cod_empleado = p_valor;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_empleado_por_codigo;
DELIMITER //
create procedure pa_buscar_empleado_por_codigo(
	in p_valor varchar(50)
)
begin
	select e.cod_empleado, e.nombre, e.apellidos, e.dni, e.direccion, e.telefono, e.email, d.descripcion, c.descripcion, e.usuario, e.contraseña, et.descripcion from empleado as e
    inner join distrito as d on d.cod_distrito = e.cod_distrito
    inner join cargo as c on c.cod_cargo = e.cod_cargo
    inner join estado as et on et.cod_estado = e.cod_estado
    having e.cod_empleado like concat('%',p_valor,'%')
    order by 1 asc;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_empleado_por_nombre_apellido;
DELIMITER //
create procedure pa_buscar_empleado_por_nombre_apellido(
	in p_valor varchar(50)
)
begin
	select e.cod_empleado, e.nombre, e.apellidos, e.dni, e.direccion, e.telefono, e.email, d.descripcion, c.descripcion, e.usuario, e.contraseña, et.descripcion from empleado as e
    inner join distrito as d on d.cod_distrito = e.cod_distrito
    inner join cargo as c on c.cod_cargo = e.cod_cargo
    inner join estado as et on et.cod_estado = e.cod_estado
	having e.nombre like concat('%',p_valor,'%') or e.apellidos like concat('%',p_valor,'%')
    order by 1 asc;
    
end;
//DELIMITER ;


drop procedure if exists pa_buscar_empleado_por_dni;
DELIMITER //
create procedure pa_buscar_empleado_por_dni(
	in p_valor varchar(50)
)
begin
	select e.cod_empleado, e.nombre, e.apellidos, e.dni, e.direccion, e.telefono, e.email, d.descripcion, c.descripcion, e.usuario, e.contraseña, et.descripcion from empleado as e
    inner join distrito as d on d.cod_distrito = e.cod_distrito
    inner join cargo as c on c.cod_cargo = e.cod_cargo
    inner join estado as et on et.cod_estado = e.cod_estado
	having e.dni like concat('%',p_valor,'%')
    order by 1 asc;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_empleado_por_distrito;
DELIMITER //
create procedure pa_buscar_empleado_por_distrito(
	in p_valor varchar(50)
)
begin
	select e.cod_empleado, e.nombre, e.apellidos, e.dni, e.direccion, e.telefono, e.email, d.descripcion, c.descripcion, e.usuario, e.contraseña, et.descripcion from empleado as e
    inner join distrito as d on d.cod_distrito = e.cod_distrito
    inner join cargo as c on c.cod_cargo = e.cod_cargo
    inner join estado as et on et.cod_estado = e.cod_estado
    having d.descripcion like concat('%',p_valor,'%')
    order by 1 asc;
end;
//DELIMITER ;

# Cambiando el orden de codigo_distrito del empleado, en la igualdad, los resultados se ordenan 
# en el orden de creacion de los empleados, si cambiaramos el orden de la igualdad se ordenarian por
# la creacion de distrito.
# call pa_buscar_empleado_por_distrito('e');

call pa_insertar_empleado('EM001','KEVIN','BASILIO','44455500','JR. 2 DE MAYO #43','999333555','paledot01@gmail.com','DI004','CAR01','','',1);
call pa_insertar_empleado('EM002','ANGELICA','ANDRADE CERNA','40138356','JR.M ANUEL PRADO #250','970315487','ANDRADE@gmail.com','DI005','CAR02','angelicaa','40138356',0);
call pa_insertar_empleado('EM003','ROSAURA','TARAZONA RIVAS','40457140','JR. LOS ROSALES #350', '993315487','TARANOZA@gmail.com','DI002','CAR02','rosaurat','40457140',1);
call pa_insertar_empleado('EM004','RUTH','TARDIO HUAMAN','40198740','AV. JOSE BALTA #170', '990115487','TARDIO@gmail.com','DI004','CAR02','rutht','40198740',0);
call pa_insertar_empleado('EM005','GLORIA','ZELADA VELA','78538140','AV. CARLOS MARIATEGUI #5000', '900315487','ZELADA@gmail.com','DI004','CAR02','gloriaz','78538140',1);
call pa_insertar_empleado('EM006','SOLEDAD','ZARATE LOPEZ','35638140','AV. ALFONSO UGARTE #3420', '990316687','ZARATE@gmail.com','DI003','CAR02','soledadz','35638140',1);
call pa_insertar_empleado('EM007','BRENDA','QUISPE RAMOS','40138140','JR. PACHITEA #140', '990387487','QUISPE@gmail.com','DI001','CAR02','brendaq','40138140',1);
call pa_insertar_empleado('EM008','JUDITH','ALEGRE FABRA','64265741','ABELARDO QUIÑONES #60', '968265993','ALEGRE@gmail.com','DI002','CAR02','juditha','64265741',1);
call pa_insertar_empleado('EM009','ROBERTO','BALLESTEROS PALACIOS','45297583','AV. 2 DE OCTUBRE #24', '957395865','BALLESTEROS@gmail.com','DI002','CAR02','robertob','45297583',0);
call pa_insertar_empleado('EM010','ELADIO','BASTIDA RODA','69930584','AV. MARAÑON #84', '963960957','BASTIDA@gmail.com','DI005','CAR02','eladiob','69930584',0);
call pa_insertar_empleado('EM011','VERA','IGLESIAS PINEDA','82748573','AV. LAS PALMERAS #35', '968265993','IGLESIAS@gmail.com','DI001','CAR02','verai','82748573',1);
call pa_insertar_empleado('EM012','NELIDA','PEDRERO CAÑELLAS','83757482','AV. UNIVERSITARIA #53', '968947261','PEDRERO@gmail.com','DI001','CAR02','nelidap','83757482',0);
call pa_insertar_empleado('EM013','JACINTO','QUINTANILLA GUERRERO','23146264','AV. LOS ALISOS #967', '998621463','QUINTANILLA@gmail.com','DI004','CAR02','jacintoq','23146264',1);
call pa_insertar_empleado('EM014','VICTORIANO','NICOLAS MANZANO','37538456','AV. 18 DE ENERO #45', '989375666','NICOLAS@gmail.com','DI005','CAR02','victorianon','37538456',1);
call pa_insertar_empleado('EM015','JIMENA','MARQUES ELIAS','73857485','AV. LOS HEROES #607', '964823546','MARQUES@gmail.com','DI004','CAR02','jimenam','73857485',1);
call pa_insertar_empleado('EM016','YESICA','SANDOBAL CUSTODIA','58483059','AV. ARICA #485', '967254637','SANDOBAL@gmail.com','DI002','CAR02','yesicas','58483059',1);
call pa_insertar_empleado('EM017','FLORENTINA','SOTO MACHADO','67859454','JR. RESTAURACION #23', '986958693','SOTO@gmail.com','DI004','CAR02','florentinas','67859454',0);
call pa_insertar_empleado('EM018','MARITZA','PEREZ VENDRELL','59326152','AV. LA ALBORADA #565', '987562112','PEREZ@gmail.com','DI002','CAR02','maritzap','59326152',1);
call pa_insertar_empleado('EM019','RAFAELA','CAÑETE BURGOS','21536473','AV. LA ALBORADA #235', '9222374677','CAÑETE@gmail.com','DI005','CAR02','rafaelac','21536473',1);
call pa_insertar_empleado('EM020','MARTINA','VILLENA ARTEAGA','36736289','AV. UNIVERSITARIA #125', '964515466','VILLENA@gmail.com','DI001','CAR02','martinav','36736289',1);
call pa_insertar_empleado('EM021','LEOPOLDO','NEIRA GOMEZ','46285944','AV. LA MARINA #578', '978525553','LEOPOLDO@gmail.com','DI004','CAR02','leopoldon','46285944',1);
call pa_insertar_empleado('EM022','ANGELA','APARICIO SEGURA','53617235','AV. BRASIL #446', '985783623','ANGELA@gmail.com','DI001','CAR02','angelaa','53617235',0);
call pa_insertar_empleado('EM023','MARIO','ALVARO IBAÑEZ','43758266','AV. TACNA #43', '974612534','ALVARO@gmail.com','DI003','CAR02','marioa','43758266',1);
call pa_insertar_empleado('EM024','CATALINA','MENDEZ HUERTA','44672834','AV. BERTOLOTTO #532', '973625367','MENDEZ@gmail.com','DI005','CAR02','catalinam','44672834',1);
call pa_insertar_empleado('EM025','JOSE','SAEZ RAYA','28678543','AV. LIMA #51', '964732876','SAEZ@gmail.com','DI001','CAR02','joses','28678543',1);


call pa_listar_empleado_original();

############################################### CLIENTE ################################################

DELIMITER // 
create procedure pa_listar_cliente()
begin
	select * from cliente;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_insertar_cliente(
	in p_cod_cliente char(7),
    in p_nombre varchar(25),
    in p_apellidos varchar(25),
    in p_dni char(8),
    in p_direccion varchar(45),
    in p_telefono varchar(12),
    in p_email varchar(45),
    in p_cod_distrito char(5)
)
begin
	insert into cliente(cod_cliente,nombre,apellidos,dni,direccion,telefono,email,cod_distrito) 
    values(p_cod_cliente,p_nombre,p_apellidos,p_dni,p_direccion,p_telefono,p_email,p_cod_distrito);
end;
//DELIMITER ;

DELIMITER // 
create procedure pa_actualizar_cliente(
	in p_cod_cliente char(7),
    in p_nombre varchar(25),
    in p_apellidos varchar(25),
    in p_dni char(8),
    in p_direccion varchar(45),
    in p_telefono varchar(12),
    in p_email varchar(45),
    in p_cod_distrito char(5)
)
begin
	update cliente 
    SET nombre          = p_nombre,
		apellidos       = p_apellidos,
        dni             = p_dni,
        direccion       = p_direccion,
        telefono        = p_telefono,
        email           = p_email,
        cod_distrito    = p_cod_distrito
    where cod_cliente = p_cod_cliente;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_ultimo_codigo_cliente()
begin
	select substring(max(cod_cliente),3) from cliente;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_cliente_por_codigo(
	in p_valor varchar(50)
)
begin
	select * from cliente where cod_cliente like concat('%',p_valor,'%');
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_cliente_por_nombre_apellido(
	in p_valor varchar(50)
)
begin
	select * from cliente where nombre like concat('%',p_valor,'%') or apellidos like concat('%',p_valor,'%');
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_cliente_por_dni(
	in p_valor varchar(50)
)
begin
	select * from cliente where dni like concat('%',p_valor,'%');
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_cliente_por_distrito(
	in p_valor varchar(50)
)
begin
	select c.* , d.* from cliente as c inner join distrito as d
		on d.cod_distrito = c.cod_distrito
        having d.descripcion like concat('%',p_valor,'%');
end;
//DELIMITER ;

call pa_insertar_cliente('CL10001','ANETH LUANA','TINEO URIBE','32425643','AV. LOS GIRASOLES # 1800','990990230','LUANITAHERMOSA@GMAIL.COM','DI002');
call pa_insertar_cliente('CL10002','JOSE LUIS','TARAZONA ZELA','78395021','AV. LAS FLORES # 1800',null,'JOSESITO@GMAIL.COM','DI003');
call pa_insertar_cliente('CL10003','ANA MARIA','VILLAVICENCIO CASTRO','48502717','AV. LAS FLORES # 2560','989434228','ANITAMARIA@GMAIL.COM','DI005');
call pa_insertar_cliente('CL10004','JOSE ANTONIO','ENCISO NOLASCO','86294711','AV. PROCERES DE LA INDEPENDENCIA # 5000','987845874','JOSANTONIO@GMAIL.COM','DI006');
call pa_insertar_cliente('CL10005','ALEJANDRA','CHUCO HUERTA','97537923','AV. GRAN CHIMU # 3500','963245874','ALEJANDRITA5245@HOTMAIL.COM','DI005');

call pa_listar_cliente;

############################################### MARCA ################################################

DELIMITER // 
create procedure pa_listar_marca()
begin
	select * from marca;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_insertar_marca(
	in p_cod_marca      char(5),
	in p_nombre_marca   varchar(25)
)
begin
	insert into marca(cod_marca,nombre_marca) 
    values(p_cod_marca,p_nombre_marca);
end;
//DELIMITER ;

DELIMITER // 
create procedure pa_actualizar_marca(
	in p_cod_marca      char(5),
	in p_nombre_marca   varchar(25)
)
begin
	update marca 
    SET nombre_marca = p_nombre_marca
    where cod_marca = p_cod_marca;
end;
//DELIMITER ;

-- DELIMITER //
-- create procedure pa_buscar_marca(
-- 	in p_valor varchar(50)
-- )
-- begin
-- 	select * from marca where cod_marca = p_valor or  nombre_marca = p_valor;
-- end;
-- //DELIMITER ;

DELIMITER //
create procedure pa_buscar_marca(
	in p_valor varchar(50)
)
begin
	select * from marca where cod_marca like concat('%',p_valor,'%') or nombre_marca like concat('%',p_valor,'%');
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_ultimo_codigo_marca()
begin
	select substring(max(cod_marca),3) from marca;
end;
//DELIMITER ;

call pa_insertar_marca('MA001','Calimod');
call pa_insertar_marca('MA002','Basement');
call pa_insertar_marca('MA003','Call It Spring');

call pa_listar_marca();

############################################### CATEGORIA ################################################

DELIMITER // 
create procedure pa_listar_categoria()
begin
	select * from categoria;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_insertar_categoria(
	in p_cod_categoria      char(5),
	in p_descripcion        varchar(25)
)
begin
	insert into categoria(cod_categoria,descripcion) 
    values(p_cod_categoria,p_descripcion);
end;
//DELIMITER ;

DELIMITER // 
create procedure pa_actualizar_categoria(
	in p_cod_categoria      char(5),
	in p_descripcion   varchar(25)
)
begin
	update categoria 
    SET descripcion = p_descripcion
    where cod_categoria = p_cod_categoria;
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_categoria(
	in p_valor varchar(50)
)
begin
	select * from categoria where cod_categoria like concat('%',p_valor,'%') or descripcion like concat('%',p_valor,'%');
end;
//DELIMITER ;

DELIMITER //
create procedure pa_buscar_ultimo_codigo_categoria()
begin
	select substring(max(cod_categoria),4) from categoria;
end;
//DELIMITER ;

call pa_insertar_categoria('CAT01','Casual');
call pa_insertar_categoria('CAT02','Vestir');

call pa_listar_categoria();

############################################### MODELO ################################################

drop procedure if exists pa_listar_modelo_original;
DELIMITER //
create procedure pa_listar_modelo_original()
begin
	select * from modelo;
end;
//DELIMITER ;


drop procedure if exists pa_listar_modelo;
DELIMITER //
create procedure pa_listar_modelo()
begin
	select md.cod_modelo, md.nombre_modelo, mr.nombre_marca, ct.descripcion, md.precio_compra, md.precio_venta from modelo as md
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    order by 1 asc ;
end;
//DELIMITER ;


DELIMITER //
create procedure pa_insertar_modelo(
    in p_cod_modelo     char(5),
    in p_nombre_modelo  varchar(25),
    in p_precio_compra  double,
    in p_precio_venta   double,
    in p_cod_marca      char(5),
    in p_cod_categoria  char(5)
)
begin
	insert into modelo(cod_modelo, nombre_modelo, precio_compra, precio_venta, cod_marca, cod_categoria)
    values(p_cod_modelo, p_nombre_modelo, p_precio_compra, p_precio_venta, p_cod_marca, p_cod_categoria);
end;
//DELIMITER ;

DELIMITER //
create procedure pa_actualizar_modelo(
    in p_cod_modelo     char(5),
    in p_nombre_modelo  varchar(25),
    in p_precio_compra  double,
    in p_precio_venta   double,
    in p_cod_marca      char(5),
    in p_cod_categoria  char(5)
)
begin
	update modelo
    set nombre_modelo = p_nombre_modelo,
		precio_compra = p_precio_compra,
        precio_venta = p_precio_venta,
        cod_marca = p_cod_marca,
        cod_categoria = p_cod_categoria
	where cod_modelo = p_cod_modelo;
end;
//DELIMITER ;

drop procedure if exists pa_buscar_modelo_por_nombre_simple;
DELIMITER //
create procedure pa_buscar_modelo_por_nombre_simple(
	in p_valor varchar(50)
)
begin
	select * from modelo where nombre_modelo = p_valor;
end;
//DELIMITER ;

-- Busca el modelo por nombre_modelo, cod_modelo, nombre_marca o descripcion de la categoria
drop procedure if exists pa_buscar_modelo;
DELIMITER //
create procedure pa_buscar_modelo(
	in p_valor varchar(50)
)
begin
	select md.cod_modelo, md.nombre_modelo, mr.nombre_marca, ct.descripcion, md.precio_compra, md.precio_venta from modelo as md
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having 
    md.nombre_modelo like concat('%',p_valor,'%') 
    or md.cod_modelo like concat('%',p_valor,'%')
    or mr.nombre_marca like concat('%',p_valor,'%')
    or ct.descripcion like concat('%',p_valor,'%')
    order by 1 asc ;
end;
//DELIMITER ;


DELIMITER //
create procedure pa_buscar_ultimo_codigo_modelo()
begin
	select substring( max( cod_modelo ),2 ) from modelo;
end;
//DELIMITER ;

call pa_insertar_modelo('M1001','1CEA003',110.00,180.00,'MA001','CAT01');
call pa_insertar_modelo('M1002','1CSG001',145.00,220.00,'MA002','CAT01');
call pa_insertar_modelo('M1003','5VCS001',125.00,200.00,'MA001','CAT02');

call pa_insertar_modelo('M1004','Bartic Ne',200.00,325.00,'MA002','CAT02');
call pa_insertar_modelo('M1005','Burkos Cl',93.00,155.00,'MA003','CAT02');
call pa_insertar_modelo('M1006','Bart Gr',112.00,182.00,'MA002','CAT01');

call pa_insertar_modelo('M1007','FRESIEN-EMB009',160.00,240.00,'MA003','CAT01');
call pa_insertar_modelo('M1008','ZALITH001',179.00,279.00,'MA001','CAT02');
call pa_insertar_modelo('M1009','IMBROS410',139.00,219.00,'MA003','CAT01');

call pa_listar_modelo();



############################################### CALZADO ################################################

drop procedure if exists pa_listar_calzado_original;
DELIMITER //
create procedure pa_listar_calzado_original()
begin
	select * from calzado; 
end;
//DELIMITER ;


drop procedure if exists pa_listar_calzado;
DELIMITER //
create procedure pa_listar_calzado()
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz 
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    order by 1 asc ;
end;
//DELIMITER ;


DELIMITER //
create procedure pa_insertar_calzado(
	in p_cod_calzado    char(7),
	in p_cod_modelo     char(5),
	in p_talla          int,
	in p_color          varchar(15),
	in p_stock          int
)
begin
	insert into calzado(cod_calzado,cod_modelo,talla,color,stock)
    values(p_cod_calzado,p_cod_modelo,p_talla,p_color,p_stock);
end;
//DELIMITER ;


DELIMITER //
create procedure pa_actualizar_calzado(
	in p_cod_calzado    char(7),
	in p_cod_modelo     char(5),
	in p_talla          int,
	in p_color          varchar(15),
	in p_stock          int
)
begin
	update calzado
    set cod_calzado = p_cod_calzado,
		cod_modelo = p_cod_modelo,
        talla = p_talla,
        color = p_color,
        stock = p_stock
	where cod_calzado = p_cod_calzado;
end;
//DELIMITER ;


drop procedure if exists pa_reducir_stock_calzado;
DELIMITER //
create procedure pa_reducir_stock_calzado(
	in p_cod_calzado    char(7),
    in cantidad          int
)
begin
	update calzado
    set stock = stock - cantidad
	where cod_calzado = p_cod_calzado;
end;
//DELIMITER ;


DELIMITER //
create procedure pa_buscar_ultimo_codigo_calzado()
begin
	select substring( max( cod_calzado ), 3 ) from calzado;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_original_por_codigo;
DELIMITER //
create procedure pa_buscar_calzado_original_por_codigo(
	in p_valor varchar(50)
)
begin
	select * from calzado where cod_calzado like concat('%',p_valor,'%');
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_codigo_exacto;
DELIMITER //
create procedure pa_buscar_calzado_por_codigo_exacto(
	in p_valor varchar(50)
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having cz.cod_calzado = p_valor;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_codigo;
DELIMITER //
create procedure pa_buscar_calzado_por_codigo(
	in p_valor varchar(50)
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having cz.cod_calzado like concat('%',p_valor,'%');
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_modelo;
DELIMITER //
create procedure pa_buscar_calzado_por_modelo(
	in p_valor varchar(50)
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having md.nombre_modelo like concat('%',p_valor,'%');
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_categoria;
DELIMITER //
create procedure pa_buscar_calzado_por_categoria(
	in p_valor varchar(50)
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having ct.descripcion like concat('%',p_valor,'%')
    order by 1 asc ;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_marca;
DELIMITER //
create procedure pa_buscar_calzado_por_marca(
	in p_valor varchar(50)
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having mr.nombre_marca like concat('%',p_valor,'%')
    order by 1 asc ;
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_talla;
DELIMITER //
create procedure pa_buscar_calzado_por_talla(
	in p_valor int
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz 
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having cz.talla like concat('%',p_valor,'%');
end;
//DELIMITER ;


drop procedure if exists pa_buscar_calzado_por_color;
DELIMITER //
create procedure pa_buscar_calzado_por_color(
	in p_valor varchar(15)
)
begin
	select cz.cod_calzado , md.nombre_modelo , mr.nombre_marca , ct.descripcion , cz.talla , cz.color , md.precio_compra , md.precio_venta , cz.stock from calzado as cz
    inner join modelo as md on cz.cod_modelo = md.cod_modelo
    inner join marca as mr on md.cod_marca = mr.cod_marca
    inner join categoria as ct on md.cod_categoria = ct.cod_categoria
    having cz.color like concat('%',p_valor,'%');
end;
//DELIMITER ;


call pa_insertar_calzado('CZ10001','M1001',40,'Marron',14);
call pa_insertar_calzado('CZ10002','M1001',40,'Azul',10);

call pa_insertar_calzado('CZ10003','M1002',41,'Marron',9);
call pa_insertar_calzado('CZ10004','M1002',42,'Marron',6);

call pa_insertar_calzado('CZ10005','M1003',40,'Negro',4);
call pa_insertar_calzado('CZ10006','M1003',42,'Canela',8);

call pa_insertar_calzado('CZ10007','M1004',42,'Azul Marino',6);
call pa_insertar_calzado('CZ10008','M1004',42,'Canela',8);

call pa_insertar_calzado('CZ10009','M1006',41,'Negro',3);

call pa_listar_calzado;

############################################### BOLETA ################################################

DELIMITER // 
create procedure pa_listar_boleta()
begin
	select * from boleta;
end;
//DELIMITER ;

drop procedure if exists pa_insertar_boleta;
DELIMITER //
create procedure pa_insertar_boleta(
	in p_cod_boleta char(7),
    -- no es necesario colocar la fecha de emision como parametro porque se mySql lo obtiene con el metodo "now()"
    in p_cod_cliente char(7),
    in p_cod_empleado char(5)
)
begin
	insert into boleta(cod_boleta,fecha_emision,cod_cliente,cod_empleado) 
    values(p_cod_boleta,now(),p_cod_cliente,p_cod_empleado);
end;
//DELIMITER ;

drop procedure if exists pa_buscar_ultimo_codigo_boleta;
DELIMITER //
create procedure pa_buscar_ultimo_codigo_boleta()
begin
	select substring( max( cod_boleta ),3 ) from boleta;
end;
//DELIMITER ;

 -- no es necesario colocar la fecha de emision como parametro porque se mySql lo obtiene con el metodo "now()"
call pa_insertar_boleta('BL10001','CL10001','EM001');
call pa_insertar_boleta('BL10002','CL10002','EM002');
call pa_insertar_boleta('BL10003','CL10003','EM003');
call pa_insertar_boleta('BL10004','CL10003','EM003');

call pa_listar_boleta;

############################################### DETALLE BOLETA ################################################

DELIMITER // 
create procedure pa_listar_detalle_boleta()
begin
	select * from detalle_boleta;
end;
//DELIMITER ;

drop procedure if exists pa_insertar_detalle_boleta;
DELIMITER //
create procedure pa_insertar_detalle_boleta(
	in p_cod_boleta char(7),
    in p_cod_calzado char(7),
    in p_cantidad int,
    in p_importe double
)
begin
	insert into detalle_boleta(cod_boleta, cod_calzado, cantidad, importe) 
    values(p_cod_boleta, p_cod_calzado, p_cantidad, p_importe);
end;
//DELIMITER ;

call pa_insertar_detalle_boleta('BL10001','CZ10001','2',360.00);
call pa_insertar_detalle_boleta('BL10001','CZ10006','1',200.00);
call pa_insertar_detalle_boleta('BL10002','CZ10002','1',180.00);
call pa_insertar_detalle_boleta('BL10002','CZ10008','1',325.00);
call pa_insertar_detalle_boleta('BL10003','CZ10009','2',364.00);
call pa_insertar_detalle_boleta('BL10003','CZ10007','1',325.00);

call pa_listar_detalle_boleta;

