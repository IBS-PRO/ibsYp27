package yandex.sprint5.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairGenerator {

    private static final Random rnd = new Random();
    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {

        // Укажите тип ещё раз.
        List<List<Stranger>> pairs = new ArrayList<>();
        while (!strangers.isEmpty()) {

            List<Stranger> pair = getRandomPair(strangers);
            // Добавьте новый элемент в набор пар.
            pairs.add(pair);
        }

        return pairs;
    }

    private List<Stranger> getRandomPair(List<Stranger> strangers) {

        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);

        strangers.removeAll(List.of(strangerOne, strangerTwo));
        List<Stranger> pair = new ArrayList<>(List.of(strangerOne, strangerTwo));
        return pair;
    }
}
