package lanchonete_inserir;

public class Cardapio 
{
    private String codigo;
    private String tipo;
    private String nome;
    private String descricao;
    private String valor;
    
    public String getCodigo()
    {
        return codigo;
    }
    public void setCodigo (String codigo)
    {
        this.codigo = codigo;
    }
    public String getTipo()
    {
        return tipo;
    }
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }
    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public String getDescricao()
    {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    public String getValor()
    {
        return valor;
    }
    public void setValor(String valor)
    {
        this.valor = valor;
    }
}
