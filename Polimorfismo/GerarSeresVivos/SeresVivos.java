//Classe abstrata
package gerarseresvivospolimorfismodois;

public abstract class SeresVivos {
private String nome;
private int idade;

public SeresVivos(String nome, int idade){
this.nome = nome;
this.idade = idade;
}

public String getNome(){
  return nome;
}

public void setNome(String nome){
   this.nome = nome;
}

public int getIdade(){
    return idade;
}

public void setIdade(int idade){
    this.idade = idade;
}

@Override
public String toString(){
return " Seres Vivos {" + "nome = " + nome + ", idade = " + idade + '}';
}

public abstract void gerarIdade(int anoAtual);

}
