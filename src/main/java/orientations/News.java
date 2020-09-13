package orientations;

public enum News {

	NORTH('N'),
	EAST('E'),
	WEST('W'),
	SOUTH('S');
	
	private final char code;
	
	private News(char code) {
		this.code = code;
	}

	public News leftOrientation() {
		News o = null;
		switch (this) {
		case NORTH:
			o = WEST;
			break;
		case EAST:
			o = NORTH;
			break;
		case SOUTH:
			o = EAST;
			break;
		case WEST:
			o = SOUTH;
			break;
		}
		return o;
	}

	public News rightOrientation() {
		News o = null;
		switch (this) {
		case NORTH:
			o = EAST;
			break;
		case EAST:
			o = SOUTH;
			break;
		case SOUTH:
			o = WEST;
			break;
		case WEST:
			o = NORTH;
			break;
		}
		return o;
	}
	
	public static News news(char code) {
		News found = null;
		for(News news : News.values()) {
			if(news.code == code) {
				found = news;
				break;
			}
		}
		return found;
	}
}
