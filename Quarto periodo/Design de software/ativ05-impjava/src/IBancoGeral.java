public interface IBancoGeral {
    ContaAbstrata abrirConta(Cliente c, String numeroConta, double saldoInicial, String tipo);
    boolean depositar(ContaAbstrata c, double valor);
    boolean sacar(ContaAbstrata c, double valor);
}