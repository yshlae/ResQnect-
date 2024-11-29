import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

public class DisasterResponseSystem {
    private static VolunteerManager volunteerManager = new VolunteerManager();
    private static ResourceManager resourceManager = new ResourceManager();
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n+====================================================+");
                System.out.println("|  Disaster Response and Relief Management System    |");
                System.out.println("+====================================================+");
                System.out.println("1. Volunteer Management");
                System.out.println("2. Resource Management");
                System.out.println("3. Task Assignment");
                System.out.println("4. Disaster Response Tracker");
                System.out.println("5. Response Time Reports");
                System.out.println("6. Exit");
                System.out.println("+----------------------------------------------------+");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                System.out.println("+----------------------------------------------------+");
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
    }

    private static void trackDisasterResponse() {
        taskManager.viewTasks();
    }

    private static void generateReports() {
        taskManager.generateResponseTimeReport();
    }

    // Volunteer Class
    static class Volunteer {
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

    // Volunteer Manager Class
    static class VolunteerManager {
        ArrayList<Volunteer> volunteers = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void menu() {
            while (true) {
                System.out.println("\n+====================================================+");
                System.out.println("                Volunteer Management              ");
                System.out.println("+====================================================+");
                System.out.println("1. Add a Volunteer");
                System.out.println("2. View Volunteers");
                System.out.println("3. Update Volunteer Availability");
                System.out.println("4. Back to Main Menu");
                System.out.println("+----------------------------------------------------+");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                System.out.println("+----------------------------------------------------+");
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
            System.out.println("              === Add a New Volunteer ===               ");
            System.out.print("Enter volunteer name: ");
            String name = scanner.next();
            System.out.print("Enter volunteer type (medical/rescue/general): ");
            String type = scanner.next();
            System.out.print("Is the volunteer available? (yes/no): ");
            String availabilityInput = scanner.next(); 
            boolean available = availabilityInput.equalsIgnoreCase("yes");
            volunteers.add(new Volunteer(name, type, available));
            System.out.println("Volunteer '" + name + "' added successfully!");
        }

        public void viewVolunteers() {
            System.out.println("              === List of Volunteers ===               ");
            if (volunteers.isEmpty()) {
                System.out.println("No volunteers available.");
            } else {
                System.out.println("+------------------+-------------------+-----------------+");
                System.out.println("| Name             | Type              | Availability    |");
                System.out.println("+------------------+-------------------+-----------------+");

                for (Volunteer volunteer : volunteers) {
                    System.out.printf("| %-16s | %-17s | %-15s |\n", volunteer.getName(), volunteer.getType(), volunteer.isAvailable() ? "Yes" : "No");
                }

                System.out.println("+------------------+-------------------+-----------------+");
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
    static class Resource {
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

    // Resource Manager Class
    static class ResourceManager {
        private HashMap<String, Resource> resources = new HashMap<>();
        private Scanner scanner = new Scanner(System.in);

        public void menu() {
            while (true) {
                System.out.println("\n+====================================================+");
                System.out.println("                 Resource Management               ");
                System.out.println("+====================================================+");
                System.out.println("1. Add Resources");
                System.out.println("2. View Available Resources");
                System.out.println("3. Update Resource Quantities");
                System.out.println("4. Back to Main Menu");
                System.out.println("+----------------------------------------------------+");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                System.out.println("+----------------------------------------------------+");
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
            System.out.println("              === Add a New Resource ===               ");
            System.out.print("Enter resource type (e.g., food, water, etc.): ");
            String type = scanner.next();
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            resources.put(type, new Resource(type, quantity));
            System.out.println("Resource '" + type + "' added successfully!");
        }

        private void viewResources() {
            System.out.println("              === Available Resources ===               ");
            if (resources.isEmpty()) {
                System.out.println("No resources available.");
            } else {
                System.out.println("+------------------+-------------------+");
                System.out.println("| Resource Type    | Quantity          |");
                System.out.println("+------------------+-------------------+");

                for (Resource resource : resources.values()) {
                    System.out.printf("| %-16s | %-17d |\n", resource.getType(), resource.getQuantity());
                }

                System.out.println("+------------------+-------------------+");
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
    static class Task {
        private String description;
        private String assignedVolunteer;
        private LocalDateTime responseTime;
        private LocalDateTime completionTime;
        private boolean completed;

        public Task(String description, String assignedVolunteer) {
            this.description = description;
            this.assignedVolunteer = assignedVolunteer;
            this.responseTime = LocalDateTime.now();
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }

        public String getAssignedVolunteer() {
            return assignedVolunteer;
        }

        public LocalDateTime getResponseTime() {
            return responseTime;
        }

        public LocalDateTime getCompletionTime() {
            return completionTime;
        }

        public void completeTask() {
            this.completed = true;
            this.completionTime = LocalDateTime.now();
        }

        public boolean isCompleted() {
            return completed;
        }
    }

    // Task Manager Class
    static class TaskManager {
        private ArrayList<Task> tasks = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        public void menu(VolunteerManager volunteerManager) {
            while (true) {
                System.out.println("\n+====================================================+");
                System.out.println("                Task Assignment                  ");
                System.out.println("+====================================================+");
                System.out.println("1. Assign a Task");
                System.out.println("2. View Assigned Tasks");
                System.out.println("3. Generate Response Time Report");
                System.out.println("4. Back to Main Menu");
                System.out.println("+----------------------------------------------------+");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                System.out.println("+----------------------------------------------------+");
                switch (option) {
                    case 1: assignTask(volunteerManager); break;
                    case 2: viewTasks(); break;
                    case 3: generateResponseTimeReport(); break;
                    case 4: return;
                    default: System.out.println("Invalid option.");
                }
            }
        }

        private void assignTask(VolunteerManager volunteerManager) {
            System.out.println("              === Assign a New Task ===               ");
            System.out.print("Enter task description: ");
            scanner.nextLine();  // Consume newline
            String description = scanner.nextLine(); 
            System.out.print("Enter volunteer name: ");
            String volunteerName = scanner.nextLine();
            tasks.add(new Task(description, volunteerName)); 
            System.out.println("Task assigned to '" + volunteerName + "'.");
        }

        public void viewTasks() {
            System.out.println("              === Assigned Tasks ===               ");
            if (tasks.isEmpty()) {
                System.out.println("No tasks assigned.");
            } else {
                System.out.println("+-------------------+----------------------+------------------+---------------------------------+");
                System.out.println("| Task Description  | Volunteer            | Status           | Response Time                   |");
                System.out.println("+-------------------+----------------------+------------------+---------------------------------+");

                for (Task task : tasks) {
                    String status = task.isCompleted() ? "Completed" : "Pending";
                    System.out.printf("| %-17s | %-20s | %-16s | %-19s   |\n", 
                        task.getDescription(), task.getAssignedVolunteer(), status, task.getResponseTime());
                }

                System.out.println("+-------------------+----------------------+------------------+---------------------------------+");
            }
        }

        public void generateResponseTimeReport() {
            System.out.println("              === Response Time Report ===              ");
            for (Task task : tasks) {
                if (task.isCompleted()) {
                    Duration duration = Duration.between(task.getResponseTime(), task.getCompletionTime());
                    System.out.printf("Task: %-20s | Volunteer: %-18s | Completion Time: %-15s minutes\n", 
                        task.getDescription(), task.getAssignedVolunteer(), duration.toMinutes());
                }
            }
        }
    }
}
