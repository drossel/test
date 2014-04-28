package de.carstendrossel.test;

import org.hibernate.validator.constraints.NotEmpty;

public class UpperFormBean {

	@NotEmpty
	private String text;

	private String upperText;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUpperText() {
		return upperText;
	}

	public void setUpperText(String upperText) {
		this.upperText = upperText;
	}

}
