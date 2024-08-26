package excluidadosbd;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluiDadosBD 
{
    static final String banco = "jdbc:mysql://localhost:3306/agenciaviagem";

    public static void main(String[] args) 
    {
        Connection conexao = null;
        PreparedStatement consulta = null;
        ResultSet resultados = null;
        
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            
            consulta = conexao.prepareStatement("DELETE FROM turista WHERE codigo = ?");
            String codigo = JOptionPane.showInputDialog(null, "Informe o código a ser excluído: ");
            consulta.setString(1, codigo);
            
            int linhasAfetadas = consulta.executeUpdate();
            System.out.println("Número de linhas afetadas: " + linhasAfetadas);
            
            System.out.println("Informações do Banco de Dados");  
        }
        catch(SQLException erro)
        {
            erro.printStackTrace();
        }
        finally
        {
            try
            {
                
                if(resultados != null) resultados.close();
                if(conexao != null) conexao.close();
                if(consulta != null) consulta.close();
            }
            catch (SQLException erronovo)
            {
                erronovo.printStackTrace();
            } 
        }     
    }
}
