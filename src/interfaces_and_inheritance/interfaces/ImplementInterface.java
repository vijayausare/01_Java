package interfaces_and_inheritance.interfaces;

public interface ImplementInterface {
	/*
	 * Implementating one than one interface By convention, the implements clause
	 * follows the extends clause, if there is one implements
	 */
	public class testClass1 implements interface1 {

		@Override
		public void test() {
			// TODO Auto-generated method stub

		}
	}

	/* Implementating more than one interface */
	public class testClass2 implements interface1, interface2, interface3 {

		@Override
		public void test() {
			// TODO Auto-generated method stub
		}
	}

	public interface interface1 {
		void test();
	}

	public interface interface2 {
	}

	public interface interface3 {
	}
}
