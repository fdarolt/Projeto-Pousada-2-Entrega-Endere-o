package br.com.fabianodarolt.pousada.Model;

public class PessoaFisica extends Pessoa{    
    
    //INSTANCIAR ATRIBUTOS 
    
    private String cpf;
    private String rg;
    
    //GERAR CONSTRUTOR
    public PessoaFisica() {
    } 

    //INSTANCIAR METODOS ACESSORES
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "PessoaFisica{" + "cpf=" + cpf + ", rg=" + rg + '}';
    }    
}
