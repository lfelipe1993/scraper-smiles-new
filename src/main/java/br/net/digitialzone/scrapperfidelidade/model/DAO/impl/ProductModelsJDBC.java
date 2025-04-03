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
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductModelsDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;


public class ProductModelsJDBC implements ProductModelsDAO {
	private Connection conn;

	public ProductModelsJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertProducsModels(ModelPhone obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO products_models " + "(name,model,storage,limit_price,flag) " + "VALUES " + "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getNome());
			st.setString(2, obj.getModel());
			st.setString(3, obj.getArmaz());
			st.setDouble(4, obj.getLimitPrice());
			st.setString(5, obj.getSigla());

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
	public List<ModelPhone> findAllModels() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * from products_models");

			rs = st.executeQuery();

			List<ModelPhone> list = new ArrayList<>();

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

	private ModelPhone instantiateRunLogsList(ResultSet rs) throws SQLException {
		ModelPhone get = new ModelPhone();
		get.setId(rs.getInt("id"));
		get.setNome(rs.getString("name"));
		get.setModel(rs.getString("model"));
		get.setArmaz(rs.getString("storage"));
		get.setLimitPrice(rs.getDouble("limit_price"));
		get.setSigla(rs.getString("flag"));
		get.setAtivo(rs.getInt("ativo"));

		return get;
	}

}
