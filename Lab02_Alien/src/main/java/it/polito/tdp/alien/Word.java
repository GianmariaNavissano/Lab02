package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	public Word(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getTranslation() {
		return translation;
	}
	

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	@Override
	public boolean equals(Object obj) {
		Word word = (Word) obj;
		if(word.getAlienWord().equals(this.alienWord) && word.getTranslation().equals(this.translation))
			return true;
		else return false;
	}

	public String getAlienWord() {
		return alienWord;
	}
	
	
	

}
