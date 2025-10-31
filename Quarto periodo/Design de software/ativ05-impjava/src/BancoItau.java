public class BancoItau implements IBancoGeral {

    @Override
    public ContaAbstrata abrirConta(Cliente c, String numeroConta, double saldoInicial, String tipo) {
        if (tipo.equalsIgnoreCase("poupanca")) {
            return new Poupanca(numeroConta, saldoInicial, c);
        } else if (tipo.equalsIgnoreCase("contacorrente")) {
            return new ContaCorrente(numeroConta, saldoInicial, c, 1000); // exemplo de limite
        }
        return null;
    }

    @Override
    public boolean depositar(ContaAbstrata c, double valor) {
        if (c != null && valor > 0) {
            c.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public boolean sacar(ContaAbstrata c, double valor) {
        if (c != null && valor > 0 && valor <= c.obterLimite()) {
            c.sacar(valor);
            return true;
        }
        return false;
    }
}