/**
 * Допишите код приложения для случайных встреч с незнакомцами — Random Coffee.  Основная программа представлена
 * в классах RandomCoffee и PairGenerator. Информация об одном незнакомце находится в классе Stranger.
 * Ваша задача — дописать методы splitByPairs и getRandomPair, чтобы программа могла разбить незнакомцев по парам.
 */

package yandex.sprint5.task4;

import java.util.ArrayList;
import java.util.List;

public class RandomCoffee {

    public static void main(String[] args) {

        List<Stranger> strangers = new ArrayList<>(List.of(
                new Stranger("Анна", 29),
                new Stranger("Иван", 25),
                new Stranger("Мария", 25),
                new Stranger("Павел", 26),
                new Stranger("Святослав", 27),
                new Stranger("Екатерина", 28)
        ));
        PairGenerator pairGenerator = new PairGenerator();

        System.out.println("На этой неделе в Random Coffee участвуют: " + strangers);

        List<List<Stranger>> splitByPairs = pairGenerator.splitByPairs(strangers);

        System.out.println("Генератор случайных чисел составил пары: " + splitByPairs);
    }
}