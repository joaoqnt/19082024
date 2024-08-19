import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private List<Conta> contas = new ArrayList<>(); 

    public Agencia() {
    }

    public void addConta(Conta conta) throws ContaException{
      this.contas.add(conta);
    }

    public void saque(String numeroConta,double valor) throws ContaException {
       Conta conta = getConta(numeroConta);
       conta.saque(valor);    
       System.out.println("-> Saque realizado com sucesso -> Valor atual: "+conta.getSaldo());
    }

    public void deposito(String numeroConta,double valor) throws ContaException {
        Conta conta = getConta(numeroConta);
        conta.deposito(valor);
    }
    
    private Conta getConta(String numeroConta) throws ContaException {
       for (Conta conta: contas) {
          if (conta.getNumeroConta().equals(numeroConta)) {
             return conta;
          }
       }
       throw new ContaException("Numero da conta "+numeroConta+" não existe");
    }

    public void cobrarTarifas() throws ContaException {
      for (Conta conta : contas) {
          if (conta instanceof Tarifavel) {
              ((Tarifavel) conta).tarifar();
          }
      }
  }
}

     