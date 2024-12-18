package interfaces_and_inheritance.inheritance;

public class HidingFields {
	/*
	 * Within a class, a field that has the same name as a field in the superclass
	 * hides the superclass'sfield,even if their types are different. Within the
	 * subclass, the field in the superclass cannot be referenced by its simple
	 * name.Instead, the field must be accessed through super.Generally speaking, we
	 * don't recommend hiding fields as it makes code difficult to read.
	 */

	/*
	 * If a constructor does not explicitly invoke a superclass constructor, the
	 * Java compiler automatically inserts a call to the no-argument constructor of
	 * the superclass. If the super class does not have a no-argument constructor,
	 * you will get a compile-time error. Object does have such a constructor, so if
	 * Object is the only superclass, there is no problem.
	 */
}
