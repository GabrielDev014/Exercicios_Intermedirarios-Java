package exiberesultados;

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
        static final String banco = "jdbc:mysql://localhost:3306/loja";
        Connection conexao = null;
        PreparedStatement minhaAlteracao = null;
        public void alterar(String codigo, String cliente, String produtoComprado, 
           String valorVenda, String meioPagamento, 
           String vendedor, String salarioVendedor)
    {
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            minhaAlteracao = conexao.prepareStatement("UPDATE vendas SET cliente = ?, produtoComprado = ?, valorVenda = ?, meioPagamento = ?, vendedor = ?, salarioVendedor = ? WHERE codigo = ?");

            minhaAlteracao.setString(1, cliente);
            minhaAlteracao.setString(2, produtoComprado);
            minhaAlteracao.setString(3, valorVenda);
            minhaAlteracao.setString(4, meioPagamento);
            minhaAlteracao.setString(5, vendedor);
            minhaAlteracao.setString(6, salarioVendedor);
            minhaAlteracao.setString(7, codigo);
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
