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
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductSmilesListDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ProductSmiles;
import br.net.digitialzone.scrapperfidelidade.scraper.model.RunParams;

public class ProductSmilesListJDBC implements ProductSmilesListDAO {
	private Connection conn;

	public ProductSmilesListJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(ProductSmiles obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO smiles_products " + "(id_seller_produto,sku_produto,nome,nome_resumido,url_modelo,sigla) " + "VALUES " + "(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, obj.getIdSellerProduto());
			st.setString(2, obj.getSkuProduto());
			st.setString(3, obj.getNome());
			st.setString(4, obj.getNomeResumido());
			st.setString(5, obj.getUrlModelo());
			st.setString(6, obj.getSigla());

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
	public void update(ProductSmiles obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
				"UPDATE smiles_products " +
				"SET id_seller_produto = ? " +
				", sku_produto = ? " +
				", nome = ? " +
				", nome_resumido = ? " +
				", sigla = ? " +
				", ativo = ? " +
				", url_modelo = ? " +
				"WHERE Id = ?");

			st.setString(1, obj.getIdSellerProduto());
			st.setString(2, obj.getSkuProduto());
			st.setString(3, obj.getNome());
			st.setString(4, obj.getNomeResumido());
			st.setString(5, obj.getSigla());
			st.setInt(6, obj.getAtivo());
			st.setString(7, obj.getUrlModelo());
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
	public ProductSmiles findByIdAndSku(String idProduto, String sku) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn
					.prepareStatement("SELECT * " + "FROM smiles_products " + "WHERE id_seller_produto = ? AND sku_produto = ?");

			st.setString(1, idProduto);
			st.setString(2, sku);

			rs = st.executeQuery();

			// se veio algum resultado
			if (rs.next()) {

				ProductSmiles obj = instantiateSkuList(rs);
				return obj;

			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}

	}

	@Override
	public List<ProductSmiles> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM smiles_products WHERE ativo=1");

			rs = st.executeQuery();

			List<ProductSmiles> list = new ArrayList<>();

			// se veio algum resultado
			while (rs.next()) {
				list.add(instantiateSkuList(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	@Override
	public List<ProductSmiles> findAllWithVarejista(RunParams runParams) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.prepareStatement("SELECT * FROM smiles_products WHERE ativo=1" + runParams.getVarejista().getSqlQuery());

			rs = st.executeQuery();

			List<ProductSmiles> list = new ArrayList<>();

			// se veio algum resultado
			while (rs.next()) {
				list.add(instantiateSkuList(rs));
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private ProductSmiles instantiateSkuList(ResultSet rs) throws SQLException {
		ProductSmiles get = new ProductSmiles();
		get.setId(rs.getInt("id"));
		get.setIdSellerProduto(rs.getString("id_seller_produto"));
		get.setSkuProduto(rs.getString("sku_produto"));
		get.setNome(rs.getString("nome"));
		get.setNomeResumido(rs.getString("nome_resumido"));
		get.setUrlModelo(rs.getString("url_modelo"));
		get.setSigla(rs.getString("sigla"));
		get.setAtivo(rs.getInt("ativo"));
		return get;
	}

}
