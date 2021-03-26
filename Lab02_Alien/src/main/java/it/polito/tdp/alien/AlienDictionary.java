package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	Map<String, Word> words;
	Map<String, WordEnhanced> wordse;

	public AlienDictionary() {
		this.words = new HashMap<String, Word>();
		this.wordse = new HashMap<String, WordEnhanced>();
	}
	/*
	public void addWord(String alienWord, String translation) {
		Word w;
		if(this.words.containsKey(alienWord)) {
			w = this.words.get(alienWord);
			w.setTranslation(translation);
		} else {
			w = new Word(alienWord, translation);
			this.words.put(alienWord, w);
		}
	}
	
	public String translateWord(String alienWord) {
		Word w = this.words.get(alienWord);
		if(w!=null) {
			return w.getTranslation();
		}else return null;
	}
	*/
	public void addWord(String alienWord, String translation) {
		WordEnhanced we;
		if(this.wordse.containsKey(alienWord)) {
			we = this.wordse.get(alienWord);
			we.addTranslation(translation);
		}
		else {
			we = new WordEnhanced(alienWord, translation);
			this.wordse.put(alienWord, we);
		}
	}
	
	public String translateWord(String alienWord){
		
		WordEnhanced we = this.wordse.get(alienWord);
		String s ="";
		
		if(alienWord.contains("?")) {
			int j = alienWord.indexOf('?');
			boolean foundIt = true;
			int wordsFound = 0;
			
			for(String w : this.wordse.keySet()) {
				if(w.length()==alienWord.length()) {
					if(w.substring(0, j).equals(alienWord.substring(0, j)) && w.substring(j+1).equals(alienWord.substring(j+1))) {
						we = this.wordse.get(w);
						wordsFound++;
						s += ""+wordsFound+". "+we.toString();
					}
				}
			}
			if(wordsFound>0) return s;
		}
		if(we!=null) {
			return we.toString();
		} else return null;
	}

}
