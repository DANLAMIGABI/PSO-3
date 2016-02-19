package Topologies;

import java.util.Arrays;
import java.util.Random;

import PsoComponents.Swarm;

public class RandomTopology {
	
	
	//Random:  	consider a random topolgy where the neighborhood size is randomly determined
		// 	the neighbors are also randomly determined and not repeated
		public static void initRandom(Swarm swarm, int swarmSize){
			Random rand = new Random();
			int neighborhoodSize = rand.nextInt(swarmSize-1)+1;
			//set neighbors for each particle in the swarm
			for(int i=0; i<swarmSize; i++){
				//randomly select size of neighborhood
				int[] neighbors = new int[neighborhoodSize];
				int[] used = new int[swarmSize];
				Arrays.fill(neighbors, -1);
				neighbors[0] = i;
				//while unique neighborhood has not yet been found, randomly select neighbors
				for(int j=1; j<neighborhoodSize; j++){
					int iP = rand.nextInt(swarmSize);
					if(used[iP]==1){
						j--;
					} else {
						used[iP] = 1;
						neighbors[j]=iP;
					}
				}
				swarm.getSwarm()[i].setNeighbors(neighbors.clone());
				//swarm[i].neighbors = neighbors.clone();
			}
		}
}
