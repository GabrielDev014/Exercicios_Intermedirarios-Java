package gerarseresvivospolimorfismodois;

public class Pessoas extends SeresVivos {
private int anoNascimento;

public Pessoas(int anoNascimento, String nome, int idade){
    super(nome, idade);
    this.anoNascimento = anoNascimento;
}

public int getAnoNascimento(){
    return anoNascimento;
}

public void setAnoNascimento(int anoNascimento){
    this.anoNascimento = anoNascimento;
}

@Override
public String toString(){
    return "Pessoas {" + "ano do nascimento = " + anoNascimento + '}' + super.toString();
}

@Override
public void gerarIdade(int anoAtual){
    this.setIdade(anoAtual - getAnoNascimento());
}

}
