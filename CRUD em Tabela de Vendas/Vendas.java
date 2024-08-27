package exiberesultados;

public class Vendas 
{
    private String codigo;
    private String cliente;
    private String produtoComprado;
    private String valorVenda;
    private String meioPagamento;
    private String vendedor;
    private String salarioVendedor;
    
    public String getCodigo()
    {
        return codigo;
    }
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public String getCliente()
    {
        return cliente;
    }
    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }

    public String getProdutoComprado()
    {
        return produtoComprado;
    }
    public void setProdutoComprado(String produtoComprado)
    {
        this.produtoComprado = produtoComprado;
    }

    public String getValorVenda()
    {
        return valorVenda;
    }
    public void setValorVenda(String valorVenda)
    {
        this.valorVenda = valorVenda;
    }

    public String getMeioPagamento()
    {
        return meioPagamento;
    }
    public void setMeioPagamento(String meioPagamento)
    {
        this.meioPagamento = meioPagamento;
    }

    public String getVendedor()
    {
        return vendedor;
    }
    public void setVendedor(String vendedor)
    {
        this.vendedor = vendedor;
    }

    public String getSalarioVendedor()
    {
        return salarioVendedor;
    }
    public void setSalarioVendedor(String salarioVendedor)
    {
        this.salarioVendedor = salarioVendedor;
    }
}
