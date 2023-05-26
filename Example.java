import java.util.*;
import java.time.*;

class Example{
    public static String[] contacts_Name =new String[0];
    public static String[] Contact_Id = new String[1];
    public static String[] contact_Company =new String[0];
    public static String[] contacts_Number =new String[0];
    public static long[] contact_Salary =new long[0];
    public static String[] contact_DOB  = new String[0];
    
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

        if(!(date.length() == 10)){
            x = true;
            return x;
        }
        ll2:for(int i=0;i<date.length();i++){
            if(i==4 || i ==7){
                if(!(date.charAt(i)== '-')){
                    x=true;
                    return x;
                }
            }else{
                if (!Character.isDigit(date.charAt(i))){
                    x= true; 
                    return x;
                }
            }
        }
        return x;
    }


    public static boolean date_check(String day){
        LocalDate currentDate = LocalDate.now();
        int input_year = Integer.parseInt(day.substring(0, 4));
        int input_month = Integer.parseInt(day.substring(5, 7));
        int input_date = Integer.parseInt(day.substring(8, 10));

        if(((input_date <=YearMonth.of(input_year,input_month).lengthOfMonth()) && input_month<=12)){
            if(input_year>currentDate.getYear()){
                return true;
            }else if(input_year<currentDate.getYear()){
                return false;
            }else if(input_month>currentDate.getMonthValue()){
                return true;
            }else if(input_month<currentDate.getMonthValue()) {
                return false;
            }else if (input_date > currentDate.getDayOfMonth()){
                return true;
            }else if(input_date < currentDate.getDayOfMonth()){
                return false;
            }else if(input_date == currentDate.getDayOfMonth()){
                return true;
            }else{
                return true;
            }
        }else{
            return true;
        }
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

    public static int index_Search(String temp){
        int index = 0; 
        if(sub_num_check(temp)){
            ll6:for (int i = 0; i < temp.length(); i++) {
                if (temp.equalsIgnoreCase(contacts_Name[i])) {
                    index = i;
                    break ll6;
                }
            }
        }else{
            ll7:for (int i = 0; i < temp.length(); i++) {
                if (temp == contacts_Number[i]) {
                    index = i;
                    break ll7;
                }
            }
        }
        return index;
    }
    
    public static int index_Search(long temp){
        int index = 0; 
            ll7:for (int i = 0; i <(Long.toString(temp)).length() ; i++) {
                if (temp == contact_Salary[i]) {
                    index = i;
                    break ll7;
                }
            }

        return index;
    }

    public static int index_Search(String temp, int c){
        int index = 0; 
            ll7:for (int i = 0; i <(temp).length() ; i++) {
                if (temp.equalsIgnoreCase(contact_DOB[i])) {
                    index = i;
                    break ll7;
                }
            }

        return index;
    }
    public static void sub_ddelete(int index){
        String[] temp_name=new String[contacts_Name.length-1];
        String[] temp_number=new String[contacts_Number.length-1];
        String[] temp_company = new String[contact_Company.length-1];
        long[] temp_Salary = new long[contact_Salary.length-1];
        String[] temp_DOB = new String[contact_DOB.length-1];
        
        for (int i =0;i<contacts_Number.length;i++){
        
        if (i!= index){
            temp_name[i]=contacts_Name[i];
            temp_number[i]=contacts_Number[i];
            temp_company[i] = contact_Company[i];
            temp_Salary[i] = contact_Salary[i];
            temp_DOB[i] = contact_DOB[i];
        }
        
        }
        
        contacts_Name = temp_name;
        contacts_Number = temp_number;
        contact_Company=temp_company;
        contact_Salary = temp_Salary;
        contact_DOB = temp_DOB;
    }

    public static int sub_search(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nSearch Contact by Name or Phone Number : ");
            String temp = input.next();
            
            int index = index_Search(temp);
            System.out.println("\tContact Id : "+Contact_Id[index]);
            System.out.println("\tName \t\t  : " + contacts_Name[index]);
            System.out.println("\tPhone Number \t  : " + contacts_Number[index]);
            System.out.println("\tCompany Name \t  : " + contact_Company[index]);
            System.out.println("\tSalary\t\t  : " + contact_Salary[index]);
            System.out.println("\tB'Day(YYYY-MM-DD) : "+ contact_DOB[index]);
            return index;
    }

    public static int[] sub_name_sort(){
        String[] temp = new String[contacts_Name.length];
        int[] index = new int[contacts_Name.length];
                
        for(int i=0;i<contacts_Name.length;i++){
            temp [i] =contacts_Name [i];
        }
        for (int i=1; i<contacts_Name.length;i++){
            for (int j=0; j<contacts_Name.length-1;j++){
                l1:for (int k=0; k<contacts_Name[j].length();k++){
                    if (contacts_Name[j+1].charAt(k)<contacts_Name[j].charAt(k)){
                        String temp_ = temp[j];
                        temp[j] = temp[j+1];
                        temp[j+1] = temp_;
                        break l1;
                    }else if((contacts_Name[j+1].charAt(k) == contacts_Name[j].charAt(k))){
                    }else{
                        break l1;
                    }
                }
            }
        }
        for (int i = 0; i<contacts_Name.length; i++){
            index[i] = index_Search(temp[i]); 
        }
        return index;
    }

    public static void print_sort_list(int[] ar ){
        
        System.out.println("+------------+--------------------+--------------+---------+------------+------------+");
        System.out.println("| contact id |      name          | phone number | company |    salary  |  Birthday  |");
        System.out.println("+------------+--------------------+--------------+---------+------------+------------+");
        
        for (int i =0; i<ar.length;i++){
            String name = sub_space_count(contacts_Name[ar[i]],20);
            String company = sub_space_count(contact_Company[ar[i]],9);
            String salary  = sub_space_count(contact_Salary[ar[i]]+".00", 12);
            System.out.println("|   "+Contact_Id[ar[i]]+"    |"+name+"|  "+contacts_Number[ar[i]]+"  |"+company+"|"+salary+"| "+contact_DOB[ar[i]]+" |");
            System.out.println("+------------+--------------------+--------------+---------+------------+------------+");     
        }
    }

    public static String sub_space_count(String temp, int x){
        String white_space = "";
        String sp_ex = "";

            int space = ((x-temp.length())/2);
            if (((x-temp.length())%2)!=0){
                sp_ex = " ";
            }
            for (int j = space;j>0;j--){
                white_space += " ";
            }

        return (white_space+temp+white_space+sp_ex);
    }

    public static int[] sub_salary_sort(){
        
        long[] temp = new long[contact_Salary.length];
        for(int i=0;i<contact_Salary.length;i++){
            temp [i] =contact_Salary [i];
        }
        for (int i =1; i<contact_Salary.length;i++){
            for (int j =0; j<temp.length-i;i++){
                if (contact_Salary[j]<contact_Salary[j+1]){
                    temp[j] = contact_Salary[j+1];
                    temp[j+1] = contact_Salary[j];
                }else{

                }
            }
        }
        int[] index = new int[temp.length];
        for (int i = 0; i<contact_Salary.length; i++){
            index[i] = index_Search(temp[i]); 
        }
        return index;
    
    }

    public static int[] sub_Birthday_sort(){
        
        String[] temp = new String[contact_DOB.length];
        for(int i=0;i<contact_Salary.length;i++){
            temp [i] =contact_DOB [i];
        }
        for (int i =1; i<contact_DOB.length;i++){
            for (int j =0; j<temp.length-i;i++){
                int input_year = Integer.parseInt(contact_DOB[j].substring(0, 4));
                int input_month = Integer.parseInt(contact_DOB[j].substring(5, 7));
                int input_date = Integer.parseInt(contact_DOB[j].substring(8, 10));
                int input_year_1 = Integer.parseInt(contact_DOB[j+1].substring(0, 4));
                int input_month_1 = Integer.parseInt(contact_DOB[j+1].substring(5, 7));
                int input_date_1 = Integer.parseInt(contact_DOB[j+1].substring(8, 10));
                if ((input_year>input_year_1)||(input_year == input_year_1 && input_month>input_month_1)||((input_year == input_year_1 && input_month==input_month_1)&& input_date>input_date_1)){
                temp[j] = contact_DOB[j+1];
                temp[j+1] = contact_DOB[j];
                }else{

                }
            }
        }
        int[] index = new int[temp.length];
        for (int i = 0; i<contact_DOB.length; i++){
            index[i] = index_Search(temp[i],1); 
        }
        return index;
    }







    public static void ADD_contacts(){
        Scanner input = new Scanner(System.in);
        clearConsole();
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                  Add contact to the contact list                |");
            System.out.println("+-----------------------------------------------------------------+");
        
        //---------this will print the contact id---------
        contact_Id:do{
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
                
                for(int i=0;i<Contact_Id.length;i++){
                    temp [i] =Contact_Id [i];
                }
                
                
                temp[Contact_Id.length] = print_num;
                Contact_Id = temp;
                
                //---this will print c code
                System.out.printf("c%04d",(last_num_1+1));
                System.out.println("\n=====");
                break contact_Id;
            }
        } while (true);
        
        
        
        //---------this will get your name-----------------------
            System.out.print("Name                : ");
            String name =input.next();
        
        
        
        //---------this will get your phone number---------------
            String input_temp;
            ll3:do {
                System.out.print("Number              : ");
                input_temp = input.next();
                if((sub_num_check(input_temp)) || (input_temp.charAt(0)!='0')||(input_temp.length()!=10)){
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
            
        
            System.out.print("Company Name        : ");
            String company = input.next();
        
        
        
        
        
        //---------------Enter Contact Salary----------------------


            System.out.print("Salary              : ");
            long salary= input.nextLong();



        //-----------------------Birthday----------------------------

        String day;
        input_birth:do {
            System.out.print("Enter your birthday : ");
            day = input.next();
            if ((date_check(day)) || (sub_date_check(day))){
                System.out.println("\nInvalid date of month...");
                System.out.print("\nDo you want to add date of birth again(y/n) ->");
                String repeat_option = input.next();
                if (repeat_option.equalsIgnoreCase("y")){
                    System.out.print("\033[5A");
                    System.out.print("\033[0J");
                    continue input_birth; 
                }else{
                    return;
                }
            }
            
            break input_birth;
        } while (true);



        //------------------------increment operater--------------------------
        String[] temp_name=new String[contacts_Name.length+1];
        String[] temp_number=new String[contacts_Number.length+1];
        String[] temp_company = new String[contact_Company.length+1];
        long[] temp_Salary = new long[contact_Salary.length+1];
        String[] temp_DOB = new String[contact_DOB.length+1];
        
        for (int i =0;i<contacts_Number.length;i++){
        
        
            temp_name[i]=contacts_Name[i];
            temp_number[i]=contacts_Number[i];
            temp_company[i] = contact_Company[i];
            temp_Salary[i] = contact_Salary[i];
            temp_DOB[i] = contact_DOB[i];
        
        }


        temp_name[temp_name.length-1]=name;
        temp_number[temp_number.length-1]=input_temp;
        temp_company[contact_Company.length] = company;
        temp_Salary[contact_Salary.length] =salary;
        temp_DOB[contact_DOB.length] = day;
        
        
        contacts_Name = temp_name;
        contacts_Number = temp_number;
        contact_Company=temp_company;
        contact_Salary = temp_Salary;
        contact_DOB = temp_DOB;

        System.out.print("\nDo you want to add an other contact again (y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        clearConsole();
                        ADD_contacts(); 
                    }else{
                        return;
                    }
    
    }
    
    public static void UPDATE_contacts() {
        
        contact_update:do {
            Scanner input = new Scanner(System.in);
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                         Update Contact                          |");
            System.out.println("+-----------------------------------------------------------------+");
            
            int index = sub_search();
            
            System.out.println("\nWhat do you want to update,");
            System.out.println("\n\t[01]Name");
            System.out.println("\t[02]Phone Number");
            System.out.println("\t[03]Company");
            System.out.println("\t[04]Salary");
            System.out.print("\nEnter option to continue : ");
            
            int option =input.nextInt();
            
            switch (option){
                case 01:
                    System.out.println("update contact name ");
                    System.out.println("===================\n");
                    System.out.print("input new conhtact name -> ");
                    contacts_Name [index]= input.next();
                    System.out.print("\nDo you want to update contact again (y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        clearConsole();
                        continue contact_update; 
                    }else{
                        return;
                    }
                    case 02:
                    String input_temp;
                    ll3:do {
                        System.out.print("Number         : ");
                        input_temp = input.next();
                        if((sub_num_check(input_temp)) || (input_temp.charAt(0)!='0')||(input_temp.length()!=10)){
                            System.out.println("\nInvalid phone number...");
                            System.out.print("\nDo you want to update phone number again(y/n) ->");
                            String repeat_option_4 = input.next();
                        if (repeat_option_4.equalsIgnoreCase("y")){
                            System.out.print("\033[5A");
                            System.out.print("\033[0J");
                            continue ll3; 
                        }else{
                            return;
                        }
                    }              

       
                        contacts_Number[index]=input_temp;       
                        break ll3;
                    } while (true);
                    System.out.print("\nDo you want to update contact again (y/n) ->");
                    String repeat_option_2 = input.next();
                    if (repeat_option_2.equalsIgnoreCase("y")){
                        clearConsole();
                        continue contact_update; 
                    }else{
                        return;
                    }
                case 03:
                    System.out.println("update contact companny name ");
                    System.out.println("===================\n");
                    System.out.print("input new conhtact company name -> ");
                    contact_Company [index]= input.next();
                    System.out.print("\nDo you want to update contact again (y/n) ->");
                    String repeat_option_3 = input.next();
                    if (repeat_option_3.equalsIgnoreCase("y")){
                        clearConsole();
                        continue contact_update; 
                    }else{
                        return;
                    }
                case 04:
                    System.out.println("update contact salary ");
                    System.out.println("===================\n");
                    System.out.print("input new conhtact salary -> ");
                    contact_Salary [index]= input.nextLong();
                    System.out.print("\nDo you want to update contact again (y/n) ->");
                    String repeat_option_4 = input.next();
                    if (repeat_option_4.equalsIgnoreCase("y")){
                        clearConsole();
                        continue contact_update; 
                        }else{
                        return;
                    }
                case 05:
                String day;
                input_birth:do {
                    System.out.print("Enter your new birthday -> ");
                    day = input.next();
                    if ((date_check(day)) || (sub_date_check(day))){
                        System.out.println("\nInvalid date of month...");
                        System.out.print("\nDo you want to update date of birth again(y/n) ->");
                        String repeat_option__ = input.next();
                        if (repeat_option__.equalsIgnoreCase("y")){
                            System.out.print("\033[5A");
                            System.out.print("\033[0J");
                            continue input_birth; 
                        }else{
                            return;
                        }
                    }
                    
                    break input_birth;
                } while (true);
                contact_DOB[index] = day;
                System.out.print("\nDo you want to update contact again (y/n) ->");
                    String repeat_option_5 = input.next();
                if (repeat_option_5.equalsIgnoreCase("y")){
                    clearConsole();
                    continue contact_update; 
                    }else{
                    return;
                }

                default:
                    return;
            }
            
        } while (true);
    }

    public static void DELETE_contacts() {
            Scanner input = new Scanner(System.in);
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                         Delete Contact                          |");
            System.out.println("+-----------------------------------------------------------------+");

            int index = sub_search();

            System.out.print("\nDo you want to delete this contact (y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        clearConsole();
                        sub_ddelete(index);
                    }else{
                        return;
                    }
    }
    
    public static void SEARCH_contacts() {
        Scanner input =new Scanner(System.in);
        search_contact:do {
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                         Search Contact                          |");
            System.out.println("+-----------------------------------------------------------------+");
            sub_search();
            System.out.print("\nDo you want to search another contact (y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        clearConsole();
                        continue search_contact;
                    }else{
                        return;
                    }
        } while (true);
    }

    public static void LIST_contacts() {
        Scanner input = new Scanner(System.in);
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("|                           Sort Contact                          |");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("\t\t[01]sorting by name");
        System.out.println("\t\t[02]sorting by salary");
        System.out.println("\t\t[03]sorting by Birth day");

        System.out.print("Input an option to continue -> ");
        int input_option = input.nextInt();
        
        switch(input_option){
            case 01:
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                           Sort by name                          |");
            System.out.println("+-----------------------------------------------------------------+");
                int[] ar = sub_name_sort();
                print_sort_list(ar);
                break;
            case 02:
            System.out.println("+-----------------------------------------------------------------+");
            System.out.println("|                         Sort by salary                          |");
            System.out.println("+-----------------------------------------------------------------+");
                int[] ar_ = sub_salary_sort();
                print_sort_list(ar_);
                break; 
            case 03:
                System.out.println("+-----------------------------------------------------------------+");
                System.out.println("|                           Sort by DOB                           |");
                System.out.println("+-----------------------------------------------------------------+");
                int[] ar__ = sub_Birthday_sort();
                print_sort_list(ar__);
                break;
        }
        System.out.print("\nDo you want to sort again (y/n) ->");
                    String repeat_option = input.next();
                    if (repeat_option.equalsIgnoreCase("y")){
                        clearConsole();
                        LIST_contacts();
                    }else{
                        return;
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
                case 02: UPDATE_contacts(); break;
                case 03: DELETE_contacts(); break;
                case 04: SEARCH_contacts(); break;
                case 05: LIST_contacts();   break;
                case 06:                    break;
            }
            //clearConsole();
            System.out.println(Arrays.toString(Contact_Id));
        } while (true); 
        }
}