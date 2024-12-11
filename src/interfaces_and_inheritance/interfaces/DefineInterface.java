package interfaces_and_inheritance.interfaces;

public interface DefineInterface {

	/**************************** In the Java programming language, an interface is a **********
	 1. Reference type, similar to a class, that can contain only constants, method signatures, default
	 	methods, static methods, and nested types. 
	 2. Method bodies exist only for default methods and static methods. 
	 3. Interfaces cannot be instantiated—they can only be implemented by classes or extended by other interfaces.
	 4. If you do not specify that the interface is public
	 ************************************************************************************/
	
	/*************************** Interface Body Contains: ****************************

	 1. An abstract method within an interface is followed by a semicolon, but no
	    braces (an abstract method does not contain an implementation). 
	 2. Default methods are defined with the default modifier 
	 3. Static methods with the static keyword. 
	 4. All abstract, default, and static methods in an interface are implicitly public, 
	 	so you can omit the public modifier.
	 5. All constant values defined in an interface are implicitly public, static, and final.
	    you can omit these modifiers.
	 ************************************************************************************/
	
   // constant declarations
    
    // base of natural logarithms
    double E = 2.718282;
 
    // method signatures
    void doSomething (int i, double x);
    int doSomethingElse(String s);
}