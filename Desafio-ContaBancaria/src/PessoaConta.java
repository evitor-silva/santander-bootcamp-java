public class PessoaConta implements InterfaceBanco{
    private String Nome;
    private int Numero;
    private String Agencia;
    private Float Saldo;

    public PessoaConta(String Nome, int Numero, String Agencia, Float Saldo){
        this.Nome = Nome;
        this.Numero = Numero;
        this.Agencia = Agencia;
        this.Saldo = Saldo;
    }
    public String Criar(){
        return "Ola "+this.Nome+", obrigado por criar uma conta em nosso banco, sua agencia "+this.Agencia+", conta "+this.Numero+" e seu saldo R$"+this.Saldo+" já disponivel para saque.";
    }
    public String retirar_Saldo(Double SaldoRetirar){
        if(this.Saldo >= SaldoRetirar){
            return "Saldo: "+(this.Saldo - SaldoRetirar);
        }
        return "Não há saldo suficiente";
    }
}
