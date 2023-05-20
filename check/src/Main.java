public class Main {

    public static void main(String[] args) {
        Classroom test = new Classroom(new Teacher("math", "Bill"));
        Frontend testfd = new Frontend(test);
        testfd.runCommandLoop();
    }
}