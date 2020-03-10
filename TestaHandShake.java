import java.util.Random;

class TestaHandShake{
    public static void main(String[] args) {
        
        Entidade cliente = new Entidade(0,0,"");
        Entidade servidor = new Entidade(0,0,"");

        cliente.handShakeCliente();
        System.out.println("Retorno 1ª via (SYN): " + cliente.handShakeCliente() );
        servidor.handShakeServidor(50);
        System.out.println("Retorno 2ª via :\nACK: " + cliente.handShakeServidor(50) + "\nSYN: " + cliente.syn+1 );
        cliente.handShakeClienteFinal(90,"JOBS");
        System.out.println("Retorno 3ª via (DADOS): " + cliente.handShakeClienteFinal(90,"JOBS") );
    }
}