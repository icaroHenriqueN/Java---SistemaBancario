//FEITO POR ICARO HENRIQUE , TADS 2 SEMESTRE
package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Contas> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Contas>();
        operacoes();

    }

    public static void operacoes() {
        System.out.println("---------------------------------------------------------");
        System.out.println("-------------------Bem vindo a agencia-------------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("--------------Qual operação deseja realizar--------------");
        System.out.println("---------------------------------------------------------");
        System.out.println("|    Opção 1 - Criar conta   |");
        System.out.println("|    opção 2 - Depositar     |");
        System.out.println("|    opção 3 - Sacar         |");
        System.out.println("|    opção 4 - Transferir    |");
        System.out.println("|    opção 5 - Lista         |");
        System.out.println("|    opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listar();
                break;
            case 6:
                System.out.println("--ÍNTEEEE--");
                System.exit(0);

            default:
                System.out.println("AI NÃO CHEFE, SELECIONE DO 1 AO 6 !");
              
                break;

        }


    }

    public static void criarConta() {
        //Criando o nome
        System.out.println("\nNome: ");
        String nome = input.next();
        //Criando o cpf
        System.out.println("\nCpf: ");
        String cpf = input.next();
        //criando email
        System.out.println("\nEmail: ");
       
        String email = input.next();      
        Contaapp app = new Contaapp(nome, cpf, email);       
        Contas conta = new Contas(app);      
        contasBancarias.add(conta);

        System.out.println("Conta criada com sucesso !! ");

        operacoes();
    }

    public static Contas encontrarConta(int numeroConta) {
        Contas conta = null;
        if (contasBancarias.size() > 0) {
            for (Contas c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }

        return conta;
    }

    public static void depositar(){
        System.out.println("Informe o numero da conta: *");
        int numeroConta = input.nextInt();

        Contas conta = encontrarConta(numeroConta);
        //Verificando se o numero da conta existe
        if(conta != null){
            System.out.println("Qual valor sera depositado: ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito);
            System.out.println("Valor depositado com sucesso!");
        }else{
            System.out.println("Conta não encontrada!!");
        }
        operacoes();
    }

    public static void sacar(){
        System.out.println("Insira numero da conta: ");
        int numeroConta = input.nextInt();

        Contas conta = encontrarConta(numeroConta);
        if (conta != null){
            System.out.println("Qual valor sera sacar?: ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            //System.out.println("Valor sacado com sucesso!");
        }else{
            System.out.println("Conta não encontrada!!");
        }
        operacoes();
    }
    public static void transferir(){
        System.out.println("Insira o numero da conta remetente: ");
        int numeroRemetente = input.nextInt();

        Contas contaRemetente = encontrarConta(numeroRemetente);

        if(contaRemetente != null){
            System.out.println("Insira o numero da conta destinario: ");
            int numeroDestino = input.nextInt();

            Contas contaDestino = encontrarConta(numeroDestino);

            if(contaDestino != null){
                System.out.println("Qual valor deseja transferir: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestino, valor);

            }else{
                System.out.println("A conta para deposito não encontrada! ");
            }
        }else{
            System.out.println("A conta para transferencia não encontrada! ");
        }
        operacoes();
    }
    public static void listar(){
        if(contasBancarias.size() > 0){
            for(Contas conta: contasBancarias) {
                System.out.println(conta);
            }
            }else{
            System.out.println("Não ha contas cadastradas!! ");
        }
        operacoes();
    }

}






