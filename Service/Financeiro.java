package Service;

import Interface.InterfaceCadastro;
import java.util.Scanner;

public abstract class Financeiro implements InterfaceCadastro {
    private int id;
    private int numero;
    private String emissao;
    private String vencimento;
    private String pagamento;
    private double valor;
    private double juros;
    private double multa;
    private double desconto;
    private double total;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getEmissao() { return emissao; }
    public void setEmissao(String emissao) { this.emissao = emissao; }
    public String getVencimento() { return vencimento; }
    public void setVencimento(String vencimento) { this.vencimento = vencimento; }
    public String getPagamento() { return pagamento; }
    public void setPagamento(String pagamento) { this.pagamento = pagamento; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public double getJuros() { return juros; }
    public void setJuros(double juros) { this.juros = juros; }
    public double getMulta() { return multa; }
    public void setMulta(double multa) { this.multa = multa; }
    public double getDesconto() { return desconto; }
    public void setDesconto(double desconto) { this.desconto = desconto; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public void calcularTotal() {
        this.total = this.valor + this.juros - this.desconto;
    }

    @Override
    public void entrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        this.id = Integer.parseInt(sc.nextLine());
        System.out.println("Numero: ");
        this.numero = Integer.parseInt(sc.nextLine());
        System.out.println("Emissao: ");
        this.emissao = sc.nextLine();
        System.out.println("Vencimento: ");
        this.vencimento = sc.nextLine();
        System.out.println("Pagamento: ");
        this.pagamento = sc.nextLine();
        System.out.println("Valor: ");
        this.valor = Double.parseDouble(sc.nextLine());
        System.out.println("Juros: ");
        this.juros = Double.parseDouble(sc.nextLine());
        System.out.println("Multa (0 se nao houver): ");
        this.multa = Double.parseDouble(sc.nextLine());
        System.out.println("Desconto (0 se nao houver): ");
        this.desconto = Double.parseDouble(sc.nextLine());
        calcularTotal();
    }

    @Override
    public void imprimir() {
        System.out.println("ID: "         + id);
        System.out.println("Numero: "     + numero);
        System.out.println("Emissao: "    + emissao);
        System.out.println("Vencimento: " + vencimento);
        System.out.println("Pagamento: "  + pagamento);
        System.out.println("Valor: "      + valor);
        System.out.println("Juros: "      + juros);
        System.out.println("Multa: "      + multa);
        System.out.println("Desconto: "   + desconto);
        System.out.println("Total: "      + total);
    }

    // Sobrecarga
    public void entrar(int numero) {
        this.numero = numero;
        entrar();
    }

    public void imprimir(boolean soTotal) {
        if (soTotal) System.out.println("Total: " + total);
        else imprimir();
    }
}