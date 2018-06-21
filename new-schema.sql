-- drop tables
drop table gb_becario;
drop table gb_condicion;
drop table gb_estado;
drop table gb_asignacion;
drop table gb_asesor;
drop table gb_sede_estudio;
drop table gb_ies;
drop table gb_tipo_gestion;
drop table gb_tipo_ies;
drop table gb_carrera;
drop table gb_beca;

-- drop sequence
drop sequence gb_becario_seq;
drop sequence gb_sede_estudio_seq;
drop sequence gb_tipo_gestion_seq;
drop sequence gb_tipo_ies_seq;
drop sequence gb_ies_seq;
drop sequence gb_carrera_seq;
drop sequence gb_beca_seq;
drop sequence gb_asesor_seq;
drop sequence gb_asignacion_seq;
drop sequence gb_estado_seq;
drop sequence gb_condicion_seq;

-- create table
create table gb_beca(
  id_beca number(3),
  convocatoria varchar2(45),
  modalidad varchar2(200),
  inicio date,
  termino date
);

create table gb_carrera(
  id_carrera number(3),
  descripcion varchar2(200),
  semestre_egreso varchar2(45),
  id_beca number(3)
);

create table gb_tipo_gestion(
  id_tipo_gestion number(3),
  descripcion varchar2(100)
);

create table gb_tipo_ies(
  id_tipo_ies number(3),
  descripcion varchar2(100)
);

create table gb_ies(
  id_ies number(3),
  nombre varchar2(100),
  id_tipo_ies number(3),
  id_tipo_gestion number(3)
);

create table gb_sede_estudio(
  id_sede_estudio number(3),
  region varchar2(45),
  sede varchar2(45),
  id_ies number(3)
);


create table gb_asesor(
  id_asesor number(3),
  nombre varchar2(100)
);

create table gb_asignacion(
  id_asignacion number(3),
  id_carrera number(3),
  id_sede_estudio number(3),
  id_asesor number(3)
);

create table gb_estado(
  id_estado number(3),
  descripcion varchar2(45)
);

create table gb_condicion(
  id_condicion number(3),
  descripcion varchar2(200),
  id_estado number(3),
  id_sub_condicion number(3)
);

create table gb_becario(
  id_becario number(4),
  dni varchar2(8),
  nombres varchar2(100),
  apellidos varchar2(100),
  fecha_nacimiento date,
  edad number(2),
  sexo varchar2(45),
  id_asignacion number(3),
  numero_expediente varchar2(45),
  id_estado number(3),
  id_condicion number(3),
  resolucion_adjudicacion varchar2(100),
  resolucion_adjudicacion_fecha date,
  representante varchar2(250),
  representante_dni varchar2(45),
  telefonos varchar2(45),
  correo_pronabec varchar2(100),
  correo_personal varchar2(100),
  direccion varchar2(200),
  region_procedencia varchar2(45),
  provincia_procedencia varchar2(45),
  distrito_procedencia varchar2(45),
  region_postulacion varchar2(45),
  provincia_postulacion varchar2(45),
  distrito_postulacion varchar2(45),
  observaciones varchar2(200)
);

-- constraint
alter table gb_beca
add constraint pk_gb_beca primary key (id_beca);

alter table gb_carrera
add constraint pk_gb_carrera primary key (id_carrera);

alter table gb_carrera
add constraint fk_gb_carrera_gb_beca foreign key (id_beca)
references gb_beca(id_beca);

alter table gb_tipo_gestion
add constraint pk_gb_tipo_gestion primary key (id_tipo_gestion);

alter table gb_tipo_ies
add constraint pk_gb_tipo_ies primary key (id_tipo_ies);

alter table gb_ies
add constraint pk_gb_ies primary key (id_ies);

alter table gb_ies 
add constraint fk_gb_ies_gb_tipo_gestion foreign key (id_tipo_gestion)
references gb_tipo_gestion(id_tipo_gestion);

alter table gb_ies
add constraint fk_gb_ies_gb_tipo_ies foreign key (id_tipo_ies)
references gb_tipo_ies (id_tipo_ies);

alter table gb_sede_estudio
add constraint pk_gb_sede_estudio primary key (id_sede_estudio);

alter table gb_sede_estudio
add constraint fk_gb_sede_estudio_gb_ies foreign key (id_ies)
references gb_ies(id_ies);

alter table gb_asesor
add constraint pk_gb_asesor primary key (id_asesor);

alter table gb_asignacion
add constraint pk_gb_asignacion primary key (id_asignacion);

alter table gb_asignacion
add constraint fk_gb_asignacion_gb_carrera foreign key (id_carrera)
references gb_carrera(id_carrera);

alter table gb_asignacion
add constraint fk_gb_asignacion_gb_sede foreign key (id_sede_estudio)
references gb_sede_estudio(id_sede_estudio);

alter table gb_asignacion
add constraint fk_gb_asignacion_gb_asesor foreign key (id_asesor)
references gb_asesor(id_asesor);

alter table gb_estado
add constraint pk_gb_estado primary key (id_estado);

alter table gb_condicion
add constraint pk_gb_condicion primary key (id_condicion);

alter table gb_condicion
add constraint fk_gb_condicion_gb_estado foreign key (id_estado)
references gb_estado(id_estado);

alter table gb_condicion
add constraint fk_gb_condicion_sub_condicion foreign key (id_sub_condicion)
references gb_condicion(id_condicion);

alter table gb_becario
add constraint pk_becario primary key (id_becario);

alter table gb_becario
add constraint fk_becario_gb_asignacion foreign key (id_asignacion)
references gb_asignacion(id_asignacion);

alter table gb_becario
add constraint fk_gb_becario_gb_estado foreign key(id_estado)
references gb_estado(id_estado);

alter table gb_becario
add constraint fk_gb_becario_gb_condicion foreign key (id_condicion)
references gb_condicion(id_condicion);

-- create sequences
create sequence gb_becario_seq
minvalue 1
maxvalue 9999
start with 1
increment by 1
cache 20;

create sequence gb_sede_estudio_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_tipo_gestion_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_tipo_ies_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_ies_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_carrera_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_beca_seq
minvalue 1
maxvalue 9999
start with 1
increment by 1
cache 20;

create sequence gb_asesor_seq
minvalue 1
maxvalue 9999
start with 1
increment by 1
cache 20;

create sequence gb_asignacion_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_estado_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

create sequence gb_condicion_seq
minvalue 1
maxvalue 999
start with 1
increment by 1
cache 20;

-- carga de data base
--insert into gb_tipo_gestion(id_tipo_gestion, descripcion) values (gb_tipo_gestion_seq.nextval, 'Publico');
--insert into gb_tipo_gestion(id_tipo_gestion, descripcion) values (gb_tipo_gestion_seq.nextval, 'Privado');
--insert into gb_tipo_gestion(id_tipo_gestion, descripcion) values (gb_tipo_gestion_seq.nextval, 'Publico - Privado');

--insert into gb_tipo_ies(id_tipo_ies, descripcion) values (gb_tipo_ies_seq.nextval, 'Instituto');
--insert into gb_tipo_ies(id_tipo_ies, descripcion) values (gb_tipo_ies_seq.nextval, 'Universidad');
--insert into gb_tipo_ies(id_tipo_ies, descripcion) values (gb_tipo_ies_seq.nextval, 'Cetpro');
--insert into gb_tipo_ies(id_tipo_ies, descripcion) values (gb_tipo_ies_seq.nextval, 'Escuela');

insert into gb_estado(id_estado, descripcion) values (gb_estado_seq.nextval, 'Activo');
insert into gb_estado(id_estado, descripcion) values (gb_estado_seq.nextval, 'Inactivo');

insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Pendiente de inicio de clases', 1, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Cursando estudios', 1, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Suspension de beca', 1, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Incapacidad medica', 1, 3);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Causa inputable a la IES', 1, 3);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Caso fortuito o fuerza mayor', 1, 3);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Vacaciones no subvencionadas', 1, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Vacaciones subvencionadas', 1, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Egresado, en tramite de titulo', 2, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Egresado, culminacion de beca y con solicitud de carta de presentacion', 2, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Perdida de beca', 2, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Revocado', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Renuncia antes de subvencion', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Renuncia despues de subvencion', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Desaprobacion de modulo', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Desaprobacion de promedio', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Abandono antes de matricula', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Abandono despues de matricula', 2, 11);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Nulidad de beca', 2, null);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Reiterado incumplimiento de obligacion', 2, 19);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Fallecimiento', 2, 19);
insert into gb_condicion(id_condicion, descripcion, id_estado, id_sub_condicion) values (gb_condicion_seq.nextval, 'Contraviene normas de la IES', 2, 19);

commit;
