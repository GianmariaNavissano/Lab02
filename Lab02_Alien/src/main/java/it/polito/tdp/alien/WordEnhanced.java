package it.polito.tdp.alien;
import java.util.*;

public class WordEnhanced {
	
	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translations = new LinkedList<String>();
		translations.add(translation);
	}
	
	public void addTranslation(String translation) {
		this.translations.add(translation);
	}

	public String getAlienWord() {
		return alienWord;
	}

	public LinkedList<String> getTranslations() {
		return (LinkedList<String>)translations;
	}
	
	public String toString() {
		String s = "";
		for(String t : translations) {
			s += t+"\n";
		}
		return s;
	}
	

}
