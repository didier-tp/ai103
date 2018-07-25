package fr.afcepf.ai103.util;

public class TestCommonData {

	public static void main(String[] args) {
		m1();
		//NB: aucun lien entre m1() et m2() 
		//qui pourraient être dans n'importe quelle autre classe
		m2();
	}
	
	public static void m1() {
		CommonDataInMemory.getInstance().setAttribute("couleur", "rouge");
		CommonDataInMemory.getInstance().setAttribute("nbPoints", 5);
	}
	
    public static void m2() {
    	String couleur = (String) CommonDataInMemory.getInstance().getAttribute("couleur");
    	Integer nbPoints = (Integer) CommonDataInMemory.getInstance().getAttribute("nbPoints");
    	System.out.println("couleur=" + couleur + " , nbPoints=" + nbPoints);
	}

}
