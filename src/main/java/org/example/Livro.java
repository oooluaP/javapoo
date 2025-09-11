package org.example;

abstract class Livro extends Item implements Catalogavel, Emprestavel {
    private Autor autor;

    public Livro(String titulo, Autor autor, Categoria categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.emprestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    // Métodos da interface Emprestavel
    @Override
    public void emprestar() {
        if (!emprestado) {
            emprestado = true;
            System.out.println(titulo + " emprestado.");
        } else {
            System.out.println(titulo + " já está emprestado.");
        }
    }

    @Override
    public void devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println(titulo + " devolvido.");
        } else {
            System.out.println(titulo + " não estava emprestado.");
        }
    }

    @Override
    public boolean isEmprestado() {
        return emprestado;
    }

    // Método abstrato
    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%s) %s",
                getTipo(), titulo, autor.getNome(), categoria.getDescricao(),
                emprestado ? "[Emprestado]" : "[Disponível]");
    }
}
