package Functions;

import Main.PsoConstants;
import PsoComponents.Swarm;

public class Michalewicz implements PsoConstants{
	public static double Mi(Swarm swarm, int pIndex){
		int m = 10;
		double sum = 0;
		
		for(int i = 0; i < DIMENSIONS; i++){
			sum -= Math.sin(swarm.getSwarm()[pIndex].getPosition()[i]) * Math.pow(Math.sin((i+1)*Math.pow(swarm.getSwarm()[pIndex].getPosition()[i], 2)/Math.PI), 2*m);
		}
		
		return sum;
	}
}
