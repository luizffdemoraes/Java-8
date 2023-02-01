package org.example;

import java.util.*;
import java.util.stream.Collectors;
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
    public static <Optional> void main(String[] args) {
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

        // Retornar algum após o filtro
        java.util.Optional<Curso> optinalCurso = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny();

       Curso curso = optinalCurso.orElse(null);
        System.out.println(curso.getNome());

        optinalCurso.ifPresent(c -> System.out.println(c.getNome()));

        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));


        OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();

        // Dado essa sequencia de dados ordenados filtrados retorne uma coleção

        cursos = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toList());

        //Guardar Chave e Valor

        Map mapa = cursos
                .stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));

        System.out.println(mapa);

        cursos
                .parallelStream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos.")) ;

        cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .findFirst();

        List<Curso> cursosFiltrados = cursos.stream()
                .filter(c -> c.getAlunos() > 50)
                .collect(Collectors.toList());

    }
}