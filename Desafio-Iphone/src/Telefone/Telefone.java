package Telefone;

public class Telefone extends Musica{

    public String musica(String str) {
        Musica musiFuncoes = new Musica();
        String retorno = null;
        if (str == "tocar") {
            retorno = musiFuncoes.tocar();
        }
        if (str == "pausar") {
            retorno = musiFuncoes.pausar();
        }
        if (str == "selecionar") {
            retorno = musiFuncoes.selecionar();
        }
        return retorno;
    }

    public String telefonia(String str) {
       Telefonia tel = new Telefonia();
       String retorno = null; 
        if (str == "atender") {
            retorno = tel.atender();
        }
        if (str == "ligar") {
            retorno = tel.ligar();
        }
        if (str == "selecionar") {
            retorno = tel.iniciarChamada();
        }
        return retorno;
    }

    public String navegador(String str){
        Navegador nv = new Navegador();
        String retorno = null;
        if(str == "exibir"){
            retorno = nv.exibirPagina();
        }
        if(str == "adicionaraba"){
            retorno = nv.adicionarNovaAba();
        }
        if(str == "atualizar"){
            retorno = nv.atualizarPagina();
        }
        return retorno;
    }
}
