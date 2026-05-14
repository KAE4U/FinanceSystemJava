package Model;

import java.util.Scanner;

public abstract class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;
    private String contato;

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getInscricaoEstadual() { return inscricaoEstadual; }
    public void setInscricaoEstadual(String inscricaoEstadual) { this.inscricaoEstadual = inscricaoEstadual; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("CNPJ: ");
        this.cnpj = sc.nextLine();
        System.out.println("Inscricao Estadual: ");
        this.inscricaoEstadual = sc.nextLine();
        System.out.println("Contato: ");
        this.contato = sc.nextLine();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("CNPJ: "               + cnpj);
        System.out.println("Inscricao Estadual: "  + inscricaoEstadual);
        System.out.println("Contato: "             + contato);
    }
}