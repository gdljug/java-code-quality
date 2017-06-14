package application;

import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class BadClass {
    
    String something;
    static final int othervar = 100;
    
    public void sum() {
        int r = 500 + 600;
    }
    
    public void opensome_Resource(){
        
        try {
            OutputStream outputStream = new ObjectOutputStream(System.out);
        } catch (Exception e) {
        }
    }
    
}