package homework.seven.genericList;

import java.util.Objects;

public class OurLinked<E> implements homework.seven.genericList.Linked<E> {

    private Node<E> firstElement;
    private int freeIndex = 0;

    private static class Node<E> {
        private E element;
        private Node<E> next;

        Node(E element) {
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

    private void checkLinked(Linked<E> c) {
        if (c == null) {
            throw new NullPointerException("Введенная вами коллекция null");
        }
    }

    @Override
    public int size() {
        return freeIndex;
    }

    public boolean isEmpty() {
        return freeIndex == 0;
    }

    @Override
    public boolean contains(E o) {
        for (int i = 0; i < freeIndex; i++) {
            if (Objects.equals(get(i), o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[freeIndex];
        Node<E> el = firstElement;
        for (int i = 0; i < freeIndex; i++) {
            newArray[i] = el.element;
            el = el.next;
        }
        return newArray;
    }

    @Override
    public boolean add(E o) {
        Node<E> newNode = new Node<>(o);
        if (firstElement == null) {
            firstElement = newNode;
            ++freeIndex;
        } else {
            Node<E> last = firstElement;
            while (last.next != null) {
                last = last.next;
            }
            ++freeIndex;
            last.next = newNode;
        }
        return true;
    }

    @Override
    public boolean addAll(Linked<E> c) {

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
    public boolean addAll(int index, Linked<E> c) {

        checkLinked(c);
        checkIndexToSize(index);
        if (c.isEmpty()) {
            return false;
        }

        if (index < freeIndex) {
            for (int i = index; i < c.size() + index; ++i) {
                add(i, c.get(i - index));
            }
        } else if (index == freeIndex) {
            for (int i = 0; i < c.size(); ++i) {
                add(c.get(i));
            }
        }
        return true;
    }

    @Override
    public void clear() {
        firstElement = null;
        freeIndex = 0;
    }

    @Override
    public E get(int index) {
        checkIndexLess(index);
        Node<E> buff = firstElement;
        for (int i = 0; i < index; i++) {
            buff = buff.next;
        }
        return buff.element;
    }

    @Override
    public E set(int index, E element) {

        checkIndexLess(index);

        E line = get(index);
        Node<E> newNode = new Node<>(element);
        if (index == 0) {
            newNode.next = firstElement.next;
            firstElement = newNode;
        } else {
            Node<E> buff = firstElement;
            Node<E> superBuff = firstElement;
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
    public void add(int index, E element) {

        checkIndexToSize(index);

        Node<E> newNode = new Node<>(element);
        if (index < freeIndex) {
            if (index == 0) {
                newNode.next = firstElement;
                firstElement = newNode;
            } else {
                Node<E> buff = firstElement;
                for (int i = 0; i < index - 1; i++) {
                    buff = buff.next;
                }
                Node<E> superBuff = buff.next;
                buff.next = newNode;
                newNode.next = superBuff;
            }
            ++freeIndex;
        } else if (index == freeIndex) {
            add(element);
        }
    }

    @Override
    public E remove(int index) {

        checkIndexLess(index);

        E line = get(index);
        if (index == 0) {
            firstElement = firstElement.next;
        } else {
            Node<E> buff = firstElement;
            Node<E> newBuff = firstElement;
            for (int i = 0; i < index; i++) {
                newBuff = buff;
                buff = newBuff.next;
            }
            newBuff.next = buff.next;
        }
        --freeIndex;
        return line;
    }

    @Override
    public boolean remove(E o) {
        for (int i = 0; i < freeIndex; ++i) {
            if (Objects.equals(o, get(i))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E o) {
        for (int i = 0; i < freeIndex; i++) {
            if (Objects.equals(get(i), o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E o) {
        int index = -1;
        for (int i = 0; i < freeIndex; i++) {
            if (Objects.equals(get(i), o)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public Linked<E> subList(int fromIndex, int toIndex) {

        checkIndexLess(fromIndex);
        checkIndexToSize(toIndex);

        Linked<E> newArray = new OurLinked<>();
        for (int i = fromIndex; i < toIndex; ++i) {
            newArray.add(get(i));
        }
        return newArray;
    }

    @Override
    public boolean removeAll(Linked<E> c) {

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
    public boolean containsAll(Linked<E> c) {

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
