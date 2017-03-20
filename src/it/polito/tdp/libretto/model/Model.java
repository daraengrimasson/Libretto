package it.polito.tdp.libretto.model;
import java.util.*;

public class Model {
	private List<Esame> esami;
	
	public Model(){
		this.esami= new LinkedList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti
	 * verificando che non sia già presente 
	 * true-->non ancora inserito false-->già inserito
	 * @param e
	 */
	public boolean addEsame( Esame e){
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}
		/*Tre modi per risolvere l'anomalia
		 * 1 silent failure (meno bello perchè non ho un'informazione sul mancato inserimento)
		 * 2 soft failure (boolean)
		 * 3 genero un'eccezione*/
		else{
			return false;
		}
	}
	
	public Esame trovaEsame(String codice){
		/*Due modi
		 * 1 scandire tutta la Lista con ciclo for()
		 * 2 metodo di più alto livello indexOf (che fa sempre un ciclo for) */
		int posizioneEsame= esami.indexOf(new Esame(codice, null, null));
		if(posizioneEsame == -1){
			/*Esame non trovato*/
			/*Se non facessi questo if e l'esame non fosse presente, eccezione*/
			return null;
		}
		else
			return esami.get(posizioneEsame);
	}

}
