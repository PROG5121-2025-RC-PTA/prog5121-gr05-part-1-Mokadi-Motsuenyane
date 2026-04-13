package social_media;

import org.junit.*;

import static org.junit.Assert.*;

/**
 *
 * @author ST10480772_Motsuenyane_MDK_Group_5
 */
public class Social_MediaTest {

    /**
     * Test of checkUserName method, of class Social_Media.
     */
    @Test
    public void CheckUserName() {
        //Valid user data
        String username = "kyl_1";
        
        boolean result = Social_Media.checkUserName(username);
        assertTrue( result);
        
        
        //invalid user generated data
        String username2 = "kyle!!!!";
        boolean result2 = Social_Media.checkUserName(username2);
        assertFalse(result2);
    }

    /**
     * Test of checkPasswordComplexity method, of class Social_Media.
     */
    @Test
    public void CheckPasswordComplexity() {
        //valid
        String password = "Ch&&sec@ke99!";
        boolean result = Social_Media.checkPasswordComplexity(password);
        assertTrue( result);
        
        //invalid
        String password2 = "password";
        boolean result2 = Social_Media.checkPasswordComplexity(password2);
        assertFalse( result2);
        
    }

    /**
     * Test of checkCellPhoneNumber method, of class Social_Media.
     */
    @Test
    public void CheckCellPhoneNumber() {
        //valid
        String cellphone = "+27838968976";
        boolean result = Social_Media.checkCellPhoneNumber(cellphone);
        assertTrue( result);
         
        //invalid
        String cellphone2 = "08966553";
        boolean result2 = Social_Media.checkCellPhoneNumber(cellphone2);
        assertFalse( result2);
    }

    /**
     * Test of registerUser method, of class Social_Media.
     */
    @Test
    public void RegisterUser() {
      
        //valid
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String cellphone = "+27838968976";
        String expResult = "You have successfully registered";
        String result = Social_Media.registerUser(username, password, cellphone);
        assertEquals(expResult, result);
        
        //invalid
        String username2 = "kyl_1";
        String password2 = "Ch&&sec@ke99!";
        String cellphone2 = "+27838968976";
        String expResult2 = "You have successfully registered";
        String result2 = Social_Media.registerUser(username2, password2, cellphone2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of loginUser method, of class Social_Media.
     */
    @Test
    public void LoginUser() {
        //valid
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        boolean result = Social_Media.loginUser(username, password);
        assertTrue(result);
        
        //invalid
        String username2 = "kyle!!!!";
        String password2 = "password";
        boolean result2 = Social_Media.loginUser(username2, password2);
        assertFalse(result2);
        
    }

    /**
     * Test of returnLoginStatus method, of class Social_Media.
     */
    @Test
    public void ReturnLoginStatus() {
        //valid
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        String expResult = "You have been successfully logged in";
        String result = Social_Media.returnLoginStatus(username, password);
        assertEquals(expResult, result);
        
        //invalid
        String username2 = "kyle!!!!";
        String password2 = "password";
        String expResult2 = "Login failed please try again";
        String result2 = Social_Media.returnLoginStatus(username2, password2);
        assertEquals(expResult2, result2);
        
        
    }
   
}
