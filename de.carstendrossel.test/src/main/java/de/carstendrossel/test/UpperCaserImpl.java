package de.carstendrossel.test;

import org.springframework.stereotype.Service;

@Service
public class UpperCaserImpl implements UpperCaser {
	
    @Override
    public String toUpperCase(String text) {
    	return text.toUpperCase();
    }
}