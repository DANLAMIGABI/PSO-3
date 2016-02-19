package Topologies;

import PsoComponents.Swarm;

public class Ring {
	
	//NOTE: a particle's neighbors list does NOT include the particle itself. Inclusion
		//of the particle is achieved with explicit inclusion in the run function.
		//Ring: considers the topolgy of a ring and the neighbors are particles
		//		to the right and left
	
	public static void initRing(Swarm swarm, int swarmSize){
		//set neighbors for each particle in the swarm to the previous and the next particle 
		//order is determined by the order in the array
		for(int i=0; i<swarmSize; i++){
			int[] neighbors = new int[3];
			if(i==0){ //if at start, connect to the last element of the array (to make a ring)
				neighbors[0] = swarmSize-1;
				neighbors[1] = i+1;
			} else if (i==swarmSize-1){ //if at the end, connect to the first element
				neighbors[0] = i-1;
				neighbors[1] = 0;
			} else {
				neighbors[0] = i-1;
				neighbors[1] = i+1;
			}
			neighbors[2]=i;
			swarm.getSwarm()[i].setNeighbors(neighbors.clone());
			//swarm[i].neighbors = neighbors.clone();
		}
	}
}
