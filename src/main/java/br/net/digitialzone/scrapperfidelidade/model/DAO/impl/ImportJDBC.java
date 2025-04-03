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
import br.net.digitialzone.scrapperfidelidade.model.DAO.ImportDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.ImportTest;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.UtilValuesScraped;

public class ImportJDBC implements ImportDAO {
	private Connection conn;

	public ImportJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insertImport(String idSellerProduto, String skuProduto, String nome, String nomeResumido,
			String urlModelo) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO import_products "
					+ "(id_seller_produto,sku_produto,nome,nome_resumido,url_modelo) " + "VALUES " + "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, idSellerProduto);
			st.setString(2, skuProduto);
			st.setString(3, nome);
			st.setString(4, nomeResumido);
			st.setString(5, urlModelo);

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
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
	public void insertImport(UtilValuesScraped uScraped) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO import_products "
					+ "(id_seller_produto,sku_produto,nome,nome_resumido,url_modelo) " + "VALUES " + "(?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, uScraped.getCodigoFornecedor());
			st.setString(2, uScraped.getIdSkuFornecedor());
			st.setString(3, uScraped.getNomeProduto());
			st.setString(4, uScraped.getNomeProduto());
			st.setString(5, uScraped.getNomeProduto());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
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
	public void update(ImportTest obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE import_products " +
				"SET id = ? " +
				", id_seller_produto = ? " +
				", sku_produto = ? " +
				", nome = ? " +
				", nome_resumido = ? " +
				", url_modelo = ? " +
				", sigla = ? " +
				"WHERE Id = ?");

			st.setInt(1, obj.getId());
			st.setString(2, obj.getIdSellerProduto());
			st.setString(3, obj.getSkuProduto());
			st.setString(4, obj.getNome());
			st.setString(5, obj.getNomeResumido());
			st.setString(6, obj.getUrlModelo());
			st.setString(7, obj.getSigla());
			st.setInt(8, obj.getId());

			st.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public List<ImportTest> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM import_products");

			// System.out.println(st);
			rs = st.executeQuery();

			List<ImportTest> list = new ArrayList<>();

			// se veio algum resultado
			while (rs.next()) {
				list.add(instantiateProductList(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	private ImportTest instantiateProductList(ResultSet rs) throws SQLException {
		ImportTest get = new ImportTest();

		get.setId(rs.getInt("id"));
		get.setIdSellerProduto(rs.getString("id_seller_produto"));
		get.setSkuProduto(rs.getString("sku_produto"));
		get.setUrlModelo(rs.getString("url_modelo"));
		get.setSigla(rs.getString("sigla"));
		get.setNome(rs.getString("nome"));
		get.setNomeResumido(rs.getString("nome_resumido"));

		return get;
	}

}
