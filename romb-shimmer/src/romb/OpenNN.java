
public class OpenNN implements ActionListener {
	private OknoGlowne frame;
	
	private final JFileChooser fileChooser;
	private File file;
	private Scanner in;
	private boolean isOpened;
	private List<KlasterDanych> ciagiKD = new ArrayList<KlasterDanych>();
	public List<OknoCzasu> ciagiOCZ = new ArrayList<OknoCzasu>();
	
	public OpenNN(OknoGlowne f) {
		String userhome = System.getProperty("user.home");
		this.frame = f;
		
		//fileChooser = new JFileChooser(userhome+"//Desktop");
		fileChooser = new JFileChooser("ciagi_uczace");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "NN Learning set", "txt");
		fileChooser.setFileFilter(filter);
		isOpened = false;
		
	}
	public boolean isOpen(){return isOpened;} 
	@Override
	public void actionPerformed(ActionEvent ae) {

		isOpened = false;
		int odpowiedz = fileChooser.showOpenDialog(frame);
		
		      if (odpowiedz == fileChooser.APPROVE_OPTION) {
		
		           file = fileChooser.getSelectedFile();
		
		          try {
		        	  
		        	  in = new Scanner(file);
		        	  
		              while(in.hasNextLine()){
		            	  KlasterDanych dane = new KlasterDanych();
        	           	  String tmp = in.nextLine();
        	           	  if(tmp.equals(""))
        	           	  	continue;
        	           	  
		            	  if(!dane.klasa.okresl(tmp)){
		            		  tmp= in.nextLine();
			            	  if(!dane.klasa.okresl(tmp)){
				            		 throw new Exception("Blad w nazwie"+tmp);
				            	  }
		            	  }
		            	  
		            	  tmp = in.nextLine();
		            	  if(tmp.equals("{")){
		            		  while(in.hasNextDouble()){
		            			  dane.X.add((float)in.nextDouble());
		            			  dane.Y.add((float)in.nextDouble());
		            			  dane.Z.add((float)in.nextDouble());
		            		  }
		            	  }
		            	  else
		            		  throw new Exception("Blad w skladni Opening");

		            	  
		            	  		              
		              }
		              isOpened = true;
		              frame.statusLabel.setText("Wczytano Learning Set");
		              OkreslOkna();
		        	  
		        
		          } catch (IOException e) {
		
		              System.out.println("Nie mog� otworzy� pliku: "+file.getAbsolutePath());
		
		              System.out.println("Problem: "+e);
		              isOpened = false;
		              
		
		          } catch (Exception e) {
		              System.out.println("Nie mog� otworzy� pliku: "+file.getAbsolutePath());
		      		
		              System.out.println("Problem: "+e);
		              isOpened = false;
					e.printStackTrace();
				
				}
		
		      }
				
				frame.nauczButton.setEnabled(isOpened);

		}
	public void OkreslOkna(){
		for(int i = 0;i<ciagiKD.size();i++){
			ciagiOCZ.add(new OknoCzasu(ciagiKD.get(i)));
		}
	}

	}


