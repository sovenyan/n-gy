import java.util.ArrayList;


public class Computer {
    private String macAddress;//unique
    private String name;
    private int numberOfUsers;
    private Boolean isServer;

    public String getMacAddress() {return macAddress;}
    public void setMacAddress(String macAddress) {this.macAddress = macAddress;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getNumberOfUsers() {return numberOfUsers;}
    public void setNumberOfUsers(int numberOfUsers) {this.numberOfUsers = numberOfUsers;}

    public Boolean getIsServer() {return isServer;}
    public void setIsServer(Boolean isServer) {this.isServer = isServer;}

    
    static ArrayList<ClientUsers> users = new ArrayList<>();
   
    static void addUser(ClientUsers user){
        users.add(user);
    }

}