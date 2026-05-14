package Service;

import Model.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

public class Receber extends Financeiro {
    private Cliente cliente;
    private String notaFiscal;
    private ArrayList<Receber> listaReceber = new ArrayList<>();

    public Receber() { this.cliente = new Cliente(); }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public String getNotaFiscal() { return notaFiscal; }
    public void setNotaFiscal(String notaFiscal) { this.notaFiscal = notaFiscal; }
    public ArrayList<Receber> getListaReceber() { return listaReceber; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("-- Dados do Cliente --");
        this.cliente.entrar();
        System.out.println("Nota Fiscal: ");
        this.notaFiscal = sc.nextLine();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("-- Cliente --");
        this.cliente.imprimir();
        System.out.println("Nota Fiscal: " + notaFiscal);
    }

    public void imprimir(int numero) {
        for (Receber r : listaReceber) {
            if (r.getNumero() == numero) { r.imprimir(); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void alterar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero para alterar: ");
        int numero = Integer.parseInt(sc.nextLine());
        for (Receber r : listaReceber) {
            if (r.getNumero() == numero) { r.entrar(); System.out.println("Alterado!"); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void consultar() {
        try {
            if (listaReceber.isEmpty()) throw new Exception("Nenhuma conta a receber!");
            for (Receber r : listaReceber) { r.imprimir(); System.out.println("---"); }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorNomeCliente(String nome) {
        try {
            boolean encontrou = false;
            for (Receber r : listaReceber) {
                if (r.getCliente().getNome().equalsIgnoreCase(nome)) { r.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorNotaFiscal(String nota) {
        try {
            boolean encontrou = false;
            for (Receber r : listaReceber) {
                if (r.getNotaFiscal().equalsIgnoreCase(nota)) { r.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorValor(double valor) {
        try {
            boolean encontrou = false;
            for (Receber r : listaReceber) {
                if (r.getValor() == valor) { r.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    @Override
    public void excluir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o numero para excluir: ");
        int numero = Integer.parseInt(sc.nextLine());
        boolean removeu = listaReceber.removeIf(r -> r.getNumero() == numero);
        System.out.println(removeu ? "Excluido!" : "Nao encontrado!");
    }
}