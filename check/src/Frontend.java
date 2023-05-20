import java.util.Scanner;

public class Frontend {
    
    private Classroom classroom;
    private Scanner userInput;


    public Frontend(Classroom c) {
        userInput = new Scanner(System.in);
        classroom = c;
    }

    public void hr() {
		System.out.println("-------------------------------------------------------------------------------");
	}

    public void runCommandLoop() {
        hr();
        System.out.println("Welcome to the Student Check-in App.");
        hr();
        char command = '\0';
        while (command != 'Q') {
            command = mainMenuPrompt();
            switch (command) {
                case 'A':
                    addStudent(userInput);
                    break;
                case 'C':
                    checkInStudent(userInput);
                    break;
                case 'V':
                    viewRoster();
                    break;
                case 'R':
                    removeStudent(userInput);
                    break;
                case 'l':
                    clearRoster();
                    break;
                case 'M':
                    markAllUnchecked();
                    break;
                case 'U':
                    viewAllUnchecked();
                case 'Q':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        hr();
        System.out.println("Thank you for using the Student Check In app.");
        hr();
    }

    public char mainMenuPrompt() {
		// display menu of choices
        System.out.println("\n--- Classroom CLI ---");
        System.out.println("[A]dd Student");
        System.out.println("[C]heck In Student");
        System.out.println("[V]iew Class Roster");
        System.out.println("[R]emove Student");
        System.out.println("C[l]ear Roster");
        System.out.println("[M]ark All Unchecked");
        System.out.println("View All [U]nchecked");
        System.out.println("[Q]uit");
        System.out.print("Enter your choice: ");
		// read in user's choice, and trim away any leading or trailing whitespace
		System.out.print("Choose command: ");
		String input = userInput.nextLine().trim();
		if (input.length() == 0) // if user's choice is blank, return null character
			return '\0';
		// otherwise, return an uppercase version of the first character in input
		return input.charAt(0);
	}

    public boolean addStudent(Scanner scanner) {
        try {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine().trim();
            System.out.println("Enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Student student = new Student(name, id);

            if (classroom.addStudent(student)) {
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Failed to add student.");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean checkInStudent(Scanner scanner) {

        try {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine().trim();
            System.out.println("Enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Checking in student: " + name + " " + id);
            Student student = new Student(name, id);

            if (classroom.checkIn(student)) {
                System.out.println("Student checked in successfully.");
            } else {
                System.out.println("Failed to check in student.");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
        
        return true;
    }

    public boolean removeStudent(Scanner scanner) {
       
        try {
            System.out.println("Enter student name: ");
            String name = scanner.nextLine().trim();
            System.out.println("Enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Student student = new Student(name, id);
            if (classroom.removeStudent(student)) {
                System.out.println("Student removed successfully.");
            } else {
                System.out.println("Failed to remove student.");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean clearRoster() {
        try {
            classroom.clearRoster();
            System.out.println("Roster cleared successfully.");
        }
        catch (Exception e) {
            System.out.println("e.getMessage()");
            return false;
        }
        
        return true;
    }

    public boolean markAllUnchecked() {
        try {
             classroom.markAllUnchecked();
            System.out.println("All students marked as unchecked.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
       
        return true;
    }

    public void viewRoster() {
        System.out.println(classroom.toString());
    }
    
    public void viewAllUnchecked() {
        System.out.println(classroom.listAllUnchecked());
    }
}