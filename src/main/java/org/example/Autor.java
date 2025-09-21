package org.example;

/**
 * Record que representa um autor de livro.
 * Demonstra o uso de records do Java 14+ com validação automática.
 */
public record Autor(String nome) {
    
    // Construtor compacto com validação automática
    public Autor {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do autor não pode ser nulo ou vazio");
        }
        // Normaliza o nome (remove espaços extras e capitaliza)
        nome = nome.trim();
    }
    
    // Método para formatação do nome
    public String getNome() {
        return nome;
    }
}

