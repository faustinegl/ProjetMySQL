import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Delete extends JPanel implements ActionListener {

    Delete(){
        this.setSize(1250,900);
        this.setLayout(null);
        Font police = new Font("Arial",Font.BOLD,15);
        JLabel message = new JLabel("Suppression :");
        String[] element=new String[]{"Eleve","Professeur","Salle","Promotion","Cours","Site","Session"};
        JComboBox modif =new JComboBox<>(element);
        message.setFont(police);
        modif.setFont(police);
        message.setBounds(50,100,100,50);
        modif.setBounds(150,100,150,50);
        this.add(message);
        this.add(modif);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
