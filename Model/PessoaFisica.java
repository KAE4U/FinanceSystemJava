package Model;

import java.util.Scanner;

public abstract class PessoaFisica extends Pessoa {
    private String cpf;
    private String rg;
    private String emissor;

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getRg() { return rg; }
    public void setRg(String rg) { this.rg = rg; }
    public String getEmissor() { return emissor; }
    public void setEmissor(String emissor) { this.emissor = emissor; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("CPF: ");
        this.cpf = sc.nextLine();
        System.out.println("RG: ");
        this.rg = sc.nextLine();
        System.out.println("Orgao Emissor: ");
        this.emissor = sc.nextLine();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("CPF: "          + cpf);
        System.out.println("RG: "           + rg);
        System.out.println("Org. Emissor: " + emissor);
    }
}