package View;

import Model.Cliente;
import Model.Fornecedor;
import Model.Funcionario;
import Service.Pagar;
import Service.Receber;
import java.util.Scanner;

public class MenuPrincipal {

    private Funcionario funcionario = new Funcionario();
    private Cliente cliente = new Cliente();
    private Fornecedor fornecedor = new Fornecedor();
    private Receber receber = new Receber();
    private Pagar pagar = new Pagar();

    Scanner sc = new Scanner(System.in);

    // ===== GETTERS PARA O FAKER =====
    public Funcionario getFuncionario() { return funcionario; }
    public Cliente getCliente() { return cliente; }
    public Fornecedor getFornecedor() { return fornecedor; }
    public Receber getReceber() { return receber; }
    public Pagar getPagar() { return pagar; }

    public void menu() {
        int opcao = 0;
        do {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1 - Cadastro de Funcionarios");
            System.out.println("2 - Cadastro de Clientes");
            System.out.println("3 - Cadastro de Fornecedores");
            System.out.println("4 - Contas a Receber");
            System.out.println("5 - Contas a Pagar");
            System.out.println("6 - Fluxo de Caixa");
            System.out.println("7 - Sair");
            System.out.print("Opcao: ");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1: menuFuncionario(); break;
                case 2: menuCliente();     break;
                case 3: menuFornecedor();  break;
                case 4: menuReceber();     break;
                case 5: menuPagar();       break;
                case 6: fluxoCaixa();      break;
                case 7: System.out.println("Saindo..."); break;
                default: System.out.println("Opcao invalida!");
            }
        } while (opcao != 7);
    }

    public void menuFuncionario() {
        String op = "";
        do {
            System.out.println("\n===== FUNCIONARIO =====");
            System.out.println("a - Incluir");
            System.out.println("b - Alterar pelo ID");
            System.out.println("c - Consultar pela posicao na lista");
            System.out.println("d - Consultar pelo ID");
            System.out.println("e - Consultar pelo Nome");
            System.out.println("f - Excluir pelo ID");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextLine();

            switch (op) {
                case "a":
                    Funcionario f = new Funcionario();
                    f.entrar();
                    funcionario.getListaFuncionarios().add(f);
                    System.out.println("Incluido!");
                    break;
                case "b": funcionario.alterar(); break;
                case "c":
                    System.out.println("Posicao (0 em diante): ");
                    int pos = Integer.parseInt(sc.nextLine());
                    try {
                        funcionario.getListaFuncionarios().get(pos).imprimir();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Posicao invalida!");
                    }
                    break;
                case "d":
                    System.out.println("ID: ");
                    funcionario.consultarPorId(Integer.parseInt(sc.nextLine()));
                    break;
                case "e":
                    System.out.println("Nome: ");
                    funcionario.consultarPorNome(sc.nextLine());
                    break;
                case "f": funcionario.excluir(); break;
                case "0": break;
                default: System.out.println("Opcao invalida!");
            }
        } while (!op.equals("0"));
    }

    public void menuCliente() {
        String op = "";
        do {
            System.out.println("\n===== CLIENTE =====");
            System.out.println("a - Incluir");
            System.out.println("b - Alterar pelo ID");
            System.out.println("c - Consultar pela posicao na Lista");
            System.out.println("d - Consultar pelo ID");
            System.out.println("e - Consultar pelo CNPJ");
            System.out.println("f - Consultar pelo Nome");
            System.out.println("g - Excluir pelo ID");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextLine();

            switch (op) {
                case "a":
                    Cliente c = new Cliente();
                    c.entrar();
                    cliente.getListaClientes().add(c);
                    System.out.println("Incluido!");
                    break;
                case "b": cliente.alterar(); break;
                case "c":
                    System.out.println("Posicao (0 em diante): ");
                    int pos = Integer.parseInt(sc.nextLine());
                    try {
                        cliente.getListaClientes().get(pos).imprimir();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Posicao invalida!");
                    }
                    break;
                case "d":
                    System.out.println("ID: ");
                    cliente.consultarPorId(Integer.parseInt(sc.nextLine()));
                    break;
                case "e":
                    System.out.println("CNPJ: ");
                    cliente.consultarPorCnpj(sc.nextLine());
                    break;
                case "f":
                    System.out.println("Nome: ");
                    cliente.consultarPorNome(sc.nextLine());
                    break;
                case "g": cliente.excluir(); break;
                case "0": break;
                default: System.out.println("Opcao invalida!");
            }
        } while (!op.equals("0"));
    }

    public void menuFornecedor() {
        String op = "";
        do {
            System.out.println("\n===== FORNECEDOR =====");
            System.out.println("a - Incluir");
            System.out.println("b - Alterar pelo ID");
            System.out.println("c - Consultar pela posicao na Lista");
            System.out.println("d - Consultar pelo ID");
            System.out.println("e - Consultar pelo CNPJ");
            System.out.println("f - Excluir pelo ID");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextLine();

            switch (op) {
                case "a":
                    Fornecedor fn = new Fornecedor();
                    fn.entrar();
                    fornecedor.getListaFornecedores().add(fn);
                    System.out.println("Incluido!");
                    break;
                case "b": fornecedor.alterar(); break;
                case "c":
                    System.out.println("Posicao (0 em diante): ");
                    int pos = Integer.parseInt(sc.nextLine());
                    try {
                        fornecedor.getListaFornecedores().get(pos).imprimir();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Posicao invalida!");
                    }
                    break;
                case "d":
                    System.out.println("ID: ");
                    fornecedor.consultarPorId(Integer.parseInt(sc.nextLine()));
                    break;
                case "e":
                    System.out.println("CNPJ: ");
                    fornecedor.consultarPorCnpj(sc.nextLine());
                    break;
                case "f": fornecedor.excluir(); break;
                case "0": break;
                default: System.out.println("Opcao invalida!");
            }
        } while (!op.equals("0"));
    }

    public void menuReceber() {
        String op = "";
        do {
            System.out.println("\n===== CONTAS A RECEBER =====");
            System.out.println("a - Incluir");
            System.out.println("b - Alterar pelo numero");
            System.out.println("c - Consultar pelo Nome do Cliente");
            System.out.println("d - Consultar pelo Valor");
            System.out.println("e - Consultar pela Nota Fiscal");
            System.out.println("f - Excluir pelo numero");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextLine();

            switch (op) {
                case "a":
                    Receber r = new Receber();
                    r.entrar();
                    receber.getListaReceber().add(r);
                    System.out.println("Incluido!");
                    break;
                case "b": receber.alterar(); break;
                case "c":
                    System.out.println("Nome do Cliente: ");
                    receber.consultarPorNomeCliente(sc.nextLine());
                    break;
                case "d":
                    System.out.println("Valor: ");
                    receber.consultarPorValor(Double.parseDouble(sc.nextLine()));
                    break;
                case "e":
                    System.out.println("Nota Fiscal: ");
                    receber.consultarPorNotaFiscal(sc.nextLine());
                    break;
                case "f": receber.excluir(); break;
                case "0": break;
                default: System.out.println("Opcao invalida!");
            }
        } while (!op.equals("0"));
    }

    public void menuPagar() {
        String op = "";
        do {
            System.out.println("\n===== CONTAS A PAGAR =====");
            System.out.println("a - Incluir");
            System.out.println("b - Alterar pelo numero");
            System.out.println("c - Consultar pelo CNPJ do Fornecedor");
            System.out.println("d - Consultar pelo Valor");
            System.out.println("e - Consultar pelo Boleto");
            System.out.println("f - Excluir pelo numero");
            System.out.println("0 - Voltar");
            System.out.print("Opcao: ");
            op = sc.nextLine();

            switch (op) {
                case "a":
                    Pagar p = new Pagar();
                    p.entrar();
                    pagar.getListaPagar().add(p);
                    System.out.println("Incluido!");
                    break;
                case "b": pagar.alterar(); break;
                case "c":
                    System.out.println("CNPJ do Fornecedor: ");
                    pagar.consultarPorCnpj(sc.nextLine());
                    break;
                case "d":
                    System.out.println("Valor: ");
                    pagar.consultarPorValor(Double.parseDouble(sc.nextLine()));
                    break;
                case "e":
                    System.out.println("Boleto: ");
                    pagar.consultarPorBoleto(sc.nextLine());
                    break;
                case "f": pagar.excluir(); break;
                case "0": break;
                default: System.out.println("Opcao invalida!");
            }
        } while (!op.equals("0"));
    }

    public void fluxoCaixa() {
        if (receber.getListaReceber().isEmpty() && pagar.getListaPagar().isEmpty()) {
            System.out.println("Nenhum dado financeiro cadastrado!");
            return;
        }

        double totalCredito = 0, totalDebito = 0, saldo = 0;

        System.out.println("\n============================================");
        System.out.println("           FLUXO DE CAIXA                  ");
        System.out.println("============================================");
        System.out.printf("%-15s %-12s %-12s %-12s%n", "Vencimento", "Credito", "Debito", "Saldo");
        System.out.println("--------------------------------------------");

        for (Receber r : receber.getListaReceber()) {
            double credito = r.getTotal();
            totalCredito += credito;
            saldo += credito;
            System.out.printf("%-15s %-12.2f %-12.2f %-12.2f%n",
                    r.getVencimento(), credito, 0.0, saldo);
        }

        for (Pagar p : pagar.getListaPagar()) {
            double debito = p.getTotal();
            totalDebito += debito;
            saldo -= debito;
            System.out.printf("%-15s %-12.2f %-12.2f %-12.2f%n",
                    p.getVencimento(), 0.0, debito, saldo);
        }

        System.out.println("--------------------------------------------");
        System.out.printf("%-15s %-12.2f %-12.2f %-12.2f%n",
                "Totais", totalCredito, totalDebito, totalCredito - totalDebito);
        System.out.println("============================================");
    }
}