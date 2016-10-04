OBJS = GUI.java BallSimulation.java Simulator.java Vector.java

default:
	javac $(OBJS)
clean:
	rm -f *.class
