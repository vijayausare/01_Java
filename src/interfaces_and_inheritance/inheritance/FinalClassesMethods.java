package interfaces_and_inheritance.inheritance;

import interfaces_and_inheritance.interfaces.DefaultMethods;

public class FinalClassesMethods {
	/*
	 * You can declare some or all of a class's methods final. You use the final
	 * keyword in a method declaration to indicate that the method cannot be
	 * overridden by subclasses. The Object class does this—a number of its methods
	 * are final.
	 */

	/* A final class is simply a class that can't be extended. */

	class ChessAlgorithm {
		enum ChessPlayer {
			WHITE, BLACK
		}

		final ChessPlayer getFirstPlayer() {
			return ChessPlayer.WHITE;
		}
	}
	/*
	 * Methods called from constructors should generally be declared final. If a
	 * constructor calls a non-final method, a subclass may redefine that method
	 * with surprising or undesirable results.
	 * 
	 * Note that you can also declare an entire class final. A class that is
	 * declared final cannot be subclassed. This is particularly useful, for
	 * example, when creating an immutable class like the String class.
	 */

	final class ThisClassCanNotBeExtendedButCanExtendOtherClass extends Thread implements DefaultMethods {
	}
}
