package Service;

import Model.Fornecedor;
import java.util.ArrayList;
import java.util.Scanner;

public class Pagar extends Financeiro {
    private Fornecedor fornecedor;
    private String boleto;
    private ArrayList<Pagar> listaPagar = new ArrayList<>();

    public Pagar() { this.fornecedor = new Fornecedor(); }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }
    public String getBoleto() { return boleto; }
    public void setBoleto(String boleto) { this.boleto = boleto; }
    public ArrayList<Pagar> getListaPagar() { return listaPagar; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Dados do Fornecedor --");
        this.fornecedor.entrar();
        System.out.println("Boleto: ");
        this.boleto = sc.nextLine();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("-- Fornecedor --");
        this.fornecedor.imprimir();
        System.out.println("Boleto: " + boleto);
    }

    public void imprimir(int numero) {
        for (Pagar p : listaPagar) {
            if (p.getNumero() == numero) { p.imprimir(); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void alterar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero para alterar: ");
        int numero = Integer.parseInt(sc.nextLine());
        for (Pagar p : listaPagar) {
            if (p.getNumero() == numero) { p.entrar(); System.out.println("Alterado!"); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void consultar() {
        try {
            if (listaPagar.isEmpty()) throw new Exception("Nenhuma conta a pagar!");
            for (Pagar p : listaPagar) { p.imprimir(); System.out.println("---"); }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorCnpj(String cnpj) {
        try {
            boolean encontrou = false;
            for (Pagar p : listaPagar) {
                if (p.getFornecedor().getCnpj().equalsIgnoreCase(cnpj)) { p.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorBoleto(String boleto) {
        try {
            boolean encontrou = false;
            for (Pagar p : listaPagar) {
                if (p.getBoleto().equalsIgnoreCase(boleto)) { p.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorValor(double valor) {
        try {
            boolean encontrou = false;
            for (Pagar p : listaPagar) {
                if (p.getValor() == valor) { p.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    @Override
    public void excluir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero para excluir: ");
        int numero = Integer.parseInt(sc.nextLine());
        boolean removeu = listaPagar.removeIf(p -> p.getNumero() == numero);
        System.out.println(removeu ? "Excluido!" : "Nao encontrado!");
    }
}