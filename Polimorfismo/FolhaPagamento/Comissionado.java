package folhapagamento;

public class Comissionado extends Empregado
{
    private double vendas;
    private double comissao;
    
    public Comissionado (double vendas, double comissao, String nome)
    {
        super(nome);
        this.vendas = vendas;
        this.comissao = comissao;
    }
    
    public double getVendas()
    {
        return vendas;
    }
    
    public void setVendas(double vendas)
    {
        this.vendas = vendas;
    }
    
    public double getComissao()
    {
        return comissao;
    }
    
    public void setComissao(double comissao)
    {
        this.comissao = comissao;
    }
    
    @Override
    public String toString()
    {
        return "Comissionado {" + "vendas = " + vendas + " comissão = " + comissao + '}' + super.toString();
    }
    
    @Override
    public double salarios()
    {
        return (getVendas() * getComissao());
    }
}
