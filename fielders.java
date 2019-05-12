import java.util.Random;

public class fielders{
  private int[] myCoord = new int[2];
  private int limit;
  Random rand = new Random();
  

  public fielders(int x, int y, int lim)
  {
    myCoord[0] = x;
    myCoord[1] = y;
    limit = lim;
  }
  public int[] act()
  {
    myCoord = move();
    return myCoord;
  }
  public int[] getCoords()
  {
    return myCoord;
  }
  public int[] move()
  {
    int[] vent = new int[2];
    vent[0] = (myCoord[0] + rand.nextInt(3) - 1);
    vent[1] = (myCoord[1] + rand.nextInt(3) - 1);
    if ((vent[0] < 0) || (vent[0] > limit) || (vent[1] < 0) || (vent[1] > limit)) {
      vent = move();
    }
    return vent;
  }
  }