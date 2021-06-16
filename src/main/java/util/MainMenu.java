/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import lombok.SneakyThrows;

/**
 *
 * @author dell
 */
public class MainMenu {

    @SneakyThrows
    public static void app() {
        System.out.println("Welcome to the file transfer app!");

        MenuUtil.login();
        String fileName = MenuUtil.askFileName();
        String[] arr = MenuUtil.askIPAndPort();

        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);
        MenuUtil.client(ip, port, fileName);

    }

}
