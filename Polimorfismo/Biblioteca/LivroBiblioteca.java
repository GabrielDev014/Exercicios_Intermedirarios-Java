package biblioteca;

public class LivroBiblioteca extends Livro implements ItemBiblioteca
{
    private boolean emprestado;
    private String local;
    
    LivroBiblioteca(String titulo, String autor, int numeroPaginas, String local)
    {
        super(titulo, autor, numeroPaginas);
        this.local = local;
        this.emprestado = false; //acabou de ser criado, não deve estar em-prestado ainda!
    }
    public boolean isEmprestado()
    {
        return emprestado;
    }
    public void setEmprestado(boolean emprestado)
    {
        this.emprestado = emprestado;
    }
    public String getLocal()
    {
        return local;
    }
    public void setLocal(String local)
    {
        this.local = local;
    }
    
    @Override
    public boolean estaEmprestado()
    {
        return emprestado;
    }
    @Override
    public void emprestar()
    {
        emprestado = true;
        System.out.println("Livro " + getTitulo() + " foi retirado e deve ser devolvido em " + diasEmprestimo + " dias.");
    }
    @Override
    public void devolver()
    {
        emprestado = false;
    }
    @Override
    public String localizacao()
    {
        return local;
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
