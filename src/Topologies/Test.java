package Topologies;

import PsoComponents.Swarm;

public class Test {
	public static void initTest(Swarm swarm, int swarmSize){
		for(int i=0; i<swarmSize; i++){
			int[] neighbors = new int[1];
			if(i==0){ //if at start, connect to the last element of the array (to make a ring)
				neighbors[0] = i+1;
			} 
			else if (i==swarmSize-1) //if at the end, connect to the first element
				neighbors[0] = 0;
		
			swarm.getSwarm()[i].setNeighbors(neighbors.clone());
			//swarm[i].neighbors = neighbors.clone();
		
		}		
	}
}
