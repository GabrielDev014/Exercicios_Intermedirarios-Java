package livraria;

public class Cliente extends Pessoa implements Usuario
{
    private int numeroCartao;
    
    Cliente(String nome, String login, String senha, int idade, int numeroCartao)
    {
        super(nome, login, senha, idade);
        this.numeroCartao = numeroCartao;
    }
    
    public int getNumeroCartao()
    {
        return numeroCartao;
    }
    public void setNumeroCartao(int numeroCartao)
    {
        this.numeroCartao = numeroCartao;
    }
    
    public void validarLogin(String login, String senha)
    {
        if (this.getLogin().equals(login) && this.getSenha().equals(senha))
        {
            System.out.println("Usuário válido");
        }
        else
        {
            System.out.println("Usuário inválido");
        }
    }
}
