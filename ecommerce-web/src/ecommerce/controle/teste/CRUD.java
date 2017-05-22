package ecommerce.controle.teste;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ecommerce.dominio.Fornecedor;

public class CRUD {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// alterTbClienteJuridico();
		// dropTbClienteJuridico();
		// criarTbClienteJuridico();
		// inserirTbClienteJuridico();
		// updateTbClienteJuridico();
		// deleteTbClienteJuridico();
		 selectTbClienteJuridico();

	}

	public static void criarTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();

		StringBuilder sb = new StringBuilder();
		sb.append(" CREATE TABLE tb_cliente_juridico_teste");
		sb.append("(");
		sb.append("id_cli_juridico_teste NUMBER (9) NOT NULL, ");
		sb.append("rzsocial VARCHAR2 (30 CHAR) NOT NULL, ");
		sb.append("cnpj CHAR (45 CHAR) NOT NULL, ");
		sb.append("id_usu NUMBER (9) NOT NULL, ");
		sb.append("id_end NUMBER (9) NOT NULL, ");
		sb.append("ativo NUMBER (1) NOT NULL,");
		sb.append("dt_cadastro DATE NOT NULL, ");
		sb.append("CONSTRAINT id_cli_juridico_teste_PK PRIMARY KEY ( id_cli_juridico_teste ) enable)");

		PreparedStatement st = conn.prepareStatement(sb.toString());
		st.executeUpdate();
		st.close();
		conn.close();
	}

	public static void alterTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();

		StringBuilder sb = new StringBuilder();
		sb.append(" ALTER TABLE tb_cliente_juridico_teste DROP CONSTRAINT id_cli_juridico_teste_PK");
		PreparedStatement st = conn.prepareStatement(sb.toString());
		st.executeUpdate();
		st.close();
		conn.close();
	}

	public static void dropTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();

		StringBuilder sb = new StringBuilder();
		sb.append(" DROP TABLE tb_cliente_juridico_teste");
		PreparedStatement st = conn.prepareStatement(sb.toString());
		st.executeUpdate();
		st.close();
		conn.close();
	}

	public static void inserirTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_cliente_juridico_teste VALUES (?, ?, ?, ?, ?, ?, ?)");
		PreparedStatement pst = conn.prepareStatement(sb.toString());
		pst.setInt(1, 0004);
		pst.setString(2, "SmartProd Celulares");
		pst.setString(3, "12345678922222");
		pst.setInt(4, 0004);
		pst.setInt(5, 0004);
		pst.setInt(6, 1);
		pst.setDate(7, new java.sql.Date(new Date().getTime()));
		pst.executeUpdate();
		pst.close();
		conn.close();
	}

	public static void updateTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tb_cliente_juridico_teste SET id_usu = (?) WHERE id_cli_juridico_teste = 2");
		PreparedStatement pst = conn.prepareStatement(sb.toString());
		pst.setInt(1, 2);
		pst.executeUpdate();
		pst.close();
		conn.close();
	}

	public static void deleteTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM tb_cliente_juridico_teste WHERE id_cli_juridico_teste = (?)");
		PreparedStatement pst = conn.prepareStatement(sb.toString());
		pst.setInt(1, 3);
		pst.executeUpdate();
		pst.close();
		conn.close();
	}

	public static void selectTbClienteJuridico() throws ClassNotFoundException, SQLException {
		Connection conn = ConnBD.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT id_cli_juridico, rzsocial, cnpj ");
		sb.append("FROM tb_cliente_juridico ");
		sb.append("WHERE CNPJ = ?");

		PreparedStatement pst = conn.prepareStatement(sb.toString());
//		pst.setInt(1, 1);
		pst.setString(1, "99988877766677");
		ResultSet rs = pst.executeQuery();
		List<Fornecedor> arrayList = new ArrayList<Fornecedor>();
		while (rs.next()) {
//			ClienteJuridico cj = new ClienteJuridico();
//			cj.setId(rs.getInt(1));
//			cj.setRazaoSocial(rs.getString(2));
//			cj.setCnpj(rs.getString(3));
//			arrayList.add(cj);
			System.out.println(rs.getLong(1) + " / " + rs.getString(2) + " / " + rs.getString(3));
		}
		rs.close();
		pst.close();
		conn.close();
	}

}
