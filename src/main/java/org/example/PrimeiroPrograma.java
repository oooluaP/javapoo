package org.example;


import java.util.Scanner;

public class PrimeiroPrograma {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Bem vindo a melhor calculadora do brasil. Digite o primeiro número: ");
            int numero = input.nextInt();



            System.out.println("Digite um número inteiro");
            int numero2 = input.nextInt();



            System.out.println("numero = " + numero);
            input.close();
        }
    }
