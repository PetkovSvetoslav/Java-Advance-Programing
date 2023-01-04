package vetClinic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    List<Pet> pets;
    int capacity;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.pets = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.capacity > this.pets.size()) {
            this.pets.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.pets.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : this.pets) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        return this.pets.stream()
                .max(Comparator.comparingInt(Pet::getAge))
                .orElse(null);
    }

    public int getCount() {
        return this.pets.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder("The clinic has the following patients:");
        for (Pet pet : pets) {
            out.append(System.lineSeparator());
            out.append(pet.getName()).append(" ").append(pet.getOwner());
        }
        return out.toString();
    }
}
