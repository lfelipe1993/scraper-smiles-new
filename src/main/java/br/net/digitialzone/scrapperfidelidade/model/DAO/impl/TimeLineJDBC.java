package br.net.digitialzone.scrapperfidelidade.model.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.net.digitialzone.scrapperfidelidade.db.DB;
import br.net.digitialzone.scrapperfidelidade.db.DbException;
import br.net.digitialzone.scrapperfidelidade.model.DAO.TimeLineDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.TimeLineProduct;

public class TimeLineJDBC implements TimeLineDAO {
	private Connection conn;

	public TimeLineJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(TimeLineProduct obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO searched_products " + "(id_product,sku_product,price_with_points,price_with_money,points_to_earn,"
							+ "retailer,buy_button,date_time,flag_products_models,isAcumuloAvailable,isResgateAvailable) " 
							+ "VALUES " + "(?,?,?,?,?,?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);


			st.setString(1, obj.getIdProduct());
			st.setString(2, obj.getSkuProduct());
			st.setDouble(3, obj.getPriceWithPoints());
			st.setDouble(4, obj.getPriceWithMoney());
			st.setDouble(5, obj.getPointsToEarn());
			st.setString(6, obj.getRetailer());
			st.setString(7, obj.getproductSmilesList().getUrlBuilder());
			st.setTimestamp(8, obj.getDateTime());
			st.setString(9, obj.getproductSmilesList().getModelo().getSigla());
			st.setInt(10, obj.getIsAcumuloAvailable() ? 1 : 0);
			st.setInt(11, obj.getIsResgateAvailable() ? 1 : 0);

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

}
