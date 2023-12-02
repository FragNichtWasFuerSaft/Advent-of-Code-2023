import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

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
	
	public static void main(String args[]) {
		List<String> datei = liesDatei("/home/jou/AoC2023/InputPuzzle11");
		List<Integer> alleZahlen = new LinkedList<Integer>();
		
		for(int i = 0; i < datei.size() - 1; i++) {
			String zeile = datei.get(i);
			
			List<Character> listeZahlenproZeile = new LinkedList<Character>();
			
			for(int j = 0; j < zeile.length(); j++) {
				
				if(istCharEineZahl(zeile.charAt(j))) {
					listeZahlenproZeile.add(zeile.charAt(j));
				}
			}
			String doppelzifferString = "0";
			
			if(listeZahlenproZeile.size() == 0) {
				
			}
			else {
				doppelzifferString = listeZahlenproZeile.get(0).toString() + listeZahlenproZeile.get(listeZahlenproZeile.size() - 1).toString();
			}
			
			int doppelziffer = Integer.parseInt(doppelzifferString) ;
			alleZahlen.add(doppelziffer);
		}
		System.out.println(summeEinerListeErmitteln(alleZahlen));
	}

	private static int summeEinerListeErmitteln(List<Integer> liste) {
		int summe = 0;
		for(int i = 0; i < liste.size() - 1; i++) {
			summe = summe + liste.get(i);
		}
		return summe;
	}
	
	private static boolean istCharEineZahl(Character c) {
		switch(c) {
		case '0':
			return true;
		case '1':
			return true;
		case '2':
			return true;
		case '3':
			return true;
		case '4':
			return true;
		case '5':
			return true;
		case '6':
			return true;
		case '7':
			return true;
		case '8':
			return true;
		case '9':
			return true;
			
		}
		return false;
	}
}
