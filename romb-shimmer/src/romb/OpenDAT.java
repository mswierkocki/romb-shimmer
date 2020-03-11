
public class OpenDAT implements ActionListener {
	private OknoGlowne frame;
	
	private final JFileChooser fileChooser;
	private File file;
	private Scanner in;
	private boolean isOpened;
	KlasterDanych dane = new KlasterDanych();
	public OpenDAT(OknoGlowne f) {
		String userhome = System.getProperty("user.home");
		this.frame = f;
		//fileChooser = new JFileChooser(userhome+"//Desktop");
		fileChooser = new JFileChooser("ciagi_testowe");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "shimmer Dat", "dat");
		fileChooser.setFileFilter(filter);
		isOpened = false;
		
	}
	public boolean isOpen(){return isOpened;} 
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		int odpowiedz = fileChooser.showOpenDialog(frame);
		
		      if (odpowiedz == fileChooser.APPROVE_OPTION) {
		
		           file = fileChooser.getSelectedFile();
		
		          try {
		
		        	  in = new Scanner(file);
		        	  isOpened = true;
		        	  String zdanie = in.nextLine();

		              while(in.hasNextDouble()){
		            	  in.nextDouble();
		            	  dane.X.add((float)in.nextDouble());
		            	  dane.Y.add((float)in.nextDouble());
		            	  dane.Z.add((float)in.nextDouble());
		            	  in.nextFloat();
		            	  in.nextFloat();
		            	  		              
		              }

		        //Czytaj wi�cej na: http://javastart.pl/podstawy-jezyka/zapis-i-odczyt-z-plikow/#ixzz2SWg1baKJ
		
		          } catch (IOException e) {
		
		              System.out.println("Nie mog� otworzy� pliku: "+file.getAbsolutePath());
		
		              System.out.println("Problem: "+e);
		              isOpened = false;
		
		          }
		
		      }
		frame.analizujButton.setEnabled(isOpened);      
		
		frame.wykres.Stworz(dane);
		
		}

	}


