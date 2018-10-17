import java.io.*;
import java.net.*;

class SocketGet 
{

    // main entry point for the application
    public static void main(String args[]) 
    {
        try 
        {
            String urlString = args[0];
            URL httpUrl = new URL(urlString);

            // TODO: open the socket below
            /* Useful links:
             *
             * https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html
             * 
             */
            // HINT: you need to create a new Socket object and use httpUrl to get some parameters for the constructor
            Socket httpSocket = null;

            // open up streams to write to and read from
            PrintWriter request = new PrintWriter(httpSocket.getOutputStream(), true);
            BufferedReader response = new BufferedReader(new InputStreamReader(httpSocket.getInputStream()));

            // TODO: build the HTTP "GET" request, alter the httpHeader string to take a path (e.g. http://www.examplefoo.com/dir1/page.html)
            /* Useful links:
             *
             * https://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html
             * https://msdn.microsoft.com/en-us/library/aa287673%28v=vs.71%29.aspx?f=255&MSPPError=-2147217396 
             * 
             */
            String httpHeader = "GET / HTTP/1.1\r\n                      - COMPLETE THIS GET QUERY";

            // send the HTTP request
            request.println(httpHeader);

            // read the reply and print
            String responseStr = response.readLine();
            while ((responseStr != null) && (responseStr != ""))
            {   
                System.out.println(responseStr);
                responseStr = response.readLine();
            } 

            // TODO: close the socket
        } 
        catch (UnknownHostException e) 
        {
            System.err.println("Don't know the hostname");
        } 
        catch (IOException e) 
        {
            System.err.println("Couldn't get I/O for the connection");
        }
    }
}
