import java.util.Scanner;
// import java.util.stream.Stream;
import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;

class Library3 {
    public static Scanner sc1 = new Scanner(System.in);
    public static Scanner sc2 = new Scanner(System.in);
    public String file;
    LocalDateTime dt = LocalDateTime.now();

    File f1 = new File("D:\\Library Management Project\\IssueBooks.txt");
    File pbf = new File("D:\\Library Management Project\\Previous Books.txt");

    public void showAvailableBooks() {
        String file = null;
        System.out.println(
                "Genres:\n1.Biography\n2.Science and Research\n3.Health and Fitness\n4.Politics and Law\n5.Environment");
        System.out.print("\nEnter your Choice: ");
        int choice = sc1.nextInt();
        if (choice == 1) {
            file = "biography.txt";
        } else if (choice == 2) {
            file = "science and research.txt";
        } else if (choice == 3) {
            file = "health and fitness.txt";
        } else if (choice == 4) {
            file = "politics and law.txt";
        } else if (choice == 5) {
            file = "environment.txt";
        } else {
            System.out.println("Invalid Choice.txt");
        }
        try {
            File f = new File(
                    "D:\\Library Management Project\\All Books\\"
                            + file);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println("==> " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void issueBooks(String user) {
        Scanner in = new Scanner(System.in);
        String genre = null;
        System.out.println(
                "Genres:\n1.Biography\n2.Science and Research\n3.Health and Fitness\n4.Politics and Law\n5.Environment");
        System.out.print("\nEnter your Choice: ");
        int choice = in.nextInt();
        if (choice == 1) {
            genre = "biography.txt";
        } else if (choice == 2) {
            genre = "science and research.txt";
        } else if (choice == 3) {
            genre = "health and fitness.txt";
        } else if (choice == 4) {
            genre = "politics and law.txt";
        } else if (choice == 5) {
            genre = "environment.txt";
        } else {
            System.out.println("Invalid Choice.txt");
        }
        int ind = genre.indexOf('.');
        String ngenre = genre.substring(0,ind);
        File f2 = new File("D:\\Library Management Project\\All Books2\\"+ genre);
        System.out.println("\nEnter the name of the book you want: ");
        String bknm = sc1.nextLine();
        try {
            Scanner sc = new Scanner(f2);
            StringBuffer buffer = new StringBuffer();
            while (sc.hasNextLine()) {
                buffer.append(sc.nextLine() + System.lineSeparator());
            }
            String fileContents = buffer.toString();
            if (fileContents.contains(bknm)) {
                System.out.println("Book is issued to you. Please return it in time");
                fileContents = fileContents.replaceFirst(bknm, "sold");
                try {
                    FileWriter fw1 = new FileWriter(f1, true);
                    FileWriter fw3 = new FileWriter(pbf, true);
                    fw1.append("'" + bknm + "', " + ngenre + ": issued to " + user + "\n");
                    fw1.close();
                    fw3.append("'" + bknm + "', " + ngenre + ": issued to " + user + "\n");
                    fw3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    FileWriter fw2 = new FileWriter(f2);
                    fw2.append(fileContents);
                    fw2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Sorry book is not available for now.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void returnBooks(String user) {
        Scanner sc1 = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String genre1 = null;
        System.out.println(
                "Genres:\n1.Biography\n2.Science and Research\n3.Health and Fitness\n4.Politics and Law\n5.Environment");
        System.out.print("\nEnter your Choice: ");
        int choice = in.nextInt();
        if (choice == 1) {
            genre1 = "biography.txt";
        } else if (choice == 2) {
            genre1 = "science and research.txt";
        } else if (choice == 3) {
            genre1 = "health and fitness.txt";
        } else if (choice == 4) {
            genre1 = "politics and law.txt";
        } else if (choice == 5) {
            genre1 = "environment.txt";
        } else {
            System.out.println("Invalid Choice.txt");
        }
        int ind = genre1.indexOf('.');
        String ngenre1 = genre1.substring(0,ind);
        File f3 = new File("D:\\Library Management Project\\All Books2\\"+ genre1);
        System.out.println("Enter the name of the book you want to return: ");
        String bknm1 = sc1.nextLine();
        try {
            Scanner sc3 = new Scanner(f3);
            Scanner sc4 = new Scanner(f1);
            StringBuffer buffer2 = new StringBuffer();
            StringBuffer buffer3 = new StringBuffer();

            while (sc3.hasNextLine()) {
                buffer2.append(sc3.nextLine() + System.lineSeparator());
            }

            while (sc4.hasNextLine()) {
                buffer3.append(sc4.nextLine() + System.lineSeparator());
            }

            String bookContents = buffer2.toString();
            String issueContents = buffer3.toString();
            issueContents = issueContents.trim();

            if (issueContents.contains(bknm1) && bookContents.contains("sold")) {
                System.out.println("Thankyou for returning the book.");
                issueContents = issueContents.replaceAll("'" + bknm1 + "', " + ngenre1 + ": issued to " + user, "");
                bookContents = bookContents.replaceFirst("sold", bknm1);
                try {
                    FileWriter fw3 = new FileWriter(f1);
                    fw3.append(issueContents);
                    fw3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter fw4 = new FileWriter(f3);
                    fw4.append(bookContents);
                    fw4.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ShowPreviousBook(String user){
        try {
            Scanner sc = new Scanner(pbf);
            int i = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.contains(user)){
                    int sp = line.indexOf(':');
                    String first = line.substring(0, sp);
                    System.out.println(i+". "+first);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Grievance(String user) {
        System.out.println("Enter your Grievance:");
        String gri = sc1.nextLine();
        File nwfile = new File("grievance.txt");
        try {
            FileWriter fileWriter = new FileWriter(nwfile);
            fileWriter.write("Username:" + user + "\n");
            fileWriter.write(gri);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void add_book() {
        System.out.println(
                "Genres:\n1.Biography\n2.Science and Research\n3.Health and Fitness\n4.Politics and Law\n5.Environment");
        System.out.print("\nEnter your Choice: ");
        int choice = sc1.nextInt();
        if (choice == 1) {
            try (FileWriter f = new FileWriter(
                    "D:\\Library Management Project\\All Books2\\biography.txt",
                    true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) {
                System.out.println("Enter book name: ");
                String b_name = sc2.nextLine();
                p.println(b_name);

            } catch (IOException i) {
                i.printStackTrace();
            }

        } else if (choice == 2) {

            try (FileWriter f = new FileWriter(
                    "D:\\Library Management Project\\All Books2\\science and research.txt",
                    true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) {
                System.out.println("Enter book name: ");
                String b_name = sc2.nextLine();
                p.println(b_name);

            } catch (IOException i) {
                i.printStackTrace();
            }
        } else if (choice == 3) {

            try (FileWriter f = new FileWriter(
                    "D:\\Library Management Project\\All Books2\\health and fitness.txt",
                    true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) {
                System.out.println("Enter book name: ");
                String b_name = sc2.nextLine();
                p.println(b_name);

            } catch (IOException i) {
                i.printStackTrace();
            }
        } else if (choice == 4) {

            try (FileWriter f = new FileWriter(
                    "D:\\Library Management Project\\All Books2\\politics and law.txt",
                    true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) {
                System.out.println("Enter book name: ");
                String b_name = sc2.nextLine();
                p.println(b_name);

            } catch (IOException i) {
                i.printStackTrace();
            }
        } else if (choice == 5) {

            try (FileWriter f = new FileWriter(
                    "D:\\Library Management Project\\All Books2\\environment.txt",
                    true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) {
                System.out.println("Enter book name: ");
                String b_name = sc2.nextLine();
                p.println(b_name);

            } catch (IOException i) {
                i.printStackTrace();
            }
        } else {
            System.out.println("Invalid Choice");
        }
    }

    public void remove_book(){
        String file1 = null;
        System.out.println(
            "Genres:\n1.Biography\n2.Science and Research\n3.Health and Fitness\n4.Politics and Law\n5.Environment");
        System.out.print("\nEnter your Choice: ");
        int choice1 = sc1.nextInt();
        if (choice1 == 1) {
            file1 = "biography.txt";
        } else if (choice1 == 2) {
            file1 = "science and research.txt";
        } else if (choice1 == 3) {
            file1 = "health and fitness.txt";
        } else if (choice1 == 4) {
            file1 = "politics and law.txt";
        } else if (choice1 == 5) {
            file1 = "environment.txt";
        } else {
            System.out.println("Invalid Choice.txt");
        }
        System.out.println("Enter the name of the book you want to remove.");
        String rb_name = sc2.nextLine();
        try {
            File f3 = new File("D:\\Library Management Project\\All Books2\\"+ file1);
            Scanner sc2 = new Scanner(f3);
            StringBuffer buffer1 = new StringBuffer();
            while (sc2.hasNextLine()) {
                buffer1.append(sc2.nextLine() + System.lineSeparator());
            }
            String fileContents1 = buffer1.toString();
            if (fileContents1.contains(rb_name)) {
                fileContents1 = fileContents1.replaceFirst(rb_name, "");
                fileContents1 = fileContents1.trim();
                try {
                    FileWriter fw2 = new FileWriter(f3);
                    fw2.append(fileContents1);
                    fw2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Book doesn't exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class LibraryManagement3 {
    public static Scanner sc = new Scanner(System.in);
    public static Scanner sc1 = new Scanner(System.in);
    public static File userlist = new File("D:\\Library Management Project\\LoginDetails.txt");
    public static File adminlist = new File("D:\\Library Management Project\\AdLoginDetails.txt");
    public static int checkDetails(String username, String password) {
        boolean flag = false;
        try {
            Scanner sc5 = new Scanner(userlist);
            while (sc5.hasNextLine()) {
                String line = sc5.nextLine();
                if (line.equals(username + " " + password)) {
                    flag = true;
                    break;
                }
            }
            sc5.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int checkDetails2(String username, String password) {
        boolean flag = false;
        try {
            Scanner sc5 = new Scanner(adminlist);
            while (sc5.hasNextLine()) {
                String line = sc5.nextLine();
                if (line.equals(username + " " + password)) {
                    flag = true;
                    break;
                }
            }
            sc5.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag == true) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Library3 onlineLibrary = new Library3();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("\n*******************************Welcome to PVPPcoe Library*******************************");
        System.out.println("1. User Login");
        System.out.println("2. Admin Login");
        System.out.println("3. New user");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
        int num = sc1.nextInt();
        switch (num) {
            case 1:
                System.out.print("Enter username: ");
                String username = sc.nextLine();
                System.out.print("Enter password: ");
                String password = sc.nextLine();
                if (checkDetails(username, password) == 0) {
                    System.out.println("Username or Password Incorrect!");
                    System.exit(0);
                }

                int choice = 0;
                while (true) {
                    System.out.println(
                            "\n1. List all Books\n2. Borrow Book\n3. Return\n4. Enquiry/Grievance\n5. Show Previous Books\n6. log out.");
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
                            onlineLibrary.Grievance(username);
                            break;
                        case 5:
                            onlineLibrary.ShowPreviousBook(username);
                            break;
                        case 6:
                            LibraryManagement3.main(args);
                        default:
                            System.out.println("Enter Valid Choice");
                            break;
                    }
                }

            case 2:
                System.out.print("Admin name: ");
                String admin_name = sc.nextLine();
                System.out.print("Enter password: ");
                String a_password = sc.nextLine();
                if (checkDetails2(admin_name, a_password) == 0) {
                    System.out.println("Username or Password Incorrect!");
                    System.exit(0);
                }
                while (true) {
                    System.out.println("\n1. view Books\n2. add Book\n3. Remove Book\n4. user Grievance\n5. log out.");
                    System.out.println("Enter your choice:");
                    int an = sc1.nextInt();
                    switch (an) {
                        case 1:
                            onlineLibrary.showAvailableBooks();
                            break;
                        case 2:
                            onlineLibrary.add_book();
                            break;
                        case 3:
                            onlineLibrary.remove_book();
                            break;
                        case 4:
                            File myFile = new File("grievance.txt");
                            if(myFile.length() == 0){
                                System.out.println("No Grievance found");
                            }
                            try {
                                Scanner sc = new Scanner(myFile);
                                while (sc.hasNextLine()) {
                                    String line = sc.nextLine();
                                    System.out.println(line);
                                }
                                sc.close();
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            break;
                        case 5:
                            LibraryManagement3.main(args);
                            // System.exit(0);
                            break;
                        default:
                            break;
                    }

                }

            case 3:
                String name, ph_no, add,set_U,set_P;
                System.out.println("Enter your Name: ");
                name = sc.nextLine();
                System.out.println("Enter your Phone No.: ");
                ph_no = sc.nextLine();
                System.out.println("Enter your Address: ");
                add = sc.nextLine();
                System.out.println("Set your Username: ");                
                set_U = sc.nextLine();
                System.out.println("Set your Password: ");
                set_P = sc.nextLine();
                File regfile = new File("D:\\Library Management Project\\Registered Users.txt");
                try {
                    FileWriter rfw = new FileWriter(regfile, true);
                    rfw.append("Name: "+name+"\n"+"Phone"+"("+name+"): "+ph_no+"\n"+"Address"+"("+name+"): "+add+"\n");
                    rfw.close();
                    System.out.println("User Registered!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    FileWriter lfw = new FileWriter(userlist, true);
                    lfw.append("\n"+set_U+" "+set_P);
                    lfw.close();
                    System.out.println("Username and Password saved!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                LibraryManagement3.main(args);
                break;

            case 4:
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }
}

