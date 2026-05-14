package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends PessoaFisica {
    private String dataAdmissao;
    private String dataDemissao;
    private String ctps;
    private double salario;
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    public String getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(String d) { this.dataAdmissao = d; }
    public String getDataDemissao() { return dataDemissao; }
    public void setDataDemissao(String d) { this.dataDemissao = d; }
    public String getCtps() { return ctps; }
    public void setCtps(String c) { this.ctps = c; }
    public double getSalario() { return salario; }
    public void setSalario(double s) { this.salario = s; }
    public ArrayList<Funcionario> getListaFuncionarios() { return listaFuncionarios; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("Data de Admissao: ");
        this.dataAdmissao = sc.nextLine();
        System.out.println("Data de Demissao: ");
        this.dataDemissao = sc.nextLine();
        System.out.println("CTPS: ");
        this.ctps = sc.nextLine();
        System.out.println("Salario: ");
        this.salario = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Data de Admissao: " + dataAdmissao);
        System.out.println("Data de Demissao: " + dataDemissao);
        System.out.println("CTPS: "             + ctps);
        System.out.println("Salario: "          + salario);
    }

    @Override
    public void alterar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID para alterar: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Funcionario f : listaFuncionarios) {
            if (f.getId() == id) { f.entrar(); System.out.println("Alterado!"); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void consultar() {
        try {
            if (listaFuncionarios.isEmpty()) throw new Exception("Nenhum funcionario cadastrado!");
            for (Funcionario f : listaFuncionarios) { f.imprimir(); System.out.println("---"); }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorId(int id) {
        try {
            boolean encontrou = false;
            for (Funcionario f : listaFuncionarios) {
                if (f.getId() == id) { f.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Funcionario nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorNome(String nome) {
        try {
            boolean encontrou = false;
            for (Funcionario f : listaFuncionarios) {
                if (f.getNome().equalsIgnoreCase(nome)) { f.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Funcionario nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    @Override
    public void excluir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID para excluir: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removeu = listaFuncionarios.removeIf(f -> f.getId() == id);
        System.out.println(removeu ? "Excluido!" : "Nao encontrado!");
    }
}