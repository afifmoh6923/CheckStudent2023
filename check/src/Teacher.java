public class Teacher extends Person {
    private String subject;

    public Teacher(String subject, String name) {
        super(name);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public String setSubject(String newSubject) {
        this.subject = newSubject;
        return newSubject;
    }

}