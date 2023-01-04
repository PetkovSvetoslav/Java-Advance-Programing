package Exercises.PokémonTrainer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //Runtime errors in judge - I don't know why

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input;
        while (!"Tournament".equals(input = scanner.nextLine())) {
            String[] pokemonData = input.split("\\s+");
            String trainer = pokemonData[0];
            String name = pokemonData[1];
            String element = pokemonData[2];
            int health = Integer.parseInt(pokemonData[3]);

            Pokemon pokemon = new Pokemon(name, element, health);

            trainers.putIfAbsent(trainer, new Trainer());
            trainers.get(trainer).addPokemon(pokemon);
        }

        String element;
        while (!"End".equals(element = scanner.nextLine())) {
            boolean hasPokemon = false;
            for (Trainer trainer : trainers.values()) {
                for (Pokemon pokemon : trainer.getPokemons()) {
                    if (pokemon.getElement().equals(element)) {
                        hasPokemon = true;
                        trainer.addBadge();
                        break;
                    }
                }
                if (!hasPokemon) {
                    trainer.damageAllPokemons(10);
                }
            }
        }

        trainers.entrySet()
                .stream()
                .sorted((t1, t2) -> t2.getValue().getBadges() - t1.getValue().getBadges())
                .forEach(t -> System.out.printf("%s %d %d%n"
                        , t.getKey(), t.getValue().getBadges(), t.getValue().getPokemons().size()));
    }
}
