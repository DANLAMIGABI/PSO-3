package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Schwefel implements PsoConstants{
	public static double Sch(Swarm swarm, int pIndex){
		double sum = 0;
		for(int i = 0; i < DIMENSIONS; i++){
			for(int j = 0; j < i; j++){
				sum += swarm.getSwarm()[pIndex].getPosition()[j] * swarm.getSwarm()[pIndex].getPosition()[j];
			}
		}
		
		return sum;
	}
}
