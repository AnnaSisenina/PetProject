import java.util.ArrayList;
import java.util.Date;

public abstract class Animal {
    private int id;
    private String name;
    private String dateOfBirth;
    private String animalType;

    public Animal(int id, String name, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public Animal(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    public Animal(int id, String name, String dateOfBirth, String animalType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.animalType = animalType;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return this.name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", animalType='" + animalType + '\'' +
                '\n';
    }
}
