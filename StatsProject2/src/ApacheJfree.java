import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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

import org.apache.commons.math3.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class ApacheJfree extends ApplicationFrame
{
	/*
	 * contructor that also set the setting
	 * to display the graph in awt form
	 */
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
	    	      chartPanel.setPreferredSize( new java.awt.Dimension( 1200 , 800 ) );
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
	      final XYSeries origin = new XYSeries( "Original" );
	      final XYSeries salt = new XYSeries( "Salt" );
	      final XYSeries smooth = new XYSeries( "Smooth" );
	      ArrayList<Integer> saltArr = new ArrayList<Integer>();
	      Random rand = new Random();
	      
	      DescriptiveStatistics stats = new DescriptiveStatistics();
	      stats.setWindowSize(9);
	      
	      int x = 0;
	      int idex = 0;
	      int count1 = 0;
	      
	      
	      for(int i = 0; i<100;i++)
	      {
	    	  origin.add(i,2*i+1);
	    	  int rando = 2*i+1+rand.nextInt(10*2)-10;
	    	  salt.add(i,rando);
	    	  saltArr.add(rando);
	      }
	      
	      while(idex<saltArr.size())
	      {    	  
	    	  int copy = idex;
	    	  if(count1 == 0)
	    	  {
	    		  stats.addValue(saltArr.get(copy));
	    	  }
	    	  
	    	  if(copy+count1<idex+(stats.getWindowSize()/2))
	    	  {
		    	  while(((copy+count1)<saltArr.size()-1)&(copy+count1<idex+(stats.getWindowSize()/2)))
					{
						count1++;
						stats.addValue(saltArr.get(copy+count1));
					}
		    	  count1 --;
	    	  }
	    	  
	    	  smooth.add(x,stats.getMean());
	    	  x++;
	    	  idex++;
	    	  
	      }

	      
	      final XYSeriesCollection dataset = new XYSeriesCollection( );
	      dataset.addSeries(origin);
	      dataset.addSeries(salt);
	      dataset.addSeries(smooth);
	      return dataset;
	}
	


}
