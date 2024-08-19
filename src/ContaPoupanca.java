public class ContaPoupanca extends Conta implements Tarifavel {

    public ContaPoupanca(Agencia agencia, String numeroConta, double saldo) {
        super(agencia, numeroConta, saldo);
    } 

    @Override
    public void saque(double valor) throws ContaException {
        if (valor > 0) {
           if (this.saldo >= valor) {
              this.saldo -= valor;
           } else {
              throw new ContaException("Conta sem saldo suficiente: "+this.saldo);
           }
        } else {
              throw new ContaException("Valor inválido para saque "+valor);
        }
     }
     

    public void atualizarRendimento(Double taxaRendimento) {
        this.saldo += (this.saldo * taxaRendimento);
    }

    @Override
    public void tarifar() throws ContaException {      
        if (getSaldo() >= 5) {
            setSaldo(getSaldo() - 5);
        }
        else {
            throw new ContaException("Valor insuficiente para tarifa ");
        }
    }

}
