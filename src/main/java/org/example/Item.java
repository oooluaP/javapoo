package org.example;

abstract class Item {
    protected String titulo;
    protected Categoria categoria;
    protected boolean emprestado;
    protected Usuario cadastradoPor;
    protected Usuario emprestadoPor;

    public Usuario getCadastradoPor() {
        return cadastradoPor;
    }

    public void setCadastradoPor(Usuario usuario) {
        this.cadastradoPor = usuario;
    }

    public Usuario getEmprestadoPor() {
        return emprestadoPor;
    }

    public void setEmprestadoPor(Usuario usuario) {
        this.emprestadoPor = usuario;
    }
}
