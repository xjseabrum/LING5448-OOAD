public class Employee {

    protected String name;

    public Employee(String name){
        this.name = name;
    }

    public Employee(){
        this.name = RandomUtils.getRandomName(10);
    }

    // Getters and Setters.
    public String getName(){
        return this.name;
    }
}
