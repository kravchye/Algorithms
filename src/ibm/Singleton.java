package ibm;
// Double Checking locking singleton
// Use volatile to make sure only one instance is created and
// the rest threads are aware of the change

// Use this implementation in case we need the additional initialization logic
// Otherwise use EnumSingleton implementation as Joshua Bloch suggest which is thread safe on JVM level
public class Singleton {
    // guarantees that all accesses to it actually read its current value from memory.
    private volatile static Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}