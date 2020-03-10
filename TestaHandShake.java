class TestaHandShake{
    public static void main(String[] args) {
        
        Entidade cliente = new Entidade(0,0,"");
        Entidade servidor = new Entidade(0,0,"");

        // int aux

        cliente.handShakeCliente();
        System.out.println("Retorno 1ª via (SYN): " + cliente.handShakeCliente() );
        System.out.println("------------------------------------------------");
        
        servidor.handShakeServidor(cliente.getAck()+1);
        servidor.setAck(cliente.getSyn());

        
        // System.out.println("SYN CLIENTE = " + cliente.getSyn());
        // System.out.println("ACK SERVIDOR = " + servidor.getAck());

        System.out.println("Retorno 2ª via :\nACK: " + (servidor.getAck()+1) + "\nSYN: " + servidor.getSyn() ) ;
        System.out.println("------------------------------------------------");

        cliente.setAck(servidor.getSyn() );
    
        cliente.handShakeClienteFinal(90,"JOBS");
        System.out.println("Retorno 3ª via:\nACK : " + (cliente.getAck()+1) + "\nDADOS: " + cliente.handShakeClienteFinal(90,"JOBS") );

    }
}