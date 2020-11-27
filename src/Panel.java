import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {


    public Panel()
    {
        this.setSize(1250,900);
        this.setLayout(null);

        JLabel labelFond = new JLabel(new ImageIcon("PHOTOS/homepage.png"));
        labelFond.setBounds(0,0,1250,900);
        labelFond.setSize(1460,677);

        Font police = new Font("Arial",Font.BOLD,10);
        Font policeMessage = new Font("Arial",Font.BOLD,25);

        JLabel message=new JLabel("Entrez votre email et password");
        JLabel email=new JLabel("EMAIL :");
        JLabel password=new JLabel("PASSWORD :");
        JButton validated= new JButton("Valider");

        message.setBounds(170,30,400,50);
        email.setBounds(220,100,100,20);
        password.setBounds(220,150,100,20);
        validated.setBounds(370,200,100,20);

        message.setFont(policeMessage);
        validated.setFont(police);

        JTextField textEmail= new JTextField();
        textEmail.setBounds(320,100,200,20);
        textEmail.setFont(police);
        textEmail.addActionListener(this);

        JPasswordField textPassWord= new JPasswordField();
        textPassWord.setBounds(320,150,200,20);
        textPassWord.setFont(police);
        textPassWord.addActionListener(this);



        this.setFont(police);


        this.add(message);
        this.add(email);
        this.add(textEmail);
        this.add(password);
        this.add(textPassWord);
        this.add(validated);
        this.setBackground(Color.white);
        this.add(labelFond);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getID()!=4)
        {

        }

    }
}
