package Exercises.FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final String birthday;
    private final List<Person> parents = new ArrayList<>();
    private final List<Person> children = new ArrayList<>();

    public Person(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    /**
     * Add a child to this Person
     * Adds parents to that child
     *
     * @param child
     */
    public void addChild(Person child) {
        this.children.add(child);
        child.parents.add(this);
    }

    public String getName() {
        return this.name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public List<Person> getParents() {
        return this.parents;
    }

    public List<Person> getChildren() {
        return this.children;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthday;
    }
}
