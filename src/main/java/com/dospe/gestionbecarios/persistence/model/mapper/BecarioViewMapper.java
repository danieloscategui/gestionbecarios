package com.dospe.gestionbecarios.persistence.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dospe.gestionbecarios.persistence.model.BecarioView;

public class BecarioViewMapper implements RowMapper<BecarioView> {

	@Override
	public BecarioView mapRow(ResultSet rs, int rowNum) throws SQLException {
		BecarioView becarioView = new BecarioView();
		becarioView.setIdBecario(rs.getLong("id_becario"));
		becarioView.setNombres(rs.getString("nombres"));
		becarioView.setApellidos(rs.getString("apellidos"));
		becarioView.setCarrera(rs.getString("carrera"));
		becarioView.setIes(rs.getString("ies"));
		becarioView.setSede(rs.getString("sede"));
		becarioView.setAsesor(rs.getString("asesor"));
		becarioView.setEstado(rs.getString("estado"));
		return becarioView;
	}

}
