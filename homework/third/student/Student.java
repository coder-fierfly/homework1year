package homework.third.student;

public class Student {

    final int NUM = 5;
    public String lastName;
    public String initials;
    public String groupNumber;
    public float[] marks = new float[NUM];

    public Student(String lastName, String initials, String groupNumber, float[] marks) {
        this.lastName = lastName;
        this.initials = initials;
        this.groupNumber = groupNumber;
        this.marks = marks;
    }

    public String getInfo() {
        StringBuilder line = new StringBuilder();
        line.append("FIO: ");
        line.append(lastName);
        line.append(" ");
        line.append(initials);
        line.append(", group number: ");
        line.append(groupNumber);
        line.append(", marks: ");

        for (int i = 0; i < NUM; ++i) {
            line.append(marks[i]);
            line.append(" ");
        }

        return line.toString();
    }
}