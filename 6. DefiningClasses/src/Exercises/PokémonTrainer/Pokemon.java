package Exercises.PokémonTrainer;

public class Pokemon {
    private String name;
    private String element;
    int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return this.element;
    }

    public int decreaseHealth(int damage) {
        return this.health = this.health - damage;
    }
}
