import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CourseManagementSystem {

    private static List<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add new Course(input id name subject)");
            System.out.println("2. List Courses");
            System.out.println("3. Find Course BY ID");
            System.out.println("4. Find Course By Title");
            System.out.println("5. Remove Course By ID");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter course ID:");
                    int id = scanner.nextInt();
                    System.out.println("Enter course name:");
                    String name = scanner.next();
                    System.out.println("Enter course subject:");
                    String subject = scanner.next();
                    Course course = new Course(id, name, subject);
                    courses.add(course);
                    System.out.println("Course added successfully!");
                    System.out.println("Added course:");
                    System.out.println(course);
                    break;
                case 2:
                    System.out.println("List of all courses:");
                    courses.stream().forEach(System.out::println);

                    // Find course by ID after listing all courses
                    System.out.println("Enter course ID to find:");
                    int idToFind = scanner.nextInt();
                    Course foundCourse = courses.stream()
                            .filter(Course -> Course.getId() == idToFind)
                            .findFirst()
                            .orElse(null);
                    if (foundCourse != null) {
                        System.out.println("Found course:");
                        System.out.println(foundCourse);
                    } else {
                        System.out.println("Course not found!");
                    }
                    break;
                case 3:
                    System.out.println("Enter course ID:");
                    int id1 = scanner.nextInt();
                    Course foundCourse1 = courses.stream()
                            .filter(Course -> Course.getId() == id1)
                            .findFirst()
                            .orElse(null);
                    if (foundCourse1 != null) {
                        System.out.println("Found course:");
                        System.out.println(foundCourse1);
                    } else {
                        System.out.println("Course not found!");
                    }
                    break;
                case 4:
                    System.out.println("Enter course title:");
                    String title1 = scanner.next();
                    List<Course> foundCourses = courses.stream()
                            .filter(Course -> Course.getTitle().contains(title1))
                            .collect(Collectors.toList());
                    if (foundCourses.isEmpty()) {
                        System.out.println("No courses found with that title!");
                    } else {
                        System.out.println("Found courses:");
                        foundCourses.stream().forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.println("Enter course ID:");
                    int id2 = scanner.nextInt();
                    courses = courses.stream()
                            .filter(Course -> Course.getId() != id2)
                            .collect(Collectors.toList());
                    System.out.println("Course removed successfully!");
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid number.");
            }
        }
    }

    private static class Course {
        private int id;
        private String name;
        private String subject;

        public Course(int id, String name, String subject) {
            this.id = id;
            this.name = name;
            this.subject = subject;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getSubject() {
            return subject;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", subject='" + subject + '\'' +
                    '}';
        }

        public Collection<Object> getTitle() {
            return null;
        }
    }
}