/**
 * Один из наиболее частых алгоритмов сортировки — сортировка слиянием, он состоит из трёх последовательных шагов:
 * 1) разделение массива элементов на два,
 * 2) сортировка каждого из них,
 * 3) обратное объединение этих массивов.
 * Ваша задача в этом тренажёре реализовать последний шаг — объединение двух отсортированных массивов в один
 * отсортированный. К примеру, объединение массива {1, 3, 4} и {2, 4, 6} будет выглядеть так: {1, 2, 3, 4, 4, 6}.
 * При объединении двух отсортированных массивов можно воспользоваться следующей логикой:
 *  1. Заведём результирующий массив resultArray, размер которого — сумма размеров двух сортируемых массивов.
 *  2. Теперь необходимо завести индексы для левого и правого массива в отдельности: переменные left и right,
 *  которые в начале равны 0. Максимальное значение этих индексов — максимальный индекс соответствующего массива.
 *  Для left это leftArray.length - 1, а для right — rightArray.length - 1.
 *  3. Наконец, начинаем заполнять элементы resultArray по следующей логике:
 *      1. Если какой-то из индексов вышел за свою максимальную границу — добавляем элемент из другого массива
 *      и увеличиваем его индекс. Если, к примеру, элементы в левом массиве закончились — добавляем элемент из правого
 *      массива и увеличиваем right на единицу.
 *      2. Если же индексы ещё не вышли за границу, то добавляем наименьший из двух элементов leftArray[left]
 *      и rightArray[right]. Когда элемент берётся из левого массива, необходимо увеличить left. Аналогично если
 *      берётся элемент из правого, увеличивается right.
 * Напишите операцию merge для объединения двух отсортированных массивов.
 */

package yandex.sprint5.task3;

public class Practicum {
    public static void main(String[] args) {
        int[] array1 = new int[]{1, 3, 4, 6, 8};
        int[] array2 = new int[]{1, 2, 3, 8, 9};
        int[] resultArray = merge(array1, array2);

        for (int e : resultArray) {
            System.out.print(e + ", ");
        }
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {

        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int[] resultArray = new int[leftSize + rightSize];

        int left = 0;
        int right = 0;
        int index = 0;

        while (index < resultArray.length) {

            if (left >= leftSize) {
                resultArray[index] = rightArray[right];
                right++;
            }

            else if (right >= rightSize) {
                // !!! Добавьте ваш код
                resultArray[index] = leftArray[left];
                left++;
            }

            else if (leftArray[left] <= rightArray[right]) {
                resultArray[index] = leftArray[left];
                left++;
            }

            else {
                // !!! Добавьте ваш код
                resultArray[index] = rightArray[right];
                right++;
            }
            index++;
        }
        return resultArray;
    }
}
