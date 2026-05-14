package Main;

import Model.Cliente;
import Model.Fornecedor;
import Model.Funcionario;
import Service.Pagar;
import Service.Receber;
import View.MenuPrincipal;

public class Faker {

    public static void popular(MenuPrincipal menu) {

        // ===== FUNCIONARIOS =====
        Funcionario f1 = new Funcionario();
        f1.setId(1);
        f1.setNome("Carlos Silva");
        f1.setEmail("carlos@email.com");
        f1.setCpf("111.222.333-44");
        f1.setRg("12345678");
        f1.setEmissor("SSP");
        f1.setDataAdmissao("01/03/2020");
        f1.setDataDemissao("--");
        f1.setCtps("123456");
        f1.setSalario(3500.00);
        menu.getFuncionario().getListaFuncionarios().add(f1);

        Funcionario f2 = new Funcionario();
        f2.setId(2);
        f2.setNome("Ana Souza");
        f2.setEmail("ana@email.com");
        f2.setCpf("555.666.777-88");
        f2.setRg("87654321");
        f2.setEmissor("SSP");
        f2.setDataAdmissao("15/06/2021");
        f2.setDataDemissao("--");
        f2.setCtps("654321");
        f2.setSalario(4200.00);
        menu.getFuncionario().getListaFuncionarios().add(f2);

        // ===== CLIENTES =====
        Cliente c1 = new Cliente();
        c1.setId(1);
        c1.setNome("Empresa ABC Ltda");
        c1.setEmail("abc@empresa.com");
        c1.setCnpj("12.345.678/0001-99");
        c1.setInscricaoEstadual("123456789");
        c1.setContato("Joao");
        c1.setLimiteCredito(10000.00);
        menu.getCliente().getListaClientes().add(c1);

        Cliente c2 = new Cliente();
        c2.setId(2);
        c2.setNome("Comercial XYZ");
        c2.setEmail("xyz@comercial.com");
        c2.setCnpj("98.765.432/0001-11");
        c2.setInscricaoEstadual("987654321");
        c2.setContato("Maria");
        c2.setLimiteCredito(5000.00);
        menu.getCliente().getListaClientes().add(c2);

        // ===== FORNECEDORES =====
        Fornecedor fn1 = new Fornecedor();
        fn1.setId(1);
        fn1.setNome("Distribuidora Delta");
        fn1.setEmail("delta@dist.com");
        fn1.setCnpj("11.222.333/0001-44");
        fn1.setInscricaoEstadual("111222333");
        fn1.setContato("Pedro");
        fn1.setLimiteCompra(20000.00);
        fn1.setDataCadastro("10/01/2022");
        fn1.setSite("www.delta.com.br");
        menu.getFornecedor().getListaFornecedores().add(fn1);

        Fornecedor fn2 = new Fornecedor();
        fn2.setId(2);
        fn2.setNome("Industria Omega");
        fn2.setEmail("omega@ind.com");
        fn2.setCnpj("55.666.777/0001-88");
        fn2.setInscricaoEstadual("555666777");
        fn2.setContato("Lucas");
        fn2.setLimiteCompra(15000.00);
        fn2.setDataCadastro("05/03/2021");
        fn2.setSite("www.omega.com.br");
        menu.getFornecedor().getListaFornecedores().add(fn2);

        // ===== CONTAS A RECEBER =====
        Receber r1 = new Receber();
        r1.setId(1);
        r1.setNumero(101);
        r1.setEmissao("01/04/2025");
        r1.setVencimento("19/05/2025");
        r1.setPagamento("--");
        r1.setValor(500.00);
        r1.setJuros(0.00);
        r1.setMulta(0.00);
        r1.setDesconto(0.00);
        r1.calcularTotal();
        r1.setNotaFiscal("NF-001");
        r1.setCliente(c1);
        menu.getReceber().getListaReceber().add(r1);

        Receber r2 = new Receber();
        r2.setId(2);
        r2.setNumero(102);
        r2.setEmissao("10/04/2025");
        r2.setVencimento("25/05/2025");
        r2.setPagamento("--");
        r2.setValor(800.00);
        r2.setJuros(10.00);
        r2.setMulta(0.00);
        r2.setDesconto(50.00);
        r2.calcularTotal();
        r2.setNotaFiscal("NF-002");
        r2.setCliente(c2);
        menu.getReceber().getListaReceber().add(r2);

        // ===== CONTAS A PAGAR =====
        Pagar p1 = new Pagar();
        p1.setId(1);
        p1.setNumero(201);
        p1.setEmissao("05/04/2025");
        p1.setVencimento("20/05/2025");
        p1.setPagamento("--");
        p1.setValor(800.00);
        p1.setJuros(0.00);
        p1.setMulta(0.00);
        p1.setDesconto(0.00);
        p1.calcularTotal();
        p1.setBoleto("BOL-001");
        p1.setFornecedor(fn1);
        menu.getPagar().getListaPagar().add(p1);

        Pagar p2 = new Pagar();
        p2.setId(2);
        p2.setNumero(202);
        p2.setEmissao("12/04/2025");
        p2.setVencimento("28/05/2025");
        p2.setPagamento("--");
        p2.setValor(1200.00);
        p2.setJuros(20.00);
        p2.setMulta(0.00);
        p2.setDesconto(100.00);
        p2.calcularTotal();
        p2.setBoleto("BOL-002");
        p2.setFornecedor(fn2);
        menu.getPagar().getListaPagar().add(p2);
    }
}