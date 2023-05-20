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
        if (!(other instanceof Student)) {
            return false;
        }
        return ((Student) other).getName() == this.getName() && ((Student) other).getID() == this.getID();
    }
}