package org.example;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Catalogavel> itens = new ArrayList<>();

    public void adicionarItem(Catalogavel item) {
        itens.add(item);
        System.out.println("Item adicionado: " + item.getTitulo());
    }

    public void removerItem(String titulo) {
        itens.removeIf(i -> i.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Item removido: " + titulo);
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Nenhum item cadastrado.");
        } else {
            System.out.println("Itens disponíveis na biblioteca:");
            for (Catalogavel i : itens) {
                System.out.println(i);
            }
        }
    }

    public void buscarPorTitulo(String titulo) {
        for (Catalogavel i : itens) {
            if (i.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Encontrado: " + i +" o Status é ");
                return;
            }
        }
        System.out.println("Item não encontrado: " + titulo);
    }

}

