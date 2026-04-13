package social_media;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


import java.util.Arrays;
/**
 *
 * @author RC_Student_lab
 */
public class messageTest {
    
 

/**
 *
 * @author ST10480772_Motsuenyane_MDK_Group_5
 */

    private message messages;
    private message manager;
    private static final String testRecipient1 = "+27718693002";  // Message 1
    private static final String testMessage1 = "Hi Mike, can you join us for dinner tonight";
    
    private static final String testRecipient2 = "08575975889";  // Message 2
    private static final String testMessage2 = "Hi Keegan, did you receive the payment?";        
    
    @BeforeEach
    void setup() {
        // Initialize the message object before each test
        messages = new message(); 
    }

    // Test for Message Hash generation with first and last word of message
    @org.junit.jupiter.api.Test
    @DisplayName("TC1: Test Message Hash Generation")
    void testMessageHashGeneration() {
        // Generate a message ID and create a hash
        int messageID = messages.generateUserID();
        String messageHash = messages.createMesageHash(String.valueOf(messageID), 0, testMessage1);
        
        // Check the message hash format
        assertNotNull(messageHash, "Message Hash should not be null");
        assertEquals("00:0:HITONIGHT", messageHash, "Message Hash is not correctly formatted.");
    }

    // Test for sending the message
    @org.junit.jupiter.api.Test
    @DisplayName("TC2: Test Send Message Option")
    void testSendMessageOption() {
        //if the user selects 'Send Message'
        String result = messages.sentMessage(testMessage1);  
        assertEquals("Message successfully sent.", result, "Message sending failed.");
    }

    // Test for disregarding the message
    @org.junit.jupiter.api.Test
    @DisplayName("TC3: Test Disregard Message Option")
    void testDisregardMessageOption() {
        // if the user selects 'Disregard Message'
        String result = messages.sentMessage(testMessage1);  
        // We simulate pressing '0' to delete the message
        result = messages.sentMessage(" "); 
        assertEquals("Message deleted.", result, "Message deletion failed.");
    }

    // Test for storing the message
    @org.junit.jupiter.api.Test
    @DisplayName("TC4: Test Store Message Option")
    void testStoreMessageOption() {
        // if the user selects 'Store Message'
        String result = messages.sentMessage(testMessage1);  
        assertEquals("Message successfully stored..", result, "Message storage failed.");
    }

    // Test for Message ID via auto-generation
    @org.junit.jupiter.api.Test
    @DisplayName("TC5: Test Message ID Generation")
    void testGenerateMessageID() {
        int messageID = messages.generateUserID();
        //insures the mesageID is not null
        assertNotNull(messageID, "Message ID should not be null");
        assertTrue(String.valueOf(messageID).length() == 9, "Message ID should be 9 digits long");
    }

    // Test for valid recipient number format
    @org.junit.jupiter.api.Test
    @DisplayName("TC6: Test Valid Recipient Number Format")
    void testValidRecipientNumber() {
        // Correct number format
        int result = messages.checkRecipientCell(testRecipient1);  
        assertEquals(testRecipient1.length(), result, "Recipient number format is invalid.");
    }

    // Test for invalid recipient number format
    @org.junit.jupiter.api.Test
    @DisplayName("TC7: Test Invalid Recipient Number Format")
    void testInvalidRecipientNumber() {
         // Incorrect number format (no international code)
        int result = messages.checkRecipientCell(testRecipient2); 
        assertEquals(testRecipient2.length(), result, "Recipient number format is valid, but should be invalid.");
    }

    // Test for message length validation (<= 250 characters)
    @org.junit.jupiter.api.Test
    @DisplayName("TC8: Test Message Length Validation")
    void testMessageLength() {
        // Test for a message under 251 characters 
        String result = messages.checkMessageLength(testMessage1);
        assertEquals("Message ready to send.", result, "Message length should be less than or equal to 250 characters.");
        
        // Test for a message exceeding 250 characters and it generates a string with more  characters
        String longMessage = "A".repeat(251); 
        result = messages.checkMessageLength(longMessage);
        assertEquals("Message should not exceed 250 characters", result, "Message should be rejected if length exceeds 250 characters.");
    }

    // Test for sending multiple messages and total messages sent
    @org.junit.jupiter.api.Test
    @DisplayName("TC9: Test Sending Multiple Messages")
    void testSendMultipleMessages() {

        // Manually increase message count the more the button is clicked
        message.messageSent = 2; 
        
        // Check that the total messages sent is correct
        int totalMessages = message.returnTotalMessages();
        assertEquals(2, totalMessages, "Total messages sent should be 2 after sending two messages.");
    }


    @BeforeEach
    public void setUp() {
        manager = new message(
            Arrays.asList("Hello", "Good morning", "This is a longer message"),
            Arrays.asList("12345", "67890", "12345"),
            Arrays.asList("ID1", "ID2", "ID3"),
            Arrays.asList("HASH1", "HASH2", "HASH3")
        );
    }

    @Test
    public void testGetLongestMessage() {
        assertEquals("This is a longer message", manager.getLongestMessage());
    }

    @Test
    public void testFindMessageById() {
        assertEquals(1, manager.findMessageIndexById("ID2"));
        assertEquals(-1, manager.findMessageIndexById("ID4"));
    }

    @Test
    public void testFindMessagesByRecipient() {
        var results = manager.findMessagesByRecipient("12345");
        assertEquals(2, results.size());
        assertTrue(results.contains("Hello"));
        assertTrue(results.contains("This is a longer message"));
    }

    @Test
    public void testDeleteMessageByHash() {
        boolean deleted = manager.deleteMessageByHash("HASH2");
        assertTrue(deleted);
        assertEquals(2, manager.getAllSentMessages().size());
        // Try deleting non-existent hash
        assertFalse(manager.deleteMessageByHash("NON_EXISTENT"));
    }

    @Test
    public void testGetAllSentMessages() {
        var allMessages = manager.getAllSentMessages();
        assertEquals(3, allMessages.size());
        assertTrue(allMessages.contains("Good morning"));
    }
}


    

