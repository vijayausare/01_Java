package interfaces_and_inheritance.interfaces;

public class UsingInterfaceAsType {
	/*
	 * If you define a reference variable whose type is an interface, any object you
	 * assign to it must be an instance of a class that implements the interface.
	 */
	TestInterface testInterface;
	/* Above testInterface variable will store instance of a class that implements
	 the TestInterface. */
}

interface TestInterface {}
