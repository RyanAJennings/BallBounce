/// @brief This program simulates the motion of a bouncing ball in a vacuum.
public class BallSimulation {
  public static void main(String args[]) {
    if(args.length != 4) {
      System.out.println("Usage: java BallSimulation <mass> <time step> <gravity magnitude in down-y direction> <dynamics>");
      System.exit(1);
    }

    // Input mass, time, gravity
    double m = Double.parseDouble(args[0]);
    double t = Double.parseDouble(args[1]); //0.#
    double g = Double.parseDouble(args[2]); // - down + up
    double d = Double.parseDouble(args[3]); // bigger -> wind affects more

    // Make a simulator on the parameters and simulate
    Simulator simulator = new Simulator(m, t, g, d);
    simulator.simulate();
  }
}
