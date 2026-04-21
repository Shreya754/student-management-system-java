import java.util.*;

public class StudentService {

    private List<Student> students;

    public StudentService() {
        students = FileHandler.load();
    }

    public void addStudent(Student s) {
        for (Student st : students) {
            if (st.getId() == s.getId()) {
                System.out.println("❌ ID already exists.");
                return;
            }
        }

        students.add(s);
        FileHandler.save(students);
        System.out.println("✅ Student added.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }

        System.out.println("\nID | Name | Age");
        System.out.println("------------------");

        for (Student s : students) {
            System.out.println(
                s.getId() + " | " + s.getName() + " | " + s.getAge()
            );
        }
    }

    public void deleteStudent(int id) {
        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            FileHandler.save(students);
            System.out.println("✅ Deleted successfully.");
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    public void searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println(
                    s.getId() + " | " + s.getName() + " | " + s.getAge()
                );
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    public void updateStudent(int id, String newName, int newAge) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setAge(newAge);
                FileHandler.save(students);
                System.out.println("✅ Updated successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    public void sortById() {
        students.sort(Comparator.comparingInt(Student::getId));
        System.out.println("✅ Sorted by ID.");
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("✅ Sorted by Name.");
    }
}