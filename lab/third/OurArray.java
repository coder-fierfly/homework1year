package lab.third;

import java.util.Objects;

public class OurArray implements lab.third.Array {

    private static final int STANDART_VALUE = 10;
    private String[] array;
    private int amountOfElements;
    private int freeIndex = 0;

    public OurArray(int amountOfElements) throws IndexOutOfBoundsException {
        this.amountOfElements = amountOfElements;
        if (amountOfElements < 1) {
            throw new IndexOutOfBoundsException("Число меньше 1");
        }
        array = new String[amountOfElements];
    }

    public OurArray() {
        this.array = new String[STANDART_VALUE];
        amountOfElements = STANDART_VALUE;
    }

    private void checkIndexLess(int index) {
        if (index > freeIndex - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Индекс " + index +
                    " выходит за пределы массива размером " + freeIndex);
        }
    }

    private void checkIndexToSize(int index) {
        if (index > freeIndex || index < 0) {
            throw new IndexOutOfBoundsException("Индекс " + index +
                    " выходит за пределы массива размером " + freeIndex);
        }
    }

    private void checkArray(Array c) {
        if (c == null) {
            throw new NullPointerException("Введенная вами коллекция null");
        }
    }

    @Override
    public int size() {
        return freeIndex;
    }

    @Override
    public boolean isEmpty() {
        return freeIndex == 0;
    }

    @Override
    public boolean contains(String o) {
        for (int k = 0; k < freeIndex; ++k) {
            if (Objects.equals(array[k], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[freeIndex];
        if (freeIndex >= 0) {
            System.arraycopy(array, 0, newArray, 0, freeIndex);
        }
        return newArray;
    }

    @Override
    public boolean add(String o) {
        if (freeIndex != amountOfElements) {
            array[freeIndex] = o;
        } else {
            String[] newArray = new String[freeIndex + STANDART_VALUE];
            amountOfElements += STANDART_VALUE;
            System.arraycopy(array, 0, newArray, 0, freeIndex);
            newArray[freeIndex] = o;
            array = newArray;
        }
        ++freeIndex;
        return true;
    }

    @Override
    public boolean addAll(Array c) {

        checkArray(c);
        if (c.isEmpty()) {
            return false;
        }

        if ((freeIndex + c.size()) >= amountOfElements) {
            if ((c.size() + freeIndex) % amountOfElements == 0) {
                int count = c.size() / amountOfElements;
                amountOfElements += count * STANDART_VALUE;
            } else {
                int count = c.size() / amountOfElements + 1;
                amountOfElements += count * STANDART_VALUE;
            }
            String[] newArray = new String[amountOfElements];
            System.arraycopy(array, 0, newArray, 0, freeIndex);
            array = newArray;
        }

        for (int i = 0; i < c.size(); ++i) {
            this.add(c.get(i));
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Array c) {

        checkIndexToSize(index);
        checkArray(c);
        if (c.isEmpty()) {
            return false;
        }

        if ((freeIndex + c.size()) >= amountOfElements) {
            if ((c.size() + freeIndex) % amountOfElements == 0) {
                int count = c.size() / amountOfElements;
                amountOfElements += count * STANDART_VALUE;
            } else {
                int count = c.size() / amountOfElements + 1;
                amountOfElements += count * STANDART_VALUE;
            }
            String[] newArray = new String[amountOfElements];
            System.arraycopy(array, 0, newArray, 0, freeIndex);
            array = newArray;
        }

        for (int i = index; i < freeIndex; ++i) {
            this.array[i + c.size()] = this.array[i];
        }

        for (int i = 0; i < c.size(); ++i) {
            this.array[i + index] = c.get(i);
        }

        freeIndex += c.size();
        return true;
    }

    @Override
    public void clear() {
        array = new String[STANDART_VALUE];
        amountOfElements = STANDART_VALUE;
        freeIndex = 0;
    }

    @Override
    public String get(int index) {
        checkIndexLess(index);
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        checkIndexLess(index);
        String line = array[index];
        array[index] = element;
        return line;
    }

    @Override
    public void add(int index, String element) {

        checkIndexToSize(index);

        if (freeIndex != amountOfElements) {
            for (int i = freeIndex; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = element;
            ++freeIndex;
        } else if (freeIndex == amountOfElements) {
            ++freeIndex;
            String[] ourArray = new String[amountOfElements + STANDART_VALUE];
            amountOfElements += STANDART_VALUE;
            System.arraycopy(array, 0, ourArray, 0, freeIndex - 1);
            array = ourArray;
            if (freeIndex != amountOfElements) {
                if (freeIndex - index >= 0) {
                    System.arraycopy(array, index, array, index + 1, freeIndex - index);
                }
                array[index] = element;
            }
        }
    }

    @Override
    public String remove(int index) {
        checkIndexLess(index);
        String line = array[index];
        System.arraycopy(array, index + 1, array, index, freeIndex - index - 1);
        --freeIndex;
        return line;
    }

    @Override
    public boolean remove(Object o) {
        int size = freeIndex;
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(array[i], o)) {
                System.arraycopy(array, i + 1, array, i, freeIndex - i - 1);
                --freeIndex;
                return true;
            }
        }
        return false;
    }


    @Override
    public int indexOf(String o) {
        for (int i = 0; i < size(); i++) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String o) {
        int index = -1;
        int size = freeIndex;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public Array subList(int fromIndex, int toIndex) {
        checkIndexLess(fromIndex);
        checkIndexToSize(toIndex);
        Array newArray = new OurArray();
        int size = freeIndex;
        for (int i = size; i < toIndex; ++i) {
            newArray.add(array[i]);
        }
        return newArray;
    }

    @Override
    public boolean removeAll(Array c) {

        checkArray(c);
        if (c.isEmpty()) {
            return false;
        }

        int count = 0;
        int size = freeIndex;
        for (int j = size - 1; j >= 0; --j) {
            for (int i = 0; i < c.size(); ++i) {
                if (Objects.equals(array[j], c.get(i))) {
                    remove(j);
                    ++count;
                }
            }
        }
        return count != 0;
    }

    @Override
    public boolean containsAll(Array c) {

        checkArray(c);
        if (c.isEmpty()) {
            return false;
        }

        int i = 0;
        for (int j = 0; j < c.size(); ++j) {
            for (int k = 0; k < freeIndex; ++k) {
                if (Objects.equals(array[k], c.get(j))) {
                    ++i;
                }
            }
        }
        return i != c.size();
    }
}