package exiberesultados;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD_Inserir 
{
    static final String banco = "jdbc:mysql://localhost:3306/loja";
    Connection conexao = null;
    PreparedStatement minhaInclusao = null;
    
   public void inserir(String codigo, String cliente, String produtoComprado, 
           String valorVenda, String meioPagamento, 
           String vendedor, String salarioVendedor) 
   {
        try 
        {
            conexao = DriverManager.getConnection(banco,"root","");

            minhaInclusao = conexao.prepareStatement("insert into vendas(codigo, cliente, produtoComprado, valorVenda, meioPagamento, vendedor, salarioVendedor) VALUES (?,?,?,?,?,?,?)");

            minhaInclusao.setString(1,codigo);
            minhaInclusao.setString(2,cliente);
            minhaInclusao.setString(3,produtoComprado);
            minhaInclusao.setString(4,valorVenda);
            minhaInclusao.setString(5,meioPagamento);
            minhaInclusao.setString(6,vendedor);
            minhaInclusao.setString(7,salarioVendedor);
            
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
