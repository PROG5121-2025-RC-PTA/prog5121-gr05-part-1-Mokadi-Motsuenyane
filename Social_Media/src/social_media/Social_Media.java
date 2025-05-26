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

    // global variables
    public static String cellPhone[] = new String[3];
    public static String password[] = new String[3];
    public static String cellphone;
    public static String username[] = new String[3];
    public static int arrayIndex = 0;

    public static void main(String[] args) {

        //Label GUI to display a string 
        JLabel lblWelcome = new JLabel();//creates a new label
        //The Label Displays text that Welcomes the user
        lblWelcome.setText("Welcome to ConnectCircle ");//Welcomes the user to the program
        lblWelcome.setVerticalAlignment(JLabel.CENTER);//Sets the vertical position

        lblWelcome.setForeground(Color.WHITE);//Sets the Color of the label
        //Sets the border
        Border borderLbl = BorderFactory.createLineBorder(Color.WHITE, 3);//Creates a border for the lable
        lblWelcome.setBorder(borderLbl);//Sets the border of the label
        ImageIcon imgLogo = new ImageIcon("logo.png");//Sets an image from the projects folder

        lblWelcome.setIcon(imgLogo);//Changes icon of frame
        lblWelcome.setHorizontalTextPosition(JLabel.RIGHT);//Sets the horizontal alignment from the image
        lblWelcome.setVerticalAlignment(JLabel.CENTER);// Sets the vertical alignment from the image

        lblWelcome.setBounds(81, 30, 270, 100);//Sets position, width and height of the label

        // frame interface so that user can see the program 
        JFrame frmWelcome = new JFrame();//Creates a new frame
        frmWelcome.setTitle("ConnectCircle");//Sets the title of the frame
        frmWelcome.getContentPane().setBackground(new Color(0x12342));//sets the color of the frame
        frmWelcome.setLayout(null);//Allows space in the frame
        //sets the size of the frame
        frmWelcome.setSize(420, 420);
        frmWelcome.setResizable(false);

        frmWelcome.setLocationRelativeTo(null);//Aligns the frame
        frmWelcome.setVisible(true);//Makes the frame visible
        frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//It allows the user to close the program
        frmWelcome.add(lblWelcome);//Adds the lable to the frame
        ImageIcon imgIcon = new ImageIcon("logo.png");//Sets an image from the projects folder
        frmWelcome.setIconImage(imgIcon.getImage());//Changes icon of frame

        //Button Register 
        JButton btnRegister = new JButton();//creates the button
        btnRegister.setBounds(75, 250, 85, 26);//Adjusts the size and position of the button 
        frmWelcome.add(btnRegister);//adds the button on the frame
        btnRegister.setText("Sign-up");
        btnRegister.addActionListener(new ActionListener() {//The things that happen when the user clicks the button 
            @Override
            public void actionPerformed(ActionEvent e) {
                register();//the button calls the function
                frmWelcome.dispose();//it closes the frame
            }
        });

        //Button Login
        JButton btnLogin = new JButton();//creates the button
        btnLogin.setBounds(255, 250, 85, 26);//Adjusts the size and position of the button
        frmWelcome.add(btnLogin);//adds the button to the frame
        btnLogin.setText("Sign-in");//Sets text on a button
        btnLogin.addActionListener(new ActionListener() {//The things that happen when the user clicks the button 
            @Override
            public void actionPerformed(ActionEvent e) {
                login();//the button calls the function
                frmWelcome.dispose();//it closes the frame
            }
        });

    }

    // code inspired by Brocode Youtube channel 
    public static void register() {

        // frame of Signup page
        JFrame frmSignUp = new JFrame("Sign-up to ConnectCircle");//Creates a new frame
        frmSignUp.setVisible(true);//Makes frame visible
        frmSignUp.setSize(400, 400);//it adjusts the frame's size
        frmSignUp.setResizable(false);// it disables the resizabilityof the  
        frmSignUp.getContentPane().setBackground(new Color(0x12342));//sets the color of the frame
        frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//It allows the user to close the program
        ImageIcon imgIcon = new ImageIcon("logo.png");//Sets an image from the projects folder
        frmSignUp.setIconImage(imgIcon.getImage());//Changes icon of frame

        JLabel lblSignUp = new JLabel("Sign Up to ConnectCircle, Connect with your Circle ");//creates a new label
        lblSignUp.setForeground(Color.WHITE);//Sets the color of the label
        frmSignUp.add(lblSignUp);// adds the label to the frame
        lblSignUp.setBounds(30, 50, 350, 25);

        JLabel lblUsername2 = new JLabel("Username : ");//creates a new label
        lblUsername2.setForeground(Color.WHITE);//Sets the color of the label
        frmSignUp.add(lblUsername2);// adds the label to the frame
        lblUsername2.setBounds(50, 100, 75, 25);

        JTextField usernameField2 = new JTextField(10);//Creates a new textField
        usernameField2.setBounds(125, 100, 200, 25);//sets size and position of the textField
        frmSignUp.add(usernameField2);// adds a textField to the frame
        //Password
        JLabel lblCellphone = new JLabel("Cellphone : ");//creates a new label
        frmSignUp.add(lblCellphone);// adds the label tothe frame
        lblCellphone.setForeground(Color.WHITE);//Sets the color of the label
        lblCellphone.setBounds(50, 150, 75, 25);// Sets the size and position of the label

        JLabel lblMessage2 = new JLabel();
        frmSignUp.add(lblMessage2);// adds the label to the frame
        lblMessage2.setForeground(Color.white);//Sets the Color of the lable
        lblMessage2.setBounds(125, 275, 250, 35);//sets size aand position of the label

        JTextField cellphoneField = new JTextField(10);//Creates a new textField
        cellphoneField.setBounds(125, 150, 200, 25);//sets size and position of the textField
        frmSignUp.add(cellphoneField);// adds a textField to the frame
        frmSignUp.setLayout(null);// sets the layout of the frame

        JLabel lblPassword2 = new JLabel("Password : ");//creates a new label
        frmSignUp.add(lblPassword2);// adds the label tothe frame
        lblPassword2.setForeground(Color.WHITE);//Sets the color of the label
        lblPassword2.setBounds(50, 200, 75, 25);// Sets the size and position of the label

        JPasswordField passwordField2 = new JPasswordField(10);//Creates a new textField
        passwordField2.setBounds(125, 200, 200, 25);//sets size and position of the textField
        frmSignUp.add(passwordField2);// adds a textField to the frame

        JButton btnSignUp = new JButton("Sign-Up");//creates the button
        btnSignUp.setBounds(170, 250, 85, 26);//Adjusts the size and position of the button
        frmSignUp.add(btnSignUp);//adds the button to the frame
        btnSignUp.addActionListener(new ActionListener() {//The things that happen when the user clicks the button 
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

        JButton btnSignIn2 = new JButton("Sign-In");
        btnSignIn2.setBounds(250, 310, 85, 26);//Adjusts the size and position of the button
        frmSignUp.add(btnSignIn2);//adds the button to the frame
        btnSignIn2.addActionListener(new ActionListener() {//The things that happen when the user clicks the button 
            @Override
            public void actionPerformed(ActionEvent e) {
                login();// it calls the login frame
                frmSignUp.dispose();//closes the program
            }
        });

        JLabel lblLogin = new JLabel("Do you an account on ConnectCircle ? ");//creates a label
        frmSignUp.add(lblLogin);//add to frame
        lblLogin.setForeground(Color.white);//Sets the Color of the lable
        lblLogin.setBounds(20, 300, 300, 50);//set the label's position and size

    }
    // methods inspired by BroCode YouTube channel

    public static void login() {

        //frame the login page
        JFrame frmSignIn = new JFrame("Sign-in to ConnectCircle");//Creates a new frame
        frmSignIn.setVisible(true);//Makes frame visible
        frmSignIn.setSize(400, 400);//it adjusts the frame's size
        frmSignIn.setResizable(false);
        frmSignIn.getContentPane().setBackground(new Color(0x12342));//sets the color of the frame
        frmSignIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//It allows the user to close the program

        JLabel lblSignIn = new JLabel("Sign In to ConnectCircle, Connect with your Circle ");//creates a new label
        lblSignIn.setForeground(Color.WHITE);//Sets the color of the label
        frmSignIn.add(lblSignIn);// adds the label to the frame
        lblSignIn.setBounds(30, 50, 350, 25);

        //label show text that makes it easier for the user to use the program
        //Username
        JLabel lblUsername = new JLabel("Username : ");//creates a new label
        lblUsername.setForeground(Color.WHITE);//Sets the color of the label
        frmSignIn.add(lblUsername);// adds the label to the frame
        lblUsername.setBounds(50, 100, 75, 25);
        //Password
        JLabel lblPassword = new JLabel("Password : ");//creates a new label
        frmSignIn.add(lblPassword);// adds the label tothe frame
        lblPassword.setForeground(Color.WHITE);//Sets the color of the label
        lblPassword.setBounds(50, 150, 75, 25);// Sets the size and position of the label

        JLabel lblMessage = new JLabel();
        frmSignIn.add(lblMessage);// adds the label to the frame
        lblMessage.setForeground(Color.white);//Sets the Color of the lable
        lblMessage.setBounds(125, 250, 250, 35);//sets size aand position of the label

        //Text fields
        JTextField usernameField = new JTextField(10);//Creates a new textField
        usernameField.setBounds(125, 100, 200, 25);//sets size and position of the textField
        frmSignIn.add(usernameField);// adds a textField to the frame
        frmSignIn.setLayout(null);// sets the layout of the frame

        JPasswordField passwordField = new JPasswordField(10);//Creates a new textField
        passwordField.setBounds(125, 150, 200, 25);//sets size and position of the textField
        frmSignIn.add(passwordField);//add the textField to the frame

        ImageIcon imgIcon = new ImageIcon("logo.png");//Sets an image from the projects folder
        frmSignIn.setIconImage(imgIcon.getImage());//Changes icon of frame

        JButton btnSignIn = new JButton("Sign-In");//creates the button
        btnSignIn.setBounds(180, 210, 85, 26);//Adjusts the size and position of the button
        frmSignIn.add(btnSignIn);//adds the button to the frame
        btnSignIn.addActionListener(new ActionListener() {//The things that happen when the user clicks the button 
            @Override
            public void actionPerformed(ActionEvent e) {
                //Declarations
                String loginUsername, passwordText;

                loginUsername = usernameField.getText();// gets text from the textField
                passwordText = String.valueOf(passwordField.getPassword());// gets text from the textField
                loginUser(loginUsername, passwordText);// calls the function  
                //checks if the username is valid
                if (checkUserName(loginUsername) == false) {
                    JOptionPane.showMessageDialog(null, "Username is formatted inccorrectly please make sure that your username "
                            + "contains an underscore and is no more than five characters long.");//prints messsage
                }//close if
                //Checks and validate password
                if (checkPasswordComplexity(passwordText) == false) {

                    JOptionPane.showMessageDialog(null, "Password  is not correctly formatted; please ensure that the password "
                            + "contains at least eight characters, a capital and small letter, a number, and a special character.");//prints message
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
                   
                    } //close if
                } // close for loop
                

            }
        });

        JLabel lblRegister = new JLabel("Have signed up to ConnectCircle? ");//creates a label
        frmSignIn.add(lblRegister);//add to frame
        lblRegister.setForeground(Color.white);//Sets the Color of the lable
        lblRegister.setBounds(20, 300, 300, 50);//set the label's position and size

        JButton btnSignUp2 = new JButton("Sign-Up");
        btnSignUp2.setBounds(230, 310, 85, 26);//Adjusts the size and position of the button
        frmSignIn.add(btnSignUp2);//adds the button to the frame
        btnSignUp2.addActionListener(new ActionListener() {//The things that happen when the user clicks the button 
            @Override
            public void actionPerformed(ActionEvent e) {
                register();// it calls the registration frame
                frmSignIn.dispose();//closes the program
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
            return true;//returns the boolean true
        } else {
            return false; // returns the boolean false
        }
    }
    // the fuction validates the password of that the user enters

    public static boolean checkPasswordComplexity(String password) {
        //Function checks if password is valid
        String capitalLetter = ".*[A-Z].*";//Checks all capital letters
        String smallLetter = ".*[a-z].*";//Checks all small letters
        String specialChar = ".*[!@#$%^&*(),.?\":{}|<>].*";//Checks all special characters
        String digits = ".*\\d.*";//Checks character digits
        //if statement checks that password is valid
        if (password.length() >= 8 && password.matches(capitalLetter) && password.matches(smallLetter)
                && password.matches(digits) && password.matches(specialChar)) {
            return true;//returns function to true
        } else {
            return false;// returns function to false
        }
    }
    //function validates cellphone number
    //inspired by ChatGpt

    public static boolean checkCellPhoneNumber(String cellphone) {
        //declaration
        String cellCode = "+27";//Cellphone code of south africa
        String firstChar;
        int fourthDigit;
        int cellphoneLength;
        cellphoneLength = cellphone.length();//gets the length of the cellphone number
        firstChar = cellphone.substring(0, 3); // Gets characters from index 0 to 2 (inclusive)
        fourthDigit = Character.getNumericValue(cellphone.charAt(3));//Gets and converts the fourth digit of the cellphone number
        //if statement validates the cellphone number
        if ((cellphoneLength == 12) && (firstChar.equals(cellCode)) && (fourthDigit >= 6) && fourthDigit <= 8) {
            return true;//returns function true
        } else {
            return false;// returns function false
        }
    }
    //registers the user to the program

    public static String registerUser(String username, String password, String cellphone) {
        //if statement checks that the cellphone number, username and password are valid
        if (checkCellPhoneNumber(cellphone) == true && checkPasswordComplexity(password) == true && checkUserName(username) == true) {

            return "You have successfully registered";//returns message
        } else {
            return "Registration failed please, Try again!";//returns error message
        }
    }
    //fuction cheks that user logs in
    //inspired by meta ai

    public static boolean loginUser(String username, String password) {
        //if statement checks if user and password if they valid
        if (checkUserName(username) == true && checkPasswordComplexity(password) == true) {
            return true;//return the function as true
        } else {
            return false;//return the function as false
        }
    }
    // function returns the login status
    //inspired by meta Ai

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
