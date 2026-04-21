import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Update Student");
            System.out.println("6. Sort by ID");
            System.out.println("7. Sort by Name");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("❌ Invalid input. Enter a number.");
                sc.next(); // clear wrong input
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid ID.");
                        sc.next();
                        break;
                    }
                    int id = sc.nextInt();

                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid Age.");
                        sc.next();
                        break;
                    }
                    int age = sc.nextInt();

                    service.addStudent(new Student(id, name, age));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid ID.");
                        sc.next();
                        break;
                    }
                    service.deleteStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid ID.");
                        sc.next();
                        break;
                    }
                    service.searchStudent(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter ID to update: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid ID.");
                        sc.next();
                        break;
                    }
                    int updateId = sc.nextInt();

                    System.out.print("Enter new Name: ");
                    String newName = sc.next();

                    System.out.print("Enter new Age: ");
                    if (!sc.hasNextInt()) {
                        System.out.println("❌ Invalid Age.");
                        sc.next();
                        break;
                    }
                    int newAge = sc.nextInt();

                    service.updateStudent(updateId, newName, newAge);
                    break;

                case 6:
                    service.sortById();
                    break;

                case 7:
                    service.sortByName();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }
}