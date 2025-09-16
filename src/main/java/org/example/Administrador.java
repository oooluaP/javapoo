package org.example;


public non-sealed  class Administrador extends Usuario  {


    public Administrador(String nome) {
        super (nome);
    }

    @Override
    public String gerarRelatorio() {
        return """
       
                =======================
                Relatorio do ADM
                ---------------------------
                
                Nome:""" + this.getNome() + "\n";
    }


}
