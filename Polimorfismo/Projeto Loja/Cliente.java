
package consulta_de_vendas;

public class Cliente extends Pessoa
{
    private String formaPagamento;
    private String telefone;
    
    Cliente (String nome, int idade, String formaPagamento, String telefone)
    {
        super (nome, idade);
        this.formaPagamento = formaPagamento;
        this.telefone = telefone;
    }
    public String getFormaPagamento()
    {
        return formaPagamento;
    }
    public void setFormaPagamento()
    {
        this.formaPagamento = formaPagamento;
    }
        public String getTelefone()
    {
        return telefone;
    }
    public void setTelefone()
    {
        this.telefone = telefone;
    }
    @Override
    public String toString()
    {
        return "Cliente {" + super.toString() + ", Forma de pagamento: " + getFormaPagamento() + ", Telefone: " + getTelefone() + "}";
    }
}
