package br.com.fabianodarolt.pousada.Model;

public class ProdutoCompraGeral {

    //INSTANCIAR ATRIBUTOS 
    private int idCompra;
    private String nomeProdutoCompra;
    private String funcionarioCompra;
    private String valorCompra;
    private int quantidadeCompra;
    private String nomeEmpresaCompra;
    
    
    //GERAR CONSTRUTOR
    public ProdutoCompraGeral() {
    }
    
    //INSTANCIAR METODOS ACESSORES
    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getNomeProdutoCompra() {
        return nomeProdutoCompra;
    }

    public void setNomeProdutoCompra(String nomeProdutoCompra) {
        this.nomeProdutoCompra = nomeProdutoCompra;
    }

    public String getFuncionarioCompra() {
        return funcionarioCompra;
    }

    public void setFuncionarioCompra(String funcionarioCompra) {
        this.funcionarioCompra = funcionarioCompra;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getQuantidadeCompra() {
        return quantidadeCompra;
    }

    public void setQuantidadeCompra(int quantidadeCompra) {
        this.quantidadeCompra = quantidadeCompra;
    }

    public String getNomeEmpresaCompra() {
        return nomeEmpresaCompra;
    }

    public void setNomeEmpresaCompra(String nomeEmpresaCompra) {
        this.nomeEmpresaCompra = nomeEmpresaCompra;
    }
   
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "ProdutoCompraGeral{" + "idCompra=" + idCompra + ", nomeProdutoCompra=" + nomeProdutoCompra + ", funcionarioCompra=" + funcionarioCompra + ", valorCompra=" + valorCompra + ", quantidadeCompra=" + quantidadeCompra + ", nomeEmpresaCompra=" + nomeEmpresaCompra + '}';
    }
   
}