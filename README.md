<div align="center">
  <img src="https://github.com/yshlae/ResQnect/blob/main/images/resqnect%20logo.png" alt="ResQnect Logo" width="240" height="240">
  
  <h1>ResQnect</h1>
  
  <h3>🪢 Prepare, Respond, Recover, Repeat. 🪢 <br>
  A disaster response management system for communities. Built for support, made to connect.</h3>
  
  <p><b>IT 2104</b><br>
  <a href="https://github.com/yshlae">Banaag, Ashley Mae R.</a></p>
  
  <hr class="w-48 h-1 mx-auto my-4 bg-gray-100 border-0 rounded md:my-10 dark:bg-gray-700">
</div>

<details>
  <summary><strong>Table of Contents</strong></summary>
  
  1. [Project Overview](#project-overview)  
  2. [Application of OOP Principles](#application-of-oop-principles)  
  3. [Integration with SDG](#integration-with-sdg)  
  4. [Running the Program](#running-the-program)

</details>

<hr class="w-48 h-1 mx-auto my-4 bg-gray-100 border-0 rounded md:my-10 dark:bg-gray-700">
</div>

### Project Overview 🔍
**ResQnect** is a disaster response management system designed to enhance the efficiency of relief operations. The system simplifies the coordination of volunteers, tracks essential resources like food and medical supplies, and assigns tasks to ensure organized disaster response efforts. With its streamlined interface, this enables users to manage volunteers, resources, and disaster-related tasks effectively. By facilitating clear communication and well-defined roles during emergencies, the system reduces delays and improves outcomes. Furthermore, it allows users to generate reports and analyze response times to continuously improve disaster readiness. The software is built with Object-Oriented Programming (OOP) principles, ensuring its modularity and maintainability. As communities face increasing risks from natural disasters, it serves as a tool to improve preparedness and resilience. Its ultimate goal is to empower local governments and organizations to save lives and resources during critical situations.

<hr class="w-48 h-1 mx-auto my-4 bg-gray-100 border-0 rounded md:my-10 dark:bg-gray-700">
</div>

### Application of OOP Principles 🛠️
In developing **ResQnect**, core Object-Oriented Programming (OOP) principles were applied to create a modular and efficient system. Here's how each principle was implemented:

- **Encapsulation** 💊  
  In the code, data related to volunteers, resources, and tasks is stored in private attributes within classes like `Volunteer`, `Resource`, and `Task`. These private attributes are accessed and modified only through getter and setter methods, ensuring the integrity of the data. For example, the `Resource` class ensures that the quantity of items cannot be set to a negative value, protecting the data from invalid inputs.

- **Abstraction** 🗄️  
  Complex operations are abstracted into separate classes like `VolunteerManager`, `ResourceManager`, and `TaskManager`. For instance, when adding a new volunteer, the user simply selects the "Manage Volunteers" option, and the `VolunteerManager` class handles the creation and storage of the volunteer. Users interact with a straightforward menu system, while the internal complexities of data processing are hidden.

- **Inheritance** 🧬  
  A base class `User` is used to define common properties such as `name`, `contact`, and `address`. The `Volunteer` class inherits from `User`, reducing redundant code and enabling shared methods to be reused. This structure allows for easy future expansion, such as adding other user roles like coordinators or responders.

- **Polymorphism** 📑  
  Polymorphism is utilized through overridden methods like `toString()`. For example, the `Volunteer` class overrides the `toString()` method to return detailed information about the volunteer, while the `Resource` class provides a different representation for its objects. This makes it easier to display relevant information based on the object type, improving user interaction.

<hr class="w-48 h-1 mx-auto my-4 bg-gray-100 border-0 rounded md:my-10 dark:bg-gray-700">
</div>

### Integration with SDG 🌍
<div align="center">
  <img src="https://github.com/yshlae/ResQnect/blob/main/images/SDG%20Goal%2011.png" alt="SDG Goal 11" width="1000">
</div>

**Sustainable Development Goal (SDG) 11: Sustainable Cities and Communities** emphasizes creating safe, resilient, and inclusive communities, and **ResQnect** directly contributes to this goal. The system improves preparedness by enabling local governments and organizations to track and manage critical resources such as food, water, and medical supplies, ensuring readiness for emergencies. It facilitates an efficient response by streamlining the assignment of tasks to volunteers, reducing delays in relief operations. This also supports recovery efforts by providing tools to monitor and track the completion of disaster response activities, ensuring affected communities receive timely support. Moreover, the system promotes resilience by generating detailed reports that analyze response times and resource usage, which can be used to improve future disaster preparedness strategies.

<hr class="w-48 h-1 mx-auto my-4 bg-gray-100 border-0 rounded md:my-10 dark:bg-gray-700">
</div>

### Running the Program 💻

To run the **ResQnect** system, follow these steps for a smooth experience:

1. **Prepare the Code Files**  
   - Save all the necessary Java files (e.g., `Volunteer.java`, `Resource.java`, `Task.java`, `DisasterResponseSystem.java`) in a single project folder.

2. **Compile the Program**  
   - Open your terminal or IDE, navigate to the project folder, and compile the main script:
     ```bash
     javac DisasterResponseSystem.java
     ```

3. **Execute the Program**  
   - Run the compiled program with:
     ```bash
     java DisasterResponseSystem
     ```

4. **Main Menu Options**  
   - After launching the program, you will be greeted with a menu offering the following options:
     - **1. Manage Volunteers**: Add, view, update, or delete volunteers.  
     - **2. Manage Resources**: Track resources like food, water, and medical supplies.  
     - **3. Assign Tasks**: Assign specific disaster response tasks to volunteers.  
     - **4. Track Tasks**: Monitor the progress of assigned tasks.  
     - **5. Response Time Reports**: Generate reports for analysis and future planning.  
     - **6. Exit**: Close the application safely.

5. **Perform Actions**  
   - Navigate through the menu by entering the corresponding number for each option. For instance, selecting **1** will allow you to manage volunteer information, such as adding a new volunteer with their details.

6. **Save and Exit**  
   - The program automatically saves data to files (e.g., `volunteers.json`, `resources.json`) to preserve it across sessions. Use the **Exit** option to terminate the application securely.

By following these steps, users can efficiently utilize **ResQnect** to prepare for and respond to disasters while maintaining organized records and reports.

<hr class="w-48 h-1 mx-auto my-4 bg-gray-100 border-0 rounded md:my-10 dark:bg-gray-700">
</div>

<p align="center">🚨 <b>Prepare, Respond, Recover, Repeat!</b> 🚨</p> 
