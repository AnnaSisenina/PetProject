import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true){
            menu();
        }
        }

    private static void menu() throws SQLException {
        System.out.println("""
                    ����� ���������� � �������� "���������� ����".
                    1. ���������� ������ �������� \s
                    2. �������� �������� \s
                    3. ������� �������� \s
                    4. ���������� ������ ������ ��������� \s
                    5. �������� ������� � ������ ������ ���������\s
                    """);

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        switch (answer) {
            case "1": {
                List<Animal> animals = CRUD.getAnimalData();
                System.out.println(animals);
                break;
            }
            case "2": {
                System.out.println("""
                            ���� ����� ���������?
                            1. ���/�����
                            2. ������
                            """);
                String answerType = scanner.nextLine();
                switch (answerType) {
                    case "1" -> {
                        System.out.println("������� ��� ���������:");
                        String name = scanner.nextLine();
                        System.out.println("������� ���� �������� ���������: ");
                        String dateOfBirth = scanner.nextLine();
                        Animal cat = new Cat(name, dateOfBirth);
                        CRUD.addAnimal(cat);
                    }
                    case "2" -> {
                        System.out.println("������� ��� ���������: ");
                        String name = scanner.nextLine();
                        System.out.println("������� ���� �������� ���������: ");
                        String dateOfBirth = scanner.nextLine();
                        Animal dog = new Dog(name, dateOfBirth);
                        CRUD.addAnimal(dog);
                    }
                }
                break;
            }
            case "3": {
                System.out.println("������� id ���������: ");
                int id = scanner.nextInt();
                String type = CRUD.getAnimalType(id);
                CRUD.deleteAnimal(id);
                switch (type) {
                    case "Cat" -> {
                        CRUD.deleteCat(id);
                    }
                    case "Dog" -> {
                        CRUD.deleteDog(id);
                    }
                }
                break;
            }
            case "4": {
                System.out.println("������� id ���������: ");
                int id = scanner.nextInt();
                String type = CRUD.getAnimalType(id);
                if (type != null) {
                    switch (type) {
                        case "Cat" -> {
                            System.out.println(CRUD.getCatCommands(id));
                        }
                        case "Dog" -> {
                            System.out.println(CRUD.getDogCommands(id));
                        }
                    }
                }
                break;
            }
            case "5": {
                System.out.println("������� ����� �������: ");
                String command = scanner.nextLine();
                System.out.println("������� id ���������: ");
                int id = scanner.nextInt();
                String type = CRUD.getAnimalType(id);
                switch (type) {
                    case "Cat" -> {
                        CRUD.addCatCommand(command, id);
                    }
                    case "Dog" -> {
                        CRUD.addDogCommand(command, id);
                    }
                }
                break;
            }
            default: {
                System.out.println("�� ����� ���-�� �� ��, ���������� ��� ���");
            }
        }
    }
}

