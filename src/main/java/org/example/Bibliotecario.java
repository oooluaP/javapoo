package org.example;

    public final class Bibliotecario extends Usuario {
        public Bibliotecario(String nome) {
            super(nome);
        }

        @Override
        public String gerarRelatorio() {
            return """
       
                =======================
                Relatorio do bibliotecario
                ---------------------------
                
                Nome: """ + this.getNome() + "\n";
        }
    }

