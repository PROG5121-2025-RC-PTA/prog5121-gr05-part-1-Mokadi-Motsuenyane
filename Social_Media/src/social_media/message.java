
package social_media;
//imports
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import com.google.gson.*;//imports everything from json
import java.io.*;




/**
 *
 * @author ST10480772_Motsuenyane_MDK_Group_5
 */
public class message {
    //attributes
    private static int arrayIndex;
    public static int messageSent = 0;
    public static String recipient;
    public static int totalMessages = 0;
    public static int deleteMessage;
    
    
    public static void selectionPage(){

      
       //create a new frame with text
        JFrame frmSelection = new JFrame("Make a selection on ConnnectCircle");
        //makes the frame visible
        frmSelection.setVisible(true);
        //sets the colour of the frame
         frmSelection.getContentPane().setBackground(new Color(0x12342));
         //Allows space in the frame
        frmSelection.setLayout(null);
        //sets the size of the frame
        frmSelection.setSize(470,450);
        frmSelection.setResizable(false);
        //Aligns the frame
        frmSelection.setLocationRelativeTo(null);
        //Makes the frame visible
        frmSelection.setVisible(true);
        //It allows the user to close the program
        frmSelection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //Sets an image from the projects folder
        ImageIcon imgIcon = new ImageIcon("logo.png");
        //Changes icon of frame
        frmSelection.setIconImage(imgIcon.getImage());
        
        
        // creates a new label with text
        JLabel lblSelect = new JLabel("Select the between the following options :");
        //Sets position, width and height of the label
        lblSelect.setBounds(95, 30, 270, 100);
        //Sets the Color of the label
        lblSelect.setForeground(Color.WHITE);
        //adds label to the frame
        frmSelection.add(lblSelect);
        
        // option 1
        
        //creates a button
        JButton btnSend = new JButton( "Send a message");
        //adds button the frame
        frmSelection.add(btnSend);
        //Adjusts the size and position of the button
        btnSend.setBounds(130,120,220,26);
        //The things that happen when the user clicks the button
        btnSend.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                //declarations
                String index;
                int value;
                //promts the user the enter the number of messages
                  index = JOptionPane.showInputDialog(null, "How many messages do you want to enter");
                  // changes string to int
                value = Integer.parseInt(index);
                //gives array index a value
                 arrayIndex = value;
                sendPage();
            }
        });
        
        // option 2
        
        //creates a button
        JButton btnRecent = new JButton("Show recently sent messages");
        //Adjusts the size and position of the button
        btnRecent.setBounds(130,200,220,26);
        //adds button the frame
        frmSelection.add(btnRecent);
        //The things that happen when the user clicks the button
        btnRecent.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Coming Soon");
            }
        });
        
        //option 3
        
        //creates a button
        JButton btnQuit = new JButton("Quit");
        //Adjusts the size and position of the button
        btnQuit.setBounds(130,280,220,26);
        //adds button the frame
        frmSelection.add(btnQuit);
        //The things that happen when the user clicks the button
        btnQuit.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                int selection;
                //user output
                JOptionPane.showMessageDialog(null, "The total number of messages sent : "+returnTotalMessages());
                //checks if the user really wants to quit
               selection = JOptionPane.showConfirmDialog(null, "Are you sure you to Quit ?");
                if (selection == JOptionPane.YES_OPTION){
                    //it closes the frame
                  frmSelection.dispose();
                }
            }
        });
        
    }
    
    //function generates a random userID
    public static int generateUserID(){
        //declarations
        int randomNum,numMessageID;
        String messageID;
        //creates a new randomizer
      Random randomizer = new Random();
       //generates a random number
      randomNum =randomizer.nextInt(1,9);
      //turns interger to string
      messageID =String.valueOf(randomNum);
      //loop use to generate a message id using random numn=ber
        for (int i = 0; i <= 7; i++) {
            //random number between 1 and 9
             randomNum =randomizer.nextInt(1,9);
             //add the random number to messageID as a String
          messageID=messageID.concat(String.valueOf(randomNum));
        }
        //turns the string into an integer
        numMessageID=Integer.parseInt(messageID);
        //calls the function
        checkMessageID(messageID);
      return numMessageID;
    }
    
    public static String checkMessageLength(String message){
        if (message.length() <=250) {
            return "Message ready to send.";//returns message
        } else {
            return "Message should not exceed 250 characters";//returns message
        }
    }
    public static String sentMessage(String message){
        //declaration 
        int userSelection,userDelete ;
        //if statement checks for message lenght
        if (checkMessageLength(message).equals("Message ready to send.")) {
            //promts the user to select th options
        userSelection = Integer.valueOf(JOptionPane.showInputDialog(null," Select the following\n 1. Send Message"
                + "\n 2.Disregard Message\n 3.Store Message"));//prompt the user to select the option
        if (userSelection == 1) {
            printMessage(message);
          return "Message successfully sent." ; //returns message
        }
        else if(userSelection == 2){
          userDelete =  Integer.valueOf(JOptionPane.showInputDialog(null,"Press 0 to delete message."));
          if (userDelete == 0){
              //gives delete message a valuee
              deleteMessage = userDelete;
              //changes content of the message string
              message =message.replace(message, " ");
              return "Message deleted."; //returns message
          }
          else{
              return "Message not deleted."; //returns message
          }
        }
        else if (userSelection == 3) {
            storeMessage(message);
          return "Message successfully stored..";  //returns message
        }
        else{
            return "Error please enter between options 1-3";//returns message
        }
        
    }
            else{
                return "Message should not exceed 250 characters";//returns message
                }
    }

    
   
    public static boolean checkMessageID(String messageID){
        //if statement checks if messengerID is not more than 10 characters
        if (messageID.length() < 10) {
          return true;
        }
        else{
          return false;     
        }
    }
    
  
    
     public static String printMessage(String message){
         return message;//returns the message
     }
     
     public static void storeMessage(String message) {
         //creates a new gson file
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    List<String> messages = new ArrayList<>();
    
    //creates a new gson file 
    File file = new File("message.json");

    // Step 1: If file exists, read existing messages
    if (file.exists()) {
        try (Reader reader = new FileReader(file)) {
            // Read as a list
            messages = gson.fromJson(reader, List.class); 
            if (messages == null) messages = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading existing messages.");
        }
    }

    // Step 2: Add new message
    messages.add(message);

    // Step 3: Write full updated list back to file
    try (Writer writer = new FileWriter(file)) {
        // Save list to file
        gson.toJson(messages, writer); 
        //returns a successfully stored message
        JOptionPane.showMessageDialog(null, "Message successfully stored.");
    } catch (Exception e) {
        e.printStackTrace();
        //returns an error message
        JOptionPane.showMessageDialog(null, "Error writing message to file.");
    }
}

    public static int returnTotalMessages(){
      //returns the total number of messages
      return totalMessages;
    } 
    
    public static String createMesageHash(String messageID,int numMesssages,String sentence) {
        //declarations
        String firstTwo,messageHash,messageIndex,firstWord,lastWord;
        // it splits the sentence into a word array without spaces 
        String [] words = sentence.split("\\s+");
        
        //converts an int to a string
        messageIndex = String.valueOf(numMesssages);
        // gets first two characters in the the meesageID
        firstTwo = messageID.substring(0, 2);
       
        //gets the first word of the sentence
        firstWord = (words[0]).toUpperCase(); 
        //gets the last word of the sentence  
        lastWord = (words[words.length-1]).toUpperCase();  
        //generates the messageHash
        messageHash = firstTwo+":"+messageIndex+":"+firstWord+lastWord;
        //it will return the messageHash
        return messageHash;
    }
    
    //function checks if the length of the cellphone number is 10
    public static int checkRecipientCell(String cellphone) {
        if (cellphone.length() == 10) {
            return 10;
        }
        else{
            return cellphone.length();
        }
    }
  
    
    public static void sendPage() {
       
       
        //prompts the user to enter the recipient number
        recipient = JOptionPane.showInputDialog(null,"Please enter the recipient's cellphone number "
                + "with the country code");
        //creates a new instance of the class
        Social_Media social = new Social_Media();
        //Function called from theb  social class
        social.checkCellPhoneNumber(recipient);
        
        
    
            
    
        //creates a new label
         JLabel lblProfile = new JLabel("Chat with "+recipient);
      
         //Sets the vertical position
         lblProfile.setVerticalAlignment(JLabel.CENTER);
         //Sets the Color of the label
         lblProfile.setForeground(Color.WHITE);
         //Sets an image from the projects folder
         ImageIcon imgLogo = new ImageIcon("profile.png");
         
        //Changes icon of frame
         lblProfile.setIcon(imgLogo);
         //Sets the horizontal alignment from the image
         lblProfile.setHorizontalTextPosition(JLabel.RIGHT);
         lblProfile.setVerticalAlignment(JLabel.CENTER);// Sets the vertical alignment from the image
        
         lblProfile.setBounds(20, 10, 40, 80);//Sets position, width and height of the label
        JFrame frmSend = new  JFrame("Send message ");
         //makes the frame visible
        frmSend.setVisible(true);
      
        frmSend.setLayout(null);//Allows space in the frame
        //sets the size of the frame
        frmSend.setSize(470,450);
        frmSend.setResizable(false);
        //Aligns the frame
        frmSend.setLocationRelativeTo(null);
       //It allows the user to close the program
        frmSend.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         //Sets an image from the projects folder
        ImageIcon imgIcon = new ImageIcon("logo.png");
        //Changes icon of frame
        frmSend.setIconImage(imgIcon.getImage());
        
        //creates a new panel
        JPanel pnlDetails = new JPanel();
        //changes the colour of the panel
        pnlDetails.setBackground(new Color(0x12342));
        //sets the size and width for the panel
        pnlDetails.setBounds(0, 10, 470,110);
        //adds label to the panel
        pnlDetails.add(lblProfile);
        // adds panel to the frame
        frmSend.add(pnlDetails);
        
        // creates a new textfield
        JTextField messageField = new JTextField();
        // adds the button to the frame
        frmSend.add(messageField);
        //sets size and position of the textField
        messageField.setBounds(15, 360, 310, 27);
        //creates a new button
        JButton btnSend = new JButton("Send");
        //adds the button to the frame
        frmSend.add(btnSend);
        //sets size and position of the textField
        btnSend.setBounds(340, 360, 90, 25);
        //The things that happen when the user clicks the button
        btnSend.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                //declarations
                String messageID,message,messageHash;
                //intialized
                int value = arrayIndex;
                int counter = 0;
                
                //gets text from the texfield
                message = messageField.getText();
                //increase message counter
               messageSent++;
               //changes the total messages to the counter
               totalMessages = counter;
               
               //if statement checks the number of messages sent
                if (messageSent <=arrayIndex){
                    //gets message ID as a String
                 messageID=Integer.toString(generateUserID());
                   
                 
                 messageHash = createMesageHash(messageID, messageSent, message);
                  //displays the user output  
                 JOptionPane.showMessageDialog(null, "Message ID: \s"+messageID+"\nMessage Hash: \s"+messageHash+"\nRecipient : \s"+recipient
                 +"\nMessage : \s"+message+"\n"+sentMessage(message));
                 //if the user press 0 then the frame closes
                    if (deleteMessage == 0) {
                        //Clears the text of the textfiled
                    messageField.setText("");
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "You have exceeded the number of messages");
            }
        });
    }
}
