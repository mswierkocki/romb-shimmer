
public class Wykres extends JPanel {
	
	JFreeChart chart;
	XYSeries X = new XYSeries("X");
	XYSeries Y = new XYSeries("Y");
	XYSeries Z = new XYSeries("Z");
 	XYSeriesCollection data = new XYSeriesCollection();;
	public Wykres() {
		//data=new XYSeriesCollection();
		data.addSeries(X);
	    data.addSeries(Y);
	    data.addSeries(Z);
        
        chart= ChartFactory.createScatterPlot(
            "Akcelerometr Przed",
            "Numer", "Warto��", 
            data, 
            PlotOrientation.VERTICAL,
            true, 
            true, 
            true
        );
        NumberAxis domainAxis = (NumberAxis) chart.getXYPlot().getDomainAxis();
        domainAxis.setAutoRangeIncludesZero(false);
        ChartPanel chartPanel = new ChartPanel(chart);
       
       
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 270));
        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setHorizontalAxisTrace(true);
        
        this.add(chartPanel);
        
        //setContentPane(chartPanel);
        //return chartPanel;
    }
	public Wykres(KlasterDanych dane) {
		
        
        

        //NumberAxis domainAxis = (NumberAxis) chart.getXYPlot().getDomainAxis();
        //domainAxis.setAutoRangeIncludesZero(false);
        ChartPanel chartPanel = new ChartPanel(chart);
       
       
        chartPanel.setPreferredSize(new java.awt.Dimension(600, 270));
        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setHorizontalAxisTrace(true);
        chartPanel.setVerticalAxisTrace(true);
        chartPanel.setHorizontalAxisTrace(true);
        
        this.add(chartPanel);
        
        //setContentPane(chartPanel);
        //return chartPanel;
    }
public void Stworz(KlasterDanych dane){
	//XYSeries X = new XYSeries("X");
	//XYSeries Y = new XYSeries("Y");
	//XYSeries Z = new XYSeries("Z");
 	for(int i = 0;i<dane.X.size();i++){
 		
 	X.add(i, (double)dane.X.get(i));
 	Y.add(i, (double)dane.Y.get(i));
 	Z.add(i, (double)dane.Z.get(i));
 	}
    
   
}
