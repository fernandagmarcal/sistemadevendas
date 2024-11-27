public class Caixa {
    private double saldo;

    public Caixa(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double valor) {
        this.saldo += valor;
    }
}
