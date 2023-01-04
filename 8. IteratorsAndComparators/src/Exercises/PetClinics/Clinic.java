package Exercises.PetClinics;

import java.util.Iterator;

public class Clinic implements Iterable<Pet> {

    private class RoomIterator implements Iterator<Pet> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < rooms.length;
        }

        @Override
        public Pet next() {
            return rooms[this.index++];
        }
    }

    private final String name;
    private Pet[] rooms;

    public Clinic(String name, int roomsCount) {
        this.name = name;
        setRooms(roomsCount);
    }

    private void setRooms(int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        } else {
            this.rooms = new Pet[roomsCount];
        }
    }

    public boolean addPet(Pet pet) {
        int room = this.rooms.length / 2;
        for (int i = 0; i < this.rooms.length; i++) {
            if (i % 2 == 0) {
                room += i;
            } else {
                room -= i;
            }

            if (this.rooms[room] == null) {
                this.rooms[room] = pet;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        int begin = this.rooms.length / 2;
        for (int i = begin; i < this.rooms.length; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }
        for (int i = 0; i < begin; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        for (Pet room : this.rooms) {
            if (room == null) {
                return true;
            }
        }
        return false;
    }

    public void printClinicInfo(int room) {
        room -= 1;
        if (this.rooms[room] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(this.rooms[room]);
        }
    }

    @Override
    public Iterator<Pet> iterator() {
        return new RoomIterator();
    }
}
