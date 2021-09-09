package A;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ListaSimpleCuCifre {

	

	// field variables

	static ArrayList<Integer> lista = new ArrayList<Integer>();
	static int suma;
	static int myint;
	//static Scanner keyboard;
	
	public static void main(String[] args) {
		
		//Scanner keyboard = new Scanner(null);
		
		//matricea matrix de intregi [1,2,3]
		int[] matrix = {1,2,3};
		
		//transforma matrix in lista - pt a putea folosi metodele de la LinkedList
	    for (Integer item: matrix) {lista.add(item);}
		
		//Afiseaza lista - la capatul metodei de afisare exista un keyboard input care mentine in ciclu aplicatia.
	    //diverse.valori pozitive pt a adauga lista
	    //diverse.valori negative pentru a le scoate din lista
	    //0 - pentru a inchide aplicatia
	    
	    System.out.println("enter an integer: positive-adds to list | negative-removes from list | 0 - exit");
	    afis();
		}
	 
	public static void adauga(int numar) {
		//daca n-a gasit numarul in lista cu indexOf, atunci il adauga
		if(lista.indexOf(numar)<0){
			lista.add(numar); System.out.println("am adaugat " + numar);}
			else{System.out.println("era deja " + numar);}
		
		afis();
		}

	public static void sterge(int numar) {
		//sterge numarul de la pozitia respectiva - sterge pozitia, nu numarul din argument
		if(lista.indexOf(numar)>-1){
			lista.remove(lista.indexOf(numar));	System.out.println("am sters " + numar);}
			else{System.out.println("nu era " + numar);}
		
		afis();
	}
	
	public static void afis() {
		//ordoneaza crescator numerele din lista
				Collections.sort(lista);
				
				suma = 0;
				for (Integer temp : lista) {suma = suma + temp;}
				
				// se pare ca asa printeaza automat lista cu [ ,  , ] toString 		
				System.out.println("Lista " + lista.toString() + ". Suma: " + suma + " \n");

				Scanner keyboard = new Scanner(System.in);
								
				myint = keyboard.nextInt();
				
				if(myint > 0){adauga(myint);}
				else if(myint <0){sterge(0-myint);}
				else{System.out.println("hai salut!");};
				
				}
				
	}
	
