package mower;

public enum Commands {

	TURN_LEFT('L'),
	TURN_RIGHT('R'),
	MOVE_FORWARD('F');

	private final char code;

	private Commands(char code) {
		this.code = code;
	}

	public static Commands command(char code) {
		Commands found = null;
		for (Commands command : Commands.values()) {
			if (code == command.getCode()) {
				found = command;
				break;	
			}
		}
		return found;
	}

	public char getCode() {
		return code;
	}
}
