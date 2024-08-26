package biblioteca;

public interface ItemBiblioteca 
{
    //implicitamente static e final
    int diasEmprestimo = 10;
    
    //todos os métodos em uma interface são públicos e abstratos
    boolean estaEmprestado();
    
    void emprestar();
    void devolver();
    String localizacao();
}
