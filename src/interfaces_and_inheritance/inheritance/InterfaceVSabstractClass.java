package interfaces_and_inheritance.inheritance;

public class InterfaceVSabstractClass {

	// when to use Interface and abstract class

	interface interface1 {
		/*
		 * 1. You expect that unrelated classes would implement your interface. For
		 * 	  example, the interfaces Comparable and Cloneable are implemented by many
		 *    unrelated classes. 
		 * 
		 * 2. You want to specify the behavior of a particular data
		 *    type, but not concerned about who implements its behavior.
		 * 
		 * 3. You want to take advantage of multiple inheritance of type.
		 */
	}

	abstract class abstractClass {
		/*
		 * 1. You want to share code among several closely related classes. 
		 * 
		 * 2. You expect that classes that extend your abstract class have many common methods or fields,
		 * 	  or require access modifiers other than public (such as protected and private). 
		 * 
		 * 3. You want to declare non-static or non-final fields. This enables
		 * 	  you to define methods that can access and modify the state of the object to
		 * 	  which they belong.
		 */
	}

}
