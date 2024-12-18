package interfaces_and_inheritance.inheritance;

public abstract class AbstractClassAndMethods {
	
	/*
	 * An abstract class may have static fields and static methods. You can use
	 * these static members with a class reference (for example,
	 * AbstractClass.staticMethod()) as you would with any other class.
	 */	

	/*
	 * An abstract class is a class that is declared abstract—it may or may not
	 * include abstract methods. Abstract classes cannot be instantiated, but they
	 * can be subclassed.
	 */
	abstract void moveTo();

	/*
	 * When an abstract class is subclassed, the subclass usually provides
	 * implementations for all of the abstract methods in its parent class. However,
	 * if it does not, then the subclass must also be declared abstract.
	 */

	class extendAndProvideImplementation extends AbstractClassAndMethods {
		@Override
		void moveTo() {
			// TODO Auto-generated method stub

		}
	}
	// this class becomes abstract
	abstract class extendAndDoNotProvideImplementation extends AbstractClassAndMethods{}
}
