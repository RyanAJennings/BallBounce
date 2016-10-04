import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/// @brief Simulator for a ball.
///
/// The simulator owns the ball and determines the overall forces for an object.
/// It also determines the simulation loop of the code - clear, update, draw.
public class Simulator implements ActionListener{

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == GUI.gravityButton){
      double g = Double.parseDouble(GUI.gravityChange.getText());
      gravity.Y(g);
    }
    if (e.getSource() == GUI.timeButton){
      timeStep = Double.parseDouble(GUI.timeChange.getText());
    }
    if (e.getSource() == GUI.massButton){
      //m = Double.parseDouble(GUI.massChange.getText());
    }
  }


  private double timeStep; /// Timestep - time passed in virtual world per frame
  private Ball ball;       /// Ball to simulate
  private Vector gravity;  /// Gravity force
  private Vector windForce; /// Wind force
  

  /// @brief Constructor
  /// @param m Mass of the ball
  /// @param t Time step
  /// @param g Gravity magnitude
  /// @param d aerodynamics of ball
  public Simulator(double m, double t, double g, double d) {
    GUI.gravityButton.addActionListener(this);
    GUI.timeButton.addActionListener(this);
    GUI.massButton.addActionListener(this);
    timeStep = t;
    ball = new Ball(m, d);
    gravity = new Vector(0, g);
    windForce = new Vector(d, 0);
  }

  /// @brief Simulation loop
  ///
  /// Clear, update, draw
  public void simulate() {
    while(true) {
      GUI.clear();
      Vector ftot = determineForces();
      ball.applyForce(ftot, timeStep);
      ball.draw();
      GUI.draw();
    }
  }

  private Vector determineForces() {
    //determine F_g -> force due to gravity
    Vector fg = gravity.scalarMultiply(ball.getMass());
    //determine F_w -> wind force
    Vector fw = windForce.scalarMultiply(ball.getDyn());
    //determine F_a -> air resistance force
    Vector fa = ball.getVel().scalarMultiply(-ball.getDyn());
    //F_tot = F_g + F_w + F_a
    return fg.plus(fw.plus(fa));
  }


  //ftotal new function
  //check collision new function
  //line intersection review to get the fraction
  

}
