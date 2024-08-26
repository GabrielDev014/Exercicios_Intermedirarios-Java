package folhapagamento;

public abstract class Empregado 
{
    private String nome;
    
    public Empregado (String nome)
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return nome;
    }
    
    public void setNome (String Nome)
    {
        this.nome = nome;
    }
    
    @Override
    
    public String toString()
    {
        return " Empregado{" + "Nome=" + nome + '}';
    }
    
    public abstract double salarios();
}
