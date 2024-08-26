//SUPER CLASSE:

package gerarseresvivospolimorfismodois;

public class GerarSeresVivosPolimorfismoDois {

public static void main(String[] args) {

    // cria objetos de subclasse
    Pessoas pessoaUm = new Pessoas (1977, "marcelo",0);
    Arvore arvoreUm = new Arvore (1913,0,"Carvalho",0);

    System.out.println("Seres Vivos processados individualmente: \n");
    pessoaUm.gerarIdade(2020);
    System.out.println(pessoaUm);
    arvoreUm.gerarIdade(2020);
    System.out.println(arvoreUm);

    // Cria um Array

    SeresVivos seres [] = new SeresVivos[2];

    // inicializa o array
    seres[0] =  pessoaUm;
    seres[1] = arvoreUm;

    System.out.println("\nSeres Vivos processados utilizando POLIMORFISMO \n");

    //processa genericamente cada elemento /objeto
    for (SeresVivos serCorrente: seres){
        serCorrente.gerarIdade(2020);
        System.out.println(serCorrente);
    }
  }
}
