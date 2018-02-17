package COLLECTIONSGENERICS;

public class ArrayList<T> {

    private int lastCurrentIndex = 0;

    private static MyArrayList[] data = new MyArrayList[3];

    public void add(T data, int index) {
        if (lastCurrentIndex == this.data.length - 1) {
            addSize();
        }
        replace((T) data, index);
    }

    public int add(T data) {
        if (lastCurrentIndex == this.data.length - 1) {
            addSize();
        }
        this.data[lastCurrentIndex++] = (MyArrayList) data;
        return lastCurrentIndex;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public void remove(int index) {
        set(index, null);

    }

    public T getValueOF(int index) {
        return (T) data[index];
    }

    private void addSize() {
        MyArrayList[] data = new MyArrayList[getNewArraySize()];
        System.arraycopy(this.data, 0, data, 0, this.data.length);
        this.data = data;
    }

    private void replace(T data, int index) {
        if (lastCurrentIndex + 1 == this.data.length) {
            addSize();
        }
        int last = lastCurrentIndex;
        T operative;
        for (int i = 0; i < index; i++) {
            operative = (T) getValueOF(last);
            set(last, operative);
            last--;
        }
    }

    private void set(int index, T element) {
        this.data[index] = (MyArrayList) element;
    }

    private int getNewArraySize() {
        return this.data.length + this.data.length / 2 + 1;
    }

}
