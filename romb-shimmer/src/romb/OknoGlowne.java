
public class OknoGlowne extends JFrame {
	private OpenDAT openDAT;
	private OpenNN openNN;
	public Wykres wykres;
	private static int counter = 0;
	public JTextField odJTF;
	public JTextField doJTF;
	public JTextField dlugoscJTF;
	public JTextField skokJTF;
	public JLabel statusLabel;
	public JButton nauczButton;
	JButton analizujButton;
	JButton dalejButton;
	public Driver driver;
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Plik");
	JMenuItem otworzNNMenu = new JMenuItem("Wczytaj ciag uczacy");
	JMenuItem otworzTestMenu = new JMenuItem("Wczytaj ciag testowy");
	JMenuItem exitMenu = new JMenuItem("Wyjd�");
	JTextPane toast;
	
	private JPanel doGornyPanel()
	{
		JPanel gorny = new JPanel(new GridBagLayout());
		gorny.setSize(800,100);
        JButton wczytajButton = new JButton("Wczytaj ci�g ucz�cy");
        statusLabel = new JLabel("Nie wczytano ciagu uczacego");
        nauczButton = new JButton("Naucz sie�");
        gorny.setBorder(BorderFactory.createTitledBorder("Nauka sieci"));
  		
  		nauczButton.setEnabled(false);
  		
  		//// Listenery
  		wczytajButton.addActionListener(openNN);
  		nauczButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(openNN.isOpen()){
					try {
						driver = new Driver(openNN.ciagiOCZ);
						statusLabel.setText("Stworzylem siec");
						otworzTestMenu.setEnabled(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
  		
  		//////dodawanie 
  		gorny.setLayout(new FlowLayout(FlowLayout.LEFT));

  		gorny.add(wczytajButton);
  		gorny.add(nauczButton);
  		//gorny.setLayout(new FlowLayout(FlowLayout.RIGHT));
  		gorny.add(statusLabel);
		//pakowanie
  		//gorny.setMaximumSize(new Dimension(100, 600));
		return gorny;

	}
	private JPanel doSrodkowyPanel(){
		JPanel srodkowy = new JPanel();
		srodkowy.setSize(800, 100);
		JLabel odJL = new JLabel("Od");
        odJTF = new JTextField("5");
        odJTF.setSize(40, 50);
        JLabel doJL = new JLabel("Do");
        doJTF = new JTextField("25");
        doJTF.setSize(40,50);
        analizujButton = new JButton("Analizuj");
        JLabel dlugoscJL = new JLabel("Szerokosc okna");
        dlugoscJTF = new JTextField("35");
        JLabel skokJL = new JLabel("Skok co ile");
        skokJTF = new JTextField("1");
        dalejButton = new JButton("Dalej");
		
		odJTF.setHorizontalAlignment(JTextField.RIGHT);
		//srodkowy.setMaximumSize(new Dimension(300,900));
		//srodkowy.setSize(new Dimension(100, 900));
		
		/////////listenery
		dalejButton.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int from = Integer.parseInt(odJTF.getText());
				int to = Integer.parseInt(doJTF.getText());
				int skok = Integer.parseInt(skokJTF.getText());
				int szerokosc = Integer.parseInt(dlugoscJTF.getText());
				from +=skok;
				to = from+szerokosc;
				odJTF.setText(String.valueOf(from));
				doJTF.setText(String.valueOf(to));
				
				
			}
		});
		analizujButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
			if(openDAT.isOpen()){
	
				if(driver!=null){
			//	((Wykres) wykres).dodajPunkt(openDAT.dane.X.get(counter),openDAT.dane.Y.get(counter),openDAT.dane.Z.get(counter));
				
			//	wykres.repaint();
					OknoCzasu o = new OknoCzasu(openDAT.dane,Integer.parseInt(odJTF.getText()),Integer.parseInt(doJTF.getText()));
					try {
						driver.okreslKlase(o);
						toast.setText(o.klasa.getKlasa());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
				toast.setText("Nie nauczyles sieci!");
				}
			}
			else
				toast.setText("Nie wczytales pliku");
				
			}
		});
		////dodawanie
  		srodkowy.add(odJL);
  		srodkowy.add(odJTF);
  		srodkowy.add(doJL);
  		srodkowy.add(doJTF);
		srodkowy.add(analizujButton);
		srodkowy.add(dlugoscJL);
		srodkowy.add(dlugoscJTF);
		srodkowy.add(skokJL);
		srodkowy.add(skokJTF);
		srodkowy.add(dalejButton);
		srodkowy.setBorder(BorderFactory.createTitledBorder("Obs�uga"));
		srodkowy.setLayout(new GridLayout(0,5));
	  return srodkowy;
	}
	private JPanel doDolnyPanel()
	{
		JPanel dolny= new JPanel();
		dolny.setSize(800, 400);
		JLabel txt1 = new JLabel("Wyniki sieci ");
		wykres = new Wykres();
		toast = new JTextPane();
		toast.setEditable(false);
		
		JScrollPane editorScrollPane = new JScrollPane(toast);
		editorScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		editorScrollPane.setPreferredSize(new Dimension(250, 145));
		editorScrollPane.setMinimumSize(new Dimension(10, 10));
		
		dolny.setBorder(BorderFactory.createTitledBorder("Wyniki"));
		dolny.setLayout(new BoxLayout(dolny,BoxLayout.Y_AXIS));
		dolny.add(wykres);
		dolny.add(txt1);
		dolny.add(toast);
		return dolny;

	}
	public void onCreate(){
	
	this.setTitle("Romb");
	openDAT = new OpenDAT(this);
	openNN = new OpenNN(this);
	Container contentPane = getContentPane();
	
	
	//wykres = new Wykres();

		
	// Ustawienia komponentow
	//contentPane.setLayout(new FlowLayout());
	contentPane.setLayout(new BoxLayout(contentPane,BoxLayout.Y_AXIS));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	//otworzTestMenu.setEnabled(false);
	otworzTestMenu.addActionListener(openDAT);
	otworzNNMenu.addActionListener(openNN);
	// Dodawanie komponentow
	menu.add(otworzTestMenu);
	menu.add(otworzNNMenu);
	menu.add(exitMenu);
	menuBar.add(menu);
	setJMenuBar(menuBar);
	

	}// Koniec OnCreate
	
}
