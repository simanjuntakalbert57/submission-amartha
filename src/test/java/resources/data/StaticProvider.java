package resources.data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
     // DataProvider providing different data sets
     @DataProvider(name = "dataTest")
     public Object[][] createData() {
         return new Object[][] {
             { "Cat 1",2,"cute1","https://upload.wikimedia.org/1200px-Cat_August_2010-4.jpg" },
             { "Cat 2",3,"cute2","https://upload.wikimedia.org/1200px-Cat_August_2010-4.jpg" },
         };
     } 

     @DataProvider(name = "dataStatus")
     public Object[][] dataStatus() {
         return new Object[][] {
             { "available" },
             { "pending" },
         };
     } 
}
