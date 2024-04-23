import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class gui implements ActionListener {

  JTextField userName;
  String User = "";
  String address = "";
  String firstName = "";
  String lastName = "";
  String age = "";
  String emailAddress = "";
  String newPassword = "";
  JFrame starupFrame = new JFrame("Airline login/create acc");
  JFrame adminLoginFrame = new JFrame("Airline Admin");
  JFrame loginFrame = new JFrame("Airline: User Login");
  JFrame CreateAccFrame = new JFrame("Airline: Create an account");
  JFrame adminFrame = new JFrame("Airline: Welcome.");
  JFrame HomePageFrame = new JFrame("Airline: Welcome " + User);
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

    starupFrame.dispose();

    // INPUTS Section
    // create label for user name
    JLabel FirstNameLabel = new JLabel();
    FirstNameLabel.setText("Enter First name:"); // set label value for textField1
    FirstNameLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get username from the user
    JTextField FirstName = new JTextField(15); // set length of the text
    FirstName.setMaximumSize(new Dimension(1200, 40));

    // create label for lastname
    JLabel LastNameLabel = new JLabel();
    LastNameLabel.setText("Enter Last name:"); // set label value for textField2
    LastNameLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get lastname from the user
    JTextField LastName = new JTextField(15); // set length for the password
    LastName.setMaximumSize(new Dimension(1200, 40));

    // create label for age
    JLabel AgeLabel = new JLabel();
    AgeLabel.setText("Enter Age:"); // set label value for textField1
    AgeLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get age from the user
    JTextField Age = new JTextField(15); // set length of the text
    Age.setMaximumSize(new Dimension(1200, 40));

    // create text field to get address from the user
    JLabel addressLabel = new JLabel();
    addressLabel.setText("Enter Residential Address:");
    addressLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get Address from the user
    JTextField Address = new JTextField(15);
    Address.setMaximumSize(new Dimension(1200, 40));

    /// AB TESTS

    // create text field to get eamil address from the user
    JLabel EmailAddressLabel = new JLabel();
    EmailAddressLabel.setText("Enter Email Address:");
    EmailAddressLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get email Address from the user
    JTextField email = new JTextField(15);
    email.setMaximumSize(new Dimension(1200, 40));

    // create label for username
    JLabel UserNameLabel = new JLabel();
    UserNameLabel.setText("Enter User Name:");
    UserNameLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get username from the user
    userName = new JTextField(15);
    userName.setMaximumSize(new Dimension(1200, 40));

    // create label for password
    JLabel NewpassLabel = new JLabel();
    NewpassLabel.setText("Create New Password:"); // set label value for textField2
    NewpassLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get password from the user
    JPasswordField Newpassword = new JPasswordField(15); // set length for the password
    Newpassword.setMaximumSize(new Dimension(1200, 40));

    // create submit button
    JButton submit = new JButton("Create an Account"); // set label to button
    submit.setActionCommand("Create user");
    submit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        firstName = FirstName.getText();
        lastName = LastName.getText();
        age = Age.getText();
        address = Address.getText();
        emailAddress = email.getText();
        User = userName.getText();
        newPassword = String.valueOf(Newpassword.getPassword());

        if (FirstName.getText().isEmpty() || LastName.getText().isEmpty() || Age.getText().isEmpty() ||
            Address.getText().isEmpty() || email.getText().isEmpty() || userName.getText().isEmpty() ||
            Newpassword.getPassword().length == 0) {
          JOptionPane.showMessageDialog(null, "Please fill in all sections.");
        } else {
          /*
           * String fullName = firstName + " " + lastName;
           * int ageInt = Integer.parseInt(age);
           * guest.setCustomerName(fullName);
           * guest.setCustomerAge(ageInt);
           * guest.setCustomerAddress(address);
           * guest.setCustomerEmail(emailAddress);
           * try {
           * db.makeAccount(User, newPassword, guest);
           * } catch (Exception e1) {
           * // TODO Auto-generated catch block
           * e1.printStackTrace();
           * }
           */
          if (e.getSource() == submit) {
            starupFrame.getContentPane().removeAll();
            CreateAccFrame.getContentPane().removeAll();
            JOptionPane.showMessageDialog(null, "You have successfully created an account.");
            CreateAccFrame.dispose();

            HomePageFrame(); // Go to reservation page next
          }
        }
      }

    });

    // create back button
    JButton back = new JButton("Back"); // set label to button
    back.setActionCommand("Go back");
    back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
          starupFrame.getContentPane().removeAll();
          CreateAccFrame.getContentPane().removeAll();
          reservationFrame.dispose();
          ;
          loginFrame.dispose();
          CreateAccFrame.dispose();
          starupFrame(); // replace this with correct next frame
        }
      }
    });

    CreateAccFrame.add(FirstNameLabel);
    CreateAccFrame.add(FirstName);
    CreateAccFrame.add(LastNameLabel);
    CreateAccFrame.add(LastName);
    CreateAccFrame.add(AgeLabel);
    CreateAccFrame.add(Age);
    CreateAccFrame.add(addressLabel);
    CreateAccFrame.add(Address);
    CreateAccFrame.add(EmailAddressLabel);
    CreateAccFrame.add(email);
    CreateAccFrame.add(UserNameLabel);
    CreateAccFrame.add(userName);
    CreateAccFrame.add(NewpassLabel);
    CreateAccFrame.add(Newpassword);
    CreateAccFrame.add(submit);
    CreateAccFrame.add(back);

    // Source:
    // https://stackoverflow.com/questions/761341/error-upon-assigning-layout-boxlayout-cant-be-shared
    CreateAccFrame.getContentPane().setLayout(new BoxLayout(CreateAccFrame.getContentPane(), BoxLayout.Y_AXIS));

    CreateAccFrame.setSize(500, 500);
    CreateAccFrame.setLocationRelativeTo(null);
    CreateAccFrame.setVisible(true);

  }

  void loginFrame() {
    starupFrame.dispose();

    JLabel userLabel = new JLabel();
    userLabel.setText("Enter Username:"); // set label value for textField1
    userLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get username from the user
    JTextField user = new JTextField(15); // set length of the text
    user.setMaximumSize(new Dimension(1200, 40));

    // create label for password
    JLabel passLabel = new JLabel();
    passLabel.setText("Enter Password:"); // set label value for textField2
    passLabel.setMaximumSize(new Dimension(1200, 40));

    // create text field to get password from the user
    JPasswordField password = new JPasswordField(15); // set length for the password
    password.setMaximumSize(new Dimension(1200, 40));
    // create submit button
    JButton submit = new JButton("Login"); // set label to button
    // A
    // create back button
    JButton back = new JButton("Back"); // set label to button
    back.setActionCommand("Go back");
    back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
          starupFrame.getContentPane().removeAll();
          loginFrame.getContentPane().removeAll();
          loginFrame.dispose();
          CreateAccFrame.dispose();
          starupFrame();
        }
      }
    });

    submit.setActionCommand("Authenticate");
    submit.addActionListener(this);
    /*
     * {
     * 
     * @Override
     * public void actionPerformed(ActionEvent e) {
     * User = user.getText();
     * newPassword = String.valueOf(password.getPassword());
     * 
     * // when verified, has access. If not, need to pop a message
     * /*
     * if (db.customerLogin(User, newPassword)) {
     * JOptionPane.showMessageDialog(mainFrame, "You have logged in.");
     * guestAccount = db.getAccount(User);
     * loginFrame.dispose();
     * HomePageFrame();
     * System.out.println("Customer " + User + " login." +timeLog() );
     * 
     * } else {
     * System.out.println("Customer " + User+ " failed to login." +timeLog() );
     * System.out.println("Customer failed login.");
     * JOptionPane.showMessageDialog(starupFrame, "Customer failed login.");
     * }
     * 
     * }
     * });
     */

    loginFrame.add(userLabel);
    loginFrame.add(user);
    loginFrame.add(passLabel);
    loginFrame.add(password);
    loginFrame.add(submit);
    loginFrame.add(back);

    // Source:
    // https://stackoverflow.com/questions/761341/error-upon-assigning-layout-boxlayout-cant-be-shared
    loginFrame.getContentPane().setLayout(new BoxLayout(loginFrame.getContentPane(), BoxLayout.Y_AXIS));

    loginFrame.setSize(500, 500);
    loginFrame.setLocationRelativeTo(null);
    loginFrame.setVisible(true);

  }

  void HomePageFrame() {
    CreateAccFrame.dispose();
    loginFrame.dispose();
    PaymentFrame.dispose();

    JPanel HomePage = new JPanel();
    HomePage.setBackground(Color.gray);
    // mainMenu.setMaximumSize((new Dimension(40, 40)));
    JButton Reservation = new JButton("Make Reservation");

    Reservation.setBackground(Color.yellow);

    JButton Cancel = new JButton("Cancel Reservation");
    Cancel.setBackground(Color.CYAN);

    JButton Exit = new JButton("Exit");

    Exit.setActionCommand("Exit");
    Exit.addActionListener(this);
    Reservation.setActionCommand("Make Reservation");
    Reservation.addActionListener(this);
    Cancel.setActionCommand("Cancel Reservation");
    Cancel.addActionListener(this);
    // login.setPreferredSize(new Dimension(40, 40));
    HomePage.add(Reservation);
    // HomePage.add(RoomInfo);
    HomePage.add(Cancel);
    HomePage.add(Exit);

    HomePageFrame.add(HomePage);

    // Pack, Locate, and Visibility

    HomePageFrame.setSize(500, 500);
    HomePageFrame.setLocationRelativeTo(null);
    // HomePageFrame.setLayout(new BorderLayout(0,500));
    HomePageFrame.setVisible(true);

  }

  void reservationFrame() {
    HomePageFrame.dispose();

    SpinnerModel value = new SpinnerNumberModel(1, 1, 4, 1);
    /*
     * SpinnerModel value2 = new SpinnerNumberModel(0,0,4,1);
     * SpinnerModel value3 = new SpinnerNumberModel(0,0,4,1);
     */
    Date dates = new Date();
    SpinnerDateModel date = new SpinnerDateModel(dates, null, null, Calendar.DATE);
    JLabel welcomeText = new JLabel();
    welcomeText.setText("Welcome ");// + guest.getCustomerName() + ".");

    JLabel arrivalLabel = new JLabel();
    arrivalLabel.setText("Arrival - Date");
    arrivalLabel.setMaximumSize(new Dimension(120, 40));
    JSpinner dateSpinner = new JSpinner(date);
    JSpinner.DateEditor de = new JSpinner.DateEditor(dateSpinner, "MM/dd/yyyy");
    dateSpinner.setToolTipText("Hightlight the number to change");
    dateSpinner.setEditor(de);
    dateSpinner.setMaximumSize(new Dimension(100, 40));

    // JTextField arrvial = new JTextField("mm-D-year");
    // arrvial.setMaximumSize(new Dimension(1200,40));

    JLabel stayLabel = new JLabel();
    stayLabel.setText("Length of stay");
    stayLabel.setMaximumSize(new Dimension(120, 40));

    SpinnerModel staySpinner = new SpinnerNumberModel(1, 1, 7, 1);
    JSpinner staySpinner2 = new JSpinner(staySpinner);
    staySpinner2.setMaximumSize(new Dimension(50, 40));

    JTextField stay = new JTextField(5);
    stay.setMaximumSize(new Dimension(120, 40));

    JLabel Adults = new JLabel();
    Adults.setText("Number of guests");
    JSpinner numGuestSpinner = new JSpinner(value);
    numGuestSpinner.setMaximumSize(new Dimension(50, 40));

    JLabel Roomselection = new JLabel();
    Roomselection.setText("Room Selection");
    Roomselection.setMaximumSize(new Dimension(120, 40));
    DefaultListModel<String> l1 = new DefaultListModel<>();
    l1.addElement("Classic - $149.99 per night");
    l1.addElement("Premium - $199.99 per night");
    l1.addElement("Deluxe - $249.99 per night");
    l1.addElement("Business - $274.99 per night");
    l1.addElement("Honeymoon - $299.99 per night");
    JList<String> list = new JList<>(l1);
    list.setMaximumSize(new Dimension(260, 100));

    JLabel RoomType = new JLabel();
    RoomType.setText("Room type selection");
    RoomType.setMaximumSize(new Dimension(120, 40));
    DefaultListModel<String> l2 = new DefaultListModel<>();
    l2.addElement("1 king");
    l2.addElement("2 king");
    l2.addElement("1 queen");
    l2.addElement("2 queen");
    JList<String> list2 = new JList<>(l2);
    list2.setMaximumSize(new Dimension(100, 80));

    JCheckBox checkbox1 = new JCheckBox("Agree to Hotel policies and regulations");

    JButton submit = new JButton("Make Reservation"); // set label to button
    submit.setActionCommand("");

    submit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        final String[] roomClassT = new String[1];
        final String[] roomAmen = new String[1];

        // try {
        // numGuestSpinner.commitEdit();
        // } catch (ParseException ex) {
        // ex.printStackTrace();
        // }
        Integer numGuestSpinner2 = (Integer) numGuestSpinner.getValue();

        Date dateSpinner2 = (Date) dateSpinner.getValue();
        int stay2 = (int) staySpinner2.getValue();

        if (!checkbox1.isSelected()) {
          JOptionPane.showMessageDialog(null, "can't progessive forword if you don't agree with the hotel policies ");
        } else {
          if ((list.getSelectedIndex() != -1) && (list2.getSelectedIndex() != -1)) {
            roomClassT[0] = list.getSelectedValue();
            roomAmen[0] = list2.getSelectedValue();
          }

          String[] roomClassArr = roomClassT[0].split(" ", 2);

          boolean exists = false;

          // for (Room r : db.getDb().keySet()) {
          // if (r.getAmenities().equalsIgnoreCase(roomAmen[0]) &&
          // r.getRoomType().equalsIgnoreCase(roomClassArr[0].toLowerCase())) {
          // exists = true;
          // }
        }
        // if (roomClassArr[0].equalsIgnoreCase("honeymoon") && numGuestSpinner2 == 1) {
        // System.out.println("Yes");
        // JOptionPane.showMessageDialog(null, "You may not book a honeymoon for
        // yourself. That is just sad.");
        // return;
        // }
        // else if (roomClassArr[0].equalsIgnoreCase("honeymoon") && numGuestSpinner2 >
        // 2) {
        // JOptionPane.showMessageDialog(null, "You want to book a honeyroom room for "
        // + numGuestSpinner2 + " people. You need Jesus!");
        // return;
        // }

        // if (!exists) {
        // JOptionPane.showMessageDialog(null, "There are no rooms that is a " +
        // roomClassT[0] +
        // " and has " + roomAmen[0] + ". Please selection different options.");
        // return;
        // }

        // try {
        // db.reservationHelper(guestAccount.getAccountID(), dateSpinner2, stay2,
        // numGuestSpinner2, roomClassT[0], roomAmen[0]);
        // } catch (ParseException ex) {
        // ex.printStackTrace();
        // }

        System.out.println("Reservation made.");
        JOptionPane.showMessageDialog(starupFrame, "Reservation made.");
        reservationFrame.getContentPane().removeAll();
        reservationFrame.dispose();
        adminFrame.dispose();
        adminLoginFrame.dispose();
        loginFrame.dispose();
        CreateAccFrame.dispose();
        PaymentFrame.getContentPane().removeAll();
        PaymentFrame.dispose();

        // try {
        // PaymentFrame();
        // } catch (ParseException ex) {
        // ex.printStackTrace();
        // }
      }
    });

    // create back button
    JButton back = new JButton("Back"); // set label to button
    // back.setActionCommand("Go back");
    back.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
          reservationFrame.getContentPane().removeAll();

          reservationFrame.dispose();
          adminFrame.dispose();
          adminLoginFrame.dispose();
          loginFrame.dispose();
          CreateAccFrame.dispose();

          HomePageFrame(); // replace this with correct next frame
        }
      }
    });

    reservationFrame.add(welcomeText);
    reservationFrame.add(Adults);
    reservationFrame.add(numGuestSpinner);
    reservationFrame.add(arrivalLabel);
    reservationFrame.add(dateSpinner);
    reservationFrame.add(stayLabel);
    reservationFrame.add(staySpinner2);
    reservationFrame.add(Roomselection);
    reservationFrame.add(list);
    reservationFrame.add(RoomType);
    reservationFrame.add(list2);
    reservationFrame.add(checkbox1);
    reservationFrame.add(submit);
    reservationFrame.add(back);
    // reservationFrame.setSize(200,200);
    reservationFrame.getContentPane().setLayout(new BoxLayout(reservationFrame.getContentPane(), BoxLayout.Y_AXIS));

    reservationFrame.setSize(500, 500);
    reservationFrame.setLocationRelativeTo(null);
    reservationFrame.setVisible(true);

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

      case "Create user":
        User = userName.getText();

        JOptionPane.showMessageDialog(null, "Account has been created");
        System.out.println(User + "'s Account has been created. Time: " + timeLog());

        int dialogButton = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null,
            "Would you like to sign in?", "Confirmation", dialogButton);
        if (dialogButton == JOptionPane.YES_OPTION) {
          HomePageFrame();
          System.out.println(User + "'s entered  home page. Time: " + timeLog());

        }
        if (dialogButton == JOptionPane.NO_OPTION) {
          JOptionPane.showMessageDialog(null, "Returning to main menu.");
          starupFrame();
        }
        break;

      case "Make Reservation":
        reservationFrame();
        System.out.println("Entering user Make reservation. Time: " + timeLog());
        break;

      case "Authenticate":
        // Need the account portion for this
        HomePageFrame();
        System.out.println("Logging in as User. Time: " + timeLog());
        break;

      /*
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