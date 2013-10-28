package br.com.fabianodarolt.pousada.Model;

 public class Cliente extends PessoaFisica {
     
    //INSTANCIAR ATRIBUTOS   
    private String passaporte;    
    private String cartaoCredito;    
    private String telefoneEmpresaCliente;
    private String procedenciaCliente;
    private String destinoCliente;
    private ServicoGeral servicoGeral;    
    
     //GERAR CONSTRUTOR
    public Cliente() {
    }
    
    //INSTANCIAR METODOS ACESSORES
    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public String getTelefoneEmpresaCliente() {
        return telefoneEmpresaCliente;
    }

    public void setTelefoneEmpresaCliente(String telefoneEmpresaCliente) {
        this.telefoneEmpresaCliente = telefoneEmpresaCliente;
    }

    public String getProcedenciaCliente() {
        return procedenciaCliente;
    }

    public void setProcedenciaCliente(String procedenciaCliente) {
        this.procedenciaCliente = procedenciaCliente;
    }

    public String getDestinoCliente() {
        return destinoCliente;
    }

    public void setDestinoCliente(String destinoCliente) {
        this.destinoCliente = destinoCliente;
    }

    public ServicoGeral getServicoGeral() {
        return servicoGeral;
    }

    public void setServicoGeral(ServicoGeral servicoGeral) {
        this.servicoGeral = servicoGeral;
    }    

    //INSTANCIAR METODO TO STRING
    @Override
    public String toString() {
        return "Cliente{" + "passaporte=" + passaporte + ", cartaoCredito=" + cartaoCredito + ", telefoneEmpresaCliente=" + telefoneEmpresaCliente + ", procedenciaCliente=" + procedenciaCliente + ", destinoCliente=" + destinoCliente + ", servicoGeral=" + servicoGeral + '}';
    }    
}
