package entity;

public class ContaCorrente {
    private double saldo;
    private Usuario titular;
    private String numeroConta;

    public ContaCorrente(double saldo, Usuario titular, String numeroConta) {
        this.saldo = saldo;
        this.titular = titular;
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Usuario getTitular() {
        return titular;
    }

    public void setTitular(Usuario titular) {
        this.titular = titular;
    }

    public void tranferir(double valorTransferencia) {
        this.saldo -= valorTransferencia;
    }

    public void depositar(double valorDeposito) {
        this.saldo += valorDeposito;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
}
