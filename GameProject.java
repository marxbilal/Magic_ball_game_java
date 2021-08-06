
package gameproject;
import javax.swing.JFrame;

public class GameProject {

    
    public static void main(String[] args) {
        JFrame a=new JFrame();
        play p=new play();
        a.setBounds(10, 10, 700, 600);
        a.setTitle("Magic Ball");
        a.setResizable(true);
        a.setVisible(true);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.add(p);
                
    }
    
}
