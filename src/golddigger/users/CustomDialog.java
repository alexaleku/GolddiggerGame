/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package golddigger.users;

import golddigger.gui.MainFrame;

/**
 *
 * @author alexkurocha
 */
public class CustomDialog {
    private IntStringValidator nameValidator = new NameValidator();
    
    private String typedText = null;

    public CustomDialog(MainFrame aThis, String user_Name, String enter_Name, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void propertyChange() {
        if (nameValidator.isValid(typedText)) {
            
        }
    }

    public Object getValidatedText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
