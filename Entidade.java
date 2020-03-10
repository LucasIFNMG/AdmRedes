import java.util.Random;

class Entidade{
    private int syn;
    private int ack;
    private String dados;

    Random random = new Random();

    public int getSyn()
    {
        return this.syn;
    }

    public void setSyn(int syn)
    {
        this.syn = syn;
    }

    public int getAck()
    {
        return this.ack;
    }

    public void setAck(int ack)
    {
        this.ack = ack;
    }

    public String getDados()
    {
        return this.dados;
    }

    public void setDados(String dados)
    {
        this.dados = dados;
    }

    public Entidade(int syn, int ack, String dados)
    {
        this.syn = syn;
        this.ack = ack;
        this.dados = dados;
    }

    public int getNumeroRandom()
    {
        return random.nextInt(100); // 4294967296 - 1
    }
    
    // 1ª via
    public int handShakeCliente()
    {
        // 0 a (4294967296-1)
        this.setSyn(getNumeroRandom() );
        return this.syn;
    }

    // 2ª via
    public int handShakeServidor(int numero)
    {
        numero = this.handShakeCliente()+1; // olhar depois
        
        if(numero != (this.getSyn()+1))
        {
            System.out.println("NÃO foi possível estabelecer a conexão! (2ª via)");
            return -1;
        }
        else
        {
            this.setAck(this.getNumeroRandom() );
            return this.ack;
        }
    }

    // 3ª via
    public String handShakeClienteFinal(int numero, String dados)
    {
        numero = this.ack + 1; // olhar depois
        if(numero != (this.ack + 1))
        {
            return "NÃO foi possível estabelecer a conexão! (3ª via)";
        }
        else
        {
            return dados;
        }
    }

    public static void main(String[] args) {
        
    }    
    
}