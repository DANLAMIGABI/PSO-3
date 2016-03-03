package Averages;

import Main.Pso;
import Main.PsoConstants;

public class StandardDeviation implements PsoConstants {	
	
	private double[] arrayToPrintGraph;
	private Pso pso;
	private double averageHelper;
	private double averages[];
	private double average;
	private double deviation[];
	
	public StandardDeviation(int swarmSize, String topology){
		arrayToPrintGraph = new double[ITERATIONS];
		pso = new Pso(swarmSize, topology);
		averageHelper = 0;
		averages= new double[100];
		average = 0;
		initArrayToPrintGraph();
		deviation = new double[100];
	}
	
	
	
	
	public void sD(){
		for(int i = 0; i < 100; i++){
			pso.runWithArgs();
			averages[i] = pso.getBestSoFar();
			for(int j = 0; j < arrayToPrintGraph.length; j++){
				arrayToPrintGraph[j] += pso.getArrayToGraphic()[j];
			}
		}
		calculateAverageArrayToGraph();
		
		for(int i = 0; i < 100; i++){
			averageHelper += averages[i];
		}
		average = averageHelper/100;
		
		
		for(int i = 0; i < 100; i++){
			deviation[i] = averages[i] - average;
		}
		
		double deviationSquared[] = new double[100];
		for(int i = 0; i < 100; i++){
			deviationSquared[i] = deviation[i] * deviation[i];
		}
		
		double sumDeviationSquared = 0;
		for(int i = 0; i < 100; i++){
			sumDeviationSquared += deviationSquared[i];
		}
		
		double averageSumDeviationSquared = sumDeviationSquared / 100;
		
		double standardDeviation = Math.sqrt(averageSumDeviationSquared);
		System.out.println("----------------------------------");
		System.out.println("TOPOLOGY:" + pso.getTopology());
		System.out.println("AVERAGE:" + average);
		System.out.println("Standard Deviation:" + standardDeviation);
		System.out.println();
	}
	
	public void initArrayToPrintGraph(){
		for(int i = 0; i < ITERATIONS; i++)
			arrayToPrintGraph[i] = 0;
	}
	
	public void calculateAverageArrayToGraph(){
		for(int i = 0; i < ITERATIONS; i++){
			double result = arrayToPrintGraph[i];
			arrayToPrintGraph[i] = result / 100;
		}
	}
	
	public double[] getArrayToGraph(){
		return this.arrayToPrintGraph;
	}
	
}
