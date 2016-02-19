package Topologies;

import PsoComponents.Swarm;

public class MultiNeighborsOnMatriz {
	private static int mat[][];
	private static int square;

	public static void initMultiNeighborsOnMatriz(Swarm swarm, int swarmSize){
		square = sizeArraySquareInMatrix(swarmSize);
		if(square != 0){
			mat = new int[square][square];
			initMatrix();
			initMultiRandomChanges(swarm);
		}
		else
			System.out.println("Swarm's size: 9, 16, 25, 36, 49, 64, 81");
	}
	
	
	
	private static void initMatrix(){
		int aux = 0;
		for(int i = 0; i < square; i++){
			for(int j = 0; j < square; j++){
				mat[i][j] = aux;
				aux ++;
			}
		}
	}
	
	
	private static  int sizeArraySquareInMatrix(int swarmSize ){
		int aux = 3;
		while(true){
			if(swarmSize == (aux * aux)){
				return aux;
			}
			else if(swarmSize < (aux * aux))
				return 0;
			
			aux++;
		}
	}
	
	
	
	private static void initMultiRandomChanges(Swarm swarm){
		 //System.err.println("Square:" + square);
		int aux = 0;
		int neighbors[];
		for(int i = 0; i < square; i++){
			for(int j = 0; j < square; j++){
				// PRIMEIRO QUADRADO DA MATRIZ EM QUE CADA PARTICULA TEM 3 VIZINHOS
				if(i == 0 && j == 0){
					neighbors = new int[4];
					neighbors[0] = mat[0][1];
					neighbors[1] = mat[i+1][j];
					neighbors[2] = mat[i+1][j+1];
					neighbors[3] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
				
					
					aux++;
					
				}
				// SEGUNDO QUADRADO DA MATRIZ EM QUE CADA PARTICULA TEM 3 VIZINHOS
				else if(i == 0 && j == square -1){
					neighbors = new int[4];
					neighbors[0] = mat[i][j-1];
					neighbors[1] = mat[i+1][j-1];
					neighbors[2] = mat[i+1][j];
					neighbors[3] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
				
					aux++;
					
				}
				// TERCEIRO QUADRADO DA MATRIZ EM QUE CADA PARTICULA TEM 3 VIZINHOS
				else if(i == square -1 && j == 0){
					neighbors = new int[4];
					neighbors[0] = mat[i-1][j];
					neighbors[1] = mat[i-1][j+1];
					neighbors[2] = mat[i][j+1];
					neighbors[3] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
			
					aux++;
					
				}
				// QUARTO QUADRADO DA MATRIZ EM QUE CADA PARTICULA TEM 3 VIZINHOS
				else if(i == square -1 && j == square -1){
					neighbors = new int[4];
					neighbors[0] = mat[i-1][j-1];
					neighbors[1] = mat[i-1][j];
					neighbors[2] = mat[i][j-1];
					neighbors[3] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());

					aux++;
				}
				//PARTICULA CENTRAL COM 8 VIZINHOS
				else if((i !=0  && j != 0) && (i != square -1 && j != square -1)){
					neighbors = new int[9];
					neighbors[0] = mat[i-1][j-1];
					neighbors[1] = mat[i-1][j];
					neighbors[2] = mat[i-1][j+1];
					neighbors[3] = mat[i][j -1];
					neighbors[4] = mat[i][j +1];
					neighbors[5] = mat[i+1][j-1];
					neighbors[6] = mat[i+1][j];
					neighbors[7] = mat[i+1][j+1];
					neighbors[8] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
					
					aux++;
					
				}
				//PARTÍCULA QUE ESTÁ NA PRIMEIRA LINHA DA MATRIZ E NÃO É UM DOS QUADRADOS
				else if( i == 0){
					neighbors = new int[6];
					neighbors[0] = mat[i][j-1];
					neighbors[1] = mat[i][j+1];
					neighbors[2] = mat[i+1][j-1];
					neighbors[3] = mat[i+1][j];
					neighbors[4] = mat[i+1][j+1];
					neighbors[5] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
	
					aux++;
					
				}
				//PARTÍCULA QUE ESTÁ NA PRIMEIRA COLUNA DA MATRIZ E NÃO É UM DOS QUADRADOS
				else if( j == 0){
					neighbors = new int[6];
					neighbors[0] = mat[i-1][j];
					neighbors[1] = mat[i-1][j+1];
					neighbors[2] = mat[i][j+1];
					neighbors[3] = mat[i+1][j];
					neighbors[4] = mat[i+1][j+1];
					neighbors[5] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
					aux++;
					
				}
				//PARTÍCULA QUE ESTÁ NA ULTIMA COLUNA DA MATRIZ E NÃO É UM DOS QUADRADOS
				else if( j == square-1){
					neighbors = new int[6];
					neighbors[0] = mat[i-1][j-1];
					neighbors[1] = mat[i-1][j];
					neighbors[2] = mat[i][j-1];
					neighbors[3] = mat[i+1][j-1];
					neighbors[4] = mat[i+1][j];
					neighbors[5] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
				
					aux++;

				}
				//PARTÍCULA QUE ESTÁ NA ULTIMA LINHA DA MATRIZ E NÃO É UM DOS QUADRADOS
				else if( i == square-1){
					neighbors = new int[6];
					neighbors[0] = mat[i-1][j-1];
					neighbors[1] = mat[i-1][j];
					neighbors[2] = mat[i-1][j+1];
					neighbors[3] = mat[i][j-1];
					neighbors[4] = mat[i][j+1];
					neighbors[5] = aux;
					swarm.getSwarm()[aux].setNeighbors(neighbors.clone());
			
					aux++;
		
				}
				
			}
		}
	}
	
	
	
}
