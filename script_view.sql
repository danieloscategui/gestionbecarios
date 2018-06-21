create or replace view vw_gb_beca_carrera
as
select  b.id_beca, b.convocatoria, b.modalidad, b.inicio, b.termino,
        c.id_carrera, c.descripcion carrera, c.semestre_egreso
from gb_beca b
inner join gb_carrera c
on b.id_beca = c.id_beca;

create or replace view vw_gb_ies_carrera_sede 
as
select  i.id_ies, i.nombre ies,
        tg.descripcion tipo_gestion,
        ti.descripcion tipo_ies,
        sd.id_sede_estudio,
        sd.region,
        sd.sede
from gb_ies i
inner join gb_tipo_gestion tg
on i.id_tipo_gestion = tg.id_tipo_gestion
inner join gb_tipo_ies ti
on i.id_tipo_ies = ti.id_tipo_ies
inner join gb_sede_estudio sd
on i.id_ies = sd.id_ies;

create or replace view vw_gb_asignacion
as
select  asig.id_asignacion,
        b.id_beca,
        b.convocatoria,
        b.modalidad,
        c.id_carrera,
        c.descripcion carrera,
        i.id_ies,
        i.nombre ies,
        tg.descripcion tipo_gestion,
        ti.descripcion tipo_ies,
        sd.id_sede_estudio,
        sd.region,
        sd.sede,
        ase.id_asesor,
        ase.nombre asesor
from gb_asignacion asig
inner join gb_carrera c
  inner join gb_beca b
  on c.id_beca = b.id_beca
on asig.id_carrera = c.id_carrera
inner join gb_sede_estudio sd
  inner join gb_ies i
    inner join gb_tipo_gestion tg
    on i.id_tipo_gestion = tg.id_tipo_gestion
    inner join gb_tipo_ies ti
    on i.id_tipo_ies = ti.id_tipo_ies
  on sd.id_ies = i.id_ies
on asig.id_sede_estudio = sd.id_sede_estudio
inner join gb_asesor ase
on asig.id_asesor = ase.id_asesor;


create or replace view vw_gb_becario
as
select  b.id_becario, b.dni, b.nombres, b.apellidos, b.sexo,
        a.id_asignacion,
        a.id_beca,
        a.convocatoria,
        a.modalidad,
        a.carrera,
        a.ies,
        a.tipo_gestion,
        a.tipo_ies,
        a.region,
        a.sede,
        a.asesor,
        e.id_estado,
        e.descripcion estado
from gb_becario b
inner join vw_gb_asignacion a
on b.id_asignacion = a.id_asignacion
inner join gb_estado e
on b.id_estado = e.id_estado;