class TestaHandShake{
    public static void main(String[] args) {
        
        Entidade cliente = new Entidade(0,0,"");
        Entidade servidor = new Entidade(0,0,"");

        cliente.handShakeCliente();
        System.out.println("Retorno 1ª via: \nSYN: " + cliente.handShakeCliente() );
        System.out.println("------------------------------------------------");
        
        servidor.handShakeServidor(cliente.getAck()+1);
        servidor.setAck(cliente.getSyn());

        System.out.println("Retorno 2ª via :\nACK: " + (servidor.getAck()+1) + "\nSYN: " + servidor.getSyn() ) ;
        System.out.println("------------------------------------------------");

        cliente.setAck(servidor.getSyn() );
    
        cliente.handShakeClienteFinal(90,"TESTE");
        System.out.println("Retorno 3ª via:\nACK : " + (cliente.getAck()+1) + "\nDADOS: " + cliente.handShakeClienteFinal(90,"TESTE") );

    }
}