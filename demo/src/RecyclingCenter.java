import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecyclingCenter {
    private static final String INSERT_MATERIAL_SQL = "INSERT INTO materials (material_type, weight, impact_factor) VALUES (?, ?, ?)";
    private static final String SELECT_MATERIALS_SQL = "SELECT * FROM materials";
    private static final String DELETE_MATERIAL_SQL = "DELETE FROM materials WHERE material_type = ?";
    
    // Add material to the center and the database
    public void addMaterial(RecyclingMaterial material) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MATERIAL_SQL)) {
            preparedStatement.setString(1, material.getMaterialType());
            preparedStatement.setDouble(2, material.getWeight());
            preparedStatement.setDouble(3, material.getImpactFactor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all materials from the database
    public void listMaterials() {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_MATERIALS_SQL)) {
            
            while (resultSet.next()) {
                System.out.println("Material: " + resultSet.getString("material_type") +
                        ", Weight: " + resultSet.getDouble("weight") +
                        " kg, Environmental Impact Factor: " + resultSet.getDouble("impact_factor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Remove material from the center and the database
    public void removeMaterial(RecyclingMaterial material) {
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MATERIAL_SQL)) {
            preparedStatement.setString(1, material.getMaterialType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Generate an environmental impact report (optional)
    public void generateImpactReport() {
        // Implement a similar logic to list materials and calculate environmental impact if needed
    }
}
