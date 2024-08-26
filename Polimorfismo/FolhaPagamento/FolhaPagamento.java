package folhapagamento;

public class FolhaPagamento 
{
    public static void main(String[] args) 
    {
        Horista empregadoUm = new Horista(160, 35, "Gabriel");
        Comissionado empregadoDois = new Comissionado(5000, 0.5, "José");
        
        System.out.println("Empregados processados individualmente:\n");
        System.out.printf("%s\n%s: $%,.2f \n \n", empregadoUm, "Salário", empregadoUm.salarios());
        System.out.printf("%s\n%s: $%,.2f \n \n", empregadoDois, "Salário", empregadoDois.salarios());
        
        //cria um array Empregado de dois elementos
        Empregado empregados[] = new Empregado[2];
        
        //inicializa o array
        empregados [0] = empregadoUm;
        empregados[1] = empregadoDois;
        
        System.out.println("Empregados processados utilizando polimorfismo \n");
        
        //processa genericamente cada elemento
        for (Empregado empregadoCorrente : empregados)
        {
            System.out.println(empregadoCorrente); //invoca toString
            System.out.printf("Salário $%,.2f\n\n", empregadoCorrente.salarios());
        }
    }
}
