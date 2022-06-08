package homework.seven.genericMap;

import java.util.Objects;

public class OurMap<K, V> implements homework.seven.genericMap.Map<K, V> {

    private Basket<K, V>[] basket;
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

            Basket<K, V>[] massive = basket;
            this.basket = new Basket[size];
            for (int i = 0; i < outSize; ++i) {
                Basket<K, V> basket = massive[i];
                if (basket == null) {
                    continue;
                }
                Node<K, V> node = basket.first;
                while (node != null) {
                    this.put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    private static class Node<K, V> {
        protected K key;
        protected V value;
        protected Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    // суммирует все значения по ASCII и делит на введенный размер
    private int hash(K key) {

        int sum = 0;

        if (key == null) {
            return 0;
        }

        for (int i = 0; i < key.toString().length(); i++) {
            sum += key.toString().charAt(i);
        }
        return sum % size;
    }

    static class Basket<K, V> {

        Node<K, V> first;
        Node<K, V> last;

        public Basket(K key, V value) {
            first = new Node<>(key, value);
            last = first;
        }

        public void addNode(K key, V value) {
            last.next = new Node<>(key, value);
            last = last.next;
        }

        public Node<K, V> findKey(K key) {

            Node<K, V> seeker = this.first;

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
    public boolean containsKey(K key) {

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
    public boolean containsValue(V value) {

        if (this.isEmpty()) {
            return false;
        }

        for (Basket<K, V> o : basket) {
            if (o == null) {
                continue;
            }
            Node<K, V> node = o.first;
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
    public V get(K key) {

        int index = hash(key);

        if (basket[index] == null) {
            return null;
        }

        Node<K, V> find = basket[index].findKey(key);
        return find.value;
    }

    @Override
    public V put(K key, V value) {

        int index = hash(key);

        if (basket[index] == null) {
            basket[index] = new Basket<>(key, value);
            ++countElements;
            this.resize();
            return null;
        } else {
            Node<K, V> find = basket[index].findKey(key);
            if (find == null) {
                basket[index].addNode(key, value);
                ++countElements;
                this.resize();
                return null;
            } else {
                V prevValue = find.value;
                find.value = value;
                return prevValue;
            }
        }
    }

    @Override
    public V remove(K key) {

        int index = hash(key);
        Basket<K, V> bask = basket[index];
        if (bask == null) {
            return null;
        }
        Node<K, V> node = bask.first;
        Node<K, V> remover = node;
        Node<K, V> helper = remover;

        while (remover != null) {
            if (Objects.equals(remover.key, key)) {


                V prevValue = remover.value;
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
    public void putAll(Map<K, V> map) {

        OurMap<K, V> mapa = (OurMap<K, V>) map;
        Basket<K, V>[] massive = mapa.basket;

        for (int i = 0; i < mapa.size; ++i) {
            Basket<K, V> basket = massive[i];
            if (basket == null) {
                continue;
            }
            Node<K, V> node = basket.first;
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
}
