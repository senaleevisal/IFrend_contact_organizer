import java.util.*;
import javax.sql.*;
import java.time.*;
import java.time.Month;

class Example{
    public static String[] contacts_Name =new String[0];
    public static String[] Contact_Id = new String[1];
    public static String[] contacts_Number =new String[0];
    public static String[] contact_Company =new String[0];
    public static long[] contact_Salary =new long[0];
    
    public static boolean sub_num_check(String tp){
        boolean x =false;
        for(int i=0;i<tp.length();i++){
            if (!Character.isDigit(tp.charAt(i))){
                x= true; 
            }
        }
        return x;
    }

    public static boolean sub_date_check(String date){
        boolean x =false;
        for(int i=0;i<date.length();i++){
            if(i!=4 && i!=6)
            if (!Character.isDigit(date.charAt(i))){
                x= true; 
            }
        }
        return x;
    }

    public static boolean date_check(String date){
        boolean x = false;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int date_ = Integer.parseInt(date.substring(8, 10));

        if (year>Year.now().getValue()){
            x=true;
            return x;
        }else if (year<Year.now().getValue()){
            x=false;
            return x;
        }else if(month>Month.now().getValue()){

        }
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
                String last_c = Contact_Id[Contact_Id.length-1];
                String last   = last_c.substring(1, 5);
                int last_num_1 = Integer.parseInt(last);
                
                
                //----------this will coppy the old number-------------
                String print_num = String.format("c%04d", (last_num_1+1));
                String[] temp = new String[Contact_Id.length+1];
                
                for(int i=0;i<Contact_Id.length-1;i++){
                    temp [i] =Contact_Id [i];
                }
                
                
                temp[Contact_Id.length] = print_num;
                Contact_Id = temp ;
                
                //---this will print c code
                System.out.printf("c%04d",(last_num_1+1));
                System.out.println("\n=====");
                break contact_Id;
            }
        } while (true);
        
        
        
        //---------this will get your name-----------------------
            System.out.print("Name           : ");
            String name =input.next();
        
        
        
        //---------this will get your phone number---------------
            String input_temp;
            ll3:do {
                System.out.print("Number         : ");
                input_temp = input.next();
                if((input_temp.charAt(0)!='0')||(input_temp.length()!=10)){
                    System.out.println("\nInvalid phone number...");
                    System.out.print("\nDo you want to add phone number again(y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        System.out.print("\033[5A");
                        System.out.print("\033[0J");
                        continue ll3; 
                    }else{
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
                        return;
                    }
                }              
                break ll3;
            } while (true);

        
        
        
        
        
        //----------------enter cmpany name------------------------
            
        
            System.out.print("Company Name  :");
            String company = input.next();
        
        
        
        
        
        //---------------Enter Contact Salary----------------------


            System.out.print("Salary      :");
            long salary= input.nextLong();



        //-----------------------Birthday----------------------------

        String input_date;
        ll4:do {
            System.out.print("B'Day(YYYY-MM-DD) : ");
            input_date = input.next();
            if((input_temp.length()!=10)){
                System.out.println("\nInvalid Date ...");
                System.out.print("\nDo you want to add Date again(y/n) ->");
                String repeat_option = input.next();
                if (repeat_option.equalsIgnoreCase("y")){
                    System.out.print("\033[5A");
                    System.out.print("\033[0J");
                    continue ll4; 
                }else{
                    return;
                }
            }else if((sub_date_check(input_date))){
                System.out.println("\nInvalid Date ...");
                System.out.print("\nDo you want to add Date again(y/n) ->");
                String repeat_option = input.next();
                if (repeat_option.equalsIgnoreCase("y")){
                    System.out.print("\033[5A");
                    System.out.print("\033[0J");
                    continue ll4; 
                }else{
                    return;
                }
            }else if (date_check(input_date)){

            }              
            break ll4;
        } while (true);

        
        




        //------------------------increment operater--------------------------
        String[] temp_name=new String[contacts_Name.length+1];
        String[] temp_number=new String[contacts_Number.length+1];
        String[] temp_company = new String[contact_Company.length+1];
        long[] temp_Salary = new long[contact_Salary.length+1];
        
        
        for (int i =0;i<Contact_Id.length;i++){
        
        
            temp_name[i]=contacts_Name[i];
            temp_number[i]=contacts_Number[i];
            temp_company[i] = contact_Company[i];
            temp_Salary[i] = contact_Salary[i];
        
        }


        temp_name[temp_name.length-1]=name;
        temp_number[temp_number.length-1]=input_temp;
        temp_company[contact_Company.length] = company;
        temp_Salary[contact_Salary.length] =salary;
        
        
        contacts_Name = temp_name;
        contacts_Number = temp_number;
        contact_Company=temp_company;
        contact_Salary = temp_Salary;
    
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
        Contact_Id[0]="0";
        
        do {
            Scanner input =new Scanner(System.in);
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
        } while (true); 
        }
}