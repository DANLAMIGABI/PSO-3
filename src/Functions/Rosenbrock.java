package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Rosenbrock implements PsoConstants {
	//Rosenbrock
    // minimum is 0.0, which occurs at (1.0,...,1.0)
    // reads in a particle and returns the value
	public static double rosenbrockEvaluate(Swarm swarm, int pIndex){
		double sum=0;
		for(int i=0; i<DIMENSIONS-1; i++){
			sum += 100.0 * Math.pow(swarm.getSwarm()[pIndex].getPosition()[i+1] - swarm.getSwarm()[pIndex].getPosition()[i]*swarm.getSwarm()[pIndex].getPosition()[i], 2.0) + Math.pow(swarm.getSwarm()[pIndex].getPosition()[i]-1.0, 2.0);
		}
		return sum;
	}
}
