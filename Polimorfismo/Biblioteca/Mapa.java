package biblioteca;

public class Mapa 
{
    private String escala;
    
    Mapa (String escala)
    {
        this.escala = escala;
    }
    public String getEscala()
    {
        return escala;
    }
    public void setEscala(String escala)
    {
        this.escala = escala;
    }
    
    @Override
    public String toString()
    {
        return " Escala: " + getEscala();
    }
}
