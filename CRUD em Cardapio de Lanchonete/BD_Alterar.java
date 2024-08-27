package lanchonete_alterar;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD_Alterar 
{
    static final String banco = "jdbc:mysql://localhost:3306/lanchonete";
    
    Connection conexao = null;
    PreparedStatement minhaAlteracao = null;
    
    public void alterar(String codigo, String tipo, String nome, String descricao, String valor)
    {
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            
            minhaAlteracao = conexao.prepareStatement("UPDATE cardapio SET tipo = ?, nome = ?, descricao = ?, valor = ? WHERE codigo = ?");
            minhaAlteracao.setString(1, tipo);
            minhaAlteracao.setString(2, nome);
            minhaAlteracao.setString(3, descricao);
            minhaAlteracao.setString(4, valor);
            minhaAlteracao.setString(5, codigo);
            minhaAlteracao.executeUpdate();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
        }
        finally 
        {
            try 
                {
                    minhaAlteracao.close();
                    conexao.close();
                }
                catch (Exception erronovo) 
                {
                    erronovo.printStackTrace();
                }
        }
    }
}
