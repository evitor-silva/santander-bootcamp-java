import java.util.Locale;
import java.util.Scanner;

public class ContaBanco {
    public static void main(String[] args) throws Exception {
        Scanner Input = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite seu Nome");
        String Nome  = Input.next();

        System.out.println("Digite seu Numero");
        int Numero  = Input.nextInt();

        System.out.println("Digite o número da Agência");
        String Agencia  = Input.next();

        System.out.println("Digite o número do Saldo");
        Float Saldo  = Input.nextFloat();

        Input.close();
        try {
          PessoaConta Conta = new PessoaConta(Nome, Numero, Agencia, Saldo);
          System.out.println(Conta.Criar());
          System.out.println(Conta.retirar_Saldo(30.70));
        } catch (Exception e) {
          System.out.println("Houve um Erro"+ e); 
        }
    }
}
