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
	//window size
	private int window = 5;
	//where x will start
	private int start = 0;
	//the number in which the salter will salt by
	private int generate = 10;
	
	/*
	 * constructor that also set the setting
	 * to display the graph in awt form
	 */
	public ApacheJfree(String applicationTitle, String chartTitle)
	{
		
		super(applicationTitle);
		//constructor from jfreechart that will construct our chart for us
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
	
	/*
	 * method that set the parameters for the graph being created
	 */
	private XYDataset createDataset()
	{
	      final XYSeries origin = new XYSeries( "Original" );
	      final XYSeries salt = new XYSeries( "Salt" );
	      final XYSeries smooth = new XYSeries( "Smooth" );
	      ArrayList<Integer> saltArr = new ArrayList<Integer>();
	      Random rand = new Random();
	      
	      DescriptiveStatistics stats = new DescriptiveStatistics();
	      stats.setWindowSize(window*2);
	      
	      int x = start;
	      int idex = 0;
	      int count1 = 0;
	      
	      /*
	       * loop that adds the x,y points for both the
	       * original plot and the salted plot
	       *also adds the y values into arraylist @saltArr
	       */
	      for(int i = start; i<100;i++)
	      {
	    	  origin.add(i,2*i+1);
	    	  int rando = 2*i+1+rand.nextInt(generate*2)-generate;
	    	  salt.add(i,rando);
	    	  saltArr.add(rando);
	      }
	      
	      /*
	       * the smoothing part of my program
	       */
	      while(idex<saltArr.size())
	      {    	  
	    	  //immediatly at the start add the first value of @saltArr into @stats
	    	  int copy = idex;
	    	  if(count1 == start)
	    	  {
	    		  stats.addValue(saltArr.get(copy));
	    	  }
	    	  
	    	  /*
	    	   * initially in the very first loop add the values ahead of our current index x
	    	   * to @stats
	    	   * base on the window size
	    	   * after that it only adds 1 value following the current index
	    	   * so if your window size is 5 it first adds the 5 following values
	    	   * then every loop after that it only add the 5 value ahead of where the index currently is
	    	   */
	    	  if(copy+count1<idex+(stats.getWindowSize()/2))
	    	  {
		    	  while(((copy+count1)<saltArr.size()-1)&(copy+count1<idex+(stats.getWindowSize()/2)))
					{
						count1++;
						stats.addValue(saltArr.get(copy+count1));
					}
		    	  count1 --;
	    	  }
	    	  
	    	  //add the x,y point of the smooth data to @smooth
	    	  smooth.add(x,stats.getMean());
	    	  x++;
	    	  idex++;
	    	  
	      }

	      /*
	       * adds all 3 XYSeries into one giant series
	       * which will make up the actual graph
	       */
	      final XYSeriesCollection dataset = new XYSeriesCollection( );
	      dataset.addSeries(origin);
	      dataset.addSeries(salt);
	      dataset.addSeries(smooth);
	      return dataset;
	}
	


}
