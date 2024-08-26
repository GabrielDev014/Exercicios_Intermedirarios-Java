package inclusaodedados;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InclusaoDeDados
{
    static final String banco = "jdbc:mysql://localhost:3306/concessionaria";

    public static void main(String[] args) 
    {
        Connection conexao = null;
        Statement consulta = null;
        ResultSet resultados = null;
        PreparedStatement minhainclusao = null;
        
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            
            consulta = conexao.createStatement();
            
            resultados = consulta.executeQuery("Select * from veiculo");
            
            ResultSetMetaData colunas = resultados.getMetaData();
            
            int numeroColunas = colunas.getColumnCount();
            System.out.println("Informações do Banco de Dados");  
            
            minhainclusao = conexao.prepareStatement("insert into veiculo(nome,fabricante) VALUES (?,?)");
            
            String nome = (JOptionPane.showInputDialog(null, "Informe o nome do veículo: "));
            minhainclusao.setString(1, nome);
   
            String fabricante = (JOptionPane.showInputDialog(null, "Informe o fabricante a ser incluído: "));
            minhainclusao.setString(2, fabricante);
            minhainclusao.executeUpdate();
            
            resultados = consulta.executeQuery("Select * from veiculo");
            
            while (resultados.next())
            {
                for (int i = 1; i <= numeroColunas; i++)
                System.out.println("Dados: " + resultados.getObject(i));
                System.out.println();
                System.out.println("Dados inseridos com sucesso!");
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
