package Graphic;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class LineChart extends JFrame {
 
	private double[]MNOM;
	private double[] GL;
	private double[] RI;
	
    public LineChart(double[]MNOM, double[] GL, double[] RI) {
        super("Particle Swarm Optimization with Neighbors different");
        this.MNOM = MNOM;
    	this.GL = GL;
    	this.RI = RI;
        JPanel chartPanel = createChartPanel();
        add(chartPanel, BorderLayout.CENTER);
 
        setSize(1350, 735);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
 
    private JPanel createChartPanel() {
    	String chartTitle = "Função Rosenbrock";
        String xAxisLabel = "Iterações";
        String yAxisLabel = "Fitness";
     
        XYDataset dataset = createDataset();
     
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,
                xAxisLabel, yAxisLabel, dataset,
                PlotOrientation.VERTICAL, true, true, false);
        
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
     // sets paint color for each series
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesPaint(2, Color.BLACK);
         
        // sets thickness for series (using strokes)
        
        renderer.setSeriesStroke(0, new BasicStroke(1.0f));
        renderer.setSeriesStroke(1, new BasicStroke(1.0f));
        renderer.setSeriesStroke(2, new BasicStroke(1.0f));
        
        //plot.setOutlinePaint(Color.BLUE);
        plot.setOutlineStroke(new BasicStroke(2.0f));
        
        plot.setBackgroundPaint(Color.white);
        
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.white);
         
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.white);
        
        plot.setRenderer(renderer);
        
        
        File imageFile = new File("XYLineChart.png");
        int width = 640;
        int height = 480;
         
        try {
            ChartUtilities.saveChartAsPNG(imageFile, chart, width, height);
        } catch (IOException ex) {
            System.err.println(ex);
        }
        
        return new ChartPanel(chart);
    }
 
    private XYDataset createDataset() {
    	XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series1 = new XYSeries("MNOM 1");
        XYSeries series2 = new XYSeries("Global 2");
        XYSeries series3 = new XYSeries("Ring 3");
        

        for(int i = 0; i < 1000; i += 10){
        	series1.add(i, MNOM[i] );
        	series2.add(i, GL[i] );
        	series3.add(i, RI[i] );
        }
        
    
  
     
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
     
        return dataset;
    }
 
    
}