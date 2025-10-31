public class Teste {
    public static void main(String[] args) {
        IBancoGeral banco = new BancoItau();

        Cliente cliente1 = new Cliente("João", "111.222.333-44");
        ContaAbstrata contaPoupanca = banco.abrirConta(cliente1, "123", 500, "poupanca");

        Cliente cliente2 = new Cliente("Maria", "555.666.777-88");
        ContaAbstrata contaCorrente = banco.abrirConta(cliente2, "456", 1000, "contacorrente");

        banco.depositar(contaPoupanca, 200);
        banco.sacar(contaPoupanca, 100);

        banco.sacar(contaCorrente, 1500); // usa cheque especial

        System.out.println("Saldo Poupança: " + contaPoupanca.getSaldo());
        System.out.println("Saldo Conta Corrente: " + contaCorrente.getSaldo());
    }
}