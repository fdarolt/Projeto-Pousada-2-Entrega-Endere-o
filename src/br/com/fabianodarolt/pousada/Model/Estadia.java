package br.com.fabianodarolt.pousada.Model;

import java.util.Date;

public class Estadia {

    //ISTANCIAR ATRIBUTOS 
    private int idEstadia;
    private UnidadeHabitacional unidadeHabEstadia;
    private Cliente cliente;
    private int quantidadeUnidadeEstadia;
    private Date dataEntradaEstadia;
    private Date dataSaidaEstadia;
    private int numeroPessoasEstadia;
    
    //GERAR CONSTRUTOR
    public Estadia() {
    }
    
    //INSTANCIAR METODOS ACESSORES
    public int getIdEstadia() {
        return idEstadia;
    }

    public void setIdEstadia(int idEstadia) {
        this.idEstadia = idEstadia;
    }

    public UnidadeHabitacional getUnidadeHabEstadia() {
        return unidadeHabEstadia;
    }

    public void setUnidadeHabEstadia(UnidadeHabitacional unidadeHabEstadia) {
        this.unidadeHabEstadia = unidadeHabEstadia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;        
    }

    public int getQuantidadeUnidadeEstadia() {
        return quantidadeUnidadeEstadia;
    }

    public void setQuantidadeUnidadeEstadia(int quantidadeUnidadeEstadia) {
        this.quantidadeUnidadeEstadia = quantidadeUnidadeEstadia;
    }
    

    public Date getDataEntradaEstadia() {
        return dataEntradaEstadia;
    }

    public void setDataEntradaEstadia(Date dataEntradaEstadia) {
        this.dataEntradaEstadia = dataEntradaEstadia;
    }

    public Date getDataSaidaEstadia() {
        return dataSaidaEstadia;
    }

    public void setDataSaidaEstadia(Date dataSaidaEstadia) {
        this.dataSaidaEstadia = dataSaidaEstadia;
    }

    public int getNumeroPessoasEstadia() {
        return numeroPessoasEstadia;
    }

    public void setNumeroPessoasEstadia(int numeroPessoasEstadia) {
        this.numeroPessoasEstadia = numeroPessoasEstadia;
    }
    
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "Estadia{" + "idEstadia=" + idEstadia + ", unidadeHabEstadia=" + unidadeHabEstadia + ", cliente=" + cliente + ", quantidadeUnidadeEstadia=" + quantidadeUnidadeEstadia + ", dataEntradaEstadia=" + dataEntradaEstadia + ", dataSaidaEstadia=" + dataSaidaEstadia + ", numeroPessoasEstadia=" + numeroPessoasEstadia + '}';
    }
   }

