import java.util.*;

class Example{
    public static String[] contacts_Name =new String[0];
    public static String[] Contact_Id = new String[1];
    public static String[] contacts_Number =new String[0];
    public static String[] contact_Company =new String[0];
    public static int[] contact_Salary =new int[0];
    
    public static boolean sub_num_check(String tp){
        boolean x =false;
        for(int i=0;i<tp.length();i++){
            if (!Character.isDigit(tp.charAt(i))){
                x= true; 
            }
        }
        return x;
    }
    
    public static void ADD_contacts(){
        Scanner input= new Scanner(System.in);
        clearConsole();
        
        
        //---------this will print the contact id---------
        contact_Id:do {
            int last_num = 0;
            if(Contact_Id[0]=="0"){
                last_num = 0;
                String print_num = String.format("c%04d", (last_num+1));
                Contact_Id[0] = print_num;
                System.out.printf("c%04d",(last_num+1));
                System.out.println("\n=====");
                break contact_Id;
                
            }else{
                String last = Contact_Id[Contact_Id.length-1];
                int last_num_1 = 0;
                for (int i = 1; i<last.length();i++){
                    last_num_1 *=10;
                    int temp_num = last.charAt(i);
                    last_num_1 += temp_num;
                }
                System.out.println(last_num_1);
                
                //----------this will coppy the old number-------------
                String print_num = String.format("c%04d", (last_num_1+1));
                String[] temp = new String[Contact_Id.length+1];
                for(int i=0;i<Contact_Id.length-1;i++){
                    temp [i] =Contact_Id [i];
                }
                
                //---------this will assign the new number to the Array----
                temp[Contact_Id.length] = print_num;
                Contact_Id = temp ;
                
                //---this will print c code
                System.out.printf("c%04d",(last_num_1+1));
                System.out.println("\n=====");
                break contact_Id;
            }
        } while (true);
        
        
        
        //---------this will get your name-----------------------
        name:do{
            System.out.print("Name           : ");
            String[] temp=new String[contacts_Name.length+1];
            for (int i = 0; i < contacts_Name.length; i++){
                temp[i]=contacts_Name[i];
            }
            temp[temp.length-1]=input.next();
            contacts_Name = temp;
            break;
        }while(true);
        
        
        
        //---------this will get your phone number---------------
        phone_num:do{
            String[] temp=new String[contacts_Number.length+1];
            for (int i = 0; i < contacts_Number.length; i++){
                temp[i]=contacts_Number[i];
            }
            ll3:do {
                System.out.print("Number         : ");
                String input_temp = input.next();
                if((input_temp.charAt(0)!='0')||(input_temp.length()!=10)){
                    System.out.println("\nInvalid phone number...");
                    System.out.print("\nDo you want to add phone number again(y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue ll3; 
                    }else{
                        contacts_Name=delete(contacts_Name);
                        return;
                    }
                }else if((sub_num_check(input_temp))){
                    System.out.println("\nInvalid phone number...");
                    System.out.print("\nDo you want to add phone number again(y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue ll3; 
                    }else{
                        contacts_Name=delete(contacts_Name);
                        return;
                    }
                }             
                temp[temp.length-1]=input_temp;
                contacts_Number = temp; 
                break phone_num;
                
            } while (true);
        }while(true);
        
        
        
        
        
        //----------------enter cmpany name------------------------
        do {
            String[] temp = new String[contact_Company.length+1];
            for (int i =0; i<contact_Company.length-1;i++){
                temp [i] = contact_Company[i];
            }
            System.out.print("Company Name  :");
            temp[contact_Company.length] = input.next();
            contact_Company=temp;
            break;
        } while (true);
        
        
        
        
        
        //---------------Enter Contact Salary----------------------
        do {
            int[] temp = new int[contact_Salary.length+1];
            for (int i =0; i<contact_Salary.length-1;i++){
                temp [i] = contact_Salary[i];
            }
            System.out.print("Salary      :");
            temp[contact_Salary.length] = input.nextInt();
            contact_Salary = temp;
            break;
        } while (true);
        
        
    }
    
    
    public static String[] delete(String[] c){
        String[] temp =  new String[c.length-1];
        for(int i=0;i<c.length-2;i++){
            temp [i] =c [i];
        }
        c=temp;
        return contacts_Name;
    }
    
    
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }
    
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        Contact_Id[0]="0";
        System.out.println("           /$$ /$$$$$$$$ /$$$$$$$  /$$$$$$ /$$$$$$$$ /$$   /$$  /$$$$$$$");
        System.out.println("           |__/| $$_____/| $$__  $$|_  $$_/| $$_____/| $$$ | $$|  $$__  $$");
        System.out.println("            /$$| $$      | $$   \\$$ | $$   | $$      | $$$$| $$|  $$  \\ $$");
        System.out.println("           | $$| $$$$$   | $$$$$$$/ | $$   | $$$$$   | $$ $$ $$|  $$  | $$");
        System.out.println("           | $$| $$__/   | $$__  $$ | $$   | $$__/   | $$  $$$$|  $$  | $$");
        System.out.println("           | $$| $$      | $$  \\ $$ | $$   | $$      | $$\\  $$$|  $$  | $$");
        System.out.println("           | $$| $$      | $$  | $$ /$$$$$ | $$$$$$$$| $$ \\  $$| $$$$$$$/");
        System.out.println("           |__/|__/      |__/  |__/|______/|________/|__/  \\__/|_______/");
        System.out.println("\n\n");
        System.out.println("  _____            _              _           _____                        _");
        System.out.println(" / ____|          | |            | |         / __  \\                      (_)");
        System.out.println("| |     ___  _ __ | |_ __ _  ____| |_ ____  | |  | |_ __ __ _  __ _ _ __  _ _______ _ __");
        System.out.println("| |    / _ \\| '_ \\| __/  _'|/ __| __/  __|  | |  | | '__/ _ '|/ _' | '_ \\| |_  / _ \\ '__|");
        System.out.println("| |___| ( ) | | | | ||  |_|| |__| |_\\__  \\  | |__| | | | |_| | |_| | | | | |/ /  __/ |");
        System.out.println(" \\____ \\___/|_| |_|\\__\\__,_|\\___|\\__|____/   \\____/|_| \\___, |\\__,_|_| |_|_/___\\___|_|     ");
        System.out.println("                                                         __/ |");
        System.out.println("                                                        |___/");
        System.out.println("\n\n=========================================================================================\n");
        System.out.println("\t[01] ADD Contacts\n");
        System.out.println("\t[02] UPDATE Contacts\n");
        System.out.println("\t[03] DELETE Contacts\n");
        System.out.println("\t[04] SEARCH Contacts\n");
        System.out.println("\t[05] LIST Contacts\n");
        System.out.println("\t[06] EXIT\n\n");
        
        
        
        System.out.print("Enter an option to continue -> ");
        byte Option_Selecter = input.nextByte();
        
        switch (Option_Selecter){
            case 01: ADD_contacts();    break;
            //case 02: UPDATE_contacts(); break;
            //case 03: DELETE_contacts(); break;
            //case 04: SEARCH_contacts(); break;
            //case 05: LIST_contacts();   break;
            case 06:                    break;
        }
        clearConsole();
        System.out.println(Arrays.toString(contacts_Name));
        main(args);
    }
}