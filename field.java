public class field { 
  int sideLength;
  public int myLimit;
  boolean[][] field;
  fielders[] objects;
  
  public field(int side, int quant) { 
    myLimit = (side - 1);
    sideLength = side;
    field = new boolean[side][side];
    spawn(quant);
  }
  
  public void spawn(int quantity) {
    objects = new fielders[quantity];
    for (int i = 0; i < quantity; i++)
      objects[i] = new fielders(sideLength / 2, sideLength / 2, myLimit);
  }
  
  public void clearSpace(int index) {
    int[] coords = objects[index].getCoords();
    field[coords[0]][coords[1]] = false;
  }
  
  public void play()
  {
    for (;;) {
      printer();
      for (int i = 0; i < objects.length; i++) {
        clearSpace(i);
        int[] movement = objects[i].act();
        field[movement[0]][movement[1]] = true;
      }
    }
  }
  
  public void printer()
  {
    try
    {
      Thread.sleep(64L);            //this is rendering everything at ~15 fps
    }
    catch (InterruptedException ex)
    {
      Thread.currentThread().interrupt();
    }
    
    String text = "";
    for (int i = 0; i < sideLength; i++) {
      for (int j = 0; j < sideLength; j++) {
        text = text + boolTochar(field[i][j]) + " ";
      }
      text = text + "\n";
    }
    text = text + "--------------------------------\n";
    System.out.print(text);
  }
  
  public char boolTochar(boolean bool) { 
    if (bool) {
      return '@';
    }
    
    return '.';
  }
}