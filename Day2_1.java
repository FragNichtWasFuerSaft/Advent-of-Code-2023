import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day2_1 {

	static int maxWertBlau = 14;
	static int maxWertGrün = 13;
	static int maxWertRot = 12;
	static int anzahlSpieleGültig = 0;
	
	private static List<String> liesDatei(String dateipfad) {
		try {
			List<String> s = Files.readAllLines(Path.of(dateipfad));
			return s;	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static boolean spielGültig(String spielWerte) {
		boolean spielGültig = true;
		
		String[] subsets = spielWerte.split(";");
		
		for(int i= 0; i < subsets.length; i++) {
			String s = subsets[i];
			String[] sub_subsets = s.split(",");
			
			for(int j = 0; j < sub_subsets.length; j++) {
				String temp = sub_subsets[j];
				
				int onlyNumbers = Integer.parseInt(temp.replaceAll("[^0-9]", ""));
				
				if (temp.contains("blue")) {
					if(onlyNumbers > maxWertBlau)
						spielGültig = false;
				}
				else if(temp.contains("green")) {
					if(onlyNumbers > maxWertGrün)
						spielGültig = false;
					
				}
				else if(temp.contains("red")) {
					if(onlyNumbers> maxWertRot)
						spielGültig = false;
				}
			}
		}
		return spielGültig;
	}
	
	private static void anzahlSpieleGültigErmitteln() {
		List<String> liste = liesDatei("/home/jou/AoC2023/Day2/InputPuzzle21");
		for(int i = 0; i < liste.size(); i++) { 
			String[] inputFürSpielGültigArray = liste.get(i).split(":");
			String inputFürSpielGültig = String.join(",", inputFürSpielGültigArray);
			System.out.println(inputFürSpielGültig);
			boolean gültigkeit = spielGültig(inputFürSpielGültig);
			System.out.println(gültigkeit);
			if(gültigkeit)
				anzahlSpieleGültig++;
		}
	}
	
	public static void main(String args[]) {
		anzahlSpieleGültigErmitteln();
		System.out.println(anzahlSpieleGültig);
	} 
}
 