package ibm;

// This singleton is thread-safe
// because the only one enum exists per VM
public enum EnumSingleton {
    ONE("One" , 1);
    private String desc;
    private int counter;

    EnumSingleton(String description, int counter) {
        this.desc = description;
        this.counter = counter;
    }

    public EnumSingleton getInstance() {
        return ONE;
    }
}
