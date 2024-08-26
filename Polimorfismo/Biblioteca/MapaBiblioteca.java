package biblioteca;

public class MapaBiblioteca extends Mapa implements ItemBiblioteca
{
    private boolean emprestado;
    private String local;
    
    MapaBiblioteca(String escala, String local)
    {
        super(escala);
        this.local = local;
        emprestado = false;
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
       System.out.println("Mapa: " + getEscala() + " foi retirado e deve ser devolvido em " + diasEmprestimo + " dias.");
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
