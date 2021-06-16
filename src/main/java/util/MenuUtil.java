
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import lombok.SneakyThrows;

/**
 *
 * @author dell
 */
public class MenuUtil {

    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your first name: ");
        String firstName = sc.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = sc.nextLine();
        System.out.println("Hello " + firstName + " " + lastName);

    }

    @SneakyThrows
    public static void client(String ip, int port, String fileLocation) {

        Socket socket = new Socket(ip, port);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        byte[] bytes = FileUtility.readBytes(fileLocation);

        dos.writeInt(bytes.length);
        dos.write(bytes);
        socket.close();

    }

    public static String askFileName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the file location: ");
        String fileLocation = sc.nextLine();
        return fileLocation;
    }

    public static String[] askIPAndPort() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the IP address and port number. Put ':' between IP adress and port number");
        String s = sc.nextLine();

        String[] ipAndPort = s.split(":");

        return ipAndPort;

    }
}
