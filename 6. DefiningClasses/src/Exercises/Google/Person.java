package Exercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person() {
        this.company = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = null;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public Car getCar() {
        return car;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Company:")
                .append(System.lineSeparator());
        if (this.company != null) {
            output.append(this.company.getName()).append(" ")
                    .append(this.company.getDepartment()).append(" ")
                    .append(String.format("%.2f", this.company.getSalary()))
                    .append(System.lineSeparator());
        }
        output.append("Car:")
                .append(System.lineSeparator());
        if (this.car != null) {
            output.append(this.car.getCarModel()).append(" ")
                    .append(car.getSpeed())
                    .append(System.lineSeparator());
        }
        output.append("Pokemon:")
                .append(System.lineSeparator());
        for (Pokemon pokemon : this.pokemons) {
            output.append(pokemon.getName()).append(" ")
                    .append(pokemon.getType())
                    .append(System.lineSeparator());
        }
        output.append("Parents:")
                .append(System.lineSeparator());
        for (Parent parent : this.parents) {
            output.append(parent.getName()).append(" ")
                    .append(parent.getBirthday())
                    .append(System.lineSeparator());
        }
        output.append("Children:")
                .append(System.lineSeparator());
        for (Child child : this.children) {
            output.append(child.getName()).append(" ")
                    .append(child.getBirthday())
                    .append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
