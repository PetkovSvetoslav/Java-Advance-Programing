package Exercises.PokémonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private int badges;
    private List<Pokemon> pokemons;

    public Trainer() {
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void addBadge() {
        this.badges++;
    }

    public int getBadges() {
        return this.badges;
    }
    public void damageAllPokemons(int damage) {
        int i = 0;
        while (i < pokemons.size()) {
            Pokemon pokemon = this.pokemons.get(i);
            if (pokemon.decreaseHealth(damage) <= 0) {
                pokemons.remove(i);
            } else {
                i++;
            }
        }
    }
}
