/**
 * Попробуйте самостоятельно реализовать ArrayList<T>. Часть класса HandMadeArrayList уже написана. Вам нужно дописать
 * реализацию двух методов. Так, grow() должен отвечать за увеличение вместительности массива на 50%, а add(T) добавлять
 * очередной элемент в список.
 */
package yandex.sprint5.task5;

public class HandMadeArrayList<T> {

    private int size = 0;
    private Object[] elements;

    public HandMadeArrayList() {
        this.elements = new Object[10];
    }

    public void add(T newElement) {
        // Допишите проверку
        if (size == elements.length) {
            grow();
        }
        /* Допишите код, который добавит очередной элемент в массив
           и увеличит размер массива на единицу.*/
        elements[size] = newElement;
        size = size + 1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Element with index " + index + " does not exist");
        }
        return (T) this.elements[index];
    }

    private void grow() {
        Object[] newArray = new Object[elements.length + elements.length / 2];
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }
        this.elements = newArray;
    }

    public static void main(String[] args) {
        final var ar = new HandMadeArrayList<Integer>();
        for (int i = 0; i < 2000; i++) {
            ar.add(i);
        }
        System.out.println(ar.size);
    }
}
