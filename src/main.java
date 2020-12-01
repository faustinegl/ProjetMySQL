import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class main {
    public static void main(String[] args) {
        ConnectDAO connectDAO = new ConnectDAO();
        connectDAO.createConnection();
        Page page = new Page();


    }

   /* public static void addUser(ConnectDAO connectDAO)
    {
        User user =new User();
        DAO<User> userDao = new UserDAO();
        int choice=0,id=0;
        String email;
        String password;
        String lastname;
        String firstname;
        String permission;
        System.out.println("Voulez-vous ajouter un eleve (1) ou un Professeur(2)? ");
        Scanner scanner=new Scanner(System.in);
        choice=scanner.nextInt();

        if (choice ==1)
        {
            permission="STUDENT";
            System.out.println("Donnez les information de l'eleve ");
            id=scanner.nextInt();
            email=scanner.nextLine();
            password=scanner.nextLine();
            lastname=scanner.nextLine();
            firstname=scanner.nextLine();
            user.setId(id);
            user.setPassword(password);
            user.setEmail(email);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setPermission(permission);


        }
        else if(choice==2)
        {

        }
    }
*/

}
