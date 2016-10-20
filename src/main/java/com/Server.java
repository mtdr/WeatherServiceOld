package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 2000;
        try {
            ServerSocket ss = new ServerSocket(port); // создаем сокет сервера и прив€зываем его к вышеуказанному порту
            System.out.println("ќжидаем клиентов");

            Socket socket = ss.accept(); // заставл€ем сервер ждать подключений и выводим сообщение когда кто-то св€залс€ с сервером
            System.out.println(" лиент подключен");
            System.out.println();

            // Ѕерем входной и выходной потоки сокета, теперь можем получать и отсылать данные клиенту.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            //  онвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщени€.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.
                System.out.println(" лиент запросил " + line);
                String line1 = weather.showWeather(line);
                System.out.println("ќтсылаем клиенту " + line1);
                out.writeUTF(line1); // отсылаем клиенту обратно ту самую строку текста.
                out.flush(); // заставл€ем поток закончить передачу данных.
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}