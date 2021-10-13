import java.util.Scanner;
// import java.util.stream.Stream;
import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

class Library3 {
    public static Scanner sc1 = new Scanner(System.in);
    public String file;
    LocalDateTime dt = LocalDateTime.now();
    File f1 = new File("D:\\Library Management Project\\IssueBooks.txt");

    public void showAvailableBooks() {
        String file = null;
        System.out.println("Genres:\n1.Biography\n2.Science and Research\n3.Health and Fitness\n4.Politics and Law\n5.Environment");
        System.out.print("\nEnter your Choice: ");
        int choice = sc1.nextInt();
        if(choice==1) { file = "biography.txt"; }
        else if(choice==2) { file = "science and research.txt"; }
        else if(choice==3) { file = "health and fitness.txt"; }
        else if(choice==4) { file = "politics and law.txt"; }
        else if(choice==5) { file = "environment.txt"; }
        else { System.out.println("Invalid Choice.txt"); }
        try {
            File f = new File("D:\\Library Management Project\\All Books\\"+file);
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println("==> "+line);
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void issueBooks(String user) {
        System.out.println("Enter the Genre of Books: ");
        String genre = sc1.nextLine();
        genre = genre.toLowerCase();
        genre = genre.concat(".txt");
        System.out.println("Enter the name of the book you want.");
        String bknm = sc1.nextLine();
        try {
            File f2 = new File("D:\\Library Management Project\\All Books2\\"+genre);
            Scanner sc = new Scanner(f2);
            StringBuffer buffer = new StringBuffer();
            while(sc.hasNextLine()){
                buffer.append(sc.nextLine()+System.lineSeparator());
            }
            String fileContents = buffer.toString();
            if(fileContents.contains(bknm)){
                System.out.println("Book is issued to you. Please return it in time");
                fileContents = fileContents.replaceFirst(bknm, "sold");
                try{
                    FileWriter fw1 = new FileWriter(f1,true);
                    fw1.append("'"+bknm+"'"+" issued to "+user+"\n");
                    fw1.close();
                }catch(IOException e){ e.printStackTrace(); }
        
                try{
                    FileWriter fw2 = new FileWriter(f2);
                    fw2.append(fileContents);
                    fw2.close();
                }catch(IOException e){ e.printStackTrace(); }
            }
            else{
                System.out.println("Sorry book is not available for now.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBooks(String user) {
        System.out.println("Enter the Genre of Books: ");
        String genre1 = sc1.nextLine();
        genre1 = genre1.toLowerCase();
        genre1 = genre1.concat(".txt");
        System.out.println("Enter the name of the book you want to return.");
        Scanner sc1 = new Scanner(System.in);
        String bknm1 = sc1.nextLine();
        try {
            File f3 = new File("D:\\Library Management Project\\All Books2\\"+genre1);
            Scanner sc3 = new Scanner(f3);
            Scanner sc4 = new Scanner(f1);
            StringBuffer buffer2 = new StringBuffer();
            StringBuffer buffer3 = new StringBuffer();

            while(sc3.hasNextLine()){
                buffer2.append(sc3.nextLine()+System.lineSeparator());
            }

            while(sc4.hasNextLine()){
                buffer3.append(sc4.nextLine()+System.lineSeparator());
            }

            String bookContents = buffer2.toString();
            String issueContents = buffer3.toString();
            issueContents = issueContents.trim();

            if(issueContents.contains(bknm1) && bookContents.contains("sold")){
                System.out.println("Thankyou for returning the book.");
                issueContents = issueContents.replaceAll("'"+bknm1+"'"+" issued to "+user, "");
                bookContents = bookContents.replaceFirst("sold", bknm1);
                try{
                    FileWriter fw3 = new FileWriter(f1);
                    fw3.append(issueContents);
                    fw3.close();
                }catch(IOException e){ e.printStackTrace(); }
                try{
                    FileWriter fw4 = new FileWriter(f3);
                    fw4.append(bookContents);
                    fw4.close();
                }catch(IOException e){ e.printStackTrace(); }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class LibraryManagement3 {
    public static Scanner sc = new Scanner(System.in);

    public static int checkDetails(String username,String password){
        boolean flag = false;
        File userlist = new File("D:\\Library Management Project\\LoginDetails.txt");
        try {
            Scanner sc5 = new Scanner(userlist);
            while(sc5.hasNextLine()){
                String line = sc5.nextLine();
                if(line.equals(username+" "+password))
                {
                    flag = true;
                    break;
                }
            }
            sc5.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        if(flag == true){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args) {

        Library3 onlineLibrary = new Library3();

        System.out.println("Login: ");
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        if(checkDetails(username,password) == 0){
            System.out.println("Username or Password Incorrect!");
            System.exit(0);
        }

        int choice = 0;
        while (true) {
            System.out.println(
                    "\nWELCOME TO ONLINE LIBRARY\n1. List all Books\n2. Borrow Book\n3. Return\n4. Exit.");
            System.out.print("\tEnter your Choice : ");
            Scanner sc = new Scanner(System.in);
            
            choice = sc.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    onlineLibrary.showAvailableBooks();
                    break;
                case 2:
                    onlineLibrary.issueBooks(username);
                    break;
                case 3:
                    onlineLibrary.returnBooks(username);
                    break;
                case 4:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
        }
    }
}
