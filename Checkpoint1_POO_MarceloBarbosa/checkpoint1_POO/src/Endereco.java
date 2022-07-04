public class Endereco {
    private String logradouro;
    private String referencia;
    private String bairro;
    private int cep;

    public void imprimirEndereco(){
        System.out.println("Logradouro: " + this.logradouro);
        System.out.println("Referência: " + this.referencia);
        System.out.println("Bairro: " + this.bairro);
    }

    public Endereco(String logradouro, String referencia, String bairro, int cep) {
        this.logradouro = logradouro;
        this.referencia = referencia;
        this.bairro = bairro;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }
}
