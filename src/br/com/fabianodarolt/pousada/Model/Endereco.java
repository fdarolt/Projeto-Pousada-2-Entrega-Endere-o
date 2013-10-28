package br.com.fabianodarolt.pousada.Model;

public class Endereco {

    //INSTANCIAR ATRIBUTOS
    private int idEndereco;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    //GERAR CONSTRUTOR
    public Endereco() {
    }

    //INSTANCIAR METODOS ACESSORES
    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "Endereco{" + "idEndereco=" + idEndereco + ", rua=" + rua + 
                ", numero=" + numero + ", complemento=" + complemento + 
                ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + 
                ", pais=" + pais + ", cep=" + cep + '}';
    }
    
  
}
