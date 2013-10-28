
package br.com.fabianodarolt.pousada.app;

import br.com.fabianodarolt.pousada.view1.JanelaLogin;

public class Principal {
    
    public static void main(String[] args) {
        
         //Chamar janela Login
        JanelaLogin jl = new JanelaLogin();
        //aparecer janela centralizada
        jl.setLocationRelativeTo(null);
        //tornar visivel a janela
        jl.setVisible(true);  
    }    
}
