
public class KlasterDanych {
	public List<Float> X = new ArrayList<Float>();
	public List<Float> Y = new ArrayList<Float>();
	public List<Float> Z = new ArrayList<Float>();
	public Klasy klasa = new Klasy();
	public KlasterDanych(){}
	public KlasterDanych(List<Float> x,List<Float> y,List<Float> z){
	X = x; Y = y; Z = z;
	}
	public float[] getValues(int index){
		float []tab = new float[3];
		tab[0] = X.get(index);
		tab[1] = Y.get(index);
		tab[2] = Z.get(index);
		return tab;
	}
	public void addValues(float X,float Y,float Z){
		this.X.add(X);
		this.Y.add(Y);
		this.Z.add(Z);
	}
	public int getSize(){
		return X.size();
	}
	public KlasterDanych[] podzielN(int naIle){
		return null;
	}
	public KlasterDanych[] podzielC(int coIle){
		int size = getSize(),czesc=0;
		//KlasterDanych r[] = new KlasterDanych()[1100];
		if(coIle>=size)
			return null;
		else{
		for(int i = 0;i<size;i++)
			if(coIle%i==0)
				czesc++;
		
		}
		
		return null;
	}
	
	public KlasterDanych przedzial(int s,int k){
		KlasterDanych kd = new KlasterDanych(X.subList(s, k),Y.subList(s, k),Z.subList(s, k));
		return kd;
	}
	
}
