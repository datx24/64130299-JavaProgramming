package controller;

public class HocSinh {
    private int id;
    private String name;
    private int age;
    private String className;

    public HocSinh(int id, String name, int age, String className) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.className = className;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }
}
