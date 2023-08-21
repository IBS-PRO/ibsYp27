/**
 * Реализуйте игру-угадайку. В начале игры программа загадывает случайное число от 1 до 1000.
 * Пользователь вводитнекоторое число в поле для ввода, после чего программа должна сказать:
 *  Если введённое число меньше загаданного — вывести «Ваше число меньше».
 *  Если введённое число больше загаданного — вывести «Ваше число больше».
 *  Если введённое число равно загаданному — вывести «Правильный ответ».
 * После того, как успешно выполните задание, сыграйте в «угадайку», применяя алгоритм бинарного поиска для победы в игре.
 */
package yandex.sprint5.task2;

import java.util.Random;
import java.util.Scanner;

public class Practicum {
    public static void main(String[] args) {
        Random random = new Random();
        int target = random.nextInt(1000) + 1;
        System.out.println("Я загадал число. Попробуйте угадать!");

        Scanner s = new Scanner(System.in);
        int userGuess = -1;
        // Считывайте числа от пользователя пока не найдёте число, равное target
        while (userGuess != target) {
            userGuess = s.nextInt();
            if (userGuess < target) {
                System.out.println("Ваше число меньше");
            } else if (userGuess > target) {
                System.out.println("Ваше число больше");
            } else if (userGuess == target) {
                System.out.println("Правильный ответ");
                return;
            }
        }
    }
}
