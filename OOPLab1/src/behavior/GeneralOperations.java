package behavior;

import entities.Faculty;
import entities.University;
import utilities.StudyField;

import java.util.Scanner;

public class GeneralOperations {
    String command = "";
    Scanner scanner = new Scanner(System.in);

    public String createNewFaculty(University university) {
        System.out.println("Introduce faculty's full name:");
        String fName = scanner.nextLine().trim();

        System.out.println("Introduce faculty's abbreviation:");
        String fAbbrv = scanner.nextLine().trim().toUpperCase();

        System.out.println("Choose the study field from the following list:\n" +
                "m - Mechanical Engineering\n" +
                "s - Software Engineering\n" +
                "f - Food Technology\n" +
                "u - Urbanism Architecture\n" +
                "v - Veterinary Medicine");

        command = scanner.nextLine().trim();
        StudyField st = null;
        switch (command) {
            case "m":
                st = StudyField.MECHANICAL_ENGINEERING;
                break;
            case "s":
                st = StudyField.SOFTWARE_ENGINEERING;
                break;
            case "f":
                st = StudyField.FOOD_TECHNOLOGY;
                break;
            case "u":
                st = StudyField.URBANISM_ARCHITECTURE;
                break;
            case "v":
                st = StudyField.VETERINARY_MEDICINE;
                break;
            default:
                break;
        }

        university.addFaculty(new Faculty(fName, fAbbrv, st));
        System.out.println("The faculty was added!");

        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public String searchWhatFacultyBelongs(University university) {
        System.out.println("Introduce student's email: ");
        command = scanner.nextLine().trim();

        boolean check = false;
        for (Faculty faculty : university.getFaculties()) {
            if (faculty.findStudentByEmail(command) != null) {
                System.out.println("The student belongs to: " + faculty.toString());
                check = true;
                break;
            }
        }

        if (!check) {
            System.out.println("Faculty nonexistant!\n");
        }
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public String displayAllFaculties(University university) {
        university.displayFaculties();
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public String displayAllFacultiesByField(University university) {
        StudyField st = null;
        System.out.println("Choose the study field from the following list:\n" +
                "m - Mechanical Engineering\n" +
                "s - Software Engineering\n" +
                "f - Food Technology\n" +
                "u - Urbanism Architecture\n" +
                "v - Veterinary Medicine");
        command = scanner.nextLine().trim();
        switch (command) {
            case "m":
                st = StudyField.MECHANICAL_ENGINEERING;
                break;
            case "s":
                st = StudyField.SOFTWARE_ENGINEERING;
                break;
            case "f":
                st = StudyField.FOOD_TECHNOLOGY;
                break;
            case "u":
                st = StudyField.URBANISM_ARCHITECTURE;
                break;
            case "v":
                st = StudyField.VETERINARY_MEDICINE;
                break;
            default:
                break;
        }

        university.displayFacultiesByField(st);
        printOptions();
        command = scanner.nextLine().trim();
        return command;
    }

    public void printOptions() {
        System.out.println("m - go back to main menu\n" +
                "g - go to general operations\n" +
                "f - go to faculty operations\n" +
                "q - quit");
    }
}
