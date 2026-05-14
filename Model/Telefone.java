package Model;

import java.util.Scanner;

public class Telefone {
    private int ddd;
    private long numero;

    public int getDdd() { return ddd; }
    public void setDdd(int ddd) { this.ddd = ddd; }
    public long getNumero() { return numero; }
    public void setNumero(long numero) { this.numero = numero; }

    public void entrar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("DDD: ");
        this.ddd = Integer.parseInt(sc.nextLine());
        System.out.println("Numero: ");
        this.numero = Long.parseLong(sc.nextLine());
    }

    public void imprimir() {
        System.out.println("DDD: "    + ddd);
        System.out.println("Numero: " + numero);
    }
}