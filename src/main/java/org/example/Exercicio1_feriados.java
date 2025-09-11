package org.example;

import javax.xml.crypto.Data;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Exercicio1_feriados {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LocalDate ldHoje = LocalDate.now();

        System.out.println("Digite um feriado no formado dd/mm/aaaa pra gente ver se tem emenda.");

        String DataInseridaUsuario = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate ldDataInseridaUsuario = LocalDate.parse(DataInseridaUsuario,formatter);

        DayOfWeek dia = ldDataInseridaUsuario.getDayOfWeek();

        if (dia == DayOfWeek.TUESDAY || dia ==  DayOfWeek.THURSDAY){
            System.out.println("Num é que tem emenda, vamos fazer uma viagem!");

            long dias = ChronoUnit.DAYS.between(ldHoje, ldDataInseridaUsuario);

            long uteis = 0;

            for (int i = 1; i <= dias; i++) {
                LocalDate atual = ldHoje.plusDays(i);
                DayOfWeek dow = atual.getDayOfWeek();

                if (dow != DayOfWeek.SATURDAY && dow != DayOfWeek.SUNDAY) {
                    uteis++;
                }
            }

            System.out.println("Faltam "+(uteis)+" dias úteis pra sua viagem!");

            long semanas = dias / 7;
            long resto = dias % 5;

            System.out.println("Isso equivale a " + semanas + " semana(s) completa(s) e " + resto + " dia(s) útil(eis).");

        } else {
            System.out.println("Esse feriado nao emenda. :( ");
        }

    }
}


