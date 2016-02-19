package Topologies;

import PsoComponents.Swarm;

public class VonNeumann {
	
		// von Neumann: 	considers a topolgy of a grid
		// neighbors are above, below, left and right of particle
		public static void initVonNeumann(Swarm swarm, int swarmSize){
			//set row and col counts
			int rows = (int)Math.sqrt(swarmSize);
			int cols = rows;
			int overflow = swarmSize % rows;
			if(overflow>0){rows+=1;} //if there is overflow, add a row
			//set neighbors for each particle in the swarm
			for(int i=0; i<rows; i++){
				//if in overflow row (last row), set cols to overflow count
				if(overflow>0 && i==rows-1){cols = overflow;} 
				for(int j=0; j<cols; j++){
					int index = (i*cols) + j; //particle index
					int n, s, w, e;
					//Set North Neighbor
					//If at top, north is particle at end of column (last row) 
					if(i==0){
						n=swarmSize-j-1;
						if(overflow>0 && j>overflow-1){n-=cols;} //in case of overflow, account for empty spaces
					} else {
						n = ((i-1)*cols) + j; //normal operation, get particle up a row
					}
						
					//Set South Neighbor
					if(i==rows-1){s=j;} //in last row, set south neighbor to corresponding index in first row
					else if(overflow>0 && j > overflow-1 && i == rows-2){s=j;} //row above last row, but empty columns below due to overflow
					else { s = ((i+1)*cols) + j;} // standard operating procedure

					//Set West and East Neighbors
					w = index - 1;
					e = index + 1;
					//Apply wrap around if necessary (note: cols is adjusted for overflow row)
					if(j == 0){ w += cols;}
					if(j == cols-1){ e -= cols;}
					int[] neighbors = new int[]{n, s, w, e, index};
					swarm.getSwarm()[index].setNeighbors(neighbors.clone());
					//swarm[index].neighbors = neighbors.clone();
				}
			}
		}

	
}
