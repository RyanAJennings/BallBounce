
public class Boundary{
  //owned by simulator
  private double xmin, xmax;
  private double ymin, ymax;
  
  public BoundingBox(double xmin, double xmax, double ymin, double ymax){
    this.xmin = xmin;
    this.xmax = xmax;
    this.ymin = ymin;
    this.ymax = ymax;
  }
  
  public draw(double r){
    GUI.drawRectangle(xmin - r, xmax + r, ymin - r, ymax + r);
  }
  
  private Collision checkCollision(Vector p, Vector pnew) {
    //TODO extend to obstacles and abstract boundary
    Collision c = new Collision(Double.POSITIVE_INFINITY, null);
    double f;
    if(pnew.x() > 50) {
      f = (50-p.x())/(pnew.x()-p.x());
      c = new Collision(f, new Vector(-1, 0));
    }
    else if(pnew.x() < -50) {
      f = (-50-p.x())/(pnew.x()-p.x());
      if(f < c.f())
        c = new Collision(f, new Vector(1, 0));
    }
    if(pnew.y() > 50) {
      f = (50-p.y())/(pnew.y()-p.y());
      if(f < c.f())
        c = new Collision(f, new Vector(0, -1));
    }
    else if(pnew.y() < -50) {
      f = (-50-p.y())/(pnew.y()-p.y());
      if(f < c.f())
        c = new Collision(f, new Vector(0, 1));
    }
    if(c.f() != Double.POSITIVE_INFINITY)
      return c;
    else
      return null;
  }
  
  
  
  public static xMax(){return xmax;}
  public static xMin(){return xMin;}
  public static yMax(){return yMax;}
  public static yMin(){return yMin;}
}
