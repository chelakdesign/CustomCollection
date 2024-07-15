package customCollections;

public interface CustomList<T> {
    boolean add(T element);
    boolean add(int index, T element);
    boolean addAll(CustomList<? extends T> list);
    boolean set(int index, T element);
    T get(int index);
    boolean remove(int index);
    boolean remove(T element);
    int getSize();

}
