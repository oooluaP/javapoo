package org.example;

public class AdministradorTemporario extends Administrador {


    public AdministradorTemporario(String nome) {
        super(nome);
    }

    @Override
    public String gerarRelatorio() {
        return """
       
                =======================
                Relatorio do ADM Temp
                ---------------------------
                
                Nome:""" + this.getNome() + "\n";
    }
}
