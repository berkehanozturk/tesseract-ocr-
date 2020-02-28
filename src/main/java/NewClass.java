import java.awt.Color;


public class NewClass {
    
     static NewJFrame frame=null;
    
    public static void main(String[] args) 
    { 
            NewJFrame frame1=new NewJFrame();
            frame1.setTitle("Kullanıcı Arayüzü");
            frame1.setSize(1280,700);
            //frame1.getContentPane().setBackground(Color.WHITE);
            frame1.setVisible(true);
            frame1.addChoice();
            frame1.stateChanged();

            frame=frame1;
            
            
        } 
    }