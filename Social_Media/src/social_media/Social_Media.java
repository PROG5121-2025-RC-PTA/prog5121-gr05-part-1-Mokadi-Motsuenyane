package social_media;

//imports 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 *
 * @author ST10480772_Motsuenyane_MDK_Group_5
 */
public class Social_Media {

    // attributes
    public static String cellPhone[] = new String[3];
    public static String password[] = new String[3];
    public static String cellphone;
    public static String username[] = new String[3];
    public static int arrayIndex = 0;

    public static void main(String[] args) {

        //Label GUI to display a string 
        
        //creates a new label
        JLabel lblWelcome = new JLabel();
        //The Label Displays text that Welcomes the user
        lblWelcome.setText("Welcome to ConnectCircle ");
        //Sets the vertical position
        lblWelcome.setVerticalAlignment(JLabel.CENTER);

        //Sets the Color of the label
        lblWelcome.setForeground(Color.WHITE);
       
        //Creates a border for the lable
        Border borderLbl = BorderFactory.createLineBorder(Color.WHITE, 3);
        //Sets the border of the label
        lblWelcome.setBorder(borderLbl);
        //Sets an image from the projects folder
        ImageIcon imgLogo = new ImageIcon("logo.png");

        //Changes icon of frame
        lblWelcome.setIcon(imgLogo);
        //Sets the horizontal alignment from the image
        lblWelcome.setHorizontalTextPosition(JLabel.RIGHT);
        // Sets the vertical alignment from the image
        lblWelcome.setVerticalAlignment(JLabel.CENTER);

        //Sets position, width and height of the label
        lblWelcome.setBounds(81, 30, 270, 100);

        // frame interface so that user can see the program 
        //Creates a new frame
        JFrame frmWelcome = new JFrame();
        //Sets the title of the frame
        frmWelcome.setTitle("ConnectCircle");
        //sets the color of the frame
        frmWelcome.getContentPane().setBackground(new Color(0x12342));
        //Allows space in the frame
        frmWelcome.setLayout(null);
        //sets the size of the frame
        frmWelcome.setSize(420, 420);
        frmWelcome.setResizable(false);

        //Aligns the frame
        frmWelcome.setLocationRelativeTo(null);
        //Makes the frame visible
        frmWelcome.setVisible(true);
        //It allows the user to close the program
        frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Adds the lable to the frame
        frmWelcome.add(lblWelcome);
        //Sets an image from the projects folder
        ImageIcon imgIcon = new ImageIcon("logo.png");
        //Changes icon of frame
        frmWelcome.setIconImage(imgIcon.getImage());

        //Button Register 
        //creates the button
        JButton btnRegister = new JButton("Sign-up");
        //Adjusts the size and position of the button 
        btnRegister.setBounds(75, 250, 85, 26);
        //adds the button on the frame
        frmWelcome.add(btnRegister);
        
        //The things that happen when the user clicks the button
        btnRegister.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                //the button calls the function
                register();
                //it closes the frame
                frmWelcome.dispose();
            }
        });

        //Button Login
        //creates the button
        JButton btnLogin = new JButton("Sign-in");
        //Adjusts the size and position of the button
        btnLogin.setBounds(255, 250, 85, 26);
        //adds the button to the frame
        frmWelcome.add(btnLogin);
        //The things that happen when the user clicks the button 
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //the button calls the function
                login();
                //it closes the frame
                frmWelcome.dispose();
            }
        });

    }

    // code inspired by Brocode Youtube channel 
    public static void register() {

        // frame of Signup page
        //Creates a new frame
        JFrame frmSignUp = new JFrame("Sign-up to ConnectCircle");
        //Makes frame visible
        frmSignUp.setVisible(true);
        //it adjusts the frame's size
        frmSignUp.setSize(400, 400);
        // it disables the resizability of the frame
        frmSignUp.setResizable(false);
        //sets the color of the frame
        frmSignUp.getContentPane().setBackground(new Color(0x12342));
        //It allows the user to close the program
        frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Sets an image from the projects folder
        ImageIcon imgIcon = new ImageIcon("logo.png");
        //Changes icon of frame
        frmSignUp.setIconImage(imgIcon.getImage());

        //creates a new label
        JLabel lblSignUp = new JLabel("Sign Up to ConnectCircle, Connect with your Circle ");
        //Sets the color of the label
        lblSignUp.setForeground(Color.WHITE);
        // adds the label to the frame
        frmSignUp.add(lblSignUp);
        // sets size of the label
        lblSignUp.setBounds(30, 50, 350, 25);

        //creates a new label
        JLabel lblUsername2 = new JLabel("Username : ");
        //Sets the color of the label
        lblUsername2.setForeground(Color.WHITE);
        // adds the label to the frame
        frmSignUp.add(lblUsername2);
        // sets size of the label
        lblUsername2.setBounds(50, 100, 75, 25);

        //Creates a new textField
        JTextField usernameField2 = new JTextField(10);
        //sets size and position of the textField
        usernameField2.setBounds(125, 100, 200, 25);
        // adds a textField to the frame
        frmSignUp.add(usernameField2);
        
        //creates a new label
        JLabel lblCellphone = new JLabel("Cellphone : ");
        // adds the label to the frame
        frmSignUp.add(lblCellphone);
        //Sets the color of the label
        lblCellphone.setForeground(Color.WHITE);
        // Sets the size and position of the label
        lblCellphone.setBounds(50, 150, 75, 25);

        //creates a new label
        JLabel lblMessage2 = new JLabel();
        // adds the label to the frame
        frmSignUp.add(lblMessage2);
        //Sets the Color of the lable
        lblMessage2.setForeground(Color.white);
        //sets size and position of the label
        lblMessage2.setBounds(125, 275, 250, 35);

        //Creates a new textField
        JTextField cellphoneField = new JTextField(10);
        //sets size and position of the textField
        cellphoneField.setBounds(125, 150, 200, 25);
        // adds a textField to the frame
        frmSignUp.add(cellphoneField);
        // sets the layout of the frame
        frmSignUp.setLayout(null);

        //creates a new label
        JLabel lblPassword2 = new JLabel("Password : ");
        // adds the label to the frame
        frmSignUp.add(lblPassword2);
        //Sets the color of the label
        lblPassword2.setForeground(Color.WHITE);
        // Sets the size and position of the label
        lblPassword2.setBounds(50, 200, 75, 25);

        //Creates a new passwordfield
        JPasswordField passwordField2 = new JPasswordField(10);
        //sets size and position of the passwordField
        passwordField2.setBounds(125, 200, 200, 25);
        // adds a passwordField to the frame
        frmSignUp.add(passwordField2);

        //creates the button
        JButton btnSignUp = new JButton("Sign-Up");
        //Adjusts the size and position of the button
        btnSignUp.setBounds(170, 250, 85, 26);
        //adds the button to the frame
        frmSignUp.add(btnSignUp);
        //The things that happen when the user clicks the button 
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Declaration
                String registerUsername, registerPassword, cellphoneNo;
                int index;
                index = arrayIndex;
                //using the gettext function to get input
                registerPassword = String.valueOf(passwordField2.getPassword());
                registerUsername = usernameField2.getText();
                cellphoneNo = cellphoneField.getText();
                checkCellPhoneNumber(cellphoneNo);

                checkPasswordComplexity(registerPassword);
                checkUserName(registerUsername);
                if (registerPassword.length() == 0 && registerUsername.length() == 0 && cellphoneNo.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Error please enter username,cellphone number and password  ");
                }
                lblMessage2.setText(registerUser(registerUsername, registerPassword, cellphoneNo));

                //checks the username
                if (checkUserName(registerUsername) == false) {
                    JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username "
                            + "contains an underscore and is no more than five characters in length.");//prints message
                }
                //Checks  password
                if (checkPasswordComplexity(registerPassword) == false) {
                    JOptionPane.showMessageDialog(null, "Password  is not correctly formatted; please ensure that the password "
                            + "contains at least eight characters, a capital and small letter, a number, and a special character.");//prints message
                }
                //Checks and validate phone number
                if (checkCellPhoneNumber(cellphoneNo) == false) {
                    JOptionPane.showMessageDialog(null, "Cell phone number incorrectly formatted or does not contain the \n South African cellphone code.");//printd mrssage
                  
                }
                 //if statement helps to validate the user input
                    if (checkCellPhoneNumber(cellphoneNo) == true && checkUserName(registerUsername) == true && checkPasswordComplexity(registerPassword) == true) {

                        //populating the parallel array
                        cellPhone[arrayIndex] = cellphoneNo;
                        username[arrayIndex] = registerUsername;
                        password[arrayIndex] = registerPassword;
                        arrayIndex++;//increase the index
                    }
            }
        });
          
        //creates a new button
        JButton btnSignIn2 = new JButton("Sign-In");
        //Adjusts the size and position of the button
        btnSignIn2.setBounds(250, 310, 85, 26);
        //adds the button to the frame
        frmSignUp.add(btnSignIn2);
        //The things that happen when the user clicks the button
        btnSignIn2.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                // it calls the login frame
                login();
                //closes the program
                frmSignUp.dispose();
            }
        });

        //closes the program
        JLabel lblLogin = new JLabel("Do you an account on ConnectCircle ? ");
        //add to frame
        frmSignUp.add(lblLogin);
        //Sets the Color of the label
        lblLogin.setForeground(Color.white);
        //set the label's position and size
        lblLogin.setBounds(20, 300, 300, 50);

    }
    // methods inspired by BroCode YouTube channel

    public static void login() {

        //frame the login page
        //Creates a new frame
        JFrame frmSignIn = new JFrame("Sign-in to ConnectCircle");
        //Makes frame visible
        frmSignIn.setVisible(true);
        //it adjusts the frame's size
        frmSignIn.setSize(400, 400);
        frmSignIn.setResizable(false);
        //sets the color of the frame
        frmSignIn.getContentPane().setBackground(new Color(0x12342));
        //It allows the user to close the program
        frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creates a new label
        JLabel lblSignIn = new JLabel("Sign In to ConnectCircle, Connect with your Circle ");
        //Sets the color of the label
        lblSignIn.setForeground(Color.WHITE);
        // adds the label to the frame
        frmSignIn.add(lblSignIn);
        //adjusts the size of the label
        lblSignIn.setBounds(30, 50, 350, 25);

        //Username
        
        //creates a new label
        JLabel lblUsername = new JLabel("Username : ");
        //Sets the color of the label
        lblUsername.setForeground(Color.WHITE);
        // adds the label to the frame
        frmSignIn.add(lblUsername);
        //adjusts the size of the label
        lblUsername.setBounds(50, 100, 75, 25);
        
        //Password
        //creates a new label
        JLabel lblPassword = new JLabel("Password : ");
        // adds the label to the frame
        frmSignIn.add(lblPassword);
        //Sets the color of the label
        lblPassword.setForeground(Color.WHITE);
        // Sets the size and position of the label
        lblPassword.setBounds(50, 150, 75, 25);

        //creates a new label
        JLabel lblMessage = new JLabel();
        // adds the label to the frame
        frmSignIn.add(lblMessage);
        //Sets the Color of the lable
        lblMessage.setForeground(Color.white);
        //sets size and position of the label
        lblMessage.setBounds(125, 250, 250, 35);

        //Text fields
        //Creates a new textField
        JTextField usernameField = new JTextField(10);
        //sets size and position of the textField
        usernameField.setBounds(125, 100, 200, 25);
        // adds a textField to the frame
        frmSignIn.add(usernameField);
        // sets the layout of the frame
        frmSignIn.setLayout(null);

        //Creates a new passwordField
        JPasswordField passwordField = new JPasswordField(10);
        //sets size and position of the passwordField
        passwordField.setBounds(125, 150, 200, 25);
        //add the passwordField to the frame
        frmSignIn.add(passwordField);

        //Sets an image from the projects folder
        ImageIcon imgIcon = new ImageIcon("logo.png");
        //Changes icon of frame
        frmSignIn.setIconImage(imgIcon.getImage());

        //creates the button
        JButton btnSignIn = new JButton("Sign-In");
        //Adjusts the size and position of the button
        btnSignIn.setBounds(180, 210, 85, 26);
        //adds the button to the frame
        frmSignIn.add(btnSignIn);
        //The things that happen when the user clicks the button 
        btnSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Declarations
                String loginUsername, passwordText;

                // gets text from the textField
                loginUsername = usernameField.getText();
                // gets text from the passwordField
                passwordText = String.valueOf(passwordField.getPassword());
                // calls the function 
                loginUser(loginUsername, passwordText); 
                //checks if the username is valid
                if (checkUserName(loginUsername) == false) {
                    //prints messsage
                    JOptionPane.showMessageDialog(null, "Username is formatted inccorrectly please make sure that your username "
                            + "contains an underscore and is no more than five characters long.");
                }
                //Checks and validate password
                if (checkPasswordComplexity(passwordText) == false) {
                    //prints messsage
                    JOptionPane.showMessageDialog(null, "Password  is not correctly formatted; please ensure that the password "
                            + "contains at least eight characters, a capital and small letter, a number, and a special character.");
                }//close if

                
                //for loop to find a specific element of the array
                for (int counter = 0; counter < username.length - 1; counter++) {
                    if (username[counter]!= null && password[counter] != null && username[counter].equals(loginUsername) && password[counter].equals(passwordText)) {
                        
                            JOptionPane.showMessageDialog(null, "Welcome to ConnectCircle \n" + username[counter]
                                    + " Connect with Your Circle");//prints message
                            cellphone = cellPhone[counter];
                             //creates new instance of a class
                           message messageClass = new message();
                                //calls a method from the class
                            messageClass.selectionPage();
                            //Sets the text in the label and calls the function
                             lblMessage.setText(returnLoginStatus(loginUsername, passwordText));
                            //closes the frame
                            frmSignIn.dispose();
                            //stops the loop
                            break;
                            }
                         else {
                            //Sets the text in the label and calls the function
                            lblMessage.setText("Login failed please go and register");
                   
                    } 
                } 
                

            }
        });
       //creates a label
        JLabel lblRegister = new JLabel("Have signed up to ConnectCircle? ");
        //add a label to the frame
        frmSignIn.add(lblRegister);
        //Sets the Color of the lable
        lblRegister.setForeground(Color.white);
        //set the label's position and size
        lblRegister.setBounds(20, 300, 300, 50);

        //creates a new button
        JButton btnSignUp2 = new JButton("Sign-Up");
        //Adjusts the size and position of the button
        btnSignUp2.setBounds(230, 310, 85, 26);
        //adds the button to the frame
        frmSignIn.add(btnSignUp2);
        //The things that happen when the user clicks the button
        btnSignUp2.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                // it calls the registration method
                register();
                //closes the program
                frmSignIn.dispose();
            }
        });

    }

    //fuction the is the username is valid
    public static boolean checkUserName(String username) {
        //Declaration 
        int usernameLength;
        usernameLength = username.length();//gets the length of a string
        //if statement checks that the username is valid
        if (username.contains("_") && (usernameLength <= 5)) {
            //returns the boolean true
            return true;
        } else {
            // returns the boolean false
            return false; 
        }
    }
    
    
    // the method validates the password of that the user enters
    public static boolean checkPasswordComplexity(String password) {
        //Checks all capital letters
        String capitalLetter = ".*[A-Z].*";
        //Checks all small letters
        String smallLetter = ".*[a-z].*";
        //Checks all special characters
        String specialChar = ".*[!@#$%^&*(),.?\":{}|<>].*";
        //Checks character digits
        String digits = ".*\\d.*";
        //if statement checks that password is valid
        if (password.length() >= 8 && password.matches(capitalLetter) && password.matches(smallLetter)
                && password.matches(digits) && password.matches(specialChar)) {
            //returns function to true
            return true;
        } else {
            // returns function to false
            return false;
        }
    }
    //function validates cellphone number
 

    public static boolean checkCellPhoneNumber(String cellphone) {
        //declaration
        String cellCode = "+27";//Cellphone code of south africa
        String firstChar;
        int fourthDigit;
        int cellphoneLength;
        //gets the length of the cellphone number
        cellphoneLength = cellphone.length();
        // Gets characters from index 0 to 2 (inclusive)
        firstChar = cellphone.substring(0, 3); 
        //Gets and converts the fourth digit of the cellphone number
        fourthDigit = Character.getNumericValue(cellphone.charAt(3));
        //if statement validates the cellphone number
        if ((cellphoneLength == 12) && (firstChar.equals(cellCode)) && (fourthDigit >= 6) && fourthDigit <= 8) {
           //returns function true
            return true;
        } else {
            // returns function false
            return false;
        }
    }
    //registers the user to the program

    public static String registerUser(String username, String password, String cellphone) {
        //if statement checks that the cellphone number, username and password are valid
        if (checkCellPhoneNumber(cellphone) == true && checkPasswordComplexity(password) == true && checkUserName(username) == true) {
             //returns message
            return "You have successfully registered";
        } else {
            //returns error message
            return "Registration failed please, Try again!";
        }
    }
    
    public static boolean loginUser(String username, String password) {
        //if statement checks if user and password if they valid
        if (checkUserName(username) == true && checkPasswordComplexity(password) == true) {
            return true;//return the function as true
        } else {
            return false;//return the function as false
        }
    }
    // function returns the login status
  

    public static String returnLoginStatus(String username, String password) {
        //Validates the login status
        //if statement checks if the user name and password are valid
        if (checkUserName(username) == true && checkPasswordComplexity(password) == true) {
            return "You have been successfully logged in";// returns message
        } else {
            return "Login failed please try again";//returns message
        }
    }

}
