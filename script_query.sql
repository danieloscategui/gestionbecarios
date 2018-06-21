select beca.convocatoria, beca.modalidad, ca.descripcion carrera
from gb_beca beca
inner join gb_carrera ca
on beca.id_beca = ca.id_beca;

select ies.nombre "ies", ti.descripcion tipo_ies, tg.descripcion tipo_gestion , sede.region, sede.sede
from gb_ies ies
inner join gb_tipo_gestion tg
on ies.id_tipo_gestion = tg.id_tipo_gestion
inner join gb_tipo_ies ti
on ies.id_tipo_ies = ti.id_tipo_ies
inner join gb_sede_estudio sede
on ies.id_ies = sede.id_ies;