package kimble;

/*
 * Player class is to handle the player options and information.
 * Player is actually the team.
 */
public class Player {
	private int teamSize;
	private String name;
	private Colors color;
	
	public Player(Colors color) {
		this.setColor(color);
		// TODO: Error handling? Not necessarily
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Colors getColor() {
		return color;
	}

	public void setColor(Colors color) {
		this.color = color;
	}
	
	
}
