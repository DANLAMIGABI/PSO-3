package PsoComponents;

public class Particle{
	
	//properties of a particle
	private double[] velocity; 
	private double[] position;
	private int neighbors[]; //indexes of a particle's neighbors
	private double pBestValue; //particle's best value
	private double pBestPos[]; //particle's best position

	public Particle(int dimensions) {
		//initialize the components
		position = new double[dimensions];
        velocity = new double[dimensions];
       	pBestPos = new double[dimensions];
    }
	
	
	//gets and sets about all particle's components
	
	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}

	public double[] getPosition() {
		return position;
	}

	public void setPosition(double[] position) {
		this.position = position;
	}

	public int[] getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(int[] neighbors) {
		this.neighbors = neighbors;
	}

	public double getpBestValue() {
		return pBestValue;
	}

	public void setpBestValue(double pBestValue) {
		this.pBestValue = pBestValue;
	}

	public double[] getpBestPos() {
		return pBestPos;
	}

	public void setpBestPos(double[] pBestPos) {
		this.pBestPos = pBestPos;
	}
	
	
	
	
	
	
	
}
