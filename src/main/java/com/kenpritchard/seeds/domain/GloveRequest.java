package com.kenpritchard.seeds.domain;

import java.util.ArrayList;
import java.util.List;

public class GloveRequest {
	private String targetWord;
	private List<String> inputStrings = new ArrayList<String>();
	
	public String getTargetWord() {
		return targetWord;
	}
	public void setTargetWord(String targetWord) {
		this.targetWord = targetWord;
	}
	public List<String> getInputStrings() {
		return inputStrings;
	}
	public void setInputStrings(List<String> inputStrings) {
		this.inputStrings = inputStrings;
	}
}
