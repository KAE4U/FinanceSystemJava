package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends PessoaJuridica {
    private double limiteCredito;
    private Endereco enderecoCobranca;
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Cliente() {
        this.enderecoCobranca = new Endereco();
    }

    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }
    public Endereco getEnderecoCobranca() { return enderecoCobranca; }
    public void setEnderecoCobranca(Endereco e) { this.enderecoCobranca = e; }
    public ArrayList<Cliente> getListaClientes() { return listaClientes; }

    @Override
    public void entrar() {
        super.entrar();
        Scanner sc = new Scanner(System.in);
        System.out.println("Limite de Credito: ");
        this.limiteCredito = Double.parseDouble(sc.nextLine());
        System.out.println("-- Endereco de Cobranca --");
        this.enderecoCobranca.entrar();
    }

    @Override
    public void imprimir() {
        super.imprimir();
        System.out.println("Limite de Credito: " + limiteCredito);
        System.out.println("-- Endereco de Cobranca --");
        this.enderecoCobranca.imprimir();
    }

    public void imprimir(int id) {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) { c.imprimir(); return; }
        }
        System.out.println("Cliente nao encontrado!");
    }

    @Override
    public void alterar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID para alterar: ");
        int id = Integer.parseInt(sc.nextLine());
        for (Cliente c : listaClientes) {
            if (c.getId() == id) { c.entrar(); System.out.println("Alterado!"); return; }
        }
        System.out.println("Nao encontrado!");
    }

    @Override
    public void consultar() {
        try {
            if (listaClientes.isEmpty()) throw new Exception("Nenhum cliente cadastrado!");
            for (Cliente c : listaClientes) { c.imprimir(); System.out.println("---"); }
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorId(int id) {
        try {
            boolean encontrou = false;
            for (Cliente c : listaClientes) {
                if (c.getId() == id) { c.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Cliente nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorNome(String nome) {
        try {
            boolean encontrou = false;
            for (Cliente c : listaClientes) {
                if (c.getNome().equalsIgnoreCase(nome)) { c.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Cliente nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    public void consultarPorCnpj(String cnpj) {
        try {
            boolean encontrou = false;
            for (Cliente c : listaClientes) {
                if (c.getCnpj().equalsIgnoreCase(cnpj)) { c.imprimir(); encontrou = true; }
            }
            if (!encontrou) throw new Exception("Cliente nao encontrado!");
        } catch (Exception e) { System.out.println("Erro: " + e.getMessage()); }
    }

    @Override
    public void excluir() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ID para excluir: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean removeu = listaClientes.removeIf(c -> c.getId() == id);
        System.out.println(removeu ? "Excluido!" : "Nao encontrado!");
    }
}