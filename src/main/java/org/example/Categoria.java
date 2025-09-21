package org.example;

/**
 * Record que representa uma categoria de livro.
 * Demonstra o uso de records do Java 14+ com validação e formatação.
 */
public record Categoria(String descricao) {
    
    // Construtor compacto com validação automática
    public Categoria {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição da categoria não pode ser nula ou vazia");
        }

        descricao = descricao.trim();
    }
    

    public String getDescricao() {
        return descricao;
    }
}

