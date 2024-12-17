import java.util.Scanner;

public class RecyclingManagementSystem {
}
    private static Scanner scanner = new Scanner(System.in);
    private static RecyclingCenter center = new RecyclingCenter();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addMaterial();
                    break;
                case 2:
                    removeMaterial();
                    break;
                case 3:
                    // editMaterial(); // Optional, implement as needed
                    break;
                case 4:
                    center.generateImpactReport();
                    break;
                case 5:
                    center.listMaterials();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nRecycling Management System");
        System.out.println("1. Add material");
        System.out.println("2. Remove material");
        System.out.println("3. Edit material");
        System.out.println("4. Generate impact report");
        System.out.println("5. List all materials");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addMaterial() {
        System.out.print("Enter the material type (e.g., Plastic, Glass, Paper, etc.): ");
        String materialType = scanner.nextLine();

        System.out.print("Enter the weight of the material in kilograms: ");
        double weight = scanner.nextDouble();

        System.out.print("Enter the environmental impact factor (e.g., 1.2 for Plastic): ");
        double impactFactor = scanner.nextDouble();

        // Create a new material object and add it to the center (and the database)
        RecyclingMaterial newMaterial = new CustomMaterial(materialType, weight, impactFactor);
        center.addMaterial(newMaterial);

        System.out.println("Material added successfully!");
    }

    private static void removeMaterial() {
        System.out.print("Enter the material type to remove: ");
        String materialType = scanner.nextLine();

        RecyclingMaterial material = new CustomMaterial(materialType, 0, 0); // Placeholder for removal
        center.removeMaterial(material);

        System.out.println("Material removed successfully!");
    }