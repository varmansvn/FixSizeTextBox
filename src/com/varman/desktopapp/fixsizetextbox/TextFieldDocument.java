/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varman.desktopapp.fixsizetextbox;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author varman
 */
public class TextFieldDocument extends PlainDocument {
     private float nMax;
	  
    public TextFieldDocument() {
        super();
    }
    
    /*
    public void setMaxTextLength(int maxLength) {
        limit = maxLength;
    }
    
    */
    
    public void setMaxNumber(float nMax) {
        this.nMax = nMax;
    }
    
    private boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private float getNumericValue(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    
    public void insertString(int offset, String str, AttributeSet attr)
    throws BadLocationException {
        if (str == null) return;
        /*
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
	}
        */
         String oldStr = getText(0, getLength());
         String newStr = oldStr.substring(0, offset) + str
          + oldStr.substring(offset);
        if((true == isNumeric(newStr)) &&
           (nMax >= getNumericValue(newStr))) {
            super.insertString(offset, str, attr);
        }
       
    }
}
