package customCollections;

public class CustomArrayList<T> implements CustomList<T> {

    private T[] objects;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size = 0;


    public CustomArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        objects = (T[]) new Object[this.capacity];
    }

    public CustomArrayList(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Incorrect array size");
        }
        this.capacity = capacity;
        objects = (T[]) new Object[this.capacity];
    }

    public CustomArrayList(CustomList<? extends T> list) {
        addAll(list);
    }

    public boolean add(T element) {
        checkCapacity();

        objects[size] = element;
        size++;

        return true;
    }


    public boolean add(int index, T element) {
        checkIndex(index);
        checkCapacity();

        objects = addInArray(index, element);

        size++;

        return true;
    }

    public boolean addAll(CustomList<? extends T> list) {
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            add(list.get(i));
        }
        return true;
    }

    public boolean set(int index, T element) {
        checkIndex(index);

        objects[index] = element;

        return true;
    }

    public T get(int index) {
        checkIndex(index);
        return objects[index];
    }

    public boolean remove(int index) {
        checkIndex(index);

        objects = removeFromArray(index);

        size--;

        return true;
    }

    public boolean remove(T element) {
        int index = findIndexByElement(element);

        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    private void increaseArray() {
        int increaseValue = getIncreaseArrayValue();
        T[] newArray = (T[]) new Object[increaseValue];
        capacity = increaseValue;

        copyArray(newArray);

        objects = newArray;
    }

    private int getIncreaseArrayValue(){
        return capacity * 3 / 2 + 1;
    }

    private void copyArray(T[] newArray) {
        for (int i = 0; i < size; i++) {
            newArray[i] = objects[i];
        }
    }
    private T[] addInArray(int index, T element) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < index; i++) {
            newArray[i] = objects[i];
        }

        newArray[index] = element;

        for (int i = index; i < size; i++) {
            newArray[i + 1] = objects[i];
        }

        return newArray;
    }

    private T[] removeFromArray(int index) {
        T[] newObjects = (T[]) new Object[capacity];

        for (int i = 0; i < index; i++) {
            newObjects[i] = objects[i];
        }

        for (int i = index + 1; i < size; i++) {
            newObjects[i - 1] = objects[i];
        }

        return newObjects;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index value " + index + " not found");
        }
    }

    private void checkCapacity() {
        if (size == capacity) {
            increaseArray();
        }
    }

    private int findIndexByElement(T element) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (objects[i].equals(element)) {
                index = i;
                break;
            }
        }

        return index;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");

        for (int i = 0; i <= size - 1; i++) {
            stringBuilder.append(objects[i]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

}
