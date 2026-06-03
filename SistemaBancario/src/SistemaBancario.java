import java.util.Scanner;
import java.util.Locale;

public class SistemaBancario {

    public static void titulo(String texto){

        System.out.println("\n================================");
        System.out.println(texto);
        System.out.println("================================");

    }

    public static void limparTela(){

        for(int i = 0; i < 40; i++){
            System.out.println();
        }

    }

    public static void menuPrincipal(){

        System.out.println("1 - Criar conta");
        System.out.println("2 - Login");
        System.out.println("3 - Depositar");
        System.out.println("4 - Sacar");
        System.out.println("5 - Transferir");
        System.out.println("6 - Extrato");
        System.out.println("7 - Logout");
        System.out.println("0 - Sair");

    }

    public static void main(String[] args) {

        Locale.setDefault(new Locale("pt", "BR"));
        Scanner scanner = new Scanner(System.in);

        final int VALOR_FIXO = 10;

        String emails[] = new String[VALOR_FIXO]; // Vetor para armazenar as email criadas
        String titulares[] = new String[VALOR_FIXO]; // Vetor para armazenar os nomes dos titulares das contas
        double saldos[] = new double[VALOR_FIXO]; // Vetor para armazenar os saldos das contas
        String senhas[] = new String[VALOR_FIXO]; // Vetor para armazenas as senhas das contas

        int opcao;

        boolean usuarioLogado = false;
        int indiceUsuarioLogado = -1;


        do{
            titulo("SISTEMA BANCÁRIO");

            if (usuarioLogado) {

                System.out.println("Usuário logado: "
                        + titulares[indiceUsuarioLogado]);

            } else {

                System.out.println("Usuário logado: Nenhum");

            }

            System.out.println();

            menuPrincipal();

            System.out.println();

            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();

            scanner.nextLine(); // Limpar buffer

            switch (opcao){
                case 1:
                    limparTela();
                    titulo("CRIAR CONTA");

                    int indiceLivre = -1;

                    // Procurar posição livre
                    for(int procurarPosicaoLivre = 0; procurarPosicaoLivre < emails.length; procurarPosicaoLivre++){

                        if(emails[procurarPosicaoLivre] == null){

                            indiceLivre = procurarPosicaoLivre;
                            break;
                        }
                    }

                    // Verificar se existe espaço
                    if(indiceLivre == -1){
                        System.out.println("[ERRO] Limite de contas atingido.");
                        break;
                    }

                    System.out.print("Digite seu nome completo: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite seu E-mail: ");
                    String emailNovo = scanner.nextLine();

                    // Validação de E-MAIL duplicado
                    boolean emailExistente = false;

                    for(int verificarEmailExistente = 0; verificarEmailExistente < emails.length; verificarEmailExistente++){

                        if(emails[verificarEmailExistente] != null && emails[verificarEmailExistente].equalsIgnoreCase(emailNovo)){

                            emailExistente = true;
                            break;
                        }
                    }

                    if(emailExistente){

                        System.out.println("[ERRO] Este e-mail já está cadastrado.");

                        break;
                    }

                    System.out.print("Senha: ");
                    String senhaNova = scanner.nextLine();

                    // Salvar dados
                    titulares[indiceLivre] = nome;
                    emails[indiceLivre] = emailNovo;
                    senhas[indiceLivre] = senhaNova;
                    saldos[indiceLivre] = 0.0;


                    System.out.println();
                    System.out.println("[SUCESSO] Conta criada com sucesso!");

                    break;
                case 2:
                    limparTela();
                    titulo("LOGIN");

                    System.out.print("Email: ");
                    String emailLogin = scanner.nextLine();

                    System.out.print("Senha: ");
                    String senhaLogin = scanner.nextLine();

                    // Limpar sessão anterior
                    usuarioLogado = false;
                    indiceUsuarioLogado = -1;

                    // Procurar usuário
                    for(int indiceProcurarUsuarios = 0; indiceProcurarUsuarios < emails.length; indiceProcurarUsuarios++) {

                        if (emails[indiceProcurarUsuarios] != null &&
                                emails[indiceProcurarUsuarios].equalsIgnoreCase(emailLogin) &&
                                senhas[indiceProcurarUsuarios].equals(senhaLogin)) {

                            usuarioLogado = true;

                            indiceUsuarioLogado = indiceProcurarUsuarios;

                            break;

                        }
                    }

                    if (usuarioLogado) {

                        System.out.println();

                        System.out.println("Login realizado com sucesso!");
                        System.out.println("Bem-vindo, " + titulares[indiceUsuarioLogado]);

                    } else {

                        System.out.println();

                        System.out.println("Email ou senha incorretos.");
                    }

                    break;

                case 3:
                    // Verificar se o usuário está logado
                    if (!usuarioLogado) {
                        System.out.println("[ERRO] Faça login primeiro.");
                        break;
                    }

                    limparTela();
                    titulo("DEPÓSITO");

                    System.out.println("Titular: " + titulares[indiceUsuarioLogado]);

                    System.out.printf("Saldo atual: R$ %.2f%n", saldos[indiceUsuarioLogado]);

                    System.out.println();

                    System.out.print("Valor para depósito: R$ ");
                    double deposito = scanner.nextDouble();

                    scanner.nextLine();

                    if (deposito <= 0) {

                        System.out.println("[ERRO] Valor inválido.");

                    } else {

                        saldos[indiceUsuarioLogado] += deposito;

                        System.out.println("[SUCESSO] Depósito realizado!");

                        System.out.printf("Novo saldo: R$ %.2f%n", saldos[indiceUsuarioLogado]);

                    }

                    break;
                case 4:
                    // Verificar se o usuário está logado
                    if (!usuarioLogado) {
                        System.out.println("[ERRO] Faça login primeiro.");
                        break;
                    }

                    limparTela();
                    titulo("SAQUE");

                    System.out.println("Titular: " + titulares[indiceUsuarioLogado]);
                    System.out.printf("Saldo atual: R$ %.2f%n", saldos[indiceUsuarioLogado]);

                    System.out.println();

                    System.out.print("Valor para saque: R$ ");
                    double sacar = scanner.nextDouble();

                    scanner.nextLine();

                    if (sacar <= 0) {

                        System.out.println("[ERRO] Valor inválido.");

                    } else if (sacar > saldos[indiceUsuarioLogado]) {

                        System.out.println("[ERRO] Saldo insuficiente.");

                    } else {

                        saldos[indiceUsuarioLogado] -= sacar;

                        System.out.println("[SUCESSO] Saque realizado!");
                        System.out.printf("Novo saldo: R$ %.2f%n", saldos[indiceUsuarioLogado]);
                    }

                    break;
                case 5:

                    if (!usuarioLogado) {

                        System.out.println("[ERRO] Faça login primeiro.");

                        break;
                    }

                    limparTela();
                    titulo("TRANSFERÊNCIA");

                    System.out.print("Informe o e-mail do destinatário: ");
                    String emailDestino = scanner.nextLine();

                    int indiceDestino = -1;

                    for (int procurarEmailDestino = 0; procurarEmailDestino < emails.length; procurarEmailDestino++) {

                        if (emails[procurarEmailDestino] != null && emails[procurarEmailDestino].equalsIgnoreCase(emailDestino)) {

                            indiceDestino = procurarEmailDestino;
                            break;
                        }
                    }

                    if (indiceDestino == -1) {

                        System.out.println("[ERRO] Conta não encontrada.");
                        break;
                    }

                    if (indiceDestino == indiceUsuarioLogado) {

                        System.out.println("[ERRO] Você não pode transferir para si mesmo.");
                        break;
                    }

                    System.out.println();

                    System.out.println("Destinatário: " + titulares[indiceDestino]);

                    System.out.printf("Seu saldo: R$ %.2f%n", saldos[indiceUsuarioLogado]);

                    System.out.println();

                    System.out.print("Valor da transferência: R$ ");
                    double transferencia = scanner.nextDouble();

                    scanner.nextLine();

                    if (transferencia <= 0) {

                        System.out.println("[ERRO] Valor inválido.");
                        break;
                    }

                    if (transferencia > saldos[indiceUsuarioLogado]) {

                        System.out.println("[ERRO] Saldo insuficiente.");
                        break;
                    }

                    System.out.print("Confirmar transferência? (S/N): ");
                    String confirmar = scanner.nextLine();

                    if (!confirmar.equalsIgnoreCase("S")) {

                        System.out.println("Transferência cancelada.");
                        break;
                    }

                    saldos[indiceUsuarioLogado] -= transferencia;
                    saldos[indiceDestino] += transferencia;

                    System.out.println();

                    System.out.println("[SUCESSO] Transferência realizada!");
                    System.out.println("Destinatário: " + titulares[indiceDestino]);
                    System.out.printf("Saldo atual: R$ %.2f%n", saldos[indiceUsuarioLogado]);

                    break;
                case 6:

                    if (!usuarioLogado) {

                        System.out.println("[ERRO] Faça login primeiro.");
                        break;
                    }

                    limparTela();
                    titulo("EXTRATO");

                    System.out.println("--------------------------------");

                    System.out.println("Titular : " + titulares[indiceUsuarioLogado]);

                    System.out.println("E-mail  : " + emails[indiceUsuarioLogado]);

                    System.out.printf("Saldo   : R$ %.2f%n", saldos[indiceUsuarioLogado]);

                    System.out.println("Status  : Conta ativa");

                    System.out.println("--------------------------------");

                    break;
                case 7:

                    limparTela();

                    if (!usuarioLogado) {

                        System.out.println("[ERRO] Nenhum usuário está logado.");

                    } else {

                        usuarioLogado = false;
                        indiceUsuarioLogado = -1;

                        System.out.println("[SUCESSO] Logout realizado.");

                    }

                    break;
                case 0:

                    titulo("ENCERRANDO SISTEMA");

                    System.out.println("Obrigado por utilizar o sistema.");
                    break;

                default:
                    System.out.println("[ERRO] Opção inválida.");


            }

        }while(opcao != 0);

        scanner.close();

    }
}
