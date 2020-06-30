package com.company.menu;

import com.company.action.CorrectData;
import com.company.data.Path;
import com.company.data.Patterns;
import org.jdom2.Element;
import com.company.student.Student;
import com.company.xml.XMLCreator;
import java.util.ArrayList;
import java.util.List;

public class MenuEditStudents extends CorrectData {
    private final Path path = Path.STUDENTS;
    private final XMLCreator xmlCreator = new XMLCreator(path);
    private final Patterns type = Patterns.NAME;

    private final List<Element> allElements;
    private final List<Student> allStudents;
    private final List<Integer> foundStudents;

    public MenuEditStudents(){
        System.out.println("\n# Search for a student, whose data needs to be changed.");

        xmlCreator.createDocument();

        allElements = xmlCreator.getMainElements();       // все элементы БД "Студенты"
        allStudents = getListStudents(allElements);       // все элементы БД "Студенты", конвертированные в объект "Student"
        foundStudents = new ArrayList<>();                // количество найденных студентов с одинаковыми именами и их порядковые номера в allStudents
    }

    public void start(){
        String name = getCorrectData(type);

        searchStudentsByName(name);

        System.out.println("\n- Total students: " + allStudents.size());
        System.out.println("- Found Students: " + foundStudents.size());

        // если студентов не найдено
        if(foundStudents.isEmpty())
            msgUserNotFound(name);
        // если найден один студент
        else if(foundStudents.size() == 1){
            changeStudent(allStudents.get(foundStudents.get(0)));
        }
        // если найдено несколько студентов
        else {
            choiceOneStudent(name);
        }
    }

    // ищем студентов с заданными именами
    private void searchStudentsByName(String name){
        for(int i = 0; i < allStudents.size(); i++){
            if(allStudents.get(i).getName().toLowerCase().matches(xmlCreator.patternSearchWord(name)))
                // добавляем найденных студентов в список - foundStudents
                foundStudents.add(i);
        }
    }

    // нужно выбрать одного студента из списка найденных
    private Integer getNumberStudent(){
        int key;
        while (true){
            System.out.println("\n# Choose one of the students. Enter his number." +
                    "\nYou can choose one of the numbers: " + foundStudents);
            key = getInt();

            // если выбранное пользователем число в пределах, то выходим из цикла
            for(Integer i : foundStudents) {
                if (key == i) {
                    return key;
                }
            }
            // иначе - предупреждение и повторный ввод
            msgWrongChoice();
        }
    }

    // преобразовываем студентов из Element в объект класса Student
    private List<Student> getListStudents(List<Element> elements){
        String name;
        String surname;
        String age;
        String course;
        String faculty;

        List<Student> allStudents = new ArrayList<>();

        // создаем объекты студентов
        for(Element e1 : elements){
            name = e1.getChild(Patterns.NAME.toString()).getValue();
            surname = e1.getChild(Patterns.SURNAME.toString()).getValue();
            age = e1.getChild(Patterns.AGE.toString()).getValue();
            course = e1.getChild(Patterns.COURSE.toString()).getValue();
            faculty = e1.getChild(Patterns.FACULTY.toString()).getValue();

            allStudents.add(new Student().
                    setName(name).
                    setSurname(surname).
                    setAge(age).
                    setCourse(course).
                    setFaculty(faculty).
                    createChildrenElements());
        }
        return allStudents;
    }

    // выбор одного студента из списка доступных и его изменение
    private void choiceOneStudent(String name){
        int numberStudent;
        msgStudentNamesContaining(name);

        // печать всех найденных студентов
        for(Integer i : foundStudents)
            System.out.println("\n[Student № " + i + "]" + allStudents.get(i).toString());

        numberStudent = getNumberStudent();

        changeStudent(allStudents.get(numberStudent));
    }

    protected void changeStudent(Student st) {
        System.out.println("\n# Change the desired item:");
        // вводим данные нового пользователя
        System.out.println("\n# Old name: " + st.getName());
        st.setName(getCorrectData(Patterns.NAME));
        System.out.println("\n# Old surname: " + st.getSurname());
        st.setSurname(getCorrectData(Patterns.SURNAME));
        System.out.println("\n# Old age: " + st.getAge());
        st.setAge(getCorrectData(Patterns.AGE));
        System.out.println("\n# Old faculty: " + st.getFaculty());
        st.setFaculty(getCorrectData(Patterns.FACULTY));
        System.out.println("\n# Old course: " + st.getCourse());
        st.setCourse(getCorrectData(Patterns.COURSE));
        st.createChildrenElements();

        writeNewStudents();
    }

    // создать структуру новых студентов XML и записать в БД XML
    private void writeNewStudents(){
        // создаем структуру нового документа
        xmlCreator.createNewDocument();

        // добавляем студентов
        for(Student s : allStudents)
            xmlCreator.addChildrenElements(s);
        // записываем в XML
        xmlCreator.writeInXML();
    }
}

