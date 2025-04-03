package br.net.digitialzone.scrapperfidelidade.model.DAO.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.net.digitialzone.scrapperfidelidade.db.DB;
import br.net.digitialzone.scrapperfidelidade.db.DbException;
import br.net.digitialzone.scrapperfidelidade.model.DAO.UtilidadesDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.RunLogs;
import br.net.digitialzone.scrapperfidelidade.utils.CatchProgramFidel;

public class UtilidadesJDBC implements UtilidadesDAO {
	private Connection conn;

	public UtilidadesJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertRunLogs(RunLogs obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO run_logs " + "(lojista,data_horario) " + "VALUES " + "(?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getProgram().getProgramName());
			st.setTimestamp(2, obj.getDataHorario());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}


	@Override
	public List<RunLogs> findAllRunLogsByDate(Timestamp dataTime, String lojista) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM run_logs WHERE data_horario > ? AND lojista=?");
			
			st.setTimestamp(1, dataTime);
			st.setString(2, lojista);

			rs = st.executeQuery();

			List<RunLogs> list = new ArrayList<>();

			// se veio algum resultado
			while (rs.next()) {
				list.add(instantiateRunLogsList(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private RunLogs instantiateRunLogsList(ResultSet rs) throws SQLException {
		RunLogs get = new RunLogs();
		get.setId(rs.getInt("id"));
		get.setProgram(CatchProgramFidel.toEnum(rs.getString("program")));
		get.setDataHorario(rs.getTimestamp("data_horario"));
		return get;
	}

}
