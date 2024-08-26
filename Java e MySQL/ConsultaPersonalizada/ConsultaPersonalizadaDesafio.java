package consultapersonalizadadesafio;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConsultaPersonalizadaDesafio 
{
    static final String banco = "jdbc:mysql://localhost:3306/faculdade";
    public static void main(String[] args) 
    {
        Connection conexao = null;
        PreparedStatement consulta = null;
        ResultSet resultados = null;
        
        try
        {
            conexao = DriverManager.getConnection(banco, "root", "");
            
            consulta = conexao.prepareStatement("select * from aluno where disciplina = ?");
            String disciplina = JOptionPane.showInputDialog(null, "Informe a disciplina para retornar os alunos matriculados: ");
            consulta.setString(1, disciplina);
            
            resultados = consulta.executeQuery();
            
            ResultSetMetaData colunas = resultados.getMetaData();
            int numeroColunas = colunas.getColumnCount();
            System.out.println("Informações do Banco de Dados");
            
            while(resultados.next())
            {
                for (int i = 1; i <= numeroColunas; i++)
                System.out.println("Dados: " + resultados.getObject(i));
                System.out.println();
            }
                    
        }
        catch (SQLException erro)
        {
            erro.printStackTrace();
        }
        finally
        {
            try
            {
                resultados.close();
                consulta.close();
                conexao.close();
            }
            catch (Exception erronovo)
            {
                erronovo.printStackTrace();
            }
        }
    }
}
