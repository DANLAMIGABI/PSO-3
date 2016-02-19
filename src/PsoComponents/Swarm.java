package PsoComponents;


public class Swarm {
	private Particle[] swarm; 	//global array of particles
	
	public Swarm(int swarmSize){
		swarm = new Particle[swarmSize];
	}
	
	public Particle[] getSwarm(){
		return this.swarm;
	}
	
	public void printSwarmsNeughbors(){
		int swarmSize = swarm.length;
		for(int i = 0; i < swarmSize; i++ ){
			System.out.println("Particle " + i + " :");
			for(int j = 0; j < swarm[i].getNeighbors().length; j++){
				System.out.println("Neighbor " + j + ":" + swarm[i].getNeighbors()[j]);
			}
			System.out.println();
		}
	}
	
	public void printSwarmVelocity(){
		for(int i = 0; i < swarm[i].getVelocity().length ; i++){
			System.out.println("Velocity "+ i + ": " + swarm[i].getVelocity()[i]);
		}
	}
	
	public void prinSwarmpBestPosition(){
		for(int i = 0; i < swarm[i].getpBestPos().length ; i++){
			System.out.println("pBestPosition "+ i + ": " + swarm[i].getpBestPos()[i]);
		}
	}
}
