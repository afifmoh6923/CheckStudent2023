public class Person extends Object {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (this.hashCode() == other.hashCode()) {
            return true;
        }
        if(!(other instanceof Person)) {
            return false;
        }
        else {
            return ((Person) other).getName() == this.getName();
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }


}