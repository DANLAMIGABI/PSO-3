package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Sphere implements PsoConstants {
	
	public static double Sp(Swarm swarm, int pIndex){
		double sum = 0;
		for(int i = 0; i < DIMENSIONS; i++){
			sum += swarm.getSwarm()[pIndex].getPosition()[i] * swarm.getSwarm()[pIndex].getPosition()[i];
		}
		return sum;
	}
}
