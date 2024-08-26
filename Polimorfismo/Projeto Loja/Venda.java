package consulta_de_vendas;

public class Venda 
{
    private Cliente cliente;
    private Vendedor vendedor;
    private String dataVenda;
    private String produtoVendido;
    private double valorProduto;
    
    public Venda(Cliente cliente, Vendedor vendedor, String dataVenda, String produtoVendido, double valorProduto) 
    {
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.dataVenda = dataVenda;
        this.produtoVendido = produtoVendido;
        this.valorProduto = valorProduto;
    }

    public Cliente getCliente() 
    {
        return cliente;
    }

    public Vendedor getVendedor() 
    {
        return vendedor;
    }

    public String getDataVenda() 
    {
        return dataVenda;
    }
    public void setDataVenda(String dataVenda)
    {
        this.dataVenda = dataVenda;
    }
    public String getProdutoVendido() 
    {
        return produtoVendido;
    }
    public void setProdutoVendido(String produtoVendido)
    {
        this.produtoVendido = produtoVendido;
    }
    public double getValorProduto()
    {
        return valorProduto;
    }
    public void setValorProduto(double valorProduto)
    {
        this.valorProduto = valorProduto;
    }
    
    public String toString()
    {
        return "Data da venda: " + getDataVenda() + ", Produto vendido: " + getProdutoVendido() + ", Valor do produto: " + getValorProduto() ;
    }
    
}
