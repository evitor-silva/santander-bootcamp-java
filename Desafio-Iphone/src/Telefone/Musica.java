package Telefone;

public class Musica extends Telefonia{
    protected String tocar() {
        return "Tocando musica";
    }
    protected String pausar(){
        return "Pausando musica";
    }
    protected String selecionar(){
        return "Selecionando musica";
    }
}
