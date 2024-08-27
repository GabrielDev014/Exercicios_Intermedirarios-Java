package exiberesultados;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

// As linhas e colunas do ResultSet são contadas a partir de 1 e as linhas e colunas do JTable 
// são contadas a partir de 0. Ao processar as linhas ou colunas do ResultSet para uso em um JTable, 
// é necessário adicionar 1 ao número da linha ou coluna para manipular 
// a coluna apropriada do ResultSet (ou seja, a coluna 0 do JTable é 
// a coluna 1 do ResultSet e a linha 0 do JTable é a linha 1 do ResultSet).
public class ModeloTabela extends AbstractTableModel 
{
   private Connection conexao;
   private Statement declaracao;
   private ResultSet conjuntoResultados;
   private ResultSetMetaData metaData;
   private int numeroDeLinhas;

   // acompanhar o status da conexão com o banco de dados
   private boolean conectadoAoBanco = false;
   
   // construtor inicializa ResultSet e obtém seu objeto metaData;
   // determina o número de linhas
   public ModeloTabela(String driver, String url, String usuario,
      String senha, String consulta) 
      throws SQLException, ClassNotFoundException
   {         
      // conectar ao banco de dados
      Class.forName(driver);
      conexao = DriverManager.getConnection(url, usuario, senha);

      // criar Statement para consultar o banco de dados
      declaracao = conexao.createStatement( 
         ResultSet.TYPE_SCROLL_INSENSITIVE,
         ResultSet.CONCUR_READ_ONLY);

      // atualizar status da conexão com o banco de dados
      conectadoAoBanco = true;

      // definir consulta e executá-la
      setConsulta(consulta);
   } // fim do construtor ResultSetTableModel

   // obter classe que representa o tipo de coluna
   public Class getColumnClass(int coluna) throws IllegalStateException
   {
      // garantir que a conexão com o banco de dados esteja disponível
      if (!conectadoAoBanco) 
         throw new IllegalStateException("Não conectado ao banco de dados");

      // determinar a classe Java da coluna
      try 
      {
         String colunas = metaData.getColumnClassName(coluna + 1);
         
         // retornar objeto Class que representa className
         return Class.forName(colunas);
      } // fim do try
      catch (Exception erro) 
      {
         erro.printStackTrace();
      } // fim do catch
      
      return Object.class; // se ocorrerem problemas acima, assumir tipo Object
   } // fim do método getColumnClass

   // obter número de colunas no ResultSet
   public int getColumnCount() throws IllegalStateException
   {   
      // garantir que a conexão com o banco de dados esteja disponível
      if (!conectadoAoBanco) 
         throw new IllegalStateException("Não conectado ao banco de dados");

      // determinar número de colunas
      try 
      {
         return metaData.getColumnCount(); 
      } // fim do try
      catch (SQLException erro) 
      {
         erro.printStackTrace();
      } // fim do catch
      
      return 0; // se ocorrerem problemas acima, retornar 0 como número de colunas
   } // fim do método getColumnCount

   // obter nome de uma determinada coluna no ResultSet
   public String getColumnName(int coluna) throws IllegalStateException
   {    
      // garantir que a conexão com o banco de dados esteja disponível
      if (!conectadoAoBanco) 
         throw new IllegalStateException("Não conectado ao banco de dados");

      // determinar nome da coluna
      try 
      {
         return metaData.getColumnName(coluna + 1);  
      } // fim do try
      catch (SQLException erro) 
      {
         erro.printStackTrace();
      } // fim do catch
      
      return ""; // se houver problemas, retornar string vazia como nome da coluna
   } // fim do método getColumnName

   // retornar número de linhas no ResultSet
   public int getRowCount() throws IllegalStateException
   {      
      // garantir que a conexão com o banco de dados esteja disponível
      if (!conectadoAoBanco) 
         throw new IllegalStateException("Não conectado ao banco de dados");
 
      return numeroDeLinhas;
   } // fim do método getRowCount

   // obter valor em determinada linha e coluna
   public Object getValueAt(int linha, int coluna) 
      throws IllegalStateException
   {
      // garantir que a conexão com o banco de dados esteja disponível
      if (!conectadoAoBanco) 
         throw new IllegalStateException("Não conectado ao banco de dados");

      // obter valor na linha e coluna especificadas do ResultSet
      try 
      {
         conjuntoResultados.absolute(linha + 1);
         return conjuntoResultados.getObject(coluna + 1);
      } // fim do try
      catch (SQLException erro) 
      {
         erro.printStackTrace();
      } // fim do catch
      
      return ""; // se houver problemas, retornar string vazia
   } // fim do método getValueAt
   
   // definir nova string de consulta ao banco de dados
   public void setConsulta(String consulta) 
      throws SQLException, IllegalStateException 
   {
      // garantir que a conexão com o banco de dados esteja disponível
      if (!conectadoAoBanco) 
         throw new IllegalStateException("Não conectado ao banco de dados");

      // especificar consulta e executá-la
      conjuntoResultados = declaracao.executeQuery(consulta);

      // obter meta data para o conjuntoResultados
      metaData = conjuntoResultados.getMetaData();

      // determinar número de linhas no conjuntoResultados
      conjuntoResultados.last();                  // mover para a última linha
      numeroDeLinhas = conjuntoResultados.getRow();  // obter número da linha      
      
      // notificar JTable que o modelo mudou
      fireTableStructureChanged();
   } // fim do método setConsulta

   // fechar Statement e Connection               
   public void desconectarBanco()            
   {              
      if (conectadoAoBanco)                  
      {
         // fechar Statement e Connection            
         try                                          
         {                                            
            conjuntoResultados.close();                        
            declaracao.close();                        
            conexao.close();                       
         } // fim do try                                 
         catch (SQLException erro)          
         {                                            
            erro.printStackTrace();           
         } // fim do catch  

        // atualizar status da conexão com o banco de dados 
         finally 
         {                                            
            conectadoAoBanco = false;              
         } // fim do finally                             
      } // fim do if
   } // fim do método desconectarDoBancoDeDados          
}  // fim da classe ResultSetTableModel
