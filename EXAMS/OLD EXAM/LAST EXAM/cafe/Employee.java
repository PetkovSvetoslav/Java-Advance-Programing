package cafe;

public class Employee {

   private String name;
   private int age;
   private String country;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public Employee(String name, int age, String coutry) {
        this.name = name;
        this.age = age;
        this.country = coutry;
    }

    @Override
    public String toString(){
       return String.format("Employee: %s, %d from %s",this.name,this.age,this.country);
    }
}
