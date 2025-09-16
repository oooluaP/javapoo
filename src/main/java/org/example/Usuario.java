package org.example;


public sealed abstract class Usuario
        permits Administrador, Bibliotecario, UsuarioComum {

    protected String nome;

    public Usuario (String nome){
        this.nome = nome;
        }

    public String getNome(){
        return nome;
    }

    public abstract String gerarRelatorio();

}












