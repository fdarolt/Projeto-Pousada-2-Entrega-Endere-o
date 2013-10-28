package br.com.fabianodarolt.pousada.Model;


public class ProdutoVendaCliente {
    
    
    //INSTANCIAR ATRIBUTOS 
    
    private int idVenda;
    private String nomeProdutoVCliente;
    private String compradorProdutoVCliente;
    private String valorInicialProdutoVCliente;
    private int quantidadeProduto;
    private String margemLucroProdutoVCliente;
    private String valorFinalProdutoVCliente;   
    
    //GERAR CONSTRUTOR
    public ProdutoVendaCliente() {
    }
    
    //INSTANCIAR METODOS ACESSORES
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getNomeProdutoVCliente() {
        return nomeProdutoVCliente;
    }

    public void setNomeProdutoVCliente(String nomeProdutoVCliente) {
        this.nomeProdutoVCliente = nomeProdutoVCliente;
    }

    public String getCompradorProdutoVCliente() {
        return compradorProdutoVCliente;
    }

    public void setCompradorProdutoVCliente(String compradorProdutoVCliente) {
        this.compradorProdutoVCliente = compradorProdutoVCliente;
    }

    public String getValorInicialProdutoVCliente() {
        return valorInicialProdutoVCliente;
    }

    public void setValorInicialProdutoVCliente(String valorInicialProdutoVCliente) {
        this.valorInicialProdutoVCliente = valorInicialProdutoVCliente;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getMargemLucroProdutoVCliente() {
        return margemLucroProdutoVCliente;
    }

    public void setMargemLucroProdutoVCliente(String margemLucroProdutoVCliente) {
        this.margemLucroProdutoVCliente = margemLucroProdutoVCliente;
    }

    public String getValorFinalProdutoVCliente() {
        return valorFinalProdutoVCliente;
    }

    public void setValorFinalProdutoVCliente(String valorFinalProdutoVCliente) {
        this.valorFinalProdutoVCliente = valorFinalProdutoVCliente;
    }
   
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "ProdutoVendaCliente{" + "idVenda=" + idVenda + ", nomeProdutoVCliente=" + nomeProdutoVCliente + ", compradorProdutoVCliente=" + compradorProdutoVCliente + ", valorInicialProdutoVCliente=" + valorInicialProdutoVCliente + ", quantidadeProduto=" + quantidadeProduto + ", margemLucroProdutoVCliente=" + margemLucroProdutoVCliente + ", valorFinalProdutoVCliente=" + valorFinalProdutoVCliente + '}';
    }
   
}
