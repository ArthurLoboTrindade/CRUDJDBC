package entidade;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTable {
	
	    public void createPessoaTable() {
	        Statement stmt = null;

	        try {Connection conn = Conexao.conectar();
	        	String sql = "CREATE TABLE IF NOT EXISTS pessoa (" +
                    "id SERIAL PRIMARY KEY," +
                    "nome VARCHAR(100) NOT NULL," +
                    "idade INT," +
                    "email VARCHAR(100) UNIQUE" +
                    ");";
	            stmt = conn.createStatement();
	            stmt.executeUpdate(sql);
        		System.out.println("Tabela 'pessoa' criada ou já existe!");

	        } catch (SQLException se) {
	            System.err.println("Erro ao criar a tabela 'pessoa': " + se.getMessage());
	            se.printStackTrace();
	        }
	    }
}
