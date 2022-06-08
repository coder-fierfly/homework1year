package lab.third;

import java.util.Objects;

public class OurLinked implements lab.third.Linked {

    private Node firstElement;
    private int freeIndex = 0;

    private static class Node {
        private String element;
        private Node next;

        Node(String element) {
            this.element = element;
            next = null;
        }
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

    private void checkLinked(Linked c) {
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
        for (int i = 0; i < freeIndex; i++) {
            if (Objects.equals(get(i), o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[freeIndex];
        Node el = firstElement;
        for (int i = 0; i < freeIndex; i++) {
            newArray[i] = el.element;
            el = el.next;
        }
        return newArray;
    }

    @Override
    public boolean add(String o) {
        Node newNode = new Node(o);
        if (firstElement == null) {
            firstElement = newNode;
            ++freeIndex;
        } else {
            Node last = firstElement;
            while (last.next != null) {
                last = last.next;
            }
            ++freeIndex;
            last.next = newNode;
        }
        return true;
    }

    @Override
    public boolean addAll(Linked c) {
        checkLinked(c);
        if (c.isEmpty()) {
            return false;
        }
        int size = c.size();
        for (int i = 0; i < size; ++i) {
            add(c.get(i));
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Linked c) {

        checkIndexToSize(index);
        checkLinked(c);
        if (c.isEmpty()) {
            return false;
        }

        for (int i = index; i < c.size() + index; ++i) {
            add(i, c.get(i - index));
        }
        return true;
    }

    @Override
    public void clear() {
        firstElement = null;
        freeIndex = 0;
    }

    @Override
    public String get(int index) {

        checkIndexLess(index);

        Node buff = firstElement;
        for (int i = 0; i < index; i++) {
            buff = buff.next;
        }
        return buff.element;
    }

    @Override
    public String set(int index, String element) {

        checkIndexLess(index);

        String line = get(index);
        Node newNode = new Node(element);
        if (index == 0) {
            newNode.next = firstElement.next;
            firstElement = newNode;
        } else {
            Node buff = firstElement;
            Node superBuff = firstElement;
            for (int i = 0; i < index; i++) {
                superBuff = buff;
                buff = superBuff.next;
            }
            superBuff.next = newNode;
            newNode.next = buff.next;
        }
        return line;
    }

    @Override
    public void add(int index, String element) {

        checkIndexToSize(index);

        Node newNode = new Node(element);
        if (index < freeIndex) {
            if (index == 0) {
                newNode.next = firstElement;
                firstElement = newNode;
            } else {
                Node buff = firstElement;
                for (int i = 0; i < index - 1; i++) {
                    buff = buff.next;
                }
                Node superBuff = buff.next;
                buff.next = newNode;
                newNode.next = superBuff;
            }
            ++freeIndex;
        }
    }

    @Override
    public String remove(int index) {

        checkIndexLess(index);

        String line = get(index);
        if (index == 0) {
            firstElement = firstElement.next;
            --freeIndex;
        } else {
            Node buff = firstElement;
            Node newBuff = firstElement;
            for (int i = 0; i < index; i++) {
                newBuff = buff;
                buff = newBuff.next;
            }
            newBuff.next = buff.next;
            --freeIndex;
        }
        return line;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < freeIndex; ++i) {
            if (Objects.equals(o, get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String o) {
        for (int i = 0; i < freeIndex; i++) {
            if (Objects.equals(get(i), o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String o) {
        int index = -1;
        for (int i = 0; i < freeIndex; i++) {
            if (Objects.equals(get(i), o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public Linked subList(int fromIndex, int toIndex) {

        checkIndexLess(fromIndex);
        checkIndexToSize(toIndex);

        Linked newArray = new OurLinked();
        for (int i = fromIndex; i < toIndex; ++i) {
            newArray.add(get(i));
        }
        return newArray;
    }

    @Override
    public boolean removeAll(Linked c) {

        checkLinked(c);
        if (c.isEmpty()) {
            return false;
        }

        int oldSize = freeIndex;
        for (int i = 0; i < c.size(); ++i) {
            do {
                remove(c.get(i));
            } while (contains(c.get(i)));
        }
        return oldSize != freeIndex;
    }

    @Override
    public boolean containsAll(Linked c) {

        checkLinked(c);
        if (c.isEmpty()) {
            return false;
        }

        int j = 0;
        for (int i = 0; i < c.size(); i++) {
            if (contains(c.get(i))) {
                j++;
            }
        }
        return j == c.size();
    }
}
