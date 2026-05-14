package Model;

import java.util.Scanner;

public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private int cep;

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getCep() { return cep; }
    public void setCep(int cep) { this.cep = cep; }

    public void entrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Logradouro: ");
        this.logradouro = sc.nextLine();
        System.out.println("Numero: ");
        this.numero = sc.nextLine();
        System.out.println("Complemento: ");
        this.complemento = sc.nextLine();
        System.out.println("Bairro: ");
        this.bairro = sc.nextLine();
        System.out.println("Cidade: ");
        this.cidade = sc.nextLine();
        System.out.println("Estado: ");
        this.estado = sc.nextLine();
        System.out.println("CEP: ");
        this.cep = Integer.parseInt(sc.nextLine());
    }

    public void imprimir() {
        System.out.println("Logradouro: " + logradouro);
        System.out.println("Numero: "     + numero);
        System.out.println("Complemento: "+ complemento);
        System.out.println("Bairro: "     + bairro);
        System.out.println("Cidade: "     + cidade);
        System.out.println("Estado: "     + estado);
        System.out.println("CEP: "        + cep);
    }
}