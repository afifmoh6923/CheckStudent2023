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
            throw new IllegalArgumentException("Cannot check in student; student field is null");
        }
        try {
            if (!students.containsKey(s)) {
                throw new IllegalArgumentException("Student does not exist in the roster");
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
            throw new IllegalArgumentException("Cannot remove student; student field is null");
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

    public String toString() {
        String output = "";
        if(teacher == null){
            output += "No teacher found for this class\n";
        }
        if(students.isEmpty()){
            output += "No students found in this roster\n";
        }
        else if (teacher != null && !students.isEmpty()) {
            output += teacher.toString() + "\n";
            for (Student s: students.keySet()) {
                output += s.toString() + "\n";
            }
        }
        return output;
        
    }
    public boolean contains(Student s) {
        return students.containsKey(s);
    }

    public String listAllUnchecked() {
        String output = "";
        for (Student s: students.keySet()) {
            if (students.get(s) == false) {
                output += s + "\n";
            }
        }

        return output;
    }
}