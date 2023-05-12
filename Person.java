package pl.krzywda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private List<String> skills;

    public Person(String name, int age, String ... strings) {
        this.name = name;
        this.age = age;
        this.skills = new LinkedList<String>();
        for(String string: strings){
            skills.add(string);
        }
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + age + "lat " + " skills: " + skills;
    }
}
