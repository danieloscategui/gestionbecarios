CREATE OR REPLACE PACKAGE gb_becario_pkg AS
  
  function get_asesor(n_asesor varchar2) return number;
  function get_ies(n_ies varchar2, tipo_ies_id number, gestion_ies_id number) return number;
  function get_tipo_ies(n_tipo_ies varchar2) return number;
  function get_tipo_gestion(n_tipo_gestion varchar2) return number;
  function get_sede_estudio(ies_id number, n_region varchar2, n_sede varchar2) return number;
  function get_beca(n_convocatoria varchar2, n_modalidad varchar2) return number;
  function get_carrera(n_descripcion varchar2, beca_id number) return number;
  function get_asignacion(carrera_id number, sede_estudio_id number, asesor_id number)return number;
  function get_estado(n_descripcion varchar2) return number;
  procedure crear_becario(asignacion_id number, b_dni varchar2, b_nombres varchar2, b_apellidos varchar2,  fnac date, b_sexo varchar2, b_estado_id number,
                          b_expediente varchar2, b_representante varchar2, b_representante_dni varchar2, b_telefonos varchar2, b_correo_personal varchar2, 
                          b_region_postulacion varchar2, b_provincia_postulacion varchar2, b_distrito_postulacion varchar2, b_resolucion varchar2);  
END gb_becario_pkg;
/
CREATE OR REPLACE PACKAGE BODY gb_becario_pkg AS

  function get_asesor(n_asesor varchar2) return number is
    asesor_id number;
  begin    
    begin
      select id_asesor into asesor_id 
      from gb_asesor
      where upper(nombre) = upper(trim(n_asesor));
    exception
      when no_data_found then
        select gb_asesor_seq.nextval into asesor_id from dual;
        insert into gb_asesor values (asesor_id, upper(trim(n_asesor)));
        commit;
    end;
    return  asesor_id;
  end get_asesor;
  
  function get_ies(n_ies varchar2, tipo_ies_id number, gestion_ies_id number) return number is
    ies_id number;
  begin
    begin
      select id_ies into ies_id
      from gb_ies
      where upper(nombre) = upper(trim(n_ies));
    exception
      when no_data_found then
        select gb_ies_seq.nextval into ies_id from dual;
        insert into gb_ies values(ies_id, upper(trim(n_ies)), tipo_ies_id, gestion_ies_id);
        commit;
    end;
    return ies_id;
  end get_ies;
  
  function get_tipo_ies(n_tipo_ies varchar2) return number is
    tipo_ies_id number;
  begin 
    begin
      select id_tipo_ies into tipo_ies_id
      from gb_tipo_ies
      where upper(descripcion) = upper(trim(n_tipo_ies));
    exception
      when no_data_found then
        select gb_tipo_ies_seq.nextval into tipo_ies_id from dual;
        insert into gb_tipo_ies values (tipo_ies_id, upper(trim(n_tipo_ies)) );
        commit;
    end;
    return tipo_ies_id;
  end get_tipo_ies;
  
  function get_tipo_gestion(n_tipo_gestion varchar2) return number is
    tipo_gestion_id number;
  begin
    begin
      select id_tipo_gestion into tipo_gestion_id
      from gb_tipo_gestion
      where upper(descripcion) = upper(trim(n_tipo_gestion));
    exception
      when no_data_found then
        select gb_tipo_gestion_seq.nextval into tipo_gestion_id from dual;
        insert into gb_tipo_gestion values (tipo_gestion_id, upper(trim(n_tipo_gestion)));
        commit;
    end;
    return tipo_gestion_id;
  end get_tipo_gestion;
  
  function get_sede_estudio(ies_id number, n_region varchar2, n_sede varchar2) return number is
    sede_estudio_id number;
  begin
    begin
      select id_sede_estudio into sede_estudio_id
      from gb_sede_estudio
      where id_ies = ies_id 
      and upper(region) = upper(trim(n_region))
      and upper(sede) = upper(trim(n_sede));
    exception
      when no_data_found then
        select gb_sede_estudio_seq.nextval into sede_estudio_id from dual;
        insert into gb_sede_estudio values (sede_estudio_id, upper(trim(n_region)), upper(trim(n_sede)), ies_id);
        commit;
    end;
    return sede_estudio_id;
  end get_sede_estudio;
     
  function get_beca(n_convocatoria varchar2, n_modalidad varchar2) return number is
    beca_id number;
  begin
    begin
      select id_beca into beca_id
      from gb_beca
      where upper(convocatoria) = upper(trim(n_convocatoria))
      and   upper(modalidad) = upper(trim(n_modalidad));
    exception
      when no_data_found then
        select gb_beca_seq.nextval into beca_id from dual;
        insert into gb_beca (id_beca, convocatoria, modalidad)
        values (beca_id, upper(trim(n_convocatoria)) , upper(trim(n_modalidad)));
        commit;
    end;
    return beca_id;
  end get_beca;
  
  function get_carrera(n_descripcion varchar2, beca_id number) return number is  
    carrera_id number;
  begin
      begin
        select id_carrera into carrera_id
        from gb_carrera
        where id_beca = beca_id
        and   upper(descripcion) = upper(trim(n_descripcion));
      exception
        when no_data_found then          
          select gb_carrera_seq.nextval into carrera_id from dual;
          insert into gb_carrera (id_carrera, descripcion, id_beca) 
          values (carrera_id, upper(trim(n_descripcion)), beca_id);
          commit;
      end;
      return carrera_id;
  end get_carrera;
  
  function get_asignacion(carrera_id number, sede_estudio_id number, asesor_id number)return number is
    asignacion_id number;
  begin
    begin
      select id_asignacion into asignacion_id
      from gb_asignacion
      where id_carrera = carrera_id
      and   id_sede_estudio = sede_estudio_id
      and   id_asesor = asesor_id;
    exception
      when no_data_found then        
        select gb_asignacion_seq.nextval into asignacion_id from dual;
        insert into gb_asignacion values (asignacion_id, carrera_id, sede_estudio_id, asesor_id);
        commit;
    end;
    return asignacion_id;
  end get_asignacion;
  
  function get_estado(n_descripcion varchar2) return number is
    estado_id number;
  begin
    begin            
      select id_estado into estado_id
      from gb_estado 
      where upper(descripcion) = upper(trim(n_descripcion));
    exception
      when no_data_found then        
        select gb_estado_seq.nextval into estado_id from dual;
        insert into gb_estado values (estado_id, upper(trim(n_descripcion)));
        commit;
    end;
    return estado_id;
  end get_estado;
  
  procedure crear_becario(asignacion_id number, b_dni varchar2, b_nombres varchar2, b_apellidos varchar2,  fnac date, b_sexo varchar2, b_estado_id number,
                          b_expediente varchar2, b_representante varchar2, b_representante_dni varchar2, b_telefonos varchar2, b_correo_personal varchar2, 
                          b_region_postulacion varchar2, b_provincia_postulacion varchar2, b_distrito_postulacion varchar2, b_resolucion varchar2) is
    becario_id number;
    edad_actual number;
  begin 
    begin
      select id_becario into becario_id
      from   gb_becario 
      where trim(dni) = trim(b_dni) 
      and   id_asignacion = asignacion_id;
    exception
      when no_data_found then
        
        select gb_becario_seq.nextval into becario_id from dual;
        
        if (fnac is not null) then
          edad_actual := trunc(months_between(sysdate, to_date(fnac, 'DD/MM/RRRR'))/12);
        end if;
        
        insert into gb_becario (id_becario, dni, nombres, apellidos, fecha_nacimiento, edad, sexo, id_asignacion, id_estado, numero_expediente, 
                              representante, representante_dni, telefonos, correo_personal, region_postulacion, provincia_postulacion,
                              distrito_postulacion, resolucion_adjudicacion)
        values (becario_id, trim(b_dni), upper(trim(b_nombres)), upper(trim(b_apellidos)), fnac, edad_actual, upper(trim(b_sexo)), asignacion_id, b_estado_id,
                trim(b_expediente), upper(trim(b_representante)), trim(b_representante_dni), trim(b_telefonos), trim(b_correo_personal),
                upper(trim(b_region_postulacion)), upper(trim(b_provincia_postulacion)), upper(trim(b_distrito_postulacion)), trim(b_resolucion));
        commit;
    end;
    --return id_becario;
  end crear_becario;
         
END gb_becario_pkg;
/