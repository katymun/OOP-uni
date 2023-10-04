package entities;

import utilities.StudyField;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String facultyName;
    private String abbreviation;
    private List<Student> students;
    private List<Student> graduates;
    private StudyField studyField;

    public Faculty(String facultyName, String abbreviation, List<Student> students, List<Student> graduates, StudyField studyField) {
        this.facultyName = facultyName;
        this.abbreviation = abbreviation.toUpperCase();
        this.studyField = studyField;
        this.students = students;
        this.graduates = graduates;
    }

    public Faculty(String facultyName, String abbreviation, StudyField studyField) {
        this.facultyName = facultyName;
        this.abbreviation = abbreviation.toUpperCase();
        this.studyField = studyField;
        students = new ArrayList<>();
        graduates = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
    public void graduateStudent(Student student) {
        students.remove(student);
        graduates.add(student);
    }

    public Student findStudentByEmail(String email) {
        for (Student st : students) {
            if (st.getEmail().equals(email)) {
                return st;
            }
        }
        return null;
    }

    public void displayStudents() {
        System.out.println("The following students are enrolled:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void displayGraduates() {
        System.out.println("The following students graduated: ");
        for (Student student : graduates) {
            System.out.println(student);
        }
    }
    
    // ???????????????????????????????????????????????????????????
    public boolean checkIfBelongs(Student student) {
        if(students.contains(student) || graduates.contains(student)) {
            return true;
        } else {
            return false;
        }
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Faculty: " +
                "facultyName='" + facultyName + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", students=" + students +
                ", graduates=" + graduates +
                ", studyField=" + studyField +
                '}';
    }
}
