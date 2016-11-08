
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Obstacle{

  private Vector[] points;
  private Vector[] normals;
  private edge[] edges;
  
  public static void obstacle(String file) throws FileNotFoundException{
    Scanner s = new Scanner(new File(file));
    int numPoints = s.nextInt;
    for(int i = 0; i < numPoints; i++){
      j = 0;
      while(s.hasNextDouble()){
        points[i][j] = s.nextDouble;
      }
     }
    draw();
  }
  
}

