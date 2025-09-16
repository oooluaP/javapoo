package org.example;

public final class UsuarioComum extends Usuario {

    public UsuarioComum (String nome) {
        super (nome);
    }

    @Override
    public String gerarRelatorio (){
        return """
       
                =======================
                Relatorio do Usuario Comum
                ---------------------------
                
                Nome: """ + this.getNome() + "\n";

    }
}