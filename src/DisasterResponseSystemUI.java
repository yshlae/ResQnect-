import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

public class DisasterResponseUI extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel volunteerTab, resourceTab, taskTab, disasterTab, responseTimeTab;
    private JTextField volunteerNameField, volunteerTypeField, volunteerAvailabilityField;
    private JTable volunteerTable, resourceTable, disasterTable, responseTimeTable;
    private DefaultTableModel volunteerTableModel, resourceTableModel, disasterTableModel, responseTimeTableModel;
    private JTextField resourceNameField, resourceQuantityField, resourceMonetaryField;
    private JTextField taskDescriptionField, taskVolunteerField;

    public DisasterResponseUI() {
        setTitle("ResQnect");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("🚨 ResQnect: Disaster Response and Relief Management System 🚨", JLabel.CENTER);
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titleLabel, BorderLayout.NORTH);

        tabbedPane = new JTabbedPane();
        volunteerTab = createVolunteerTab();
        resourceTab = createResourceTab();
        taskTab = createTaskTab();
        disasterTab = createDisasterTab();
        responseTimeTab = createResponseTimeTab();

        tabbedPane.add("Manage Volunteers", volunteerTab);
        tabbedPane.add("Manage Resources", resourceTab);
        tabbedPane.add("Assign Tasks", taskTab);
        tabbedPane.add("Track Disasters", disasterTab);
        tabbedPane.add("Response Time Reports", responseTimeTab);

        add(tabbedPane, BorderLayout.CENTER);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Helvetica", Font.BOLD, 14));
        exitButton.setBackground(new Color(67, 53, 167));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JOptionPane.showMessageDialog(DisasterResponseUI.this, "🚨 Prepare, Respond, Recover, Repeat! 🚨");
                System.exit(0);
            }
        });

        JPanel exitPanel = new JPanel();
        exitPanel.add(exitButton);
        add(exitPanel, BorderLayout.SOUTH);
    }

    private JPanel createVolunteerTab() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Volunteer Name:"));
        volunteerNameField = new JTextField();
        inputPanel.add(volunteerNameField);

        inputPanel.add(new JLabel("Volunteer Type:"));
        volunteerTypeField = new JTextField();
        inputPanel.add(volunteerTypeField);

        inputPanel.add(new JLabel("Availability (Yes/No):"));
        volunteerAvailabilityField = new JTextField();
        inputPanel.add(volunteerAvailabilityField);

        JButton addVolunteerButton = new JButton("Add Volunteer");
        addVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                addVolunteer();
            }
        });
        inputPanel.add(addVolunteerButton);

        JButton refreshVolunteerButton = new JButton("Refresh List");
        refreshVolunteerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                refreshVolunteerTable();
            }
        });
        inputPanel.add(refreshVolunteerButton);

        panel.add(inputPanel, BorderLayout.NORTH);

        String[] volunteerColumns = {"Name", "Type", "Availability"};
        volunteerTableModel = new DefaultTableModel(volunteerColumns, 0);
        volunteerTable = new JTable(volunteerTableModel);

        JScrollPane tableScroll = new JScrollPane(volunteerTable);
        panel.add(tableScroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createResourceTab() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        inputPanel.add(new JLabel("Resource Type:"));
        resourceNameField = new JTextField();
        inputPanel.add(resourceNameField);

        inputPanel.add(new JLabel("Quantity:"));
        resourceQuantityField = new JTextField();
        inputPanel.add(resourceQuantityField);

        inputPanel.add(new JLabel("Is it Monetary? (Yes/No):"));
        resourceMonetaryField = new JTextField();
        inputPanel.add(resourceMonetaryField);

        JButton addResourceButton = new JButton("Add Resource");
        addResourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                addResource();
            }
        });
        inputPanel.add(addResourceButton);

        JButton refreshResourceButton = new JButton("Refresh List");
        refreshResourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                refreshResourceTable();
            }
        });
        inputPanel.add(refreshResourceButton);

        panel.add(inputPanel, BorderLayout.NORTH);

        String[] resourceColumns = {"Resource Type", "Quantity", "Monetary"};
        resourceTableModel = new DefaultTableModel(resourceColumns, 0);
        resourceTable = new JTable(resourceTableModel);

        JScrollPane tableScroll = new JScrollPane(resourceTable);
        panel.add(tableScroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createTaskTab() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Task Description:"));
        taskDescriptionField = new JTextField();
        panel.add(taskDescriptionField);

        panel.add(new JLabel("Volunteer Name:"));
        taskVolunteerField = new JTextField();
        panel.add(taskVolunteerField);

        JButton assignTaskButton = new JButton("Assign Task");
        assignTaskButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                assignTask();
            }
        });
        panel.add(assignTaskButton);

        return panel;
    }

    private JPanel createDisasterTab() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] disasterColumns = {"Status", "Volunteer Name", "Task Assigned"};
        disasterTableModel = new DefaultTableModel(disasterColumns, 0);
        disasterTable = new JTable(disasterTableModel);

        JScrollPane tableScroll = new JScrollPane(disasterTable);
        panel.add(tableScroll, BorderLayout.CENTER);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                refreshDisasterTable();
            }
        });
        panel.add(refreshButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createResponseTimeTab() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] responseColumns = {"Task", "Assigned Time", "Completion Time", "Time Taken"};
        responseTimeTableModel = new DefaultTableModel(responseColumns, 0);
        responseTimeTable = new JTable(responseTimeTableModel);

        JScrollPane tableScroll = new JScrollPane(responseTimeTable);
        panel.add(tableScroll, BorderLayout.CENTER);

        return panel;
    }

    private void addVolunteer() {
        String name = volunteerNameField.getText();
        String type = volunteerTypeField.getText();
        String availability = volunteerAvailabilityField.getText();

        if (!name.isEmpty() && !type.isEmpty() && !availability.isEmpty()) {
            if (availability.equalsIgnoreCase("Yes") || availability.equalsIgnoreCase("No")) {
                volunteerTableModel.addRow(new Object[]{name, type, availability});
                JOptionPane.showMessageDialog(this, "Volunteer added successfully!");

                volunteerNameField.setText("");
                volunteerTypeField.setText("");
                volunteerAvailabilityField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Availability must be 'Yes' or 'No'.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.");
        }
    }

    private void addResource() {
        String resourceType = resourceNameField.getText();
        String quantity = resourceQuantityField.getText();
        String isMoney = resourceMonetaryField.getText();

        if (!resourceType.isEmpty() && !quantity.isEmpty() && !isMoney.isEmpty()) {
            try {
                int quantityValue = Integer.parseInt(quantity);

                if (isMoney.equalsIgnoreCase("Yes") || isMoney.equalsIgnoreCase("No")) {
                    resourceTableModel.addRow(new Object[]{resourceType, quantityValue, isMoney});
                    JOptionPane.showMessageDialog(this, "Resource added successfully!");

                    resourceNameField.setText("");
                    resourceQuantityField.setText("");
                    resourceMonetaryField.setText("");
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Quantity must be a valid number.");
                return;
            }

            JOptionPane.showMessageDialog(this, "Please fill out all fields correctly.");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.");
        }
    }

    private void assignTask() {
        String taskDescription = taskDescriptionField.getText();
        String volunteerName = taskVolunteerField.getText();

        if (!taskDescription.isEmpty() && !volunteerName.isEmpty()) {
            boolean volunteerFound = false;
            for (int i = 0; i < volunteerTableModel.getRowCount(); i++) {
                if (volunteerTableModel.getValueAt(i, 0).equals(volunteerName)) {
                    volunteerFound = true;
                    break;
                }
            }

            if (volunteerFound) {
                disasterTableModel.addRow(new Object[]{"Assigned", volunteerName, taskDescription});

                responseTimeTableModel.addRow(new Object[]{
                    taskDescription,
                    new Date().toString(),
                    "Pending",
                    "Ongoing"
                });

                JOptionPane.showMessageDialog(this, "Task assigned successfully!");

                taskDescriptionField.setText("");
                taskVolunteerField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Volunteer not found. Please add volunteer first.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill out all fields.");
        }
    }

    private void refreshVolunteerTable() {
        JOptionPane.showMessageDialog(this, "Volunteer list refreshed!");
    }

    private void refreshResourceTable() {
        JOptionPane.showMessageDialog(this, "Resource list refreshed!");
    }

    private void refreshDisasterTable() {
        JOptionPane.showMessageDialog(this, "Disaster list refreshed!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                DisasterResponseUI ui = new DisasterResponseUI();
                ui.setVisible(true);
            }
        });
    }
}

