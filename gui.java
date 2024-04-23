import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class gui implements ActionListener {

  JFrame starupFrame = new JFrame("Airline login/create acc");
  JFrame adminLoginFrame = new JFrame("Airline Admin");
  JFrame loginFrame = new JFrame("Airline: User Login");
  JFrame CreateAccFrame = new JFrame("Airline: Create an account");
  JFrame adminFrame = new JFrame("Airline: Welcome.");
  // JFrame HomePageFrame= new JFrame("Airline: Welcome " + User);
  JFrame PaymentFrame = new JFrame("Airline: Payment");
  JFrame reservationFrame = new JFrame("Airline: Reservation");

  gui() {

    starupFrame();

  }

  void starupFrame() {

    JPanel mainMenu = new JPanel(new GridLayout(3, 0, 0, 20));
    mainMenu.setSize(50, 50);
    mainMenu.setBackground(Color.GRAY);

    // mainMenu.setMaximumSize((new Dimension(40, 40)));
    JButton Login = new JButton("User Login");
    JButton Exit = new JButton("Exit");
    JButton CreateAcc = new JButton("Create an Account");

    Exit.setActionCommand("Exit");
    Exit.addActionListener(this);
    Login.setActionCommand("Login");
    Login.addActionListener(this);
    CreateAcc.setActionCommand("Create Account");
    CreateAcc.addActionListener(this);

    mainMenu.add(CreateAcc);
    mainMenu.add(Login);
    mainMenu.add(Exit);

    starupFrame.add(mainMenu);

    starupFrame.setSize(500, 500);
    starupFrame.setLocationRelativeTo(null);
    starupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    starupFrame.setVisible(true);

  }

  void CreateAccFrame() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'CreateAccFrame'");
  }

  void loginFrame() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'loginFrame'");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // source:
    // https://stackoverflow.com/questions/5936261/how-to-add-action-listener-that-listens-to-multiple-buttons
    String action = e.getActionCommand().toString();

    switch (action) {
      case "Exit":
        JOptionPane.showMessageDialog(starupFrame,
            "Thank you visiting our AirlineDatabase. Application will now close.");
        System.out.println("Exit");
        /*
         * try {
         * db.closeDB();
         * } catch (IOException | SQLException ex) {
         * ex.printStackTrace();
         * }
         */
        System.exit(420);
        break;
      case "Login":
        loginFrame();
        System.out.println("Entering user login. Time: " + timeLog());
        break;

      case "Create Account":
        CreateAccFrame();

        System.out.println("Entering user Creating account. Time: " + timeLog());
        break;

      /*
       * case "Create user":
       * User = userName.getText();
       * 
       * JOptionPane.showMessageDialog(null, "Account has been created");
       * System.out.println(User + "'s Account has been created. Time: "+timeLog() );
       * 
       * int dialogButton = JOptionPane.YES_NO_OPTION;
       * JOptionPane.showConfirmDialog (null,
       * "Would you like to sign in?","Confirmation", dialogButton);
       * if(dialogButton == JOptionPane.YES_OPTION) {
       * HomePageFrame();
       * System.out.println(User+ "'s entered  home page. Time: "+timeLog() );
       * 
       * if(dialogButton == JOptionPane.NO_OPTION) {
       * JOptionPane.showMessageDialog(null,"Returning to main menu.");
       * mainFrame();
       * }
       * }
       * break;
       * case "Make Reservation":
       * reservationFrame();
       * System.out.println("Entering user Make reservation. Time: "+timeLog() );
       * break;
       * 
       * case "Authenticate":
       * // Need the account portion for this
       * HomePageFrame();
       * System.out.println("Logging in as User. Time: " +timeLog() );
       * break;
       * case "adminLogin":
       * System.out.println("Entering Admin Login. Time: " +timeLog() );
       * 
       * adminLoginFrame();
       * break;
       * case "Authenticate ":
       * System.out.println("Logging in as Admin" +timeLog() );
       * adminHomeFrame();
       * break;
       * case "Cancel Reservation":
       * cancelF();
       * System.out.println("Entering user cancel reservation. Time: "+timeLog() );
       * break;
       */
      default:
        JOptionPane.showMessageDialog(starupFrame, "Sorry! Skill Issue");
    }
  }
  // Source: http

  public String timeLog() {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    return formattedDate;
  }

}