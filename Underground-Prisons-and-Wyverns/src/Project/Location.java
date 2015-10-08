package Project;

public class Location {
	int x;
	int y;
	boolean secret = false;
	boolean visited = false;
	public Location(int x_pos, int y_pos){
		x=x_pos;
		y = y_pos;
	}
	public Location(int x_pos, int y_pos, boolean s){
		x=x_pos;
		y = y_pos;
		secret = s;
	}
}
