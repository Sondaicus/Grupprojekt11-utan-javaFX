import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        DatabaseCommunicator test = new DatabaseCommunicator(false);
        
 /*      test.addTaskToUser("på", "aafas", "ffffffff");
        test.addTaskToUser("fördy", "asdasd", "huhuehue");*/
  //    test.createUser("hurdy", "durdy");
   test.removeUser("hurdy");
      
   /*     test.printClassVariables();
        test.testMethod();*/
        
        
        
    }

}