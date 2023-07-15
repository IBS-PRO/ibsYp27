/**
 Магазин конфет просит вас доработать их программную систему. На сайте магазина должен появиться поиск конфет по названию.
 Код поиска должен быть организован по такому алгоритму:
    1.Сначала нужно проверить, есть ли искомая конфета на складе магазина. Если конфета найдена,
    то возвращается информация о ней.
    2. Если на складе магазина конфета отсутствует — нужно проверить наличие у поставщиков. Если конфеты были найдены,
    то возвращается информация о них.
    3. Если конфета не была найдена, вернуть пустой результат.
 За поиск конфет на складе магазина отвечает класс Warehouse, за поиск конфет на складах поставщиков — класс SRM.
 Класс SRM поставляется с SRM-системой (SRM сокр. от англ. Supplier Relationship Management System — система управления
 взаимодействием с поставщиками) — у вас нет возможности повлиять на реализацию этого класса. Но можно использовать
 два его метода:
    listSuppliers — чтобы получить набор доступных поставщиков;
    getProduct — чтобы получить информацию о конфете по её названию и поставщику. Но если поставщик или товар
 отсутствуют, этот метод вернёт null.
 Класс SearchService будет содержать в себе общий алгоритм поиска и обращаться к классам Warehouse и SRM.
 Действуйте пошагово:
    1. Реализуйте метод search в классе Warehouse — для поиска конфеты на складе магазина.
    2. Реализуйте вспомогательный метод supplierSearch в классе SearchService для поиска конфеты на складах поставщиков
    с использованием объекта класса SRM. Из всех найденных конфет нужно выбрать конфету с наименьшей ценой.
    Для этого пригодится метод min из Stream API. Он находит минимальный элемент стрима при помощи объекта типа Comparator.
    3. Реализуйте метод search в классе SearchService для поиска конфеты на складе магазина или на складах поставщиков,
    если на складе магазина она отсутствует. Этот метод будет использоваться как входной для запуска поиска.
 Доработайте метод main класса Practicum, чтобы на экран выводилась нужная информация:
    1. Если конфеты найдены: Товар "[название_конфет]" доступен в количестве [количество] кг по цене [цена] руб за
    кг" (в квадратных скобках должны быть значения найденного товара).
    2. Если конфеты не найдены: Данный товар не найден.
 */

package yandex.sprint7.task5;

import java.util.Optional;

public class Practicum {
    public static void main(String[] args) {
        // Доработайте данный метод, чтобы на экран выводилось
        // сообщение в соответствии с заданием

        SearchService searchService = new SearchService();
        Optional<Candy> test = searchService.search("Африка");

        if (test.isPresent()) {
            Candy candyIsPresent = test.get();
            System.out.println("Товар " + "\"[" + candyIsPresent.name + "]\""
                    + " доступен в количестве " + candyIsPresent.amount
                    + " кг по цене " + (int) candyIsPresent.price
                    + " руб за кг");
        } else {
            System.out.println("Данный товар не найден");
        }
    }
}