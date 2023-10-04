/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import utilities.StudyField;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author munka
 */
public class University {
    private List<Faculty> faculties;

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public University() {
        faculties = new ArrayList<>();
    }
    
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }
    
    public void displayFaculties() {
        System.out.println("There are the following faculties: ");
        if (faculties.size() == 0) {
            System.out.println("No faculties.");
        } else {
            for (Faculty faculty : faculties) {
                System.out.print(faculty.getFacultyName() + ", ");
            }
            System.out.println("");
        }
    }
    
    public void displayFacultiesByField(StudyField st) {
        System.out.println("There are the following faculties for the " + st.toString() + " field:");
        if (faculties.size() == 0) {
            System.out.println("No faculties.");
        } else {
            for (Faculty faculty : faculties) {
                if (faculty.getStudyField() == st) {
                    System.out.print(faculty.getFacultyName() + ", ");
                }
            }
            System.out.println("");
        }

    }

    public Faculty findFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviation().equals(abbreviation)) {
                return faculty;
            }
        }
        return null;
    }
}
