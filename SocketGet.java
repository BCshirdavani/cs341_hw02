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
            int portNum = 80;

            // TODO: open the socket below
            /* Useful links:
             *
             * https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html
             * 
             */
            // HINT: you need to create a new Socket object and use httpUrl to get some parameters for the constructor
            // Socket httpSocket = null;
            Socket httpSocket = new Socket(urlString, portNum);

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
            // String httpHeader = "GET / HTTP/1.1\r\n                      - COMPLETE THIS GET QUERY";


            // HTTP/1.1 400 Bad Request
            // String httpHeader = "GET /index.html HTTP/1.1\r\nHost: http://www.williammortl.com\r\nUser-Agent: Firefox/3.6.10\r\nAccept: text/html,application/xhtml+xml\r\nAccept-Language: en-us,en;q=0.5\r\nAccept-Encoding: gzip,deflate\r\nAccept-Charset: ISO-8859-1,utf-8;q=0.7\r\nKeep-Alive: 115\r\nConnection: keep-alive\r\n\r\n";


            // HTTP/1.1 200 OK....but symbols returned are werid looking: ���� E�a�h
            // String httpHeader = "GET /index.html HTTP/1.1\r\nHost: www.williammortl.com\r\nUser-Agent: Firefox/3.6.10\r\nAccept: text/html,application/xhtml+xml\r\nAccept-Language: en-us,en;q=0.5\r\nAccept-Encoding: gzip,deflate\r\nAccept-Charset: ISO-8859-1,utf-8;q=0.7\r\nKeep-Alive: 115\r\nConnection: keep-alive\r\n\r\n";

            // trying to resolve the strange characters that return...
            String httpHeader = "GET /index.html HTTP/1.1\r\nHost: www.williammortl.com\r\n\r\n";

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
            httpSocket.close();
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

