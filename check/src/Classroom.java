import java.util.HashMap;
import java.util.Map;

public class Classroom{
    private Teacher teacher;
    private Map<Student, Boolean> students;

    public Classroom (Teacher t) {
        teacher = t;
        students = new HashMap<Student, Boolean>();
    }

    public boolean addStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Cannot add student; student field is null");
        }
        try { 
            students.put(s, false);
            return true; 
        }
        catch (Exception e) { 
            System.out.println(e.getMessage()); 
            return false;
        }
        
    }

    public boolean checkIn(Student s){
        if (s == null) {
            throw new IllegalArgumentException("Cannot add student; student field is null");
        }
        try {
            if (!students.containsKey(s)) {
                throw new IllegalArgumentException("This student does not exist in the class roster");
            }
            else {
                students.put(s, true);
            }
            return true;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }

    public boolean removeStudent(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Cannot add student; student field is null");
        }
        try {   
            students.remove(s);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void clearRoster() {
        students.clear();
    }

    public void markAllUnchecked() {
        students.replaceAll((Student, Boolean) -> Boolean = false);
    }
}