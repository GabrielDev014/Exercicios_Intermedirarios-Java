package lanchonete_consultar;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD_Consultar 
{
    static final String banco = "jdbc:mysql://localhost:3306/lanchonete";
    Connection conexao = null;
    ResultSet resultados = null;
    PreparedStatement minhaConsulta = null;
    
    public void consultar(String tipo)
    {
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            minhaConsulta = conexao.prepareStatement("select nome, descricao from cardapio where tipo = ?");
            minhaConsulta.setString(1,tipo);
            
            resultados = minhaConsulta.executeQuery();
            ResultSetMetaData colunas = resultados.getMetaData();
            int numeroColunas = colunas.getColumnCount();

            StringBuilder resultadoMensagem = new StringBuilder();
            while (resultados.next())
            {
                resultadoMensagem.append("Nome: ").append(resultados.getString("nome"))
                                  .append(", Descrição: ").append(resultados.getString("descricao"))
                                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, resultadoMensagem.toString());
        }
        catch(SQLException erro)
        {
            erro.printStackTrace();
        }
        finally
        {
            try
            {
                resultados.close();
                minhaConsulta.close();
                conexao.close();
            }
            catch(Exception erronovo)
            {
                erronovo.printStackTrace();
            }
        }
    }
}
