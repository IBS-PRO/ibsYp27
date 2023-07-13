/**
 * Пришло время попрактиковаться в написании кода, работающего с неизменяемыми объектами.
 * В приложение магазина конфет добавляется новая сущность. Теперь конфеты можно объединять в наборы! Допишите код,
 * создающий на основе списка конфет набор. При этом учтите такие ограничения:
 * 1. Цена конфеты в наборе всегда на 5 рублей дешевле, чем отдельно.
 * 2. Конфеты не всех производителей можно добавлять наборы — некоторые запрещают это. Список запрещенных для наборов
 * производителей задан заранее.
 * 3. Конфеты в наборе должны быть отсортированы по названию.
 * За набор отвечает класс CandyBox - он уже частично реализован. Он состоит из названия набора, списка конфет в нем и
 * их количества. В этом же классе в виде статического поля prohibitedProducers хранится список запрещенных
 * производителей - метод isProducerAllowed проверяет конфету на валидность ее производителя в соответствии с этим
 * списком. Вам нужно доработать класс CandyBox, а потом добавить в класс CandyBoxesStore код, который будет создавать
 * набор конфет. Используйте ссылки на методы, где возможно. И помните — в вашем коде не должно быть изменяемых объектов!
 */

package yandex.sprint7.task4;

import java.util.*;
import java.util.stream.Collectors;

class Candy {
    //название
    final String name;
    //производитель
    final String producer;
    //цена
    final int price;
    //проданное количество
    final int amountSold;
    //другие варианты названия
    final Set<String> alternateNames;

    public Candy(String name, String producer, int price, int amountSold, Collection<String> alternateNames) {
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.amountSold = amountSold;
        this.alternateNames = Set.copyOf(alternateNames);
    }

    public static int compareByName(Candy c1, Candy c2) {
        return c1.name.compareTo(c2.name);
    }
}

class CandyBox {
    final String boxTitle;
    final List<Candy> candies;

    //final long numberOfCandies; - просто забил

    private static final List<String> prohibitedProducers = List.of("Триумф");

    //добавьте конструктор
    public CandyBox(String boxTitle, List<Candy> candies) {
        this.boxTitle = boxTitle;
        this.candies = candies;
    }

    public static boolean isProducerAllowed(Candy candy) {
        //добаьте тело метода
        String candyProducer = candy.producer;
        String prohibitedProducer = prohibitedProducers.get(0);
        return !candyProducer.equals(prohibitedProducer);
    }


    public void printContent() {
        System.out.println("Набор " + boxTitle
                + ", содержит " /*+ numberOfCandies*/ + " конфет");
        candies.forEach(candy ->
                System.out.println(candy.name + " производства " + candy.producer + ", цена: " + candy.price));
    }
}

public class CandyBoxesStore {

    public static void main(String[] args) {
        Candy candy1 = new Candy("Мишка на севере", "Первая кондитерская фабрика", 28, 4, Set.of("Мишка косолапый", "Мишка"));
        Candy candy2 = new Candy("Мишка в лесу", "Триумф", 32, 2, Set.of("Мишка косолапый"));
        Candy candy3 = new Candy("Трюфель", "Триумф", 44, 5, Set.of("Трюфель классический", "Трюфель шоколадный"));
        Candy candy4 = new Candy("Победа", "Первая кондитерская фабрика", 14, 12, Set.of("ПОБЕДА"));

        List<Candy> candies = List.of(candy1, candy2, candy3, candy4);

        List<Candy> candiesForBox = candies.stream()
                .filter(candy -> CandyBox.isProducerAllowed(candy))
                .map(candy -> new Candy(candy.name, candy.producer, candy.price - 5, candy.amountSold, candy.alternateNames))
                .sorted(Comparator.comparing(candy -> Candy.compareByName(candy1, candy2)))
                .collect(Collectors.toList());

                CandyBox candyBox = new CandyBox("С Новым Годом", candiesForBox);

        candyBox.printContent();
    }
}
