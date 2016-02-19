package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Rastrigin implements PsoConstants {
	//Rastrigin
	// 	minimum is 0.0, which occurs at (0.0,...,0.0)
	//	reads in a particle and returns the value
	public static double ras(Swarm swarm, int pIndex){
    	double sum=0;

    	for(int i=0; i<DIMENSIONS; i++){
   	 		sum += swarm.getSwarm()[pIndex].getPosition()[i]*swarm.getSwarm()[pIndex].getPosition()[i] - 10.0*Math.cos(2.0*Math.PI*swarm.getSwarm()[pIndex].getPosition()[i]) + 10.0;
    	}

    	return sum;
	}
}
