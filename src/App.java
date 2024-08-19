public class App {
    public static void main(String[] args) throws Exception {
        Agencia loterica = new Agencia();
        Conta contaCorrente = new ContaCorrente(loterica, "2404-9",100d,1000);
        Conta contaPoupanca1 = new ContaPoupanca(loterica, "2003-9",100d) ;
        Conta contaPoupanca2 = new ContaPoupanca(loterica, "4567-9",100d) ;
        Conta contaSalario = new ContaSalario(loterica, "1234-9", 100d);

        loterica.addConta(contaPoupanca1);
        loterica.addConta(contaPoupanca2);
        loterica.addConta(contaCorrente);
        loterica.addConta(contaSalario);

        loterica.cobrarTarifas();

        loterica.saque("2404-9",1);
        loterica.saque("2003-9", 1);
        loterica.saque("4567-9", 1); 
        loterica.saque("1234-9", 1);
        
        

    }
}
