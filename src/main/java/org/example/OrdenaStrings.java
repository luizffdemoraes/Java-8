package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {
    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();

        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

       // Comparator<String> comparator = new ComparadorDeStringPorTamanho();


        // Interface Funcional
        palavras.sort(new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() < s2.length())
                    return -1;
                if (s1.length() > s2.length())
                    return 1;
                return 0;
            }
        });

        palavras.sort((s1, s2) -> {
            if (s1.length() < s2.length())
                return -1;
            if (s1.length() > s2.length())
                return 1;
            return 0;
        });

        palavras.sort((s1, s2) -> {
            return Integer.compare(s1.length(), s2.length());
        });

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        // Collections.sort(palavras, comparator);
        // palavras.sort(comparator);

        /*
        -> Método que tem corpo dentro de um interface;
        -> Métodos concreto dentro de uma interface até a versão do java 7 não podiam existir;
        -> Após o Java 8 surgio default methods

        System.out.println(palavras);

        for (String p : palavras) {
            System.out.println(p);
        }


        Consumer<String> consumidor = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };



        //Implementar interfaces e passar como argumento
        palavras.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        palavras.forEach((String s) -> {
                System.out.println(s);
            }
        );
         */

        palavras.forEach(s -> System.out.println(s));

        // Threads com lambda!

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }

        }).start();

        new Thread(() -> System.out.println("Executando um Runnable")).start();

    }
}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    // Comparar tamanho
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}