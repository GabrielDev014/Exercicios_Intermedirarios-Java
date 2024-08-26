package folhapagamento;

public class Horista extends Empregado
{
    private double quantidadeHoras;
    private double valor;

    public Horista(double quantidadeHoras, double valor, String nome)
    {
        super (nome);
        this.quantidadeHoras = quantidadeHoras;
        this.valor = valor;
    }
    
    public double getQuantidadeHoras()
    {
        return quantidadeHoras;
    }
    
    public void setQuantidadeHoras(double quantidadeHoras)
    {
        this.quantidadeHoras = quantidadeHoras;
    }
    
    public double getValor()
    {
        return valor;
    }
    
    public void setValor(double valor)
    {
        this.valor =  valor;
    }
    
    @Override
    public String toString()
    {
        return "Horista {" + "quantidade de horas = " + quantidadeHoras + " valor hora = " + valor + '}' + super.toString();
    }
    
    @Override
    public double salarios()
    {
        return (getQuantidadeHoras() * getValor());
    }
}
