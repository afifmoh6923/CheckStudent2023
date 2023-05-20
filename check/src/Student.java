public class Student extends Person {
    private final int ID;

    public Student(String name, int id){
        super(name);
        ID = id;
    }

    public int getID(){
        return ID;
    }

    @Override
    public boolean equals(Object other) {
        if (this.hashCode() == other.hashCode()) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        return ((Student) other).getName() == this.getName() && ((Student) other).getID() == this.getID();
    }
    @Override
    public int hashCode() {
        return this.getName().hashCode() + ID;
    }

    public String toString() {
        return this.getName() + " " + ID;
    }
}