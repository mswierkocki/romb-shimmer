
public class Klasy {
	public static final int NIEOKRESLONE = 0;
	public static final int POSTOJ = 1;
	public static final int SIADANIE = 2;
	public static final int WSTAWANIE = 3;
	public static final int OBROT = 4;
	public static final int CHODZENIE = 5;
	public static final int BIEG = 6;
	public static final int ERROR = -1;
	
	private static final String kNames[] = { "error", "nieokreslone", "postoj", "siadanie", "wstawanie","obrot","chodzenie","bieg" };
		
	private int state;
	
	public boolean isState(int s){return s==state;}
	public void setState(int s){state = s;}
	public int getState() {		return state;	}
	
	public String getKlasa(){
		if(state>=-1&&state<=kNames.length){
		//	System.out.println(kNames[state+1]);
			return kNames[state+1];
		}
		else{
		//	System.out.println("Nieokreslone"+state);
			return new String("Nieokreslone"+state);		
		}
	
	}
	public boolean okresl(String wejscie){
		for(int i = 2; i<kNames.length;i++){
			if(wejscie.equals(kNames[i]))
			{
				state=i-1;
				return true;
			}
		}
		
		state = NIEOKRESLONE;
		return false;
	}
	public static Object getKlasa(int code) {
		if( code>=-1&& code<=kNames.length){
		//	System.out.println(kNames[state+1]);
			return kNames[ code+1];
		}
		else{
		//	System.out.println("Nieokreslone"+state);
			return new String("Nieokreslone"+ code);		
		}
	}
    
}
