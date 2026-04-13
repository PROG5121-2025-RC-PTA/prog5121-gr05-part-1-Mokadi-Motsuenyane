
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
    private static int arrayIndex = 0;
    public static int messageSent = 0;
    public static int deleteIndex = 0;
    public static int sentIndex = 0;
    public static int idIndex = 0;
    public static int hashIndex = 0;
    public static int storeIndex = 0;
    public static String recipient;
    public static int totalMessages = 0;
    public static int deleteMessage;
    public static int sentMessage;
    
    //arrays used to store the user data
    public static ArrayList<String> sentMessages = new ArrayList<>();
    public static ArrayList<String> storedMessages = new ArrayList<>();
    public static ArrayList<String> deletedMessages = new ArrayList<>();
    public static ArrayList<String> messagesHashes = new ArrayList<>();
    public static ArrayList<String> messagesIDs = new ArrayList<>();
    public static ArrayList<String> recipients = new ArrayList<>();

 
    
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
                //declartions
                String longMessage,option,search,report;
                boolean found = false;
                boolean deleted = false;
                 //prompts the user to select an option
                 option= JOptionPane.showInputDialog(null, """
                                                           Please enter option
                                                           a. Display the sender and recipient of all sent messages
                                                           b. Display the longest sent message
                                                           c. Search for a messageID and display the correspoding recipient
                                                           d. Search for all messages sent to a particular recipient
                                                           e. Delete a message using the message hash.
                                                           f. Display a report that list of the full details of all the sent message.""");
                    
                 // if-else statements checks for all the options 
                 if (option.toUpperCase().equals("A")) {
                     //checks if the array is empty
                      if (sentMessages.isEmpty()) {
                         JOptionPane.showMessageDialog(null, "No messages sent yet.");
                         return;
                         }
                      //creates a new string builder
                     StringBuilder reports = new StringBuilder();
              for (int i = 0; i < sentMessages.size(); i++) {
                  //generates reports
              reports.append("Sender: ").append(Social_Media.cellphone)
          .append(", Recipient: ").append(recipients.get(i))
          .append(", Message: ").append(sentMessages.get(i)).append("\n");
}
JOptionPane.showMessageDialog(null, reports.toString());

                }
                 else if (option.toUpperCase().equals("B")) {
                     //checks if the array is empty
                      if (sentMessages.isEmpty()) {
                          //diplays a message
                    JOptionPane.showMessageDialog(null, "No messages available.");
                          return;
                           }
                     
                     //long message is initialized
                 longMessage  =sentMessages.get(0);  
                    //loop is used to check te longest message
                      for (int d = 0; d < sentMessages.size(); d++) {
                    //if statement checks for the longest message
                    if (sentMessages != null && sentMessages.get(d) != null && longMessage.length() < (String.valueOf(sentMessages.get(d)).length())) {
                        //gets the new longest message
                        longMessage= sentMessages.get(d);
                     }
                    
                   }
                      //displays the longest message
                 JOptionPane.showMessageDialog(null, "The longest message is: "+longMessage);
                 }
                 else if (option.toUpperCase().equals("C")) {

                     //prompts the user to search for a messageID
                    search = JOptionPane.showInputDialog(null,"Plesae enter a message ID to search for");
                  //checks if search is empty
                    if (search == null || search.isEmpty()){
                        return;
                    }

          //the loop iterates between all the elements of the array
        for (int k = 0; k < messagesIDs.size(); k++) {
            if (messagesIDs.get(k).equals(search)) {
                //generaets user output
                JOptionPane.showMessageDialog(null,
                    "Message: " + sentMessages.get(k) +
                    "\nRecipient: " + recipients.get(k));
                found = true;
                break;
            }
        }
        if (found == false) {
            //displays error message
            JOptionPane.showMessageDialog(null, "Message ID not found.");
        } 
                  }
 
                 else if (option.toUpperCase().equals("D")) {
                     
                     
                     //prompts the user to search for a messageID
       
                  search = JOptionPane.showInputDialog(null,"Plesae enter the recipient's number to search for"); 
                 //checks if search is empty
                  if (search == null || search.isEmpty()){
                     return;
                 }
                  //creates a new StringBuilder
        StringBuilder results = new StringBuilder();
        //loop is used iterate between he whole array
        for (int p = 0; p < recipients.size(); p++) {
            //if checks if the search is equal to recipients
            if (recipients.get(p).contains(search)) {
                //generates results
                results.append("Message: ").append(sentMessages.get(p)).append("\n");
            }
        }
         //checks if the are elments in the stringbuilder
        if (results.length() == 0) {
            //user output
            JOptionPane.showMessageDialog(null, "No messages found for recipient " + search);
        } 
        else {
            //user output
            JOptionPane.showMessageDialog(null, "Messages sent to " + search + ":\n" + results);
        }
                 }
                 else if (option.toUpperCase().equals("E")) {
                   //prompt the user to enter a message hash to delete a message
                   search = JOptionPane.showInputDialog(null, "Please enter a message hash to delete a message");
                     for (int z = 0; z < messagesHashes.size(); z++) {
                         //check if massage hashes is equal to search
                         if ((messagesHashes.get(z)).equals(search)) {
                            //deletes messsege
                                 deletedMessages.add(sentMessages.get(z));
                                 sentMessages.remove(z);
                                 recipients.remove(z);
                                  messagesIDs.remove(z);
                                  messagesHashes.remove(z);
                                  deleted=true;
                             //user output
                             JOptionPane.showMessageDialog(null, "Message has been deleted.");
                             //stops the loop
                             break;
                         }
                         if (deleted == false) {
                             //user output
                           JOptionPane.showMessageDialog(null, "Message hash not found.");  
                         }
   
                     }
                 }
                 else if (option.toUpperCase().equals("F")) {
                   if (sentMessages.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No sent messages available.");
                             } else {
                  StringBuilder reports = new StringBuilder();
                  
                  //loop iterates between all elements of the array
                 for (int j = 0; j < sentMessages.size(); j++) {
                     //generates a report
                reports.append("Recipient: ").append(recipients.get(j))
                          .append("\nSender: ").append(Social_Media.cellphone)
                          .append("\nMessage: ").append(sentMessages.get(j))
                          .append("\nMessage Hash: ").append(messagesHashes.get(j))
                          .append("\nMessage ID: ").append(messagesIDs.get(j))
                          .append("\\n");
            }
                 //user output
            JOptionPane.showMessageDialog(null, reports.toString());
        }
                 }
                 else{
                     //displays an error message
                     JOptionPane.showMessageDialog(null, "Error please select option a - f. Please try agian");
                 }
                      
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
        //messageID is stored in an array
        messagesIDs.add(messageID) ;
     
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
            //methods has been called
            printMessage(message);
            //the sent messages has been stored in an array
            sentMessages.add(message);
            sentMessage = 1;
          return "Message successfully sent." ; //returns message
        }
        else if(userSelection == 2){
          userDelete =  Integer.valueOf(JOptionPane.showInputDialog(null,"Press 0 to delete message."));
          if (userDelete == 0){
              //gives delete message a valuee
              deleteMessage = userDelete;
              //changes content of the message string
              message =message.replace(message, " ");
              //the disgarded messages are stored in an array
              deletedMessages.add(message) ;
              
              return "Message deleted."; //returns message
          }
          else{
              return "Message not deleted."; //returns message
          }
        }
        else if (userSelection == 3) {
            //method is called
            storeMessage(message);
             //the stored messages are stored in array
            storedMessages.add(message);
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
        //messages hashes are stored in an array
        messagesHashes.add(messageHash);
        
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
              //prompts the user to enter the recipient number
                recipient = JOptionPane.showInputDialog(null,"Please enter the recipient's cellphone number "
                + "with the country code");
                      //creates a new instance of the class
        Social_Media social = new Social_Media();
        //method called from the social class
        
        social.checkCellPhoneNumber(recipient);
        recipients.add(recipient);
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
                


            


