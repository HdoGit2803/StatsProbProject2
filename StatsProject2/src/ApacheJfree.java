import java.awt.Color;
import java.util.Random;
import java.awt.BasicStroke; 

import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.data.xy.XYDataset; 
import org.jfree.data.xy.XYSeries; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 
import org.jfree.chart.plot.XYPlot; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation; 
import org.jfree.data.xy.XYSeriesCollection; 
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
public class ApacheJfree extends ApplicationFrame
{
	public ApacheJfree(String applicationTitle, String chartTitle)
	{
		
		super(applicationTitle);
	      JFreeChart xylineChart = ChartFactory.createXYLineChart(
	    		    getTitle() ,
	    	         "X" ,
	    	         "Y" ,
	    	         createDataset() ,
	    	         PlotOrientation.VERTICAL ,
	    	         true , true , false);
	    	         
	    	      ChartPanel chartPanel = new ChartPanel( xylineChart );
	    	      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
	    	      final XYPlot plot = xylineChart.getXYPlot( );
	    	      
	    	      XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
	    	      renderer.setSeriesPaint( 0 , Color.RED );
	    	      renderer.setSeriesPaint( 1 , Color.GREEN );
	    	      renderer.setSeriesPaint( 2 , Color.YELLOW );
	    	      renderer.setSeriesStroke( 0 , new BasicStroke( 4.0f ) );
	    	      renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
	    	      renderer.setSeriesStroke( 2 , new BasicStroke( 2.0f ) );
	    	      plot.setRenderer( renderer ); 
	    	      setContentPane( chartPanel ); 
		
	}
	
	private XYDataset createDataset()
	{
	      final XYSeries smooth = new XYSeries( "Smooth" );
	      final XYSeries salt = new XYSeries( "Salt" );
	      Random rand = new Random();
	      for(int i = 0; i<100;i++)
	      {
	    	  smooth.add(i,2*i+1);
	    	  salt.add(i,2*i+1+rand.nextInt(10*2)-10);
	      }
	      final XYSeriesCollection dataset = new XYSeriesCollection( );
	      dataset.addSeries(smooth);
	      dataset.addSeries(salt);
	      return dataset;
	}

}
