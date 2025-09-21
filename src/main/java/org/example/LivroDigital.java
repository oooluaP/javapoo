package org.example;

public class LivroDigital extends Livro {
    private double tamanhoMB;

    public LivroDigital(String titulo, Autor autor, Categoria categoria, double tamanhoMB, Usuario cadastradoPor) {
        super(titulo, autor, categoria, cadastradoPor);
        this.tamanhoMB = tamanhoMB;
    }

    // Construtor antigo para compatibilidade
    public LivroDigital(String titulo, Autor autor, Categoria categoria, double tamanhoMB) {
        this(titulo, autor, categoria, tamanhoMB, null);
    }

    public double getTamanhoMB() {
        return tamanhoMB;
    }

    @Override
    public String getTipo() {
        return "Digital";
    }
}