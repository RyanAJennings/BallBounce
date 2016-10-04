/// @brief A class encapsulating a state for our simulation
///
/// A Ball is the State of the simulator. It contains an intrinsic mass. It
/// contains position and velocity data. It contains operations to access, modify,
/// and integrate the state.
public class Ball {
  private Vector pos, vel; ///< Position/velocity/windforce
  private double mass;     ///< Mass
  private double dynamics;

  /// @brief Construor to initialize position/velocity to (0,0) and mass to m
  /// @param m Mass
  public Ball(double m, double d) {
    dynamics = d;
    mass = m;
    pos = new Vector();
    vel = new Vector();

  }

  public Vector getVel() {return vel;}
  public double getMass() {return mass;}
  public double getDyn() {return dynamics;}

  /// @brief Apply force to the ball for a small time step using Euler
  ///        Integration
  /// @param force Force to apply
  /// @param t Time step
  ///
  /// x = x + t*v;
  /// v = v + t*a;
  public void applyForce(Vector force, double t) {
    Vector acc = force.scalarMultiply(1./mass); //mass of 1
    pos.add(vel.scalarMultiply(t));
    vel.add(acc.scalarMultiply(t));

    //Bounce off bottom/top of box
    if(Math.abs(pos.Y()) > 50) {
      vel.Y(-vel.Y());
    }
  
    //Bounce off the sides of the box
    if(Math.abs(pos.X()) > 50) {
      vel.X(-vel.X());
  }

}

  /// @brief Draw the ball as a circle
  public void draw() {
    GUI.drawCircle(pos.X(), pos.Y(), 2);
  }
}
