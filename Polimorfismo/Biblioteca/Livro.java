package biblioteca;


public class Livro 
{
    private String titulo,autor;
    private int numeroPaginas;
    
    Livro (String titulo, String autor, int numeroPaginas)
    {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }
    public String getAutor()
    {
        return autor;
    }
    public int getNumeroPaginas()
    {
        return numeroPaginas;
    }
    public void setAutor(int numeroPaginas)
    {
        this.numeroPaginas = numeroPaginas;
    }
    @Override
    public String toString()
    {
        return " Título " + getTitulo() + " Autor " + getAutor() + " nº " + getNumeroPaginas();
    }
}
