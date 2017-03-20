package it.polito.tdp.libretto.model;
import java.time.LocalDate;

/*Oggetto semplice che contiene i dati relativi ad un singolo esame*/
/*Semplice--> dati privati, costruttore, metodi getters-setters, metodi di servizio (compareTo, toString, equals. hashCode, ...)*/

public class Esame {
	private String codice;
	private String titoloCorso;
	private String docente;
	/*Da usare se ci serve un elenco di docenti
	private Docente docente;*/
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	
	/**
	 * Nuovo esame, non ancora superato
	 * @param codice
	 * @param titoloCorso
	 * @param docente cognome e nome del docente titolare
	 */
	public Esame(String codice, String titoloCorso, String docente) {
		this.codice = codice;
		this.titoloCorso = titoloCorso;
		this.docente = docente;
		this.superato=false;
	}


	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}


	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}


	/**
	 * @return the titoloCorso
	 */
	public String getTitoloCorso() {
		return titoloCorso;
	}


	/**
	 * @param titoloCorso the titoloCorso to set
	 */
	public void setTitoloCorso(String titoloCorso) {
		this.titoloCorso = titoloCorso;
	}


	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}


	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}


	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}


	/**
	 * Restituisce il voto solo se l'esame è superato
	 * Altrimenti eccezione
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		else
			throw new IllegalStateException("Esame "+this.codice+"non ancora superato\n");
			
	}


	/**
	 * Restituisce la data solo se l'esame è superato
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
		else
			throw new IllegalStateException("Esame "+this.codice+"non ancora superato\n");
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titoloCorso=" + titoloCorso + ", docente=" + docente + ", superato="
				+ superato + ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * A cosa serve?
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non è superato, lo considera superato con il voto e la data specificati
	 * Se fosse già superato, genera un'eccezione
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		if(!this.superato){
			this.superato=true;
			this.voto=voto;
			this.dataSuperamento=data;
		}else{
			/*Eccezione di tipo runTime*/
			throw new IllegalStateException("Esame "+this.codice+"già superato\n");
		}
	}
	
	
}
