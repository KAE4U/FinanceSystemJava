package Main;

import View.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        Faker.popular(menu); // ← adiciona essa linha
        menu.menu();
    }
}