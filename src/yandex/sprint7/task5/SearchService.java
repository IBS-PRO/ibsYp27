package yandex.sprint7.task5;

import java.util.*;

public class SearchService {
    // Создаём объект класса, отвечающий за склад магазина
    private final Warehouse warehouse = new Warehouse();
    // Создаём объект класса, отвечающий за работу с поставщиками
    public final SRM srm = new SRM();

    // Основной метод поиска
    // Проверяет наличие товара с указанным именем на складе магазина
    // Если товар отсутствует, то проверяются склады поставщиков,
    // предпочтение отдаётся тому поставщику, у которого наименьшая цена товара.
    // Для поиска товара на складе поставщиков используется метод supplierSearch
    // Если товар нигде не найден, то возвращается пустой Optional
    public Optional<Candy> search(String candyName) {
        // Реализуйте данный метод, с использованием методов Optional
        if (warehouse.search(candyName).isPresent()) {
            return warehouse.search(candyName);
        }
        return supplierSearch(candyName);
    }

    // Ищет товар с указанным именем на складах поставщиков
    // Возвращает Optional с самым дешевым вариантом товара среди всех
    // поставщиков или пустой Optional, если товар не найден
    private Optional<Candy> supplierSearch(String candyName) {
        // Реализуйте данный метод при помощи Stream API и Optional,
        // используйте метод min из Stream API для нахождения товара с наименьшей ценой
        Set<String> suppliers = srm.listSuppliers();
        return suppliers.stream()
                //.filter(String::isBlank)
                .map(s -> srm.getProduct(s,candyName))
                .filter(Objects::nonNull)
                .min(Comparator.comparing(candy -> candy.price));
    }
}
