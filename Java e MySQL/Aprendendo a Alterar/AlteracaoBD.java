package alteracaobd;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlteracaoBD
{
    static final String banco = "jdbc:mysql://localhost:3306/eletronicos";

    public static void main(String[] args) 
    {
        Connection conexao = null;
        Statement consulta = null;
        ResultSet resultados = null;
        PreparedStatement minhaAlteracao = null;
        
        try
        {
            conexao = DriverManager.getConnection(banco,"root","");
            
            consulta = conexao.createStatement();
            
            resultados = consulta.executeQuery("Select * from monitores");
            
            ResultSetMetaData colunas = resultados.getMetaData();
            
            int numeroColunas = colunas.getColumnCount();
            System.out.println("Informações do Banco de Dados");  
            
            minhaAlteracao = conexao.prepareStatement("UPDATE monitores SET valor = ? WHERE codigo = ?");
            
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código a ser alterado: "));
            minhaAlteracao.setInt(2, codigo); //número é 2 pq é o segundo parâmetro a ser informado
   
            float valor = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe o novo valor: "));
            minhaAlteracao.setFloat(1, valor); //número é 1 pq é o primeiro parâmetro a ser informado.
            minhaAlteracao.executeUpdate();
            
            resultados = consulta.executeQuery("Select * from monitores");
            
            while (resultados.next())
            {
                for (int i = 1; i <= numeroColunas; i++)
                System.out.println("Dados: " + resultados.getObject(i));
                System.out.println();
                System.out.println("Dados alterados com sucesso!");
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
