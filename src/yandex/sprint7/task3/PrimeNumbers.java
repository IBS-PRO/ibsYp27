/**
 * Немного попрактикуемся в работе с функциональными интерфейсами из стандартной библиотеки.
 * Добавьте пропущенный код. Проверьте, является ли число простым, с помощью лямбда-функций (простое число — это число,
 * которое имеет ровно два делителя: 1 и само это число).
 * Подсказка:
 * 1. В программе должны использоваться функциональные интерфейсы BiConsumer, Predicate и Supplier. Подумайте,
 * для какой из лямбд какой больше подойдёт.
 * 2. Вспомните, как называются методы каждого из этих функциональных интерфейсов, — они пригодятся вам, чтобы корректно
 * заполнить тело цикла. Вызовите эти методы у соответствующих объектов.
 */



package yandex.sprint7.task3;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class PrimeNumbers {

    public static void main(String[] args) {
        // Лямбда, возвращающая целое число в интервале от 1 до 100
        // Укажите правильный тип данных для переменной randomInt
        Supplier <Integer> randomInt = () -> ThreadLocalRandom.current().nextInt(0,100);
        // Лямбда, проверяющая, является ли число простым
        // Укажите правильный тип данных для переменной isPrime
        Predicate <Integer> isPrime = number -> {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            return count == 2;
        };
        // Лямбда, принимающая два аргумента (целое число и строку) и выводящая сообщение
        // укажите правильные параметры типа для BiConsumer
        BiConsumer <Integer, String> outputConsumer =
                (num, str) -> System.out.println("Число " + num + " " + str);

        // Используем созданные лямбды
        for (int i = 0; i < 10; i++) {
            Integer number = randomInt.get();// получаем случайное целое число

            if (number > 1) {
                // используйте нужный функциональный метод
                outputConsumer.accept(number, "является простым.");
            } else {
                // используйте нужный функциональный метод
                outputConsumer.accept(number, "не является простым.");
            }
        }
    }
}
