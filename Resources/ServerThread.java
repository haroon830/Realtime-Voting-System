package rts;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread
{
    Socket socket = null;
    ServerThread(Socket socket){
        this.socket = socket;
    }

    String U,P;
    public void run() {
        System.out.println("Server: Connected");
        NewUser A = null;
        try {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            //ArrayList<NewUser> U = new ArrayList<>(0);
            A = (NewUser) input.readObject();
            U=A.getUsername();
            P=A.getPassword();
            write();
            System.out.println("Hi Danish Bhai");
            input.close();
            output.close();
            socket.close();
            System.out.println("Socket closed");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void write() throws Exception{
        NewUser N = new NewUser(U,P);
        ArrayList<NewUser> Users = readAllData();

        Users.add(N);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\MAQ.txt"));
        for(int i=0;i<Users.size();i++) {
            out.writeObject(Users.get(i));
        }
        out.writeObject(N);
        out.flush();
        //out.close();
        System.out.println("Object has been Serialized");

    }

    public ArrayList<NewUser>readAllData() {
        ArrayList<NewUser> Users = new ArrayList<>(0);
        FileInputStream file = null;
        ObjectInputStream inputStream = null;
        try {
            file = new FileInputStream("E:\\MAQ.txt");
            inputStream = new ObjectInputStream(file);
            boolean EOF = false;
            while (!EOF) {
                try {
                    NewUser N= (NewUser) inputStream.readObject();
                    Users.add(N);

                }catch (ClassNotFoundException e) {
                    System.out.println("Class Not Found");
                }
                catch (EOFException end) {
                    EOF = true;
                }
            }
        }catch (FileNotFoundException ex){
        }catch (IOException e) {
        }
        finally {
            try {
                if(inputStream != null)
                    inputStream.close();
            }catch (FileNotFoundException e){
                System.out.println("File Not Found");
            }
            catch (IOException e){
                System.out.println("IO Exception while closing file");
            }
            return Users;
        }

}}
