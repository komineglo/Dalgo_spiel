package Algo2;

import java.util.Arrays;
import java.util.Scanner;

public class Projekt2 {
	
	//Wir deklarieren unsere Konstante array für das Gitter
	
	      public static int[][] Gitter ;
	      
		  private static final int GITTERGRÖSSE = 9;
		  
		  
		  //eine Ausgabemethode erstellen
		  private static void printGitter(int[][] Gitter) {
			  
			  //Drucken Sie das aktuelle Gitter
			  
		    for (int linie = 0; linie < GITTERGRÖSSE; linie++) {
		      if (linie % 3 == 0 && linie != 0) {
		        System.out.println("-----------");
		      }
		      for (int spalte = 0; spalte < GITTERGRÖSSE; spalte++) {
		        if (spalte % 3 == 0 && spalte != 0) {
		          System.out.print("|");
		        }
		        System.out.print(Gitter[linie][spalte]);
		      }
		      System.out.println();
		    }
		  }
		  
		  //Boolesche Methode, um zu prüfen, ob eine Zahl in der Zeile steht 
		  
		  private static boolean IstNummerInlinie(int[][] Gitter, int nummer, int linie) {
		    for (int i = 0; i < GITTERGRÖSSE; i++) {
		      if (Gitter[linie][i] == nummer) {
		        return true;
		      }
		    }
		    return false;
		  }
		  
		  ////Boolesche Methode, um zu prüfen, ob eine Zahl in der Spalte steht 
		  
		  private static boolean IstNummerInspalte(int[][] Gitter, int nummer, int spalte) {
		    for (int i = 0; i < GITTERGRÖSSE; i++) {
		      if (Gitter[i][spalte] == nummer) {
		        return true;
		      }
		    }
		    return false;
		  }
		  
		  //Boolesche Methode, um zu überprüfen, ob es in jedem 3x3-Kästchen eine Zahl gibt. 
		  //Die In-Box-Inspektion wird ausgeführt, indem man sich von der linken oberen Ecke zur Seite bewegt
		  private static boolean IstNummerInBox(int[][] Gitter, int nummer, int linie, int spalte) {
			  /* Wenn eine Zeilen- und Spaltennummer eingegeben wird, wird die Zeilen- 
              und Spaltenindexvariable der oberen linken Spalte in dem Feld mit der Nummer*/
		    int lokaleKastenlinie = linie - linie % 3;
		    int lokaleKastenspalte = spalte - spalte % 3;
		    
		    for (int i = lokaleKastenlinie; i < lokaleKastenlinie + 3; i++) {
		      for (int j = lokaleKastenspalte; j < lokaleKastenspalte + 3; j++) {
		        if (Gitter[i][j] == nummer) {
		          return true;
		        }
		      }
		    }
		    return false;
		  }
		  
		  // Eine Methode, die die drei oben genannten Elemente überprüft
		  
		  private static boolean isValidPlacement(int[][] Gitter, int nummer, int linie, int spalte) {
		    return !IstNummerInlinie(Gitter, nummer, linie) &&
		        !IstNummerInspalte(Gitter, nummer, spalte) &&
		        !IstNummerInBox(Gitter, nummer, linie, spalte);
		  }
		  
		  private static boolean geloestesGitter(int[][] Gitter) {
			  //eine for-Schleife, die die gesamte Gitter durchläuft
			  
		    for (int linie = 0; linie < GITTERGRÖSSE; linie++) {
		      for (int spalte = 0; spalte < GITTERGRÖSSE; spalte++) {
		        if (Gitter[linie][spalte] == 0) {
		          for (int nummerToTry = 1; nummerToTry <= GITTERGRÖSSE; nummerToTry++) {
		            if (isValidPlacement(Gitter, nummerToTry, linie, spalte)) {
		              Gitter[linie][spalte] = nummerToTry;
		              /*verwenden wir Rekursivität , Da wir die Lücken oben gefüllt
		               *  haben, führen Sie diese Methode erneut rekursiv aus, 
		               *  um die Lücken zu ignorieren, Dann finden und füllen Sie die Lücken.*/
		              
		              if (geloestesGitter(Gitter)) {
		                return true; //Die vorherigen Lücken wurden erfolgreich ausgefüllt
		              }
		              else {
		                Gitter[linie][spalte] = 0;
		              }
		            }
		          }
		          //false, wenn nicht alle passen (isValidPlacement)
		          return false;
		        }
		      }
		    }
		    return true;
		  }
		  
public static void main(String[] args) {
			  
			  //füllung der zeilen des 9*9 raster , Zeile für Zeile
			  
			  System.out.println("Geben sie die Erste Linie Zahl für Zahl  :");
			  Scanner sc = new Scanner( System.in);
			  int [] eins = new int[9];
			  for (int i = 0; i < eins.length; i++)
			    {
			        eins[i] = sc.nextInt();   
			    }
			  System.out.println("1 linie = "+ Arrays.toString(eins));
			  

			  
			  System.out.println("Geben sie die 2 Linie Zahl für Zahl  :");
			  int [] zwei = new int[9];
			  for (int i = 0; i < zwei.length; i++)
			    {
			        zwei[i] = sc.nextInt();   
			    }
			  System.out.println("2 linie = "+ Arrays.toString(zwei));
			  
			  
			  
			  System.out.println("Geben sie die 3 Linie Zahl für Zahl  :");
			  int [] drei = new int[9];
			  for (int i = 0; i < drei.length; i++)
			    {
			        drei[i] = sc.nextInt();     
			    }
			  System.out.println("3 linie = "+ Arrays.toString(drei));
			  
			  
			  System.out.println("Geben sie die 4 Linie Zahl für Zahl :");
			  int [] vier = new int[9];
			  for (int i = 0; i < vier.length; i++)
			    {
			        vier[i] = sc.nextInt();     
			    }
			  System.out.println("4 linie = "+ Arrays.toString(vier));
			  
			  
			  System.out.println("Geben sie die 5 Linie Zahl für Zahl :");
			  int [] funf = new int[9];
			  for (int i = 0; i < funf.length; i++)
			    {
			        funf[i] = sc.nextInt();     
			    }
			  System.out.println("5 linie = "+ Arrays.toString(funf));
			  
			  
			  System.out.println("Geben sie die 6 Linie Zahl für Zahl :");
			  int [] sechs = new int[9];
			  for (int i = 0; i < sechs.length; i++)
			    {
			        sechs[i] = sc.nextInt();     
			    }
			  System.out.println("6 linie = "+ Arrays.toString(sechs));
			  
			  
			  
			  System.out.println("Geben sie die 7 Linie Zahl für Zahl :");
			  int [] sieben = new int[9];
			  for (int i = 0; i < sieben.length; i++)
			    {
			        sieben[i] = sc.nextInt();     
			    }
			  System.out.println("7 linie = "+ Arrays.toString(sieben));
			  
			  
			  
			  
			  System.out.println("Geben sie die 8 Linie Zahl für Zahl :");
			  int [] acht = new int[9];
			  for (int i = 0; i < acht.length; i++)
			    {
			        acht[i] = sc.nextInt();     
			    }
			  System.out.println("8 linie = "+ Arrays.toString(acht));
			  
			  
			  System.out.println("Geben sie die 9 Linie Zahl für Zahl :");
			  int [] neuen = new int[9];
			  for (int i = 0; i < neuen.length; i++)
			    {
			        neuen[i] = sc.nextInt();     
			    }
			  System.out.println("9 linie = "+ Arrays.toString(neuen));
			  
			  
			  
			  //speichern wir das Ganze in unserem zweidimensionalen Array ab
			  
			 int [] []  Gitter= new int [][] { eins , zwei , drei, vier , funf , sechs , sieben , acht , neuen };
			  
			  
		    
			//Zuerst wird das Basisgitter angezeigt
			
		    printGitter(Gitter);
		    //
		    System.out.println(" ");
		    
		    if (geloestesGitter(Gitter)) {
		      System.out.println("Erfolgreich gelöst");
		    }
		    else {
		      System.out.println("Unlösbare Aufgaben");
		    }
		    //wird nun der gelöste gitter angezeigt.
		    printGitter(Gitter);
		    
		  }
		  
		  
		}
