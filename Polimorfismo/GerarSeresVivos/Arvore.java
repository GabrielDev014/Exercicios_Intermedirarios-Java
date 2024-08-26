package gerarseresvivospolimorfismodois;

public class Arvore extends SeresVivos{
private int anoPlantio;
private int numeroAneis;

public Arvore(int anoPlantio, int numeroAneis, String nome, int idade){
    super(nome, idade);
    this.anoPlantio = anoPlantio;
    this.numeroAneis = numeroAneis;
}

public int getAnoPlantio(){
    return anoPlantio;
}

public void setAnoPlantio(int anoPlantio){
    this.anoPlantio = anoPlantio;
  }

public int getNumeroAneis(){
    return numeroAneis;
}

public void setNumeroAneis(int numeroAneis){
    this.numeroAneis = numeroAneis;
}

@Override
public String toString (){
    return "Arvore {"+ "ano do plantio = " + anoPlantio + ", número de anéis = " + numeroAneis + '}' + super.toString();
}

@Override
public void gerarIdade(int anoAtual){
    setNumeroAneis(anoAtual - getAnoPlantio());
    setIdade(numeroAneis);
}

}
