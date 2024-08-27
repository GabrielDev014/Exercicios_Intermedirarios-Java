package lanchonete_inserir;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD_Criar 
{
    static final String banco = "jdbc:mysql://localhost:3306/lanchonete";
    Connection conexao = null;
    PreparedStatement minhaInclusao = null;
    
   public void inserir(String codigo, String tipo, String nome, String descricao, String valor) 
   {
        try 
        {
            conexao = DriverManager.getConnection(banco,"root","");

            minhaInclusao = conexao.prepareStatement("insert into cardapio(codigo, tipo, nome, descricao, valor) VALUES (?,?,?,?,?)");

            minhaInclusao.setString(1,codigo);
            minhaInclusao.setString(2,tipo);
            minhaInclusao.setString(3,nome);
            minhaInclusao.setString(4,descricao);
            minhaInclusao.setString(5,valor);
            
            minhaInclusao.executeUpdate();
        }    
        catch (SQLException erro)
        {
            erro.printStackTrace();
        }
        finally 
        {
            try 
            {
                minhaInclusao.close();
                conexao.close();
            }
            catch (Exception erronovo) 
            {
                erronovo.printStackTrace();
            }
        }
    }
}
