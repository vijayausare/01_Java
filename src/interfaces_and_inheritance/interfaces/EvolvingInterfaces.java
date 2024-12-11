package interfaces_and_inheritance.interfaces;

public interface EvolvingInterfaces {

	// Suppose we have interface
	public interface DoIt {
		void doSomething(int i, double x);
		int doSomethingElse(String s);
	}
	/*
	 * now we want to add new method didItWork to this interface If you make this
	 * change, then all classes that implement the old DoIt interface will break
	 * because they no longer implement the old interface
	 * 
	 * To avoid above problem we can Create new interface and extend the DoIt inteface
	 * So no longer the code is broken and all methods are inherited
	 */
	
	public interface DoItPlus extends DoIt {
		boolean didItWork(int i, double x, String s);
	}
	
	/*Above class has all methods with previous methods so programmer 
	 * can switch to this interface rather than previous*/
	
	
	/*************************Alternative Using default methods*******************/
	
	/*
	 * You must provide an implementation for default methods. You could
	 * also define new static methods to existing interfaces. Users who have classes
	 * that implement interfaces enhanced with new default or static methods do not
	 * have to modify or recompile them to accommodate the additional methods.
	 */	
	public interface DoIt1 {

		void doSomething(int i, double x);
		int doSomethingElse(String s);
		default boolean didItWork(int i, double x, String s) {
			return false;
		}
	}
}
