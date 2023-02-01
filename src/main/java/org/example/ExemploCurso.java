package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCurso {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        // Se quisermos ordenar esses cursos pela quantidade de alunos, podemos utilizar o Comparator
        cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
        // Esse é o caso que podemos usar um method reference para ficar ainda mais sucinto e legível.
        cursos.sort(Comparator.comparingInt(Curso::getAlunos));

        // cursos.forEach(System.out::println);
        // cursos.forEach(c -> System.out.println(c));

        Stream<Curso> streamDeCurso = cursos.stream();

         IntStream stream = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos);

        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        // .forEach(c -> System.out.println(c.getNome()))
        // .map(c -> c.getAlunos())
        // .forEach(total -> System.out.println(total) );

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .forEach(c -> System.out.println(c.getNome()));

        Stream<String> nomes = cursos.stream().map(Curso::getNome);


    }
}
