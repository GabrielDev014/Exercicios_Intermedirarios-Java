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
        Statement consulta = null;
        ResultSet resultados = null;
        PreparedStatement minhaexclusao = null;
        
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            
            consulta = conexao.createStatement();
            
            resultados = consulta.executeQuery("Select * from turista");
            
            ResultSetMetaData colunas = resultados.getMetaData();
            
            int numeroColunas = colunas.getColumnCount();
            System.out.println("Informações do Banco de Dados");  
            
            minhaexclusao = conexao.prepareStatement("DELETE FROM turista WHERE codigo = ?");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o código a ser excluído: "));
            minhaexclusao.setInt(1, codigo);
            minhaexclusao.executeUpdate();
            
            while (resultados.next())
            {
                for (int i = 1; i <= numeroColunas; i++)
                System.out.println("Dados: " + resultados.getObject(i));
                System.out.println();
                System.out.println("Dados Excluídos com sucesso");
            }  
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
                conexao.close();
                consulta.close();
            }
            catch (SQLException erronovo)
            {
                erronovo.printStackTrace();
            } 
        }     
    }
}
