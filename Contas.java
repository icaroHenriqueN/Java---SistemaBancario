//FEITO POR ICARO HENRIQUE , TADS 2 SEMESTRE
package Programa;


import Ultilitarios.utilitarios;

public class Contas {


    private static int contadorDeContas = 1;
    private int numeroConta;
    private Contaapp conta;
    private Double saldo = 0.0;

    public Contas(Contaapp conta) {
        this.numeroConta = contadorDeContas;
        this.conta = conta;
        contadorDeContas += 1;

    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Contaapp getConta() {
        return conta;
    }

    public void setConta(Contaapp conta) {
        this.conta = conta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString(){
        return "\nNumero da conta: "+this.getNumeroConta()+
                "\nNome: "+ this.conta.getNome()+
                "\nCPF: "+ this.conta.getCpf()+
                "\nEmail: "+ this.conta.getEmail()+
                "\nSaldo: "+ utilitarios.doubleToString(this.getSaldo())+
                "\n";

    }

    public void depositar(Double valor){
        if(valor > 0){
            setSaldo(getSaldo() + valor);
            //System.out.println("Saldo depositado com sucesso!!");
        }else{
            System.out.println("Não foi possivel realizar o deposito!!");
        }
    }
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saldo sacado com sucesso!!");
        }else{
            System.out.println("Não foi possivel sacar!!");
        }
    }
    public void transferir(Contas contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo()+valor;
            System.out.println("Valor tranferido com sucesso!!");
        }else {
            System.out.println("Não foi possivel transferir o valor!!");
        }
    }

}
