package Main;

import java.util.Random;

import Functions.Acley;
import Functions.Griewank;
import Functions.Michalewicz;
import Functions.Rastrigin;
import Functions.Rosenbrock;
import Functions.Schwefel;
import Functions.Sphere;
import PsoComponents.Particle;
import PsoComponents.Swarm;
import Topologies.MultiNeighborsOnMatriz;
import Topologies.RandomTopology;
import Topologies.Ring;
import Topologies.VonNeumann;

public class Pso implements PsoConstants{

	private Swarm swarm;
	private double nBestValue; //neighborhood best value
	private double nBestPos[]; //nieghborhood best position
	private double[] pAcceleration; //particles acceleration
	private double[] nAcceleration; //neighborhood accelation
	private double currValue; //current best value
	private double bestSoFar; //best value so far
	private double average = 0;
	private Random rand = new Random();
	private boolean globalNeighborhood = false;
	private String topology;
	private double[] arrayIterations = new double[ITERATIONS];
	
	public Pso(int swarmSize, String topology){
		this.swarm = new Swarm(swarmSize);
		this.topology = topology;
	}
	
	
	
	//Rosenbrock: 
	//	initializes particle's position: [15,30]
	//						   velocity: [-2,2]
	public  void initRok(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;;
		for(int i=0; i<swarmSize; i++) {
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = -5.0 + rand.nextDouble()*(5 - (-5.0));
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j];
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*(2.0+2.0);
			}
			double pBesValue = Rosenbrock.rosenbrockEvaluate(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBesValue);
			if(this.topology  == "Global"){
				currVal = eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}	
	}
	
	
	//Ackley: 
	//	initializes particle's position: [16,32]
	//						   velocity: [-2,4]
	public  void initAck(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;
		for(int i=0; i<swarmSize; i++) {		
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = 16.0 + rand.nextDouble()*(32.0-16.0);
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j];
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*(4.0+2.0);
			}
			double pBestValue = Acley.ack(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBestValue);
			if(this.topology == "Global"){
				currVal=eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}
	}
	
	
	
	//Rastrigin: 
	//	initializes particle's position: [2.56,5.12]
	//						   velocity: [-2,4]
	public  void initRas(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;;
		for(int i=0; i<swarmSize; i++) {	
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = 2.56 + rand.nextDouble()*((5.12-2.56));
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j]; //adicionado aqui
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*((2.0+2.0));
			}
			System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, swarm.getSwarm()[i].getpBestPos(), 0, DIMENSIONS);
			double pBestValue = Rastrigin.ras(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBestValue);
			if(this.topology == "Global"){
				currVal=eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}	
	}
	
	//	Sphere
	//	initializes particle's position: [2.56,5.12]
	//						   velocity: [-2,4]
	
	public void initSphere(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;
		for(int i=0; i<swarmSize; i++) {		
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = -50 + rand.nextDouble()*(100-(-50));
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j];
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*(4.0+2.0);
			}
			double pBestValue = Sphere.Sp(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBestValue);
			if(this.topology == "Global"){
				currVal=eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}
	}
	
	//Michalewicz
	//	initializes particle's position: [2.56,5.12]
	//						   velocity: [-2,4]
	public void initMichalewicz(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;
		for(int i=0; i<swarmSize; i++) {		
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = 2.56 + rand.nextDouble()*(5.12-2.56);
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j];
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*(4.0+2.0);
			}
			double pBestValue = Michalewicz.Mi(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBestValue);
			if(this.topology == "Global"){
				currVal=eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}
	}
	
	
	public void initSchwefel(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;
		for(int i=0; i<swarmSize; i++) {		
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = -2 + rand.nextDouble()*(5 - (-2));
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j];
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*(4.0+2.0);
			}
			double pBestValue = Schwefel.Sch(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBestValue);
			if(this.topology == "Global"){
				currVal=eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}
	}
	
	public void initGriewank(){
		int swarmSize = this.swarm.getSwarm().length;
		double currVal=Double.MAX_VALUE;
		for(int i=0; i<swarmSize; i++) {		
			for(int j=0; j<DIMENSIONS; j++){
				swarm.getSwarm()[i].getPosition()[j] = 16.0 + rand.nextDouble()*(32.0-16.0);
				swarm.getSwarm()[i].getpBestPos()[j] = swarm.getSwarm()[i].getPosition()[j];
				swarm.getSwarm()[i].getVelocity()[j] = -2.0 + rand.nextDouble()*(4.0+2.0);
			}
			double pBestValue = Griewank.Gri(this.swarm, i);
			swarm.getSwarm()[i].setpBestValue(pBestValue);
			if(this.topology == "Global"){
				currVal=eval(i);
				if(currVal < nBestValue){
					nBestValue=currVal;
					System.arraycopy(swarm.getSwarm()[i].getPosition(), 0, nBestPos, 0, DIMENSIONS);
				}
			}
		}
	}
	
	
	//evaluates the value of a particle of index i
	public double eval(int i){
		double value=Double.MAX_VALUE;
		switch(FUNCTION){
			case "Rosenbrock":
				value=Rosenbrock.rosenbrockEvaluate(this.swarm, i);
				break;
			case "Acley":
				value=Acley.ack(this.swarm, i);
				break;
			case "Rastrigin":
				value=Rastrigin.ras(this.swarm, i);
				break;
			case "Sphere":
				value = Sphere.Sp(this.swarm, i);
				break;
			case "Michalewicz":
				value = Michalewicz.Mi(this.swarm, i);
				break;
			case "Schwefel":
				value = Schwefel.Sch(this.swarm, i);
				break;
			case "Griewank":
				value = Griewank.Gri(this.swarm, i);
				break;
			default: 
				System.out.println("Function must match 'Rosenbrock', 'Acley', Sphere, Michalewicz, Schwefel, Griewank or 'Rastrigin'");
				System.exit(1); 
		}
		return value;
	}
	
	
	//initializes position and velocity of all the particles
	public void init(){
		if(this.topology == "Global")
			globalNeighborhood=true;
		switch(FUNCTION){
			case "Rosenbrock":
				initRok();
				break;
			case "Acley":
				initAck();
				break;
			case "Rastrigin":
				initRas();
				break;
			case "Sphere":
				initSphere();
				break;
			case "Michalewicz":
				initMichalewicz();
				break;
			case "Schwefel":
				initSchwefel();
				break;
			case "Griewank":
				initGriewank();
				break;
			default: 
				System.out.println("Function must match 'Rosenbrock', 'Acley', or 'Rastrigin', Sphere, Schwefel, Griewank or Michalewicz");
				System.exit(1); 
		}
	}
	
	
	//Update the particles
	//Pass in the diff neighbors
	public void update(int iterations){
		
		//System.out.println("Best so far Init:" + bestSoFar + "\n");
		//System.err.println("Init update iterations \n");
		updateHelper(iterations, false);
		
		
	}
	
	private void updateHelper(int iterations, boolean print){
		for (int i = 0; i < iterations; i++) { //For the # of iterations
			int swarmSize = this.swarm.getSwarm().length;
			//System.out.println();
			//System.err.println("ITERATION:" + i );
			for(int j = 0; j < swarmSize; j++){	//Calculate new positions
				//System.out.println("J:" + j);
				//System.out.println("Particle " + j + " Neighbors size:" + (swarm.getSwarm()[j].getNeighbors().length));
				//Calculate local best val and pos. Skip for global because
				//these are set when fitnesses are updated
				if(!globalNeighborhood){ 
					//System.out.println("Particle:" + j);
					for(int n = 0; n < swarm.getSwarm()[j].getNeighbors().length; n++){
						if(n==0){
							nBestValue = swarm.getSwarm()[swarm.getSwarm()[j].getNeighbors()[n]].getpBestValue();
							nBestPos = swarm.getSwarm()[swarm.getSwarm()[j].getNeighbors()[n]].getPosition().clone();
							continue;
						}
						double currentNeighborsBest = swarm.getSwarm()[swarm.getSwarm()[j].getNeighbors()[n]].getpBestValue();
						
						
						double[] position = swarm.getSwarm()[swarm.getSwarm()[j].getNeighbors()[n]].getPosition().clone();
						if(currentNeighborsBest < nBestValue){
							nBestValue = currentNeighborsBest;
							nBestPos = position.clone();
						}   
					}
				}

				for (int d = 0 ; d < DIMENSIONS; d++) {
					swarm.getSwarm()[j].getVelocity()[d] = CONSTRICTION_FACTOR * (swarm.getSwarm()[j].getVelocity()[d] + (phi1 * rand.nextDouble() * (swarm.getSwarm()[j].getpBestPos()[d] - swarm.getSwarm()[j].getPosition()[d]))  +  phi2 * rand.nextDouble() * (nBestPos[d] - swarm.getSwarm()[j].getPosition()[d]));
					swarm.getSwarm()[j].getPosition()[d] += swarm.getSwarm()[j].getVelocity()[d];
				}
			}
			//update fitnesses
			for(int s=0; s<swarmSize; s++){
				//calculate fitnesses
					double pFitness = eval(s);
					if(pFitness < swarm.getSwarm()[s].getpBestValue()){
						swarm.getSwarm()[s].setpBestValue(pFitness);
						System.arraycopy(swarm.getSwarm()[s].getPosition(), 0, swarm.getSwarm()[s].getpBestPos(), 0, DIMENSIONS);
					}
					if(pFitness<bestSoFar){bestSoFar = pFitness;}		
					if(globalNeighborhood && pFitness<nBestValue){ //update neighborhood best for Global
						nBestValue = pFitness;
						System.arraycopy(swarm.getSwarm()[s].getPosition(), 0, nBestPos, 0, DIMENSIONS);
					}
			}
			//System.err.print("Iteration:" + i + "  ");
			if(print){
				//System.out.println();
				System.out.println(bestSoFar);
				//System.out.println();
				//System.out.printf("%f, ", bestSoFar);
				
			}
			average += bestSoFar;
			arrayIterations[i] = bestSoFar;
		}
		//System.out.println("Best so far:" + bestSoFar);
		//System.out.println("Average:" + (average/iterations));
	}
	
	
	public void runWithArgs(){
		/*
		System.out.println();
		System.err.println("Neighbors Topology:");
		System.out.println("	Global");
		System.out.println("	Ring");
		System.out.println("	VonNeumann");
		System.out.println("	Random");
		System.err.println("Functions:");
		System.out.println("	Rosenbrock");	
		System.out.println("	ack = Ackley");
		System.out.println("	ras = Rastrigin");
		System.out.println();
		*/
		pAcceleration = new double[DIMENSIONS];
		nAcceleration = new double[DIMENSIONS];
		currValue=Double.MAX_VALUE;
		nBestPos = new double[DIMENSIONS];
		nBestValue=Double.MAX_VALUE;
		bestSoFar = Double.MAX_VALUE;

		if(DIMENSIONS < 3){
			System.out.println("The dimensions must be greater than 2.");
			System.exit(1);
		}
		
		//SWARM SIZE
		int swarmSize = swarm.getSwarm().length;
		//INIT SWARM 
		for(int i=0; i<swarmSize; i++){
			swarm.getSwarm()[i] = new Particle(DIMENSIONS);
	    }
	   
		// INIT THE FUCTION SELECTED WITH OUR BOUNDS
		init();
		
		//INIT SWARM'S NEIGHBORS WITH THE TOPOLOGY SELECTED
		switch(topology){
			case "Global":
				globalNeighborhood = true;
				break;
			case "Ring":
				Ring.initRing(swarm, swarmSize);
				break;
			case "VonNeumann":
				VonNeumann.initVonNeumann(swarm, swarmSize);
				break;
			case "Random":
				RandomTopology.initRandom(swarm, swarmSize);
				break;
			case "MNOM" :
				MultiNeighborsOnMatriz.initMultiNeighborsOnMatriz(swarm, swarmSize);
				break;
			default: 
				System.out.println("Neighborhood topology must match 'Global', 'Ring', 'VonNeumann' or 'Random'");
				System.exit(1); //exit if incorrect input
		}
		update(ITERATIONS);
		//System.out.println("-------------------------");
		//swarm.printSwarmsNeughbors();
		//swarm.prinSwarmpBestPosition();
		//System.out.println();
		//System.err.printf("\nfinal best: %f\n", bestSoFar);
	}
	
	public double getBestSoFar(){
		return this.bestSoFar;
	}
	
	public double getAverage(){
		return this.average / ITERATIONS;
	}
	
	public String getTopology(){
		return this.topology;
	}
	
	public double[] getArrayToGraphic(){
		return this.arrayIterations;
	}
}
