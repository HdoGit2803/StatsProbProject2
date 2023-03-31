import java.awt.Color;
import java.io.FileNotFoundException;
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
public class ApacheJfreeTester
{

	public static void main(String[] args)
	{
		String title = "Original, Salter, Smoother";

		ApacheJfree chart = new ApacheJfree(title,
	    	         "Which Browser are you using?");
	    	      chart.pack( );          
	    	      RefineryUtilities.centerFrameOnScreen( chart );          
	    	      chart.setVisible( true );

	}

}
