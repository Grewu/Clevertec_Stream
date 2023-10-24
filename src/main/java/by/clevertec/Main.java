package by.clevertec;

import by.clevertec.model.Animal;
import by.clevertec.model.Car;
import by.clevertec.model.Examination;
import by.clevertec.model.Flower;
import by.clevertec.model.House;
import by.clevertec.model.Person;
import by.clevertec.model.Student;
import by.clevertec.util.Util;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    }

    public static void task1() {
        List<Animal> animals = Util.getAnimals();
        int zooCount = 3;
        int animalsPerZoo = 7;

        List<Animal> animalsForZoo3 = animals.stream()
                .filter(animal -> animal.getAge() >= 10 && animal.getAge() <= 20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .skip(zooCount * animalsPerZoo)
                .limit(animalsPerZoo)
                .toList();

        animalsForZoo3.forEach(animal -> System.out.println(animal.getBread() + " - " + animal.getAge() + " years old"));
    }

    public static void task2() {
        List<Animal> animals = Util.getAnimals();
        List<String> femaleJapaneseBreeds = animals.stream()
                .filter(animal -> "Japanese".equalsIgnoreCase(animal.getOrigin()))
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .map(animal -> animal.getBread().toUpperCase())
                .toList();

        femaleJapaneseBreeds.forEach(System.out::println);
    }

    public static void task3() {
        List<Animal> animals = Util.getAnimals();
        List<String> countriesStartingWithA = animals.stream()
                .filter(animal -> animal.getAge() > 30)
                .map(Animal::getOrigin)
                .filter(country -> country.startsWith("A"))
                .distinct()
                .toList();

        countriesStartingWithA.forEach(System.out::println);
    }

    public static void task4() {
        List<Animal> animals = Util.getAnimals();
        long femaleCount = animals.stream()
                .filter(animal -> "Female".equalsIgnoreCase(animal.getGender()))
                .count();

        System.out.println("Количество животных с полом Female: " + femaleCount);
    }

    public static void task5() {
        List<Animal> animals = Util.getAnimals();
        boolean hasHungarianAnimal = animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30)
                .anyMatch(animal -> "Hungarian".equalsIgnoreCase(animal.getOrigin()));
        System.out.println(hasHungarianAnimal);
    }

    public static void task6() {
        List<Animal> animals = Util.getAnimals();
        boolean allMaleAndFemale = animals.stream()
                .allMatch(animal -> "Male".equalsIgnoreCase(animal.getGender())
                        || "Female".equalsIgnoreCase(animal.getGender()));
        System.out.println(allMaleAndFemale);
    }

    public static void task7() {
        List<Animal> animals = Util.getAnimals();
        boolean noneFromOceania = animals.stream()
                .noneMatch(animal -> "Oceania".equalsIgnoreCase(animal.getOrigin()));
        System.out.println(noneFromOceania);
    }

    public static void task8() {
        List<Animal> animals = Util.getAnimals();
        int maxAge = animals.stream()
                .sorted(Comparator.comparingInt(Animal::getAge).reversed())
                .limit(100)
                .findFirst()
                .map(Animal::getAge)
                .orElse(-1);
        System.out.println(maxAge);
    }

    public static void task9() {
        List<Animal> animals = Util.getAnimals();
        int shortestBreedLength = animals.stream()
                .map(Animal::getBread)
                .map(String::toCharArray)
                .map(charArray -> charArray.length)
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println(shortestBreedLength);
    }

    public static void task10() {
        List<Animal> animals = Util.getAnimals();
        int totalAge = animals.stream()
                .mapToInt(Animal::getAge)
                .sum();
        System.out.println(totalAge);
    }

    public static void task11() {
        List<Animal> animals = Util.getAnimals();
        OptionalDouble averageAge = animals.stream()
                .filter(animal -> "Indonesian".equalsIgnoreCase(animal.getOrigin()))
                .mapToInt(Animal::getAge)
                .average();
        System.out.println(averageAge);
    }

    public static void task12() {
        List<Person> persons = Util.getPersons();
        List<Person> collect = persons.stream()
                .filter(person -> "Male".equalsIgnoreCase(person.getGender()))
                .filter(person -> person.getDateOfBirth().isBefore(LocalDate.now().minusYears(18)) &&
                        person.getDateOfBirth().isAfter(LocalDate.now().minusYears(27)))
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .toList();

        collect.forEach(System.out::println);
    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
        students.stream()
                .filter(student -> student.getAge() < 18)
                .sorted(Comparator.comparing(Student::getSurname))
                .map(Student::getSurname)
                .forEach(System.out::println);

    }

    public static void task17() {
        List<Student> students = Util.getStudents();
        students.stream()
                .map(Student::getGroup)
                .distinct()
                .forEach(System.out::println);
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();

        List<Student> result = students.stream()
                .filter(student -> "P-1".equalsIgnoreCase(student.getGroup()))
                .filter(student -> examinations.stream()
                        .filter(examination -> examination.getStudentId() == student.getId())
                        .allMatch(exam -> exam.getExam1() + exam.getExam2() + exam.getExam3() > 4))
                .toList();

        result.forEach(student -> System.out.println(student.getSurname()));

    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        Map<String, Double> result = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.averagingDouble(Student::getAge)
                ));

        result.forEach((faculty, averageAge) -> {
            System.out.println(System.out.printf("Факультет: %s, Средний возраст: %.2f%n", faculty, averageAge));
        });
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
       students.stream()
                        .collect(Collectors.groupingBy(Student::getFaculty, Collectors.averagingDouble(
                           student -> examinations.stream()
                                   .filter(examination -> examination.getStudentId() == student.getId())
                                   .mapToInt(Examination::getExam1)
                                   .findFirst()
                                   .orElse(0)
                        )))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                        .stream().collect(Collectors.toSet())
                        .forEach(stringDoubleEntry -> System.out.printf(" %s = %.2f \n" ,stringDoubleEntry.getKey(),
                                                                                      stringDoubleEntry.getValue()));
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
        Map<String, Long> studentsInEachGroup = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));

        studentsInEachGroup.forEach((group, count) -> {
            System.out.println("Группа: " + group + " - Количество студентов: " + count);
        });
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
        Map<String, Integer> minAgeByFaculty = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getFaculty,
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Student::getAge)),
                                studentOptional -> studentOptional.map(Student::getAge).orElse(0)
                        )
                ));

        minAgeByFaculty.forEach((faculty, minAge) -> {
            System.out.println("Факультет: " + faculty + " - Минимальный возраст: " + minAge);
        });
    }
}
