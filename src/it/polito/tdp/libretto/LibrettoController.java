package it.polito.tdp.libretto;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.libretto.model.Esame;
import it.polito.tdp.libretto.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoController {
	/*Model model=new Model();
	 * Sbagliato 
	 * Per più finestre devo comunque avere un solo modello, non uno per ogni finestra
	 */
	Model model;
	

    /**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtCodice;

    @FXML
    private TextField txtTitolo;

    @FXML
    private TextField txtDocente;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtMessage;

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice=txtCodice.getText();
    	if(codice.length()<5){
    		txtMessage.appendText("Codice esame non valido\n");
    		return ;
    	}
    	Esame e=model.trovaEsame(codice);
    	/*Restituisce o l'oggetto o null*/
    	if(e==null)
    		txtMessage.appendText("Codice "+codice+"non trovato\n");
    	else{
    		txtMessage.appendText("Codice "+codice+"trovato\n");
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitoloCorso());
    		txtDocente.setText(e.getDocente());
    	}
    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	/*Recupera i dati dalla vista
    	 * Verifica la validità dei dati
    	 * Chiede al Model di effettuare l'operazione (inserimento)
    	 * Aggiorna la vista con il risultato dell'operazione*/
    	
    	/*Come può il controller "conoscere" il modello?
    	 * Deve essere comunque "informato"*/
    	String codice=txtCodice.getText();
    	String titolo=txtTitolo.getText();
    	String docente=txtDocente.getText();
    	/*Il getText() non è mai null
    	 * Al max stringa vuota*/
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esame insufficienti\n");
    		return ;
    	}
    	Esame e=new Esame(codice,titolo,docente);
    	boolean result=model.addEsame(e);
    	if(result)
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	else
    		txtMessage.appendText("Esame NON AGIUNTO (codice duplicato)\n");
    }

    @FXML
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Libretto.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'Libretto.fxml'.";

    }
}
