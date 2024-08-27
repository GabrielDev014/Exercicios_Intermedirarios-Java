package exiberesultados;

import java.awt.Color; //usamos p/ mudar cor de botões
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class ExibeResultados extends JFrame 
{
   // URL do banco de dados JDBC, nome de usuário e senha
   static final String DRIVER = "com.mysql.jdbc.Driver";
   static final String DATABASE_URL = "jdbc:mysql://localhost:3306/loja";
   static final String USERNAME = "root";
   static final String PASSWORD = "";
   
   // consulta padrão que recupera todos os dados da tabela autores
   static final String DEFAULT_QUERY = "SELECT * FROM vendas";
   
   private ModeloTabela modeloTabela;
   private JTextArea areaConsulta;
   
   // criar ResultSetTableModel e GUI
   public ExibeResultados() 
   {   
      super("Exibindo Resultados da Consulta");
        
      // criar ResultSetTableModel e exibir a tabela do banco de dados
      try 
      {
        // criar TableModel para os resultados da consulta SELECT * FROM autores
        modeloTabela = new ModeloTabela(DRIVER, DATABASE_URL,
        USERNAME, PASSWORD, DEFAULT_QUERY);

        // configurar JTextArea onde o usuário digita consultas
        areaConsulta = new JTextArea(DEFAULT_QUERY, 3, 100);
        areaConsulta.setWrapStyleWord(true);
        areaConsulta.setLineWrap(true);
         
        JScrollPane painelRolagem = new JScrollPane(areaConsulta,
        ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         
        // configurar JButton para enviar consultas
        JButton botaoEnviar = new JButton("Enviar Consulta");
        botaoEnviar.setBackground(new Color(144, 238, 144)); //será verde
         
        // configurar JButton para inserir dados
        JButton botaoInserir = new JButton("Inserir");
        botaoInserir.setBackground(new Color(173, 216, 230)); //será azul
         
        // configurar JButton para alterar dados
        JButton botaoAlterar = new JButton("Alterar");
        botaoAlterar.setBackground(new Color(255, 255, 224)); //será amarelo
         
        // configurar JButton para excluir dados
        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.setBackground(new Color(255, 102, 102)); //será vermelho

        // criar Box para gerenciar o posicionamento de areaConsulta e botaoEnviar na GUI
        Box caixaNorte = Box.createHorizontalBox();
        caixaNorte.add(painelRolagem);
        caixaNorte.add(botaoEnviar);

        // criar JTable delegada para modeloTabela 
        JTable tabelaResultados = new JTable(modeloTabela);
         
        JLabel rotuloFiltro = new JLabel("Filtro:");
        final JTextField textoFiltro = new JTextField();
        JButton botaoFiltro = new JButton("Pesquisar");
        botaoFiltro.setBackground(new Color(144, 238, 144)); //será verde
         
        Box caixaSul = Box.createHorizontalBox();
        caixaSul.add(rotuloFiltro);
        caixaSul.add(textoFiltro);
        caixaSul.add(botaoFiltro);
        caixaSul.add(Box.createHorizontalStrut(10)); //espaçamento lateral
        caixaSul.add(botaoInserir);
        caixaSul.add(Box.createHorizontalStrut(10));
        caixaSul.add(botaoAlterar);
        caixaSul.add(Box.createHorizontalStrut(10));
        caixaSul.add(botaoExcluir);

        // colocar componentes da GUI no painel de conteúdo
        add(caixaNorte, BorderLayout.NORTH);
        add(new JScrollPane(tabelaResultados), BorderLayout.CENTER);
        add(caixaSul, BorderLayout.SOUTH);

         // criar ouvinte de eventos para botaoEnviar
         botaoEnviar.addActionListener( 
         
            new ActionListener() 
            {
               // passar consulta para o modelo da tabela
               public void actionPerformed(ActionEvent evento)
               {
                  // executar uma nova consulta
                  try 
                  {
                     modeloTabela.setConsulta(areaConsulta.getText());
                  } // fim do try
                  catch (SQLException erro) 
                  {
                     JOptionPane.showMessageDialog(null, 
                        erro.getMessage(), "Erro no banco de dados", 
                        JOptionPane.ERROR_MESSAGE);
                     
                     // tentar recuperar de consulta inválida do usuário
                     // executando a consulta padrão
                     try 
                     {
                        modeloTabela.setConsulta(DEFAULT_QUERY);
                        areaConsulta.setText(DEFAULT_QUERY);
                     } // fim do try
                     catch (SQLException erronovo) 
                     {
                        JOptionPane.showMessageDialog(null, 
                           erronovo.getMessage(), "Erro no banco de dados", 
                           JOptionPane.ERROR_MESSAGE);
         
                        // garantir que a conexão com o banco de dados seja fechada
                        modeloTabela.desconectarBanco();
         
                        System.exit(1); // terminar aplicação
                     } // fim do catch interno                   
                  } // fim do catch externo
               } // fim do actionPerformed
            }  // fim da classe interna ActionListener          
         ); // fim da chamada ao addActionListener
         
         // criar ouvinte de eventos para botaoInserir
         botaoInserir.addActionListener(
         
            new ActionListener() 
            {
               // abrir o formulário de inserção
               public void actionPerformed(ActionEvent evento)
               {
                   new FormInserir().setVisible(true);
                   // Fechar a janela atual
                   setVisible(false);
               } // fim do actionPerformed
            } // fim da classe interna ActionListener
         ); // fim da chamada ao addActionListener
         
         // criar ouvinte de eventos para botaoAlterar
         botaoAlterar.addActionListener(
         
            new ActionListener() 
            {
               // abrir o formulário de alteração
               public void actionPerformed(ActionEvent evento)
               {
                   new FormAlterar().setVisible(true);
                   // Fechar a janela atual
                   setVisible(false);
               } // fim do actionPerformed
            } // fim da classe interna ActionListener
         ); // fim da chamada ao addActionListener
         
        // criar ouvinte de eventos para botaoExcluir
        botaoExcluir.addActionListener(
            new ActionListener() 
            {
               // abrir o formulário de exclusão
               public void actionPerformed(ActionEvent evento)
               {
                   new FormExcluir().setVisible(true);
                   // Fechar a janela atual
                   setVisible(false);
               } // fim do actionPerformed
            } // fim da classe interna ActionListener
         ); // fim da chamada ao addActionListener

        final TableRowSorter<TableModel> ordenador = 
            new TableRowSorter<TableModel>(modeloTabela);
        tabelaResultados.setRowSorter(ordenador);
        setSize(500, 250); // definir tamanho da janela
        setVisible(true); // exibir janela  
         
        // criar ouvinte para botaoFiltro
        botaoFiltro.addActionListener(            
            new ActionListener() 
            {
               // passar texto do filtro para o ouvinte
               public void actionPerformed(ActionEvent e) 
               {
                  String texto = textoFiltro.getText();

                  if (texto.length() == 0)
                     ordenador.setRowFilter(null);
                  else
                  {
                     try
                     {
                        ordenador.setRowFilter(
                        RowFilter.regexFilter(texto));
                     } // fim do try
                     catch (PatternSyntaxException pse) 
                     {
                        JOptionPane.showMessageDialog(null,
                           "Padrão regex inválido", "Padrão regex inválido",
                           JOptionPane.ERROR_MESSAGE);
                     } // fim do catch
                  } // fim do else
               } // fim do método actionPerfomed
            } // fim da classe interna anônima
         ); // fim da chamada ao addActionListener
      } // fim do try
      catch (ClassNotFoundException classNotFound) 
      {
         JOptionPane.showMessageDialog(null, 
            "Driver do banco de dados não encontrado", "Driver não encontrado",
            JOptionPane.ERROR_MESSAGE);
         
         System.exit(1); // terminar aplicação
      } // fim do catch
      catch (SQLException erro) 
      {
         JOptionPane.showMessageDialog(null, erro.getMessage(), 
            "Erro no banco de dados", JOptionPane.ERROR_MESSAGE);
               
         // garantir que a conexão com o banco de dados seja fechada
         modeloTabela.desconectarBanco();
         
         System.exit(1); // terminar aplicação
      } // fim do catch
      
      // descartar a janela quando o usuário fechar a aplicação (isso sobrescreve
      // o padrão de HIDE_ON_CLOSE)
      setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
      // garantir que a conexão com o banco de dados seja fechada quando o usuário fechar a aplicação
      addWindowListener(
      
         new WindowAdapter() 
         {
            // desconectar do banco de dados e sair quando a janela for fechada
            public void windowClosed(WindowEvent evento)
            {
               modeloTabela.desconectarBanco();
               System.exit(0);
            } // fim do método windowClosed
         } // fim da classe interna WindowAdapter
      ); // fim da chamada ao addWindowListener
   } // fim do construtor DisplayQueryResults
   
   // executar aplicação
   public static void main(String args[]) 
   {
      new ExibeResultados();
   } // fim do main
} // fim da classe DisplayQueryResults
