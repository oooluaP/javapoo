package org.example;

public interface Emprestavel {
    void emprestar();
    void emprestar(Usuario usuario);
    void devolver();
    boolean isEmprestado();
}
