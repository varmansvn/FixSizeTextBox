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
     private int limit;
	  
    public TextFieldDocument() {
        super();
    }
    
    public void setMaxTextLength(int maxLength) {
        limit = maxLength;
    }
    
    public void insertString(int offset, String  str, AttributeSet attr)
    throws BadLocationException {
        if (str == null) return;
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
	}
    }
}
