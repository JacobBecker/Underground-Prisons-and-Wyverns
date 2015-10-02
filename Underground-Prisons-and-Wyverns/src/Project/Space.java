
public class Space 
{
	boolean visited = false;
	boolean char_occupied = false;
	boolean shop = false;
	Enemy[] enemies;
	Space [] adjacent;
	public Space(Space previous_room, int num_enemies)
	{
		enemies = new Enemy[num_enemies];
		for (int i=0; i<num_enemies; i++)
		{
			enemies[i] = new Enemy();
		}
		//adjacent = new Space[num_doors];
		Space [] adjacent = new Space[4];//this assumes that no room will have more than 4 connecting rooms
		for (int i=0; i<adjacent.length; i++)
			adjacent[i] = null;
		adjacent[0] = previous_room;
	}
	public void connect_rooms(Space [] rooms)
	{
		for (int i=0; i<rooms.length; i++)
		{
			adjacent[i+1] = rooms[i];
		}
	}
}
