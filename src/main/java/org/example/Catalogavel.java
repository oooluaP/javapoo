package org.example;


public interface Catalogavel {
    

    String getTitulo();
    

    Categoria getCategoria();
    

    default void exibirInformacoes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Categoria: " + getCategoria().descricao());
    }
    

    default boolean pertenceCategoria(Categoria categoria) {
        return getCategoria().equals(categoria);
    }
}
