import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUD {
    private static String GET_ANIMAL_DATA = "SELECT * FROM animals";
    private static String GET_CAT_COMMAND = "SELECT commands FROM cats WHERE id = ?";
    private static String GET_DOG_COMMAND = "SELECT commands FROM dogs WHERE id = ?";
    private static String INSERT_ANIMAL = "INSERT INTO animals(name, date_of_birth, type) VALUES(?, ?, ?)";
    private static String UPDATE_CAT_COMMAND = "INSERT INTO cats(id, commands) VALUES(?, ?) ON DUPLICATE KEY UPDATE commands = CONCAT(commands, ', ', ?)";
    private static String UPDATE_DOG_COMMAND = "INSERT INTO dogs(id, commands) VALUES(?, ?) ON DUPLICATE KEY UPDATE commands = CONCAT(commands, ', ', ?)";
    private static String DELETE_ANIMAL = "DELETE FROM animals WHERE id = ?";
    private static String DELETE_CAT = "DELETE FROM cats WHERE id = ?";
    private static String DELETE_DOG = "DELETE FROM dogs WHERE id = ?";
    private static String GET_TYPE = "SELECT type FROM animals WHERE id = ?";


    public static List<Animal> getAnimalData() throws SQLException {
        List<Animal> animals = new ArrayList<>();

        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ANIMAL_DATA)) {
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()){
                int id = res.getInt("id");
                String name = res.getString("name");
                String dateOfBirth = res.getString("date_of_birth");
                String animalType = res.getString("type");
                animals.add(new Animal(id, name, dateOfBirth, animalType) {
                });
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return animals;
    }

    public static String getCatCommands(int id) throws SQLException {
        String catCommands = null;

        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CAT_COMMAND)) {
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next())
            catCommands = res.getString("commands");
            else return catCommands;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return catCommands;
    }

    public static String getDogCommands(int id) throws SQLException {
        String dogCommands = null;

        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_DOG_COMMAND)) {
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next())
                dogCommands = res.getString("commands");
            else return dogCommands;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return dogCommands;
    }

    public static void addAnimal (Animal animal){

        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ANIMAL)) {
            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getDateOfBirth());
            preparedStatement.setString(3, animal.getAnimalType());
            preparedStatement.executeUpdate();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void addCatCommand (String command, int id) {
        try (Connection connection = TestConnection.getConnect();


             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CAT_COMMAND)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, command);
            preparedStatement.setString(3, command);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void addDogCommand (String command, int id) {
        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOG_COMMAND)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, command);
            preparedStatement.setString(3, command);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void deleteAnimal (int id){
        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ANIMAL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void deleteCat (int id){
        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CAT)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static void deleteDog (int id){
        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DOG)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public static String getAnimalType(int id) {
        String animalType = null;

        try (Connection connection = TestConnection.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPE)) {
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                animalType = res.getString("type");
            }
            else {
                System.out.println("Животного с таким id нет");
                return animalType;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return animalType;
    }
}
