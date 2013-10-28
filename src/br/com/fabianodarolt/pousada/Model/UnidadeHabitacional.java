package br.com.fabianodarolt.pousada.Model;


public class UnidadeHabitacional {
    
    //INSTANCIAR ATRIBUTOS 
    
    private int idUnidadeHabitacional;
    private String nomeUnidade;    
    private String categoriaUnidade;
    private String descricaoUnidade;
    private double valorUnidadeUnidade;
    private double margemLucroUnidade;
    private double valorFinalUnidade;
    
    //GERAR CONSTRUTOR
    public UnidadeHabitacional() {
    }
     
    //INSTANCIAR METODOS ACESSORES
    public int getId() {
        return idUnidadeHabitacional;
    }

    public void setId(int id) {
        this.idUnidadeHabitacional = idUnidadeHabitacional;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String getCategoriaUnidade() {
        return categoriaUnidade;
    }

    public void setCategoriaUnidade(String categoriaUnidade) {
        this.categoriaUnidade = categoriaUnidade;
    }

    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }
    
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "UnidadeHabitacional{" + "idUnidadeHabitacional=" + idUnidadeHabitacional + ", nomeUnidade=" + nomeUnidade + ", categoriaUnidade=" + categoriaUnidade + ", descricaoUnidade=" + descricaoUnidade + '}';
    }
}
