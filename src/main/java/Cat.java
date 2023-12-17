import java.util.ArrayList;

public class Cat extends Animal {

    private String commands;

    public Cat(int id, String name, String dateOfBirth, String commands) {
        super(id, name, dateOfBirth);
        this.commands = commands;
        super.setAnimalType("Cat");
    }
    public Cat(int id, String name, String dateOfBirth) {
        super(id, name, dateOfBirth);
        super.setAnimalType("Cat");
    }
    public Cat(String name, String dateOfBirth) {
        super(name, dateOfBirth);
        super.setAnimalType("Cat");
    }
    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

}
