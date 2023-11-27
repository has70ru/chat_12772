package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class User {

    private String name;
    private Socket socket;
    private DataInputStream is;
    private DataOutputStream out;

    public User(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new DataOutputStream(this.socket.getOutputStream());
        this.is = new DataInputStream(this.socket.getInputStream());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataInputStream getIs() {
        return is;
    }

    public DataOutputStream getOut() {
        return out;
    }
}
