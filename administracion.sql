create database ADMINISTRACION;
use ADMINISTRACION;

create table usuario(
	idUsuario varchar(20) not null,
    documento int(20) not null unique,
    nombre varchar(80) not null,
    apellido varchar(80) not null,
    telefono varchar(20),
    correo varchar(80) not null,
    rol varchar(40) not null,
    constraint idUsuario_pk primary key (idUsuario)
);

create table residente(
	idResidente varchar(20) not null,
    constraint idRes_pk primary key (idResidente)
);

create table usuario_residente(
	idUsuario varchar(20) not null,
    idResidente varchar(20) not null,
    constraint usu_res_pk primary key (idUsuario,idResidente),
    constraint usu_res_idUsu_fk foreign key (idUsuario) references usuario(idUsuario),
    constraint usu_res_idRes_fk foreign key (idResidente) references residente(idResidente)   
);

create table administrador(
	idAdministrador varchar(20) not null,
    constraint idAdmin_pk primary key (idAdministrador)
);

create table usuario_administrador(
	idUsuario varchar(20) not null,
    idAdministrador varchar(20) not null,
    constraint usu_admin_pk primary key (idUsuario,idAdministrador),
    constraint usu_admin_idUsu_fk foreign key (idUsuario) references usuario(idUsuario),
    constraint usu_admin_idAdmin_fk foreign key (idAdministrador) references administrador(idAdministrador)   
);

create table apartamento(
	idApartamento varchar(20) not null,
    numApartamento varchar(20) not null unique,
    serv_basicos varchar(255) not null,
    serv_secun varchar(255) not null,
    constraint idApt_pk primary key (idApartamento)
);

create table residente_apartamento(
	idResidente varchar(20) not null,
	idApartamento varchar(20) not null,
    constraint res_apt_pk primary key(idResidente,idApartamento),
    constraint res_apt_idRes_fk foreign key (idResidente) references residente(idResidente),
    constraint res_apt_idApt_fk foreign key (idApartamento) references apartamento(idApartamento)
);

create table factura(
	idFactura varchar(20) not null,
    idResidente varchar(20) not null,
	idApartamento varchar(20) not null,
    numFactura int auto_increment,
    fec_expedicion date not null, 
    fec_pago date not null, 
    fec_pago_final date not null,
    constraint factura_pk primary key (idFactura,idResidente,idApartamento),
    constraint factura_res_fk foreign key(idResidente) references residente(idResidente),
    constraint factura_apt_fk foreign key(idApartamento) references apartamento(idApartamento)
);



insert into usuario values("1192769384","1192769384","Jose Armando","Ustaris Salcedo","3023036019","joseusa192@gmail.com");
insert into inquilino values ("INQ-3612");
insert into usuario_inquilino values ("1192769384","INQ-3612");
alter table factura add (fec_expedicion date not null, fec_pago date not null, fec_pago_final date not null);

drop database ADMINISTRACION;

select * from factura;
select *from usuario_inquilino;
