package br.net.digitialzone.scrapperfidelidade.model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.net.digitialzone.scrapperfidelidade.db.DB;
import br.net.digitialzone.scrapperfidelidade.db.DbException;
import br.net.digitialzone.scrapperfidelidade.model.DAO.MilesProgramDAO;
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductModelsDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.MilesProgram;


public class ProgFideListJDBC implements MilesProgramDAO {
	private Connection conn;

	public ProgFideListJDBC(Connection conn) {
		this.conn = conn;
	}

	
	@Override
	public List<MilesProgram> findAllPrograms() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * from miles_program");

			rs = st.executeQuery();

			List<MilesProgram> list = new ArrayList<>();

			// se veio algum resultado
			while (rs.next()) {
				list.add(instantiateProgramsList(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private MilesProgram instantiateProgramsList(ResultSet rs) throws SQLException {
		MilesProgram get = new MilesProgram();
		get.setId(rs.getInt("idprogram"));
		get.setProgramName(rs.getString("program_name"));
		get.setMilesValue(rs.getDouble("miles_value"));

		return get;
	}

}
