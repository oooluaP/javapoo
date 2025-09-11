package org.example;

import java.util.Scanner;

public class TryCatch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Vamos dividir numeros inteiros. Não pode digitar 0. Digite o primeiro número:  ");
            int numero1 = input.nextInt();
            System.out.println("Digite o segundo número:  ");
            int numero2 = input.nextInt();
            int resultado = numero1/numero2;
            System.out.println("O resultado da divisão é "+ resultado);
        } catch (ArithmeticException e) {
            System.err.println("A calculadora quebrou: " + e.getMessage());
        }finally {
            input.close();
        }
    }
}
