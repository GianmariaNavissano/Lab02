package it.polito.tdp.alien;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dictionary;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtWord;

    @FXML
    private TextArea txtResult;

    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	//Lettura e controllo input
    	String[] word = txtWord.getText().toLowerCase().split(" ");
    	//Massimo 2 parole
    	if(word.length>2 || word.length==0) {
    		txtResult.setText("You must type 1  alien word or a new alien word and its translation");
    		txtWord.clear();
    		return;
    	}
    	
    	String alienWord;
    	String translation;
    	
    	//Parola da aggiungere
    	if(word.length==2) {
    		for(int i=0;i<word.length;i++) {
        		if(!word[i].matches("[a-z]+")) {
        			txtResult.setText("Only words are permitted");
        			txtWord.clear();
        			return;
        		}
        	}
    		alienWord = word[0];
    		translation = word[1];
    		dictionary.addWord(alienWord, translation);
    		txtResult.setText("The selected word has been succefully added/updated");
    		txtWord.clear();
    	}
    	
    	//Parola da tradurre
    	if(word.length==1) {
    		alienWord = word[0];
    		if(!alienWord.matches("[a-z]*[?]?[a-z]*")) {
    			txtResult.setText("Maximum one '?' is permitted");
    			txtWord.clear();
    			return;
    		}
    		translation = dictionary.translateWord(alienWord);
    		if(translation==null) 
    			txtResult.setText("The selected word is unknown");
    		else txtResult.setText(translation);
    		txtWord.clear();
    	}

    }

    @FXML
    void initialize() {
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        
        dictionary = new AlienDictionary();

    }
}
