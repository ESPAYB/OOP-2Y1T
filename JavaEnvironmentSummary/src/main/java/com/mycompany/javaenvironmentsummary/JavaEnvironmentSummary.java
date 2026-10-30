public class JavaEnvironmentSummary {

    public static void main(String[] args) {
        System.out.println("=== Student Details ===");
        System.out.println("Student Name : Gene Andrei B. Hilario");
        System.out.println("Program/Section: TA21");
        System.out.println();

        // Retrieve and display Java environment properties
        System.out.println("=== Environment Properties ===");
        System.out.println("Java Version : " + System.getProperty("java.version"));
        System.out.println("JVM Name     : " + System.getProperty("java.vm.name"));
        System.out.println("OS Name      : " + System.getProperty("os.name"));
        System.out.println();

        // Display the execution flow
        System.out.println("=== Execution Flow ===");
        System.out.println(".java source -> javac compiler -> .class bytecode -> JVM -> output");
    }
}
