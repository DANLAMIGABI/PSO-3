package Main;


import javax.swing.SwingUtilities;

import Averages.StandardDeviation;
import Graphic.LineChart;

public class Main {

	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	StandardDeviation gl = new StandardDeviation(100, "Global");
            	gl.sD();
            	StandardDeviation ri = new StandardDeviation(100, "Ring");
            	ri.sD();
            	StandardDeviation mn = new StandardDeviation(100, "MNOM");
        		mn.sD();
        		
        		
                new LineChart(mn.getArrayToGraph(), gl.getArrayToGraph(), ri.getArrayToGraph()).setVisible(true);
            	
            }
        });
		
	}
}
