import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Page extends JFrame implements ActionListener {

    HomePage homePage = new HomePage();
    Menu menu= new Menu();

    public Page() {
        super("Page d'acceuil");

        this.setSize(1250, 900);
//        this.setDefaultLookAndFeelDecorated(true);
        this.setLayout(null);
        this.add(homePage);
        this.setVisible(true);
        homePage.validated.addActionListener(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


        @Override
        public void actionPerformed (ActionEvent e){

            if (e.getSource() == homePage.validated) {
                this.setContentPane(menu);
                this.revalidate();
            }


        }


}









