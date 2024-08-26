package livraria;

public class Livraria 
{
    public static void main(String[] args) 
    {
        Cliente clienteUm = new Cliente("Rosangela","rrxxrr", "1234",35, 22222);
        System.out.println("Cliente: " + clienteUm.toString());
        clienteUm.validarLogin("rrxxrr", "4321");
        
        System.out.println("");
        
        Funcionario funcionarioUm = new Funcionario("Pedro antonio", "ppxxpp", "6543", 34, 742, 0);
        System.out.println("Funcionário: " + funcionarioUm.toString());
        funcionarioUm.validarLogin("ppxxpp", "6543");
        System.out.println("INSS a pagar: " + funcionarioUm.calcularINSS());
    }
}
