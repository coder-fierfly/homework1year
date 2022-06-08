package lab.third;

import java.util.Objects;

public class OurMap implements lab.third.Map {

    private Basket[] basket;
    private int size;
    private int countElements;
    private double coefficient;
    private static final int STANDART_SIZE = 10;
    private static final double STANDART_COEFFICIENT = 0.75;

    public OurMap(int size, double coefficient) {
        if (size <= 0 || coefficient <= 0) {
            throw new IllegalArgumentException("Поля должны быть больше 0");
        } else {
            this.coefficient = coefficient;
            this.size = size;
            this.basket = new Basket[size];
            countElements = 0;
        }
    }

    public OurMap(int size) {
        this(size, STANDART_COEFFICIENT);
    }

    public OurMap() {
        this(STANDART_SIZE, STANDART_COEFFICIENT);
    }

    private void resize() {
        if (countElements >= size * coefficient) {
            int outSize = size;
            size = size + countElements;
            countElements = 0;

            Basket[] massive = basket;
            this.basket = new Basket[size];
            for (int i = 0; i < outSize; ++i) {
                Basket basket = massive[i];
                if (basket == null) {
                    continue;
                }
                Node node = basket.first;
                while (node != null) {
                    this.put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    private static class Node {
        private String key;
        private Integer value;
        private Node next;

        Node(String key, Integer value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    // суммирует все значения по ASCII и делит на введенный размер
    private int hash(String key) {

        int sum = 0;

        if (key == null) {
            return 0;
        }

        for (int i = 0; i < key.length(); i++) {
            sum += key.charAt(i);
        }
        return sum % size;
    }

    private class Basket {

        Node first;
        Node last;

        public Basket(String key, Integer value) {
            first = new Node(key, value);
            last = first;
        }

        public void addNode(String key, Integer value) {
            last.next = new Node(key, value);
            last = last.next;
        }

        public Node findKey(String key) {

            Node seeker = this.first;

            while (!Objects.equals(key, seeker.key)) {
                seeker = seeker.next;
                if (seeker == null) {
                    return null;
                }
            }
            return seeker;
        }
    }

    @Override
    public int size() {
        return countElements;
    }

    @Override
    public boolean isEmpty() {
        return countElements == 0;
    }

    @Override
    public boolean containsKey(String key) {

        int index = hash(key);

        if (basket[index] == null) {
            return false;
        }
        if (basket[index].findKey(key) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean containsValue(Integer value) {

        if (this.isEmpty()) {
            return false;
        }

        for (Basket o : basket) {
            if (o == null) {
                continue;
            }
            Node node = o.first;
            while (node != null) {
                if ((Objects.equals(node.value, value))) {
                    return true;
                } else {
                    node = node.next;
                }
            }
        }
        return false;
    }

    @Override
    public Integer get(String key) {

        int index = hash(key);

        if (basket[index] == null) {
            return null;
        }

        Node find = basket[index].findKey(key);

        if (find == null) {
            return null;
        } else {
            return find.value;
        }
    }

    @Override
    public Integer put(String key, Integer value) {

        int index = hash(key);

        if (basket[index] == null) {
            basket[index] = new Basket(key, value);
            ++countElements;
            this.resize();
            return null;
        } else {
            Node find = basket[index].findKey(key);
            if (find == null) {
                basket[index].addNode(key, value);
                ++countElements;
                this.resize();
                return null;
            } else {
                int prevValue = find.value;
                find.value = value;
                return prevValue;
            }
        }
    }

    @Override
    public Integer remove(String key) {

        int index = hash(key);
        Basket bask = basket[index];
        if (bask == null) {
            return null;
        }
        Node node = bask.first;
        Node remover = node;
        Node helper = remover;

        while (remover != null) {
            if (Objects.equals(remover.key, key)) {
                int prevValue = remover.value;
                if (bask.last == bask.first) {
                    bask.first = null;
                    basket[index] = null;
                    --countElements;
                    return prevValue;
                }
                helper.next = remover.next;
                basket[index].first = node;
                --countElements;
                return prevValue;
            }
            helper = remover;
            remover = remover.next;
        }
        return null;
    }

    @Override
    public void putAll(Map map) {

        if (map == null) {
            throw new NullPointerException("Введенная вами коллекция null");
        }

        OurMap mapa = (OurMap) map;
        Basket[] massive = mapa.basket;

        for (int i = 0; i < mapa.size; ++i) {
            Basket basket = massive[i];
            if (basket == null) {
                continue;
            }
            Node node = basket.first;
            while (node != null) {
                this.put(node.key, node.value);
                node = node.next;
            }
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            basket[i] = null;
        }
        countElements = 0;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            if (basket[i] != null) {
                Node printer = basket[i].first;
                while (printer != null) {
                    System.out.println(printer.key + "->" + printer.value);
                    printer = printer.next;
                }
            }
        }
    }
}


