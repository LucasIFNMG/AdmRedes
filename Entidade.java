import java.util.Random;

// TODO: 
// * Tamanho do Cabeçalho , Tamanho das flags(32 b ou 4B)
// * Fazer uma simulação para o usuário, contendo erros:
//      Primeiramente ele digita a mensagem a ser enviada. Em caso de sucesso da técnica 3-way, exibir o dado transmitido
// * Implementar conceitos de ATRASO; Em caso de ultrapassagem do tempo limite, reenviar o pacote com o mesmo valor da flag

class Entidade
{
    private int syn;
    private int ack;
    private String dados;

    public Entidade(int syn, int ack, String dados)
    {
        this.syn = syn;
        this.ack = ack;
        this.dados = dados;
    }

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

    public int getNumeroRandom()
    {
        return random.nextInt(100); // 4294967296 - 1
    }
    
    // 1ª via
    public int handShakeCliente()
    {
        // 0 a (2^32)-1
        this.setSyn(getNumeroRandom() );
        return this.syn;
    }

    // 2ª via
    public int handShakeServidor(int numero)
    {
        // numero = this.handShakeCliente()+1; 
        
        if(numero != (this.getSyn()+1))
        {
            System.out.println("NÃO foi possível estabelecer a conexão! (2ª via)");
            return -1;
        }
        else
        {
            this.setSyn(this.getNumeroRandom() );
            this.setAck(numero);
            return this.ack;
        }
    }

    // 3ª via
    public String handShakeClienteFinal(int numero, String dados)
    {
        numero = this.getAck() + 1; 
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