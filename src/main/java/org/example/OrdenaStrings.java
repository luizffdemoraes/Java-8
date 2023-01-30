package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {
    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();

        palavras.add("alura online");
        palavras.add("editora casa do codigo");
        palavras.add("caelum");

       // Comparator<String> comparator = new ComparadorDeStringPorTamanho();

        /*
        A interface Function vai nos ajudar a passar um objeto para o Comparator
        .comparing que diz qual será a informação que queremos usar como critério de comparação.
        Ela recebe dois tipos genéricos. No nosso caso, recebe uma String, que é o tipo que queremos comparar,
        e um Integer, que é o que queremos extrair dessa string para usar como critério.
        Poderia até mesmo criar uma classe anônima para implementar essa Function e seu método apply,
        sem utilizar nenhum lambda. O código ficaria grande e tedioso.

Quisemos quebrar em três linhas para que você pudesse enxergar o que ocorre por trás exatamente. Sem dúvida o palavras.sort(Comparator.comparing(s -> s.length())) é mais fácil de ler.
         */

        palavras.sort(Comparator.comparing(s -> s.length()));
        palavras.sort(Comparator.comparing(String::length));

        Function<String, Integer> funcao = s -> s.length();

        palavras.forEach(System.out::println);

        Function<String, Integer> funcaoAntiga = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Comparator<String> comparador = Comparator.comparing(funcao);
        palavras.sort(comparador);


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