import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DisasterResponseSystem {
    private static VolunteerManager volunteerManager = new VolunteerManager();
    private static ResourceManager resourceManager = new ResourceManager();
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("  Disaster Response and Relief Management System  ");
            System.out.println("==================================================");
            System.out.println("1. Volunteer Management");
            System.out.println("2. Resource Management");
            System.out.println("3. Task Assignment");
            System.out.println("4. Disaster Response Tracker");
            System.out.println("5. Response Time Reports");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------------------");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println("--------------------------------------------------");
            switch (option) {
                case 1: volunteerManager.menu(); break;
                case 2: resourceManager.menu(); break;
                case 3: taskManager.menu(volunteerManager); break;
                case 4: trackDisasterResponse(); break;
                case 5: generateReports(); break;
                case 6: System.out.println("Exit. Prepare, Respond, Recover, Repeat!"); System.exit(0); break;
                default: System.out.println("Invalid option. Please choose a valid menu item.");
            }
        }
    }

    public static void trackDisasterResponse() {
        System.out.println("\nTracking disaster response...");
        System.out.println("This feature is under development.");
    }

    public static void generateReports() {
        System.out.println("\nGenerating response time reports...");
        System.out.println("This feature is under development.");
    }
}
// Volunteer Class
class Volunteer {
    private String name;
    private String type; // medical, rescue, general volunteers
    private boolean available;

    public Volunteer(String name, String type, boolean available) {
        this.name = name;
        this.type = type;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return name + " (" + type + ") - Available: " + (available ? "Yes" : "No");
    }
}
// Volunteer Manager
class VolunteerManager {
    ArrayList<Volunteer> volunteers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("               Volunteer Management              ");
            System.out.println("==================================================");
            System.out.println("1. Add a Volunteer");
            System.out.println("2. View Volunteers");
            System.out.println("3. Update Volunteer Availability");
            System.out.println("4. Back to Main Menu");
            System.out.println("--------------------------------------------------");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println("--------------------------------------------------");
            switch (option) {
                case 1: addVolunteer(); break;
                case 2: viewVolunteers(); break;
                case 3: updateVolunteerAvailability(); break;
                case 4: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void addVolunteer() {
        System.out.println("=== Add a New Volunteer ===");
        System.out.print("Enter volunteer name: ");
        String name = scanner.next();
        System.out.print("Enter volunteer type (medical/rescue/general): ");
        String type = scanner.next();
        System.out.print("Is the volunteer available? (true/false): ");
        boolean available = scanner.nextBoolean();
        volunteers.add(new Volunteer(name, type, available));
        System.out.println("Volunteer '" + name + "' added successfully!");
    }

    public void viewVolunteers() {
        System.out.println("=== List of Volunteers ===");
        if (volunteers.isEmpty()) {
            System.out.println("No volunteers available.");
        } else {
            for (Volunteer volunteer : volunteers) {
                System.out.println(volunteer);
            }
        }
    }

    private void updateVolunteerAvailability() {
        System.out.print("Enter volunteer name to update availability: ");
        String name = scanner.next();
        for (Volunteer volunteer : volunteers) {
            if (volunteer.getName().equalsIgnoreCase(name)) {
                System.out.print("Is the volunteer available? (true/false): ");
                boolean available = scanner.nextBoolean();
                volunteer.setAvailability(available);
                System.out.println("Availability for '" + name + "' updated!");
                return;
            }
        }
        System.out.println("Volunteer not found.");
    }
}
// Resource Class
class Resource {
    private String type; // monetary or in-kind (food, water, clothes etc.)
    private int quantity;

    public Resource(String type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        String unit = "";
        if (type.equalsIgnoreCase("food")) {
            unit = "packs";
        } else if (type.equalsIgnoreCase("water")) {
            unit = "liters";
        }
        return type + " - Quantity: " + quantity + " " + unit;
    }
}
// Resource Manager
class ResourceManager {
    private HashMap<String, Resource> resources = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu() {
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("               Resource Management               ");
            System.out.println("==================================================");
            System.out.println("1. Add Resources");
            System.out.println("2. View Available Resources");
            System.out.println("3. Update Resource Quantities");
            System.out.println("4. Back to Main Menu");
            System.out.println("--------------------------------------------------");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println("--------------------------------------------------");
            switch (option) {
                case 1: addResource(); break;
                case 2: viewResources(); break;
                case 3: updateResourceQuantity(); break;
                case 4: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void addResource() {
        System.out.println("=== Add a New Resource ===");
        System.out.print("Enter resource type (e.g., food, water, etc.): ");
        String type = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        resources.put(type, new Resource(type, quantity));
        System.out.println("Resource '" + type + "' added successfully!");
    }

    private void viewResources() {
        System.out.println("=== Available Resources ===");
        if (resources.isEmpty()) {
            System.out.println("No resources available.");
        } else {
            for (Resource resource : resources.values()) {
                System.out.println(resource);
            }
        }
    }

    private void updateResourceQuantity() {
        System.out.print("Enter resource type to update quantity: ");
        String type = scanner.next();
        if (resources.containsKey(type)) {
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();
            resources.get(type).setQuantity(quantity);
            System.out.println("Quantity for '" + type + "' updated!");
        } else {
            System.out.println("Resource not found.");
        }
    }
}
// Task Class
class Task {
    private String taskDescription;
    private Volunteer volunteer;
    private String status;

    public Task(String taskDescription, Volunteer volunteer) {
        this.taskDescription = taskDescription;
        this.volunteer = volunteer;
        this.status = "In Progress";
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task: " + taskDescription + " | Volunteer: " + volunteer.getName() + " | Status: " + status;
    }
}
// Task Manager
class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void menu(VolunteerManager volunteerManager) {
        while (true) {
            System.out.println("\n==================================================");
            System.out.println("                 Task Assignment                 ");
            System.out.println("==================================================");
            System.out.println("1. Assign a Task to a Volunteer");
            System.out.println("2. View Assigned Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Back to Main Menu");
            System.out.println("--------------------------------------------------");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            System.out.println("--------------------------------------------------");
            switch (option) {
                case 1: assignTask(volunteerManager); break;
                case 2: viewTasks(); break;
                case 3: updateTaskStatus(); break;
                case 4: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    private void assignTask(VolunteerManager volunteerManager) {
        System.out.println("=== Assign a New Task ===");
        System.out.print("Enter task description: ");
        String taskDescription = scanner.next();
        System.out.println("Available Volunteers:");
        volunteerManager.viewVolunteers();
        System.out.print("Enter volunteer name to assign task: ");
        String volunteerName = scanner.next();
        for (Volunteer volunteer : volunteerManager.volunteers) {
            if (volunteer.getName().equalsIgnoreCase(volunteerName) && volunteer.isAvailable()) {
                tasks.add(new Task(taskDescription, volunteer));
                System.out.println("Task assigned to " + volunteer.getName() + " successfully!");
                return;
            }
        }
        System.out.println("Volunteer not available or not found.");
    }
    
    public void viewTasks() {
        System.out.println("=== List of Assigned Tasks ===");
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned yet.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
    
    private void updateTaskStatus() {
        System.out.print("Enter task description to update status: ");
        String taskDescription = scanner.next();
        for (Task task : tasks) {
            if (task.getTaskDescription().equalsIgnoreCase(taskDescription)) {
                System.out.print("Enter new status (e.g., Completed): ");
                String status = scanner.next();
                task.setStatus(status);
                System.out.println("Task status updated!");
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
