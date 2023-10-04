package behavior;

import entities.Faculty;
import entities.Student;
import entities.University;
import ooplab1.RunApp;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class FacultyOperations {
    String command;
    Scanner scanner = new Scanner(System.in);

    public String addStudentToFaculty(University university) {
        System.out.println("Introduce student's first name:");
        String firstName = scanner.nextLine().trim();

        System.out.println("Introduce student's last name:");
        String lastName = scanner.nextLine().trim();

        System.out.println("Introduce student's email:");
        String email = scanner.nextLine().trim();

        System.out.println("Introduce student's enrrollment date (dd-mm-yyyy):");
        Date enrollDate = manageDate(command, scanner);

        System.out.println("Introduce student's date of birth (dd-mm-yyyy):");
        Date birthDate = manageDate(command, scanner);

        Student st = new Student(firstName,lastName,email,enrollDate,birthDate);
        System.out.println("Introduce the faculty's abbreviation:");
        String command = scanner.nextLine().trim().toUpperCase();
        Faculty faculty = university.findFacultyByAbbreviation(command);

        if (faculty == null) {
            System.out.println("Faculty nonexistant!\n");
            return "m";
        }

        faculty.addStudent(st);

        System.out.println("The student was added!");

        printOptions();

        command = scanner.nextLine().trim();
        return command;
    }

    public String graduateStudentFromFaculty(University university) {

        System.out.println("Introduce the faculty's abbreviation: ");
        command = scanner.nextLine().trim().toUpperCase();
        Faculty faculty = university.findFacultyByAbbreviation(command);
        if (faculty == null) {
            System.out.println("Faculty nonexistant!\n");
            return "m";
        }

        System.out.println("Introduce student's email: ");
        command = scanner.nextLine().trim();
        Student student = faculty.findStudentByEmail(command);
        if (student != null) {
            faculty.graduateStudent(student);
            System.out.println("The student was graduated!");

        } else {
            System.out.println("Something went wrong, the email might be incorrect...");
        }
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public String displayAllStudents(University university) {
        System.out.println("Introduce the faculty's abbreviation:");
        command = scanner.nextLine().trim().toUpperCase();
        Faculty faculty = university.findFacultyByAbbreviation(command);
        if (faculty == null) {
            System.out.println("Faculty nonexistant!");
            return "m";
        }

        faculty.displayStudents();
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public String displayAllGraduates(University university) {
        System.out.println("Introduce the faculty's abbreviation:");
        command = scanner.nextLine().trim().toUpperCase();
        Faculty faculty = university.findFacultyByAbbreviation(command);

        if (faculty == null) {
            System.out.println("Faculty nonexistant!\n");
            return "m";
        }

        faculty.displayGraduates();
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public String checkIfStudentBelongs(University university) {
        System.out.println("Introduce the faculty's abbreviation: ");
        command = scanner.nextLine().trim().toUpperCase();
        Faculty faculty = university.findFacultyByAbbreviation(command);

        if (faculty == null) {
            System.out.println("Faculty nonexistant!\n");
            return "m";
        }

        System.out.println("Introduce student's email: ");
        command = scanner.nextLine().trim();
        Student student = faculty.findStudentByEmail(command);

        if (student == null) {
            System.out.println("Student nonexistant!\n");
            return "m";
        }

        boolean check = faculty.checkIfBelongs(student);
        if (check) {
            System.out.println("This student belongs to this faculty");
        } else {
            System.out.println("This student doesn't belong to this faculty");
        }
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public Date manageDate(String command, Scanner scanner) {
        String[] dateArray = scanner.nextLine().trim().split("-");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);
        Date date = Date.from(LocalDate.of(year,month,day).atStartOfDay(ZoneId.systemDefault()).toInstant());
        return date;
    }

    public void printOptions() {
        System.out.println("m - go back to main menu\n" +
                "g - go to general operations\n" +
                "f - go to faculty operations\n" +
                "q - quit");
        System.out.print("Your choice: ");
    }
}
