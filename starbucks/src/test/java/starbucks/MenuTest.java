/* (c) Copyright 2018 Paul Nguyen. All Rights Reserved */

package starbucks;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MenuTest
{
     IApp app ;
    
    public MenuTest()
    {
    }

    @Before
    public void setUp()
    {
         app = new AppAuthProxy() ;
    }

    @After
    public void tearDown()
    {
    }
    
    @Test
    public void MenuTestTest1()
    {
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
        assertEquals("$0.00", lines[7].trim());
        app.display() ;
        app.execute("B") ;
        assertEquals("Payments", app.screen());
        lines = app.screenContents().split("\n"); 
        assertEquals("Find Store", lines[7].trim());  
        assertEquals("Enable Payments", lines[8].trim());  
        app.display() ;
    }   
    
    @Test
    public void MenuTestTest2()
    {
        String[] lines ;
        assertEquals("PinScreen", app.screen());
        app.touch(1,5) ;  // 1
        app.touch(2,5) ;  // 2
        app.touch(3,5) ;  // 3
        app.touch(1,6) ;  // 4
        assertEquals("MyCards", app.screen());
        lines = app.screenContents().split("\n");
       // System.err.println("lines: " + Arrays.toString(lines));
        assertEquals("$0.00", lines[7].trim());
        app.display() ;
        app.execute("C") ;
        assertEquals("Rewards", app.screen());
        lines = app.screenContents().split("\n");
        System.err.println("lines: " + Arrays.toString(lines));
        assertEquals("Make Every", lines[7].trim());  
        assertEquals("Visit Count", lines[8].trim());  
        app.display() ;
    }  
    
   
    
}