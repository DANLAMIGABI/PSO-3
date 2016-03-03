package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Griewank implements PsoConstants {
	public static double Gri(Swarm swarm, int pIndex ){
		double sum = 0;
		double prod = 1;
		for(int i = 0; i < DIMENSIONS; i++){
			sum += (swarm.getSwarm()[pIndex].getPosition()[i] * swarm.getSwarm()[pIndex].getPosition()[i]) / 4000;
			prod *= Math.cos(swarm.getSwarm()[pIndex].getPosition()[i] / Math.sqrt(i + 1));
		}
		
		return sum - prod + 1;
	}
}
