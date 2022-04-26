
import java.util.ArrayList;
import java.io.File;  
import java.io.IOException; 
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


class Archiver{
    static Computer server;
    static ArrayList<Computer> clients = new ArrayList<>();



    public static void main(String[] args) {

        //String command = System.console().readLine();
        
        
    
    }

    public void addServerComputer(String name, int numberOfUsers, Boolean isServer) {
        server = new Computer();
        server.setMacAddress(UUID.randomUUID().toString());//random uuid
        server.setName(name);
        server.setNumberOfUsers(numberOfUsers);
        server.setIsServer(isServer);    
    }

    public void addClientComputer(String mac, String name, int numberOfUsers, Boolean isServer){
        Computer c = new Computer();
        c.setMacAddress(mac);
        c.setName(name);
        c.setNumberOfUsers(numberOfUsers);
        c.setIsServer(isServer);
        clients.add(c);
    }

    public void addUser(String username, Integer permission){
        ClientUsers u = new ClientUsers();
        u.setUsername(username);
        u.setPermission(permission);
        Computer.addUser(u);
    }

    public void createArchive(){
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDateTime now = LocalDateTime.now();
            
            File archiveObj = new File("archive"+String.valueOf(dtf.format(now))+".txt");

            if(archiveObj.createNewFile()){
                System.out.println( "File created: "+archiveObj.getName());
            }else{
                System.out.println("File already exsist");
            }

        } catch (Exception e) {
            System.out.println("Szopdki");
            e.printStackTrace();
        }

    }
} 