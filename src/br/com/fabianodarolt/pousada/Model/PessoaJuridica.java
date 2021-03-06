package br.com.fabianodarolt.pousada.Model;

public class PessoaJuridica extends Pessoa {
    
    //INSTANCIAR ATRIBUTOS 
    
    private String cnpj;    
    private String pessoaContatoEmpresa;
    
     //GERAR CONSTRUTOR
    public PessoaJuridica() {
    }
        
    //INSTANCIAR METODOS ACESSORES
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPessoaContatoEmpresa() {
        return pessoaContatoEmpresa;
    }

    public void setPessoaContatoEmpresa(String pessoaContatoEmpresa) {
        this.pessoaContatoEmpresa = pessoaContatoEmpresa;
    }
    
    
    
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "PessoaJuridica{" + "cnpj=" + cnpj + ", pessoaContatoEmpresa=" + pessoaContatoEmpresa + '}';
    }
    
}
