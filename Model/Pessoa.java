package Model;

import Interface.InterfaceCadastro;
import java.util.Scanner;

public abstract class Pessoa implements InterfaceCadastro {
    private int id;
    private String nome;
    private Endereco endereco;
    private Telefone telefone;
    private String email;

    public Pessoa() {
        this.endereco = new Endereco();
        this.telefone = new Telefone();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public Telefone getTelefone() { return telefone; }
    public void setTelefone(Telefone telefone) { this.telefone = telefone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public void entrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.println("Nome: ");
        this.nome = sc.nextLine();
        System.out.println("Email: ");
        this.email = sc.nextLine();
        System.out.println("-- Telefone --");
        this.telefone.entrar();
        System.out.println("-- Endereco --");
        this.endereco.entrar();
    }

    @Override
    public void imprimir() {
        System.out.println("ID: "    + id);
        System.out.println("Nome: "  + nome);
        System.out.println("Email: " + email);
        System.out.println("-- Telefone --");
        this.telefone.imprimir();
        System.out.println("-- Endereco --");
        this.endereco.imprimir();
    }
}