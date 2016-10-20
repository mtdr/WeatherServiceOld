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
            ServerSocket ss = new ServerSocket(port); // ������� ����� ������� � ����������� ��� � �������������� �����
            System.out.println("������� ��������");

            Socket socket = ss.accept(); // ���������� ������ ����� ����������� � ������� ��������� ����� ���-�� �������� � ��������
            System.out.println("������ ���������");
            System.out.println();

            // ����� ������� � �������� ������ ������, ������ ����� �������� � �������� ������ �������.
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            // ������������ ������ � ������ ���, ���� ����� ������������ ��������� ���������.
            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;
            while (true) {
                line = in.readUTF(); // ������� ���� ������ ������� ������ ������.
                System.out.println("������ �������� " + line);
                String line1 = weather.showWeather(line);
                System.out.println("�������� ������� " + line1);
                out.writeUTF(line1); // �������� ������� ������� �� ����� ������ ������.
                out.flush(); // ���������� ����� ��������� �������� ������.
                System.out.println();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }
}