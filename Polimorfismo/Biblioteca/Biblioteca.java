package biblioteca;

public class Biblioteca 
{
    public static void main(String[] args) 
    {
        ItemBiblioteca objetoBiblioteca[] = new ItemBiblioteca[2];
        
        //preenche o array com objetos
        objetoBiblioteca[0] = new LivroBiblioteca("Java como programar", " Deitel ",
        1200, "Estante A");
        
        objetoBiblioteca[1] = new MapaBiblioteca("3x2", "Estante C");
        
        System.out.println("Processamento POLIMÓRFICO:\n");
        //processa genericamente cada elemento no array
        for (ItemBiblioteca objetoCorrente : objetoBiblioteca)
        {
            //gera saída
            objetoCorrente.emprestar();
            System.out.println("Indicador de empréstimo " + objetoCorrente.estaEmprestado());
            System.out.println(objetoCorrente);
            
            System.out.println("Devolvido.");
            objetoCorrente.devolver();
            System.out.println("Indicador de empréstimo " + objetoCorrente.estaEmprestado());
            
            System.out.println(objetoCorrente.toString());
        } //for final
    }
}
