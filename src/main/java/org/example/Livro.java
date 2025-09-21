package org.example;

abstract class Livro extends Item implements Catalogavel, Emprestavel {
    private Autor autor;


    public Livro(String titulo, Autor autor, Categoria categoria, Usuario cadastradoPor) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.emprestado = false;
        this.cadastradoPor = cadastradoPor;
        this.emprestadoPor = null;
    }

    // Construtor antigo para compatibilidade
    public Livro(String titulo, Autor autor, Categoria categoria) {
        this(titulo, autor, categoria, null);
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
    public void emprestar(Usuario usuario) {
        if (!emprestado) {
            emprestado = true;
            emprestadoPor = usuario;
            System.out.println(titulo + " emprestado para " + usuario.getNome() + ".");
        } else {
            System.out.println(titulo + " já está emprestado.");
        }
    }

    // Para interface compatível
    public void emprestar() {
        emprestar(null);
    }


    @Override
    public void devolver() {
        if (emprestado) {
            emprestado = false;
            System.out.println(titulo + " devolvido por " + (emprestadoPor != null ? emprestadoPor.getNome() : "usuário desconhecido") + ".");
            emprestadoPor = null;
        } else {
            System.out.println(titulo + " não estava emprestado.");
        }
    }


    @Override
    public boolean isEmprestado() {
        return emprestado;
    }

    public Usuario getEmprestadoPor() {
        return emprestadoPor;
    }

    public Usuario getCadastradoPor() {
        return cadastradoPor;
    }

    // Método abstrato
    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("[%s] Titulo:  %s  Autor: %s (Descricao: %s) Status: %s",
                getTipo(), titulo, autor.getNome(), categoria.getDescricao(),
                emprestado ? "[Emprestado]" : "[Disponível]");
    }
}
