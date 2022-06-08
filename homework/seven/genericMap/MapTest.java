package homework.seven.genericMap;

public class MapTest {
    public static void main(String[] args) {

        OurMap<Integer, Integer> map = new OurMap<>(3);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);

        OurMap<Integer, Integer> map1 = new OurMap<>(3);
        map1.put(7, 7);
        map1.put(8, 8);
        map1.put(1, 80);

        System.out.println("Удаление последнего элемента по ключу");
        map.remove(6);
        System.out.println("размер 1");
        System.out.println(map.size());
        System.out.println("проверка на пустоту 1");
        System.out.println(map.isEmpty());
        System.out.println("совпадение с несуществующим ключом");
        System.out.println(map.containsKey(345));
        System.out.println("совпадение с существующим ключом");
        System.out.println(map.containsKey(1));
        System.out.println("совпадение с несуществующим value");
        System.out.println(map.containsValue(10));
        System.out.println("совпадение с существующим value");
        System.out.println(map1.containsValue(7));
        System.out.println("Возврат по ключу");
        System.out.println(map.get(1));
        System.out.println("размер map после слияния массивов map и map1");
        map.putAll(map1);
        System.out.println(map.size());
        System.out.println("размер map после очистки");
        map.clear();
        System.out.println(map.size());
    }
}
