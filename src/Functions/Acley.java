package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Acley implements PsoConstants {
	//Ackley
	// minimum is 0.0, which occurs at (0.0,...,0.0)
	// reads in a particle and returns the value
	public static  double ack(Swarm swarm, int pIndex){
		double sum1=0;
    	double sum2=0; 

    	for(int i=0; i<DIMENSIONS; i++){
    		sum1 += Math.pow(swarm.getSwarm()[pIndex].getPosition()[i],2.0);
    	}

    	for(int i=0; i<DIMENSIONS; i++){
  			sum2 += Math.cos(2.0*Math.PI*swarm.getSwarm()[pIndex].getPosition()[i]);
		}	

    	return -20.0 * Math.exp(-0.2 * Math.sqrt(sum1/DIMENSIONS) - Math.exp(sum2/DIMENSIONS)) + 20.0 + Math.E;
	}
}
