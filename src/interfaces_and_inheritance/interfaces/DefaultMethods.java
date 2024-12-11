package interfaces_and_inheritance.interfaces;

import java.util.Date;

public interface DefaultMethods {

	/*
	 * Default methods enable you to add new functionality to the interfaces of your
	 * libraries and ensure binary compatibility with code written for older
	 * versions of those interfaces. when we want to add new function in the
	 * existing interface then we use default methods default methods requires the
	 * body
	 */
	interface interface1 {
		void setTime(int hour, int minute, int second);

		void setDate(int day, int month, int year);

		default Date getTime() {
			return new Date();
		}
	}

	/***************************************************
	 * Extending Interfaces That Contain Default Methods
	 ***************************************************/
	/*
	 * When you extend an interface that contains a default method, you can do the
	 * following:
	 * 
	 * 1. Do not mention the default method at all, which lets your extended interface
	 *    inherit the default method. 
	 * 2. Redeclare the default method, which makes it
	 * 	  abstract. 
	 * 3. Redefine the default method, which overrides it.
	 */
	
	/************1***************/
	class inheritDefaultMethod implements interface1 {

		void test() {
			// we can access the default method present in the interface1
			System.out.println(getTime());
		}

		@Override
		public void setTime(int hour, int minute, int second) {
			// TODO Auto-generated method stub

		}

		@Override
		public void setDate(int day, int month, int year) {
			// TODO Auto-generated method stub

		}
	}
	
	/************2***************/
	interface RedeclarDefaultMethod extends interface1{
		// RedeclarDefaultMethod makes this method as abstract
		Date getTime();
	}
	
	class RedeclarDefaultMethodClass implements RedeclarDefaultMethod {

		@Override
		public void setTime(int hour, int minute, int second) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setDate(int day, int month, int year) {
			// TODO Auto-generated method stub
			
		}

		// this methods is made abstract here
		@Override
		public Date getTime() {
			// TODO Auto-generated method stub
			return null;
		}}
}
