package pl.krzywda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> people = new ArrayList<>(
                Arrays.asList(
                        new Person("Andrzej", 15, "c++"),
                        new Person("Lukasz", 25, "html", "css"),
                        new Person("Kamil", 13, "scratch"),
                        new Person("Antoni", 23, "Java", "Spring", "React"),
                        new Person("Mariusz", 14, "Python"),
                        new Person("Jakub", 55, "Java", "Spring"),
                        new Person("Alojzy", 35, "c++", "c#"),
                        new Person("Kacper", 53, "pascal"),
                        new Person("Jedrzej", 23, "scala"),
                        new Person("Arkadiusz", 31, "js", "nodejs"),
                        new Person("Krzysztof", 36, "c++", "c#"),
                        new Person("Dawid", 23, "c++"),
                        new Person("Olaf", 15, "c++","PHP")
                        )
        );

        //map
        List<Integer> ages = people.stream()
                .map(Person::getAge).collect(Collectors.toList());

        System.out.println(ages);

        //flatMap
        List<String> skills = people.stream()
                .map(Person::getSkills)
                .flatMap(List::stream)
                .toList();

        //filter
        List<String> javaDevelopers = people
                .stream()
                .filter(
                        person -> {
                            return person.getSkills().stream().anyMatch(s -> s.equals("Java"));
                        }
                )
                .map(Person::getName)
                .toList();

        System.out.println(javaDevelopers);

        //sorted
        people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);

        //limit
        List<Person> youngestDevelopers = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .limit(3)
                .toList();

        System.out.println(youngestDevelopers);

        //skip
        List<Person> nextYoungestDevelopers = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .skip(3)
                .limit(3)
                .toList();

        System.out.println(nextYoungestDevelopers);

        //count
        long countCppDevelopers = people.stream()
                .filter(
                        p -> {
                            return p.getSkills().stream().anyMatch(s -> s.equals("c++"));
                        })
                .map(Person::getAge)
                .count();

        System.out.println(countCppDevelopers);

        //min max
        Person youngestPerson = people.stream()
                .min(Comparator.comparing(Person::getAge)).get();

        System.out.println(youngestPerson);

        Person oldestPerson = people.stream()
                .max(Comparator.comparing(Person::getAge)).get();

        System.out.println(oldestPerson);

        //findAny findFirst
        Person firstCppDevFromList = people.stream()
                .filter(
                        p -> {
                            return p.getSkills().stream().anyMatch(s -> s.equals("c++"));
                        })
                .findFirst().get();

        Person anyCppDevFromList = people.stream().
                filter(
                        p -> {
                            return p.getSkills().stream().anyMatch(s -> s.equals("c++"));
                        }
                )
                .findAny().get();

        System.out.println("first cpp dev: " + firstCppDevFromList);
        System.out.println("any cpp dev: " + anyCppDevFromList);
    }
}