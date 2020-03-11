
public class OknoCzasu {
	public float meanX;
	public float meanY;
	public float meanZ;
	public float trendX;
	public float trendY;
	public float trendZ;
	public float ampX;
	public float ampY;
	public float ampZ;
	public KlasterDanych data;
	public Klasy klasa =  new Klasy();	
	public OknoCzasu(){
			
	}
	public OknoCzasu(KlasterDanych d){ setData(d); oblicz();}
	public OknoCzasu(KlasterDanych d,int from ,int to){
		if(from>0&&to<d.getSize()){
		
		KlasterDanych nowy = new KlasterDanych();
		for(int i =0;i<to-from;i++){
			nowy.X.add(d.X.get(from+i));
			nowy.Y.add(d.Y.get(from+i));
			nowy.Z.add(d.Z.get(from+i));
		}
		
		setData(nowy);
		oblicz();
		}
	
	}
	public KlasterDanych getData() {
		return data;
	}
	public void setData(KlasterDanych data) {
		this.data = data;
	}
	
	public void oblicz(){
		float sX = 0,sY = 0,sZ = 0;
		float minX = data.X.get(0);
		float minY = data.Y.get(0);
		float minZ = data.Z.get(0);
		float maxX = data.X.get(0);
		float maxY = data.Y.get(0);
		float maxZ = data.Z.get(0);
		float sXX = 0, sYY = 0, sZZ = 0;
		float sXi = 0, sYi = 0, sZi = 0;
		float sI = 0,sII= 0;
    	float X,Y,Z;
    	int i = 0,size = data.getSize();
    	   	
    	for(i = 0; i<size;i++){
    		X = data.X.get(i);
    		Y = data.Y.get(i);
    		Z = data.Z.get(i);
    		sX+=X;
    		sY+=Y;
    		sZ+=Z;
    		sXX += X*X;
    		sYY += Y*Y;
    		sZZ += Z*Z;
    		sXi += X*(i+1);
    		sYi += Y*(i+1);
    		
    		sZi += Z*(i+1);
    		sI +=i;
    		sII +=i*i;
    		if(X>maxX) maxX=X;
    		if(Y>maxY) maxY=Y;
    		if(Z>maxZ) maxZ=Z;
    		if(X<minX) minX=X;
    		if(Y<minY) minY=Y;
    		if(Z<minZ) minZ=Z;
    		
    		 	
    	}
    	meanX = sX/size;
    	meanY = sY/size;
    	meanZ = sZ/size;
    	ampX = maxX-minX;
    	ampY = maxY-minY;
    	ampZ = maxZ-minZ;
    	trendX = (size*sXi-sI*sX)/(size*sII-sI*sI);
    	trendY = (size*sYi-sI*sY)/(size*sII-sI*sI);
    	trendZ = (size*sZi-sI*sZ)/(size*sII-sI*sI);
    	
	}
	public void Drukuj(){
	if(klasa == null){
		System.out.println(data.klasa.getKlasa());
		System.out.println("Srednia\n X\tY\tZ");
		System.out.println(meanX+"\t"+meanY+"\t"+meanZ);
		System.out.println("Amplituda\n X\tY\tZ");
		System.out.println(ampX+"\t"+ampY+"\t"+ampZ);
		System.out.println("trend \nX\tY\tZ");
		System.out.println(trendX+"\t"+trendY+"\t"+trendZ);
		
	}
	else
		System.out.println(klasa.getKlasa());
	
	}
	
	
}
