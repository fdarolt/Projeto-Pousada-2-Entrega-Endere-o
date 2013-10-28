package br.com.fabianodarolt.pousada.Model;

import java.util.Date;

public class Reserva {
    
    //INSTANCIAR ATRIBUTOS
    
    private int idEstadiaReserva;
    private UnidadeHabitacional unidadeHabReserva;
    private Cliente cliente;
    private int quantidadeUnidadeReserva;
    private Date dataEntradaReserva;
    private Date dataSaidaReserva;
    private int numeroPessoasReserva;   
    
    //GERAR CONSTRUTOR
    public Reserva() {
    }

    //INSTANCIAR METODOS ACESSORES
    public int getIdEstadiaReserva() {
        return idEstadiaReserva;
    }

    public void setIdEstadiaReserva(int idEstadiaReserva) {
        this.idEstadiaReserva = idEstadiaReserva;
    }

    public UnidadeHabitacional getUnidadeHabReserva() {
        return unidadeHabReserva;
    }

    public void setUnidadeHabReserva(UnidadeHabitacional unidadeHabReserva) {
        this.unidadeHabReserva = unidadeHabReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getQuantidadeUnidadeReserva() {
        return quantidadeUnidadeReserva;
    }

    public void setQuantidadeUnidadeReserva(int quantidadeUnidadeReserva) {
        this.quantidadeUnidadeReserva = quantidadeUnidadeReserva;
    }

    public Date getDataEntradaReserva() {
        return dataEntradaReserva;
    }

    public void setDataEntradaReserva(Date dataEntradaReserva) {
        this.dataEntradaReserva = dataEntradaReserva;
    }

    public Date getDataSaidaReserva() {
        return dataSaidaReserva;
    }

    public void setDataSaidaReserva(Date dataSaidaReserva) {
        this.dataSaidaReserva = dataSaidaReserva;
    }

    public int getNumeroPessoasReserva() {
        return numeroPessoasReserva;
    }

    public void setNumeroPessoasReserva(int numeroPessoasReserva) {
        this.numeroPessoasReserva = numeroPessoasReserva;
    }
   
   
    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "Reserva{" + "idEstadiaReserva=" + idEstadiaReserva + ", unidadeHabReserva=" + unidadeHabReserva + ", cliente=" + cliente + ", quantidadeUnidadeReserva=" + quantidadeUnidadeReserva + ", dataEntradaReserva=" + dataEntradaReserva + ", dataSaidaReserva=" + dataSaidaReserva + ", numeroPessoasReserva=" + numeroPessoasReserva + '}';
    }   
}
