CREATE OR REPLACE PROCEDURE load_data_becario IS

  CURSOR becario_cur IS SELECT * FROM db_becarios_ext;
  b_rec db_becarios_ext%ROWTYPE;
  
  asesor_id number;
  ies_id number;
  tipo_ies_id number;
  tipo_gestion_id number;
  sede_estudio_id number;
  beca_id number;
  carrera_id number;
  asignacion_id number;
  estado_id number;
  becario_id number;
  
BEGIN
  OPEN becario_cur;
  LOOP
    FETCH becario_cur INTO b_rec;
    EXIT WHEN becario_cur%NOTFOUND;
    
    asesor_id := gb_becario_pkg.get_asesor(b_rec.asesor_nombre);
        
    tipo_ies_id := gb_becario_pkg.get_tipo_ies(b_rec.ies_tipo);
        
    tipo_gestion_id := gb_becario_pkg.get_tipo_gestion(b_rec.ies_gestion);
    
    ies_id := gb_becario_pkg.get_ies(b_rec.ies_nombre, tipo_ies_id, tipo_gestion_id);
          
    sede_estudio_id := gb_becario_pkg.get_sede_estudio(ies_id, b_rec.beca_region_estudio, b_rec.beca_sede_estudio);
    
    beca_id := gb_becario_pkg.get_beca(b_rec.beca_convocatoria, b_rec.beca_modalidad);
        
    carrera_id := gb_becario_pkg.get_carrera(b_rec.beca_carrera, beca_id);   
    
    estado_id := gb_becario_pkg.get_estado(b_rec.becario_estado);
        
    asignacion_id := gb_becario_pkg.get_asignacion(carrera_id, sede_estudio_id, asesor_id);
    
    gb_becario_pkg.crear_becario(asignacion_id, b_rec.becario_dni, b_rec.becario_nombres, b_rec.becario_apellidos, 
                                b_rec.becario_fnac, b_rec.becario_sexo, estado_id,
                                b_rec.becario_expediente, b_rec.becario_representante, b_rec.becario_representante_dni,
                                b_rec.becario_telefonos, b_rec.becario_correo_personal, b_rec.becario_region_postulacion,
                                b_rec.becario_provincia_postulacion, b_rec.becario_distrito_postulacion,
                                b_rec.becario_resolucion);
    
  END LOOP;
  CLOSE becario_cur;
  
  DBMS_OUTPUT.PUT_LINE('====== DONE! ======');
  
END;
