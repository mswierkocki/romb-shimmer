
public class Driver {
	
 Classifier cModel = (Classifier)new MultilayerPerceptron();   
 Instances isTrainingSet ;
    public Driver(List<OknoCzasu> ciagUCZ) throws Exception{
         
    	
         // Declare two numeric attributes
         Attribute Attribute1 = new Attribute("AmplitudaX");
         Attribute Attribute2 = new Attribute("AmplitudaY");
         Attribute Attribute3 = new Attribute("AmplitudaZ");
         Attribute Attribute4 = new Attribute("SredniaX");
         Attribute Attribute5 = new Attribute("SredniaY");
         Attribute Attribute6 = new Attribute("SredniaZ");
         Attribute Attribute7 = new Attribute("TrendX");
         Attribute Attribute8 = new Attribute("TrendY");
         Attribute Attribute9 = new Attribute("TrendZ");
        
          
         // Declare the class attribute along with its values
         FastVector fvClassVal = new FastVector(7);
         fvClassVal.addElement(Klasy.getKlasa(Klasy.NIEOKRESLONE));
         fvClassVal.addElement(Klasy.getKlasa(Klasy.POSTOJ));
         fvClassVal.addElement(Klasy.getKlasa(Klasy.SIADANIE));
         fvClassVal.addElement(Klasy.getKlasa(Klasy.WSTAWANIE));
         fvClassVal.addElement(Klasy.getKlasa(Klasy.OBROT));
         fvClassVal.addElement(Klasy.getKlasa(Klasy.CHODZENIE));
         fvClassVal.addElement(Klasy.getKlasa(Klasy.BIEG));
         Attribute ClassAttribute = new Attribute("theClass", fvClassVal);
          
         // Declare the feature vector
         FastVector fvWekaAttributes = new FastVector(10);
         fvWekaAttributes.addElement(Attribute1);    
         fvWekaAttributes.addElement(Attribute2);    
         fvWekaAttributes.addElement(Attribute3);
         fvWekaAttributes.addElement(Attribute4);    
         fvWekaAttributes.addElement(Attribute5);    
         fvWekaAttributes.addElement(Attribute6); 
         fvWekaAttributes.addElement(Attribute7);    
         fvWekaAttributes.addElement(Attribute8);    
         fvWekaAttributes.addElement(Attribute9); 
         fvWekaAttributes.addElement(ClassAttribute);
     
       isTrainingSet = new Instances("Rel", fvWekaAttributes, 20000);       

         isTrainingSet.setClassIndex(9);
          
//        // tutaj tworzymy naszą bazę uczącą się
//         
         for(int i =0;i<ciagUCZ.size();i++){

         Instance iExample = new Instance(10);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(0),ciagUCZ.get(i).ampX );      
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(1), ciagUCZ.get(i).ampY);      
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(2), ciagUCZ.get(i).ampZ);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(3), ciagUCZ.get(i).meanX);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(4), ciagUCZ.get(i).meanY);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(5), ciagUCZ.get(i).meanZ);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(6), ciagUCZ.get(i).trendX);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(7), ciagUCZ.get(i).trendY);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(8), ciagUCZ.get(i).trendZ);
         iExample.setValue((Attribute)fvWekaAttributes.elementAt(9), ciagUCZ.get(i).data.klasa.getState());
         

         isTrainingSet.add(iExample);
         }
         cModel.buildClassifier(isTrainingSet);
    }
         
    
    public void okreslKlase(OknoCzasu okno) throws Exception{
         // tutaj tworzymy nasze dane które chcemy przetestować

        Attribute AttributeT1 = new Attribute("AmplitudaX");
        Attribute AttributeT2 = new Attribute("AmplitudaY");
        Attribute AttributeT3 = new Attribute("AmplitudaZ");
        Attribute AttributeT4 = new Attribute("SredniaX");
        Attribute AttributeT5 = new Attribute("SredniaY");
        Attribute AttributeT6 = new Attribute("SredniaZ");
        Attribute AttributeT7 = new Attribute("TrendX");
        Attribute AttributeT8 = new Attribute("TrendY");
        Attribute AttributeT9 = new Attribute("TrendZ");
         
        

        
        FastVector fvClassValTest = new FastVector(7);
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.NIEOKRESLONE));
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.POSTOJ));
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.SIADANIE));
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.WSTAWANIE));
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.OBROT));
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.CHODZENIE));
        fvClassValTest.addElement(Klasy.getKlasa(Klasy.BIEG));

 
        Attribute ClassAttributeTest = new Attribute("theClass", fvClassValTest);
        
            
        
         // Declare the feature vector
         FastVector fvWekaAttributesTest = new FastVector(10);
         fvWekaAttributesTest.addElement(AttributeT1);    
         fvWekaAttributesTest.addElement(AttributeT2);    
         fvWekaAttributesTest.addElement(AttributeT3);
         fvWekaAttributesTest.addElement(AttributeT4);    
         fvWekaAttributesTest.addElement(AttributeT5);    
         fvWekaAttributesTest.addElement(AttributeT6); 
         fvWekaAttributesTest.addElement(AttributeT7);    
         fvWekaAttributesTest.addElement(AttributeT8);    
         fvWekaAttributesTest.addElement(AttributeT9);
         fvWekaAttributesTest.addElement(ClassAttributeTest);
      
      
         // tutaj 200 to jest pojemnośc, trzeba zamienić na więcej później
         Instances isTestingSet = new Instances("Rel", fvWekaAttributesTest, 20000); 

         
      // Set class index
         isTestingSet.setClassIndex(9);
         
//        // tutaj tworzymy naszą bazę uczącą się

         Instance iExampleTest = new Instance(10);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(0),okno.ampX);      
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(1), okno.ampY);      
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(2), okno.ampZ);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(3), okno.meanX);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(4), okno.meanY);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(5), okno.meanZ);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(6), okno.trendX);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(7), okno.trendY);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(8), okno.trendZ);
         iExampleTest.setValue((Attribute)fvWekaAttributesTest.elementAt(9), 0);
         
          
         // add the instance
         isTestingSet.add(iExampleTest);

         

         // Test the model
         Evaluation eTest = new Evaluation(isTrainingSet);
         eTest.evaluateModel(cModel, isTestingSet);
          
         // Print the result à la Weka explorer:
         String strSummary = eTest.toSummaryString();
      //   System.out.println(strSummary);
          
         // Get the confusion matrix
         double[][] cmMatrix = eTest.confusionMatrix();
         for(int row_i=0; row_i<cmMatrix.length; row_i++){
             for(int col_i=0; col_i<cmMatrix.length; col_i++){
            //     System.out.print(cmMatrix[row_i][col_i]);
             //    System.out.print("|");
             }
         //    System.out.println();
         }
         
         // Wyświetlenie komunikatu
         for (int row_i=0; row_i<cmMatrix.length; row_i++){
        	 for(int col_i=0; col_i<cmMatrix.length; col_i++){
        		 
        		 if(cmMatrix[row_i][col_i]==1){
        			 System.out.println();
        			// System.out.println(fvClassValTest.get(col_i));
        			 String tmp = (String) fvClassValTest.elementAt(col_i);
        			 try{
        				 okno.klasa.okresl(tmp);
        			 }catch (Exception e){}
//        			okno.klasa.okresl((String)fvClassValTest.get(row_i));
        		 }
        		 
        	 }
        	
         }
         
         
    }
}