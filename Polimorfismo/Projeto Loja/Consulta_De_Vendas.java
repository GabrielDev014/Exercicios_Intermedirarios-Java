//Classe Main

package consulta_de_vendas;

public class Consulta_De_Vendas {

    public static void main(String[] args) {
       Cliente clienteUm = new Cliente("Gabriel", 19, "Dinheiro", "(14) 12345-6789");
       Cliente clienteDois = new Cliente("José", 18, "Pix", "(18) 12345-6789");
       Cliente clienteTres = new Cliente("Judite", 23, "Débito", "(13) 12345-6789");
       
       Vendedor vendedorUm = new Vendedor("Josivaldo", 53, 1400, 50);
       Vendedor vendedorDois = new Vendedor("Jubileu", 24, 1320, 25);
       Vendedor vendedorTres = new Vendedor("Josefina", 47, 1560, 35);
       
       Venda vendaUm = new Venda(clienteUm, vendedorUm, "28-03-2024", "Geladeira Brastemp", 2599.99);
       Venda vendaDois = new Venda(clienteDois, vendedorDois, "27-03-2024", "Air Fryer", 857.90);
       Venda vendaTres = new Venda(clienteTres, vendedorTres, "27-03-2024", "Smart TV LG", 1799.99);
       
       Venda vendas[] = new Venda[3];
       vendas[0] = vendaUm;
       vendas[1] = vendaDois;
       vendas[2] = vendaTres;
       
       System.out.println("Histórico de Vendas \n");
       
       for (Venda vendaCorrente : vendas) 
       {
           System.out.println(vendaCorrente);
           System.out.println(vendaCorrente.getCliente());
           System.out.println(vendaCorrente.getVendedor());
           System.out.printf("Salário pós venda: $%,.2f\n\n", vendaCorrente.getVendedor().calcularSalario());
       }
    }
}
