package com.company.student;

import com.company.variable.GeneralObject;

import java.util.Comparator;
import java.util.Formatter;

public class Student extends GeneralObject implements Comparator<Student> {
    private String name;
    private String surname;
    private String age;
    private String course;
    private String faculty;

    public Student(){
    }

    public Student setName(String value) {
        this.name = value;
        ChildrenElements.NAME.setName(value);
        return this;
    }

    public Student setSurname(String value) {
        this.surname = value;
        ChildrenElements.SURNAME.setName(value);
        return this;
    }

    public Student setAge(String value) {
        this.age = value;
        ChildrenElements.AGE.setName(value);
        return this;
    }

    public Student setCourse(String value) {
        this.course = value;
        ChildrenElements.COURSE.setName(value);
        return this;
    }

    public Student setFaculty(String value) {
        this.faculty = value;
        ChildrenElements.FACULTY.setName(value);
        return this;
    }

    public Student createChildrenElements(){
        for(Student.ChildrenElements value : Student.ChildrenElements.values()) {
            childrenElements.put(value.toString(), value.getName());
        }
        return this;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getAge(){
        return this.age;
    }

    public String getFaculty(){
        return this.faculty;
    }

    public String getCourse(){
        return this.course;
    }

    @Override
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student;
    }

    @Override
    public String toString(){
        Formatter formatter = new Formatter();
        formatter.format("\n%-10s%-40s\n%-10s%-40s\n%-10s%-40s\n%-10s%-40s\n%-10s%-40s",
                "NAME:", name,
                "SURNAME:", surname,
                "AGE:", age,
                "COURSE:", course,
                "FACULTY:", faculty);
        return formatter.toString();

        /*
        return "\n- Name: " + name +
                "\n- Surname: " + surname +
                "\n- Age: " + age +
                "\n- Course: " + course +
                "\n- Faculty: " + faculty;
         */
    }

    private enum ChildrenElements {
        NAME(""),
        SURNAME(""),
        AGE(""),
        FACULTY(""),
        COURSE("");

        private String value;

        ChildrenElements(String value){
            this.value = value;
        }

        void setName(String value){
            this.value = value;
        }

        String getName(){
            return this.value;
        }
    }
}
