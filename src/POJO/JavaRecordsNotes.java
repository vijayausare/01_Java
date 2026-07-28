package POJO;

/**
 * Java Records Comprehensive Notes
 * Introduced in JDK 14 (Preview) and standard in JDK 16.
 *
 * Records are a special kind of class used to model plain data aggregates (POJOs) 
 * with minimal boilerplate.
 *
 * Key Characteristics:
 * - Immutable by default: All fields are implicitly private final.
 * - Explicitly Final: You cannot extend a record class, and it cannot extend another class.
 * - Built-in Superclass: All records automatically extend java.lang.Record.
 */
public class JavaRecordsNotes {

    /* =========================================================================
     * 1. BASIC SYNTAX & WHAT YOU GET FOR FREE
     * =========================================================================
     * The parameters in parentheses form the "header" of the record.
     *
     * By writing this one line, Java automatically generates:
     *  1. private final fields for 'length' and 'height'
     *  2. Public getter methods matching the names exactly ( length() and height() )
     *  3. equals() and hashCode() methods
     *  4. A toString() method
     */
    public record BasicDimensions(double length, double height) {
        // This is the body of the record. It can be left entirely empty!
    }

    /* =========================================================================
     * 2. CONSTRUCTORS IN RECORDS
     * =========================================================================
     * Records auto-generate a constructor, but you can define custom ones for
     * validation. There are two ways (Compact and Canonical).
     * (Note: We use different record names here since you can't have two
     * constructors of the same arity in one record).
     */

    /**
     * A. The Compact Constructor (Recommended)
     * You don't need to write the parameter list or assign 'this.length = length'.
     * You only write the validation logic.
     */
    public record CompactDimensions(double length, double height) {
        public CompactDimensions {
            if (length <= 0 || height <= 0) {
                throw new IllegalArgumentException("Dimensions must be positive.");
            }
            // No need to write: this.length = length;
        }
    }

    /**
     * B. The Canonical Constructor
     * Looks like a traditional constructor. More verbose and generally discouraged
     * unless you need to mutate the input parameters before assigning them.
     */
    public record CanonicalDimensions(double length, double height) {
        public CanonicalDimensions(double length, double height) {
            if (length <= 0 || height <= 0) {
                throw new IllegalArgumentException("Dimensions must be positive.");
            }
            this.length = length;
            this.height = height;
        }
    }

    /* =========================================================================
     * 3. ADDING METHODS AND FIELDS
     * =========================================================================
     * - ALLOWED: Static fields, static methods, custom instance methods,
     *            overriding default getters/equals/hashCode/toString.
     * - NOT ALLOWED: Additional instance variables (fields). All state must
     *                be declared in the record header.
     */
    public record AdvancedDimensions(double length, double height) {

        // Static fields are allowed
        static final double GOLDEN_RATIO = 1.618;

        // Static methods are allowed
        public static AdvancedDimensions createGoldenRectangle(double width) {
            return new AdvancedDimensions(width, width * GOLDEN_RATIO);
        }

        // Custom instance methods are allowed
        public double getArea() {
            return length * height;
        }

        // You can override default getters to add custom logic
        @Override
        public double length() {
            System.out.println("Accessing length...");
            return length;
        }
    }

    /* =========================================================================
     * 4. ADVANCED FEATURES: INTERFACES & GENERICS
     * =========================================================================
     * Records cannot extend classes, but they can implement interfaces
     * and use Generics.
     */
    public interface Measurable {
        double getMeasurement();
    }

    public record GenericBox<T>(T contents, double weight) implements Measurable {
        @Override
        public double getMeasurement() {
            return weight;
        }
    }

    /* =========================================================================
     * 5. SERIALIZATION & ANNOTATIONS (Notes)
     * =========================================================================
     * - Annotations: You can annotate header components (e.g., @NotNull double length).
     * - Serialization: Strictly governed by the record components and the canonical
     *   constructor. You cannot customize it using writeObject, readObject, etc.
     */

    /* =========================================================================
     * 6. GOTCHA: The java.lang.Record Name Collision
     * =========================================================================
     * Because all Java files implicitly import java.lang.*, java.lang.Record is
     * always in scope.
     *
     * If you have a custom class named Record (e.g., com.myapp.Record) and try
     * to import it using a wildcard (import com.myapp.*;), your code will fail
     * to compile due to ambiguity.
     *
     * FIX: Always use a fully qualified import for custom classes named Record:
     *      import com.myapp.Record;
     */

    /* =========================================================================
     * 7. THE SHALLOW IMMUTABILITY TRAP (Gotcha)
     * =========================================================================
     * Record fields are final, meaning the reference cannot change.
     * However, if a field holds a mutable object (like a List), its contents CAN change!
     */
    public record Team(String name, java.util.List<String> players) {
        // BEST PRACTICE: Use the compact constructor to make a defensive, unmodifiable copy.
        public Team {
            // This prevents external code from modifying the list after creation
            players = java.util.List.copyOf(players);
        }
    }

    // =========================================================================
    // MAIN METHOD TO TEST THE CONCEPTS
    // =========================================================================
    public static void main(String[] args) {
        System.out.println("--- Testing Basic Record ---");
        BasicDimensions basic = new BasicDimensions(10.5, 20.0);
        System.out.println("Basic toString(): " + basic); // Automatically generated!
        System.out.println("Basic length: " + basic.length());

        System.out.println("\n--- Testing Compact Constructor ---");
        try {
            CompactDimensions invalid = new CompactDimensions(-5, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught validation error: " + e.getMessage());
        }

        System.out.println("\n--- Testing Advanced Record ---");
        AdvancedDimensions golden = AdvancedDimensions.createGoldenRectangle(10);
        System.out.println("Golden Rectangle: " + golden);
        System.out.println("Area: " + golden.getArea());
        System.out.println("Length (with overridden getter): " + golden.length());

        System.out.println("\n--- Testing Generic Record ---");
        GenericBox<String> box = new GenericBox<>("Books", 15.5);
        System.out.println("Box contents: " + box.contents());
        System.out.println("Box measurement (Interface method): " + box.getMeasurement());
    }
}