package Main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double average = 0;
		for(int i = 0; i < 101; i++){
			System.out.println("ITERATION:" + i);
			Pso pso = new Pso(49);
			pso.runWithArgs();
			average += pso.getBestSoFar();
		}
		
		System.out.println();
		System.out.println("AVERAGE:" + average/100);
	}
}
