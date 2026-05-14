package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Fornecedor extends PessoaJuridica {
    private double limiteCompra;
    private String dataCadastro;
    private String site;
    private ArrayList<Fornecedor> listaFornecedores = new ArrayList<>();

    public double getLimiteCompra() { return limiteCompra; }
    public void setLimiteCompra(double v) { this.limiteCompra = v; }
    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String d) { this.dataCadastro = d; }
    public String getSite() { return site; }
    public void setSite(String s) { this.site = s; }
    public ArrayList<Fornecedor> getListaFornecedores() { return listaFornecedores; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("Limite de Compra: ");
        this.limiteCompra = Double.parseDouble(sc.nextLine());
        System.out.println("Data de Cadastro: ");
        this.dataCadastro = sc.nextLine();
        System.out.println("Site: ");
        this.site = sc.nextLine();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Limite de Compra: " + limiteCompra);
        System.out.println("Data de Cadastro: " + dataCadastro);
        System.out.println("Site: "             + site);
    }

    @Override
    public void alterar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID para alterar: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Fornecedor f : listaFornecedores) {
            if (f.getId() == id) { f.entrar(); System.out.println("Alterado!"); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void consultar() {
        try {
            if (listaFornecedores.isEmpty()) throw new Exception("Nenhum fornecedor cadastrado!");
            for (Fornecedor f : listaFornecedores) { f.imprimir(); System.out.println("---"); }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorId(int id) {
        try {
            boolean encontrou = false;
            for (Fornecedor f : listaFornecedores) {
                if (f.getId() == id) { f.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Fornecedor nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorCnpj(String cnpj) {
        try {
            boolean encontrou = false;
            for (Fornecedor f : listaFornecedores) {
                if (f.getCnpj().equalsIgnoreCase(cnpj)) { f.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Fornecedor nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    @Override
    public void excluir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID para excluir: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removeu = listaFornecedores.removeIf(f -> f.getId() == id);
        System.out.println(removeu ? "Excluido!" : "Nao encontrado!");
    }
}