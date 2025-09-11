package org.example;

public class Revista extends Item implements Catalogavel, Emprestavel {
    private int edicao;

    public Revista(String titulo, Categoria categoria, int edicao) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.edicao = edicao;
        this.emprestado = false;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public void emprestar() {
        if (!emprestado) {
            emprestado = true;
            System.out.println("Revista " + titulo + " emprestada.");
        } else {
            System.out.println("Revista já está emprestada.");
        }
    }

    @Override
    public void devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println("Revista " + titulo + " devolvida.");
        } else {
            System.out.println("Revista não estava emprestada.");
        }
    }

    @Override
    public boolean isEmprestado() {
        return emprestado;
    }

    @Override
    public String toString() {
        return String.format("[Revista] %s (Edição %d, %s) %s",
                titulo, edicao, categoria.getDescricao(),
                emprestado ? "[Emprestada]" : "[Disponível]");
    }
}

