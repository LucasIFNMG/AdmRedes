import java.util.Random;

class Entidade{
    double syn;
    double ack;
    String dados;

    Random random = new Random();

    public Entidade(double syn, double ack, String dados)
    {
        this.syn = syn;
        this.ack = ack;
        this.dados = dados;
    }

    public double getNumeroRandom()
    {
        return random.nextInt(100);
    }
    
    // 1ª via
    public double handShakeCliente()
    {
        
        //0 a (4294967296-1)
        this.syn = this.getNumeroRandom();

        return this.syn;

    }

    // 2ª via
    public double handShakeServidor(double numero)
    {
        numero = this.handShakeCliente()+1; // olhar depois
        if(numero != (this.syn+1))
        {
            System.out.println("NÃO foi possível estabelecer a conexão! (2ª via)");
            return -1;
        }
        else
        {
            this.ack = this.getNumeroRandom();
            return this.ack;
        }
    }

    // 3ª via
    public String handShakeClienteFinal(double numero, String dados)
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

    
    
}