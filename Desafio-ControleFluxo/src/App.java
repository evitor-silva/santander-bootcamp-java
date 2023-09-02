import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Insira o Primeiro Numero");
        int primeiroParametro = Input.nextInt();
        System.out.print("Insira o Segundo Numero");
        int segundoParametro = Input.nextInt();

        Input.close();
        try {
            Contar(primeiroParametro,segundoParametro);
        } catch (NumeroException e) {
            System.out.println("o Primeiro Numero deve ser MAIOR que o Segundo Numero.");
        }
    }


    static void Contar(int NumeroUm, int NumeroDois) throws NumeroException{
        if(NumeroDois > NumeroUm)
        throw new NumeroException();

        int contagem = (NumeroUm - NumeroDois);
        for (int i = 0; i < contagem; i++) {
            System.out.println( "Imprimindo o numero "+i);
        }
    }

}
