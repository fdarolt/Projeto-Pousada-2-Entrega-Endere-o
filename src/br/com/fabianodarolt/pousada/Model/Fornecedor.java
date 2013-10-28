package br.com.fabianodarolt.pousada.Model;

public class Fornecedor extends PessoaJuridica {
    
    //INSTANCIAR ATRIBUTOS
    private String descricao;    
    
    //GERAR CONTRUTOR
    public Fornecedor() {
    }

    //INSTANCIAR METODOS ACESSORES
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    } 
     
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "Fornecedor{" + "descricao=" + descricao + '}';
    }        
}
