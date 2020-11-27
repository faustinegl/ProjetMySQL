import javax.swing.*;

public class HomePage extends JFrame {



    public HomePage() {
        super("Page d'acceuil");
        Panel panel = new Panel();
        Menu menu= new Menu();
        this.setSize(1250, 900);
//        this.setDefaultLookAndFeelDecorated(true);
        this.setLayout(null);
        this.add(menu);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}









