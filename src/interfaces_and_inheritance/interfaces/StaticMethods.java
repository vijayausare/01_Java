package interfaces_and_inheritance.interfaces;

import java.util.Date;

public interface StaticMethods {

	/*
	 * A static method is a method that is associated with the class in which it is
	 * defined rather than with any object. Every instance of the class shares its
	 * static methods
	 */
	
	/**IMP: Static methods in interfaces are never inherited. but can be called 
 		using the Interface name similar like class static methods**********************/
	interface interface1 {
		void setTime(int hour, int minute, int second);

		void setDate(int day, int month, int year);

		default public Date getTime() {
			return getDate();
		}

		static Date getDate() {
			return new Date();
		}
	}
}
