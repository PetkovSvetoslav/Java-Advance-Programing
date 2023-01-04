package Exercises.PetClinics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Create": {
                    if (tokens[1].equals("Pet")) {
                        String petName = tokens[2];
                        int age = Integer.parseInt(tokens[3]);
                        String kind = tokens[4];
                        Pet pet = new Pet(petName, age, kind);
                        pets.put(petName, pet);
                    } else if (tokens[1].equals("Clinic")) {
                        String clinicName = tokens[2];
                        int rooms = Integer.parseInt(tokens[3]);
                        try {
                            Clinic clinic = new Clinic(clinicName, rooms);
                            clinics.put(clinicName, clinic);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
                case "Add": {
                    String petName = tokens[1];
                    String clinicName = tokens[2];
                    if (pets.containsKey(petName) && clinics.containsKey(clinicName)) {
                        Clinic clinic = clinics.get(clinicName);
                        Pet pet = pets.get(petName);

                        System.out.println(clinic.addPet(pet));
                    } else {
                        System.out.println(false);
                    }
                    break;
                }
                case "Release": {
                    String clinicName = tokens[1];
                    if (clinics.containsKey(clinicName)) {
                        Clinic clinic = clinics.get(clinicName);
                        System.out.println(clinic.release());
                    } else {
                        System.out.println(false);
                    }
                    break;
                }
                case "HasEmptyRooms": {
                    String clinicName = tokens[1];
                    if (clinics.containsKey(clinicName)) {
                        Clinic clinic = clinics.get(clinicName);
                        System.out.println(clinic.hasEmptyRooms());
                    } else {
                        System.out.println(false);
                    }
                    break;
                }
                case "Print": {
                    String clinicName = tokens[1];
                    Clinic clinic = clinics.get(clinicName);
                    if (tokens.length == 2) {
                        for (Pet pet : clinic) {
                            if (pet == null) {
                                System.out.println("Room empty");
                            } else {
                                System.out.println(pet);
                            }
                        }
                    } else if (tokens.length == 3) {
                        int room = Integer.parseInt(tokens[2]);
                        clinic.printClinicInfo(room);
                    }
                    break;
                }
            }
        }
    }
}
