package org.example;

public class LivroFisico extends Livro {
    private int numeroPaginas;

    public LivroFisico(String titulo, Autor autor, Categoria categoria, int numeroPaginas, Usuario cadastradoPor) {
        super(titulo, autor, categoria, cadastradoPor);
        this.numeroPaginas = numeroPaginas;
    }

    // Construtor antigo para compatibilidade
    public LivroFisico(String titulo, Autor autor, Categoria categoria, int numeroPaginas) {
        this(titulo, autor, categoria, numeroPaginas, null);
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public String getTipo() {
        return "Físico";
    }
}
