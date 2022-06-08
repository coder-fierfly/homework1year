package homework.seven.genericList;

public class LinkedTest {
    public static void main(String[] args) {
        OurLinked<String> lin = new OurLinked<>();
        lin.add("a");
        lin.add("b");
        lin.add("c");
        lin.add("d");
        lin.add("f");
        lin.add("g");
        lin.add("h");
        lin.add(null);
        lin.add(null);
        lin.add("c");


        System.out.println("Размер массива и проверка на пустоту ");
        System.out.println(lin.size());
        System.out.println(lin.isEmpty());

        System.out.println("вывод элементов 1 коллекции");
        StringBuffer newBuf = new StringBuffer();
        Object[] buf = lin.toArray();
        for (Object o : buf) {
            newBuf.append(o);
            newBuf.append(" ");
        }
        System.out.println(newBuf);

        System.out.println("Совпадение строки a с 1 коллекцией");
        System.out.println(lin.contains("a"));

        OurLinked<String> lin2 = new OurLinked();
        lin2.add("a");
        lin2.add("b");
        lin2.add(null);

        System.out.println("Добваление элементов одной коллекции к другой");
        lin.addAll(lin2);
        StringBuffer newBuf1 = new StringBuffer();
        Object[] buf1 = lin.toArray();
        for (Object o : buf1) {
            newBuf1.append(o);
            newBuf1.append(" ");
        }
        System.out.println(newBuf1);

        System.out.println("Размер 1 коллекции");
        System.out.println(lin.size());

        System.out.println("добавление элементов 2 коллекции на 13 индекс");
        lin.addAll(13, lin2);
        StringBuffer newBuf2 = new StringBuffer();
        Object[] buf2 = lin.toArray();
        for (Object s : buf2) {
            newBuf2.append(s);
            newBuf2.append(" ");
        }
        System.out.println(newBuf2);

        System.out.println("Возврат 2 элемента из 2 коллекции");
        System.out.println(lin2.get(2));

        System.out.println("Совпадение коллекций");
        System.out.println(lin.containsAll(lin2));

        System.out.println("Удаление совпадающих элементов");
        System.out.println(lin.removeAll(lin2));
        StringBuffer newBuf3 = new StringBuffer();
        Object[] buf3 = lin.toArray();
        for (Object s : buf3) {
            newBuf3.append(s);
            newBuf3.append(" ");
        }
        System.out.println(newBuf3);

        System.out.println("Возврат от 1 до 3 индексов из 1 коллекции");
        Object[] buf10;
        buf10 = lin.subList(1, 3).toArray();
        StringBuffer newBuf10 = new StringBuffer();
        for (Object item : buf10) {
            newBuf10.append(item);
            newBuf10.append(" ");
        }
        System.out.println(newBuf10);

        System.out.println("очистка 1 коллекции и вывод ее нового размера");
        lin.clear();
        System.out.println(lin.size());


        System.out.println("дублирую 2 коллекцию саму в себя");
        lin2.addAll(lin2);
        StringBuffer newBuf6 = new StringBuffer();
        Object[] buf6 = lin2.toArray();
        for (Object value : buf6) {
            newBuf6.append(value);
            newBuf6.append(" ");
        }
        System.out.println(newBuf6);

        System.out.println("первое вхождение элемента a");
        System.out.println(lin2.indexOf("a"));

        System.out.println("последнее вхождение элемента 0");
        System.out.println(lin2.lastIndexOf("a"));

        System.out.println("замена элемента на 2 позиции");
        lin2.set(2, "new");
        StringBuffer newBuf7 = new StringBuffer();
        Object[] buf7 = lin2.toArray();
        for (Object s : buf7) {
            newBuf7.append(s);
            newBuf7.append(" ");
        }
        System.out.println(newBuf7);
    }
}
