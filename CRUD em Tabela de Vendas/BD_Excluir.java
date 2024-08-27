package exiberesultados;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD_Excluir
{
    static final String banco = "jdbc:mysql://localhost:3306/loja";
    Connection conexao = null;
    PreparedStatement minhaExclusao = null;
    public void excluir(String codigo)
    {
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            minhaExclusao = conexao.prepareStatement("DELETE FROM vendas WHERE codigo = ?");

            minhaExclusao.setString(1,codigo);
            minhaExclusao.executeUpdate();
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
        }
        finally
        {
            try
            {
                minhaExclusao.close();
                conexao.close();
            }
            catch (Exception erronovo)
            {
                erronovo.printStackTrace();
            }
        }
    }
}
