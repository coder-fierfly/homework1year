package homework.seven.genericArray;

public class Main {
    public static void main(String[] args) {
        OurArray<String> arr1 = new OurArray<>();
        OurArray<String> arr2 = new OurArray<>();
        OurArray<String> arr3 = new OurArray<>();
        OurArray<String> arr4 = new OurArray<>(3);
        OurArray<String> nullArr = null;
        OurArray<String> arr5 = new OurArray<>();

        arr2.add("secondarr1");
        arr2.add("secondarr2");
        arr2.add("secondarr3");

        arr1.add("1");
        arr1.add("2");
        arr1.add("3");
        arr1.add("4");
        arr1.add("5");
        arr1.add("6");
        arr1.add("7");
        arr1.add("8");
        arr1.add("9");
        arr1.add("2");
        arr1.add(null);
        arr1.add("8");

        arr4.add(null);
        arr4.add("8");

        System.out.println("совпадение с существующим элементом");
        System.out.println(arr1.contains(null));
        System.out.println("размер arr1");
        System.out.println(arr1.size());

        System.out.println("проверка на пустоту 2");
        System.out.println(arr2.isEmpty());

        System.out.println("проверка на пустоту 3");
        System.out.println(arr3.isEmpty());

        System.out.println("совподение правдивое");
        System.out.println(arr1.contains("4"));

        System.out.println("совподение ложное");
        System.out.println(arr1.contains("fff"));

        System.out.println("возвращение массива 2");
        Object[] newArr2 = arr2.toArray();
        for (Object o : newArr2) {
            System.out.println(o);
        }

        System.out.println("прибавление к 1 четвертого");
        arr1.addAll(arr4);
        StringBuffer buf = new StringBuffer();
        Object[] mas = arr1.toArray();
        for (int i = 0; i < (arr1.size()); ++i) {
            buf.append(mas[i]);
            buf.append(" ");
        }
        System.out.println(buf);

        System.out.println("очистка всего что есть в 4 из 1");
        arr1.removeAll(arr4);
        StringBuffer buf1 = new StringBuffer();
        Object[] mas1 = arr1.toArray();
        for (int i = 0; i < (arr1.size()); ++i) {
            buf1.append(mas1[i]);
            buf1.append(" ");
        }
        System.out.println(buf1);


        System.out.println("добавление к 2 четвертого на 1 индекс");
        arr2.addAll(1, arr4);
        StringBuffer buff = new StringBuffer();
        Object[] mass = arr2.toArray();
        for (int i = 0; i < (arr2.size()); ++i) {
            buff.append(mass[i]);
            buff.append(" ");
        }
        System.out.println(buff);


        System.out.println("очистка 2");
        arr2.clear();


        System.out.println("вернуть 0 элемент 4 массива");
        System.out.println(arr4.get(0));

        System.out.println("Замена 0 элемента 4 коллекции на 5");
        arr4.set(0, "5");

        System.out.println("Добавление на 1 индекс в 1 коллекци.");
        arr1.add(1, "new");
        StringBuffer mb = new StringBuffer();
        Object[] m3 = arr1.toArray();
        for (int k = 0; k < arr1.size(); ++k) {
            mb.append(m3[k]);
            mb.append(" ");
        }
        System.out.println(mb);

        System.out.println("удаление элемента из 4 по индексу 1");
        arr4.remove(1);
        StringBuffer m2 = new StringBuffer();
        Object[] line = arr4.toArray();
        for (int k = 0; k < arr4.size(); ++k) {
            m2.append(line[k]);
            m2.append(" ");
        }
        System.out.println(m2);

        System.out.println("удаление из 1 по строке");
        arr1.remove("5");


        arr3.add("1");
        arr3.add("2");
        arr3.add(null);

        System.out.println("удаление из 3 по строке");
        arr3.remove(null);
        StringBuffer mb1 = new StringBuffer();
        Object[] m4 = arr1.toArray();
        for (int k = 0; k < arr1.size(); ++k) {
            mb1.append(m4[k]);
            mb1.append(" ");
        }
        System.out.println(mb1);

        System.out.println("первое вхождение элемента");
        System.out.println(arr1.indexOf("2"));

        System.out.println("последнее вхождение элемента");
        System.out.println(arr1.lastIndexOf("2"));

        System.out.println("от какого-то индекса до другого");
        Array<String> m = arr1.subList(1, 3);
        StringBuffer md = new StringBuffer();
        Object[] m1 = m.toArray();
        for (int k = 0; k < m.size(); ++k) {
            md.append(m1[k]);
            md.append(" ");
        }
        System.out.println(md);

        System.out.println("удаление совподающих");
        arr1.removeAll(arr3);
        StringBuffer buffws = new StringBuffer();
        Object[] massas = arr1.toArray();
        for (int i = 0; i < (arr1.size()); ++i) {
            buffws.append(massas[i]);
            buffws.append(" ");
        }
        System.out.println(buffws);

        arr5.add(null);
        arr5.add(null);
        arr5.add("lonely");

        System.out.println("совпадение");
        System.out.println(arr1.containsAll(arr4));

        arr1.add(null);
        System.out.println("cовпадение с null");
        System.out.println(arr1.contains(null));

        System.out.println("добавление null коллекции на 3 индекс в arr1");
        arr1.addAll(3, nullArr);
        StringBuffer buffer = new StringBuffer();
        Object[] massii = arr1.toArray();
        for (int i = 0; i < (arr1.size()); ++i) {
            buffer.append(massii[i]);
            buffer.append(" ");
        }
        System.out.println(buffer);

        System.out.println("удаление совподающих с коллекцией с null");
        arr5.removeAll(nullArr);
        StringBuffer emp = new StringBuffer();
        Object[] massem = arr5.toArray();
        for (int i = 0; i < (arr5.size()); ++i) {
            emp.append(massem[i]);
            emp.append(" ");
        }
        System.out.println(emp);
    }
}