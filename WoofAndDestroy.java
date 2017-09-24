import java.io.*;
import java.net.*;

/**
 *
 * @author Steven Jordan
 */
public class WoofAndDestory {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args)throws Exception
    {
        URL url = new URL(
        "https://columbusga.craigslist.org/search/ccc?query=lost%20and%20found&sort=rel");
        URLConnection connection = url.openConnection();
        connection.addRequestProperty("Referer", "www.stevenjcomedy.com");

        String line;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        while((line = reader.readLine()) != null) {
            builder.append(line);
        }

        //JSONObject json = new JSONObject(builder.toString());
        //System.out.println(builder.toString());
        // now have some fun with the results...
        
        int x = 1;
        int y = 7;
        String match = "DOG";
        char[] output = new char[60];
        boolean end = false;
        int outint = 0;
        while (end == false)
        {
           String result = builder.substring(x,y);
           System.out.println(result);
           if (result.equals(match))
           {
           //    x = x + 8;
            //   y = y + 8;
               builder.getChars(x, y, output, outint);
               end = true;
           }
           if (x >= builder.length())
           {
               end = true;
           }
           
           x++;
           y++;
           }
           
        System.out.println("Output: " + output);
        }
     
     
    }
