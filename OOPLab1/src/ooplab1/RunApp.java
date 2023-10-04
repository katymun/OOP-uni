package ooplab1;

import behavior.FacultyOperations;
import behavior.GeneralOperations;
import entities.Faculty;
import entities.Student;
import entities.University;

import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author munka
 */
public class RunApp {
    private Scanner scanner;
    private University university;
    private String command = "";
    private FacultyOperations fo;
    private GeneralOperations go;
    
    public RunApp() {
        scanner = new Scanner(System.in);
        university = new University();
        //TODO all should have this.
        this.command = "";
        fo = new FacultyOperations();
        go = new GeneralOperations();
    }
    
    public void run() {
        command = handleMainMenu();
        while (!command.equals("q")) {
            switch (command) {
                case "m":
                    command = handleMainMenu();
                    break;
                case "f":
                    command = handleFacultyOperations();
                    break;
                case "g":
                    command = handleGeneralOperations();
                    break;
                case "b":
                    command = handleMainMenu();
                    break;
                case "cf":
                    command = go.createNewFaculty(university);
                    break;
                case "s":
                    command = go.searchWhatFacultyBelongs(university);
                    break;
                case "du":
                    command = go.displayAllFaculties(university);
                    break;
                case "df":
                    command = go.displayAllFacultiesByField(university);
                    break;
                case "cs":
                    command = fo.addStudentToFaculty(university);
                    break;
                case "gs":
                    command = fo.graduateStudentFromFaculty(university);
                    break;
                case "ds":
                    command = fo.displayAllStudents(university);
                    break;
                case "dg":
                    command = fo.displayAllGraduates(university);
                    break;
                case "t":
                    command = fo.checkIfStudentBelongs(university);
                    break;
                default:
                    System.out.println("Something went wrong...");
                    command = handleMainMenu();
                    break;
            }


        }
    }



    public String handleMainMenu() {
        System.out.println("Welcome to TUM's student management system.");
        System.out.println("Choose the kind of operations you want to perform "
                + "(type the appropriate letter and press ENTER):");
        System.out.println("g - general operations");
        System.out.println("f - faculty operations");
        System.out.println("q - quit");
        System.out.print("Your choice: ");
        command = scanner.nextLine().trim();
        return command;
    }

    public String handleGeneralOperations() {
        // move to separate method
        System.out.println("Choose the operation you want to perform:");
        System.out.println("cf - create a new faculty");
        System.out.println("s - search what faculty a setudent belongs to by email");
        System.out.println("du - display university faculties");
        System.out.println("df - display all faculties belonging to a field");
        System.out.println("b - back to main menu");
        System.out.println("q - quit");
        command = scanner.nextLine().trim();
        return command;
    }
    
    public String handleFacultyOperations() {
        System.out.println("Choose the operations you want to perform:\n" +
                "cs - create and assign a student to a faculty\n" +
                "gs - graduate a student from a faculty\n" +
                "ds - display current enrolled students\n" +
                "dg - display graduates\n" +
                "t - tell or not if a student belongs to this faculty\n" +
                "b - back to the main menu\n" +
                "q - quit");

        command = scanner.nextLine().trim();
        return command;
    }
}
