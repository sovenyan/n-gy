/*
4.	Egy számítógép vagy kliensként vagy szerverként működik. 
Csak egy szerver létezik, amire be tudnak jelentkezni a kliensek. 
Minden gépnek MAC címe van, amire most bármilyen egyedi azonosító jó lesz! 
A MAC cím nem változik, de a klienseken létre lehet hozni lokális  felhasználókat.
Ez egy folyamatosan bővülő lista. 
Kliens nem jöhet létre felhasználó nélkül, de lehetőség van egyszerre több felhasználóval is létrehozni.
Minden felhasználónak van joga, ami változhat, 0..4 közötti számmal jelöljük. 
A kliens legyen másolható, és tudjuk archiválni az állapotát!
Amikor „létrejön” egy kliens, akkor aktualizálja magát, ha van létező archívum.
*/ 
import java.util.ArrayList;
import java.io.File;  
import java.io.IOException; 
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;    


class Archiver{
    static Computer server;
    static ArrayList<Computer> clients = new ArrayList<>();



    public static void main(String[] args) {

        //String command = System.console().readLine();
        
        
    
    }

    public void addServerComputer(String mac, String name, int numberOfUsers, Boolean isServer) {
        server = new Computer();
        server.setMacAddress(mac);
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

    public void addUser(String username, String permission){
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