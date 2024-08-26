package consulta_de_vendas;

public class Vendedor extends Pessoa implements CalculoSalario
{
    private double salario;
    private double bonus;
    
    Vendedor (String nome, int idade, double salario, double bonus)
    {
        super(nome, idade);
        this.salario = salario;
        this.bonus = bonus;
    }
    public double getSalario()
    {
        return salario;
    }
    public void setSalario(double salario)
    {
        this.salario = salario;
    }
    public double getBonus()
    {
        return bonus;
    }
    
    @Override
    public double calcularSalario()
    {
        return (getSalario() + getBonus());
    }
    @Override
    public String toString()
    {
        return "Vendedor {" + super.toString() + ", Salário: R$" + getSalario() + ", Bônus pela venda: R$" + getBonus() + "}";
    }
}
