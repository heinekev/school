/**
 * Time-of-day server listening to port 6013.
 *
 * Figure 3.26
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */ 

import java.net.*;
import java.io.*;

public class DateServer {

  public static void main(String[] args) {
    try {
      ServerSocket sock = new ServerSocket(6013);
      // now listen for connections
      while (true) {
        Socket client = sock.accept();
        // we have a connection
        PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
        // write the Date to the socket
        pout.println(new java.util.Date().toString());
        // terminate the connection (date has been served)
        client.close();
      }
    }
    catch (IOException ioe) {
        System.err.println(ioe);
    }
  }
}
