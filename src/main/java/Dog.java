import java.util.ArrayList;

public class Dog extends Animal{

    private String commands;

    public Dog(int id, String name, String dateOfBirth, String commands) {
        super(id, name, dateOfBirth);
        this.commands = commands;
        super.setAnimalType("Dog");
    }
    public Dog(int id, String name, String dateOfBirth) {
        super(id, name, dateOfBirth);
        super.setAnimalType("Dog");
    }
    public Dog(String name, String dateOfBirth) {
        super(name, dateOfBirth);
        super.setAnimalType("Dog");
    }
    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}
