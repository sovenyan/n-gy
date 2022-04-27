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
        String choice = "";
        
        while(!choice.equals("q")){
            System.out.print("\033[H\033[2J"); //clear terminal
            
            System.out.println("Type the number and press ENTER\n1: add Server\n2: add Clinet Computer\n3: add User\n4: create Archive\n\nType q and press ENTER for EXIT!");
            
            switch(choice){
                
                case "1"://ADD SERVER
                    System.out.print("\033[H\033[2J"); //clear terminal
                    
                    System.out.println("Type q and press ENTER for EXIT\n");
                    System.out.println("\nAdd Server\n");
                    String name = System.console().readLine("What is the name of the Server?\n").toLowerCase();
                    int numberOfUsers = Integer.parseInt(System.console().readLine("How many users?\n"));
                    Boolean isServer = true;

                    
                    addServerComputer(name, numberOfUsers ,isServer);
                    showServerComputer();
                    System.out.println("\nServer Added");


                break;
                
                case "2":// ADD CLIENT COMPUTER
                    System.out.print("\033[H\033[2J"); //clear terminal
                    System.out.println("Type q and press ENTER for EXIT\n");
                    
                    System.out.println("\nAdd Client Computer\n");

                    name = System.console().readLine("What is the name of the Computer?\n").toLowerCase();
                    numberOfUsers = Integer.parseInt(System.console().readLine("How many users?\n"));
                    isServer = false;
                    
                    addClientComputer(name, numberOfUsers, isServer);
                    getClientComputers();
                    System.out.println("\nComputer Added");

                break;

                case "3"://ADD USER
                    System.out.print("\033[H\033[2J"); //clear terminal
                    System.out.println("Type q and press ENTER for EXIT\n");

                    System.out.println("\nAdd Users\n");
                    String username = System.console().readLine("What is the name of the User?\n").toLowerCase();
                    int permission = 1;
                    /*int permission = 0;
                    while(permission < 5 && permission > 1){
                        permission = Integer.parseInt(System.console().readLine("Permission of the user 1-4\n"));

                    }
                    */

                    addUser(username, permission);
                    
                break;
                
                case "4":
                    System.out.print("\033[H\033[2J"); //clear terminal
                    
                    createArchive();
                break;
            }
            
            choice = System.console().readLine().toLowerCase();    
        }
        
        
    
    }

    public static void addServerComputer(String name, int numberOfUsers, Boolean isServer) {
        server = new Computer();
        server.setMacAddress(UUID.randomUUID().toString());//random uuid
        server.setName(name);
        server.setNumberOfUsers(numberOfUsers);
        server.setIsServer(isServer);    
    }

    public static void showServerComputer(){
        System.out.println(server.getName().toString()+"\n"+server.getMacAddress().toString());
    }

    public static void addClientComputer(String name, int numberOfUsers, Boolean isServer){
        Computer c = new Computer();
        c.setMacAddress(UUID.randomUUID().toString());
        c.setName(name);
        c.setNumberOfUsers(numberOfUsers);
        c.setIsServer(isServer);
        clients.add(c);
    }

    public static void addUser(String username, Integer permission){
        ClientUsers u = new ClientUsers();
        u.setUsername(username);
        u.setPermission(permission);
        Computer.addUser(u);
    }

    public static void createArchive(){
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
            e.printStackTrace();
        }

    }

    public static void getClientComputers(){
       clients.forEach((t) -> {
           System.out.println(t.getName());
           System.out.println(t.getMacAddress());
           System.out.println(t.getNumberOfUsers());
           System.out.println(t.getIsServer());
        });
       
    }

    public void getUserList(){

    }
} 