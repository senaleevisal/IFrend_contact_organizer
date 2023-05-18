import java.util.*;

class Example{
        public static String[] contacts_Name =new String[0];
        public static String[] Contact_Id = new String[1];
        public static String[] contacts_Number =new String[0];


        public static void ADD_contacts(){
            Scanner input= new Scanner(System.in);

            name:do{
                System.out.print("Name          : ");
                String[] temp=new String[contacts_Name.length+1];
                for (int i = 0; i < contacts_Name.length; i++){
                    temp[i]=contacts_Name[i];
                }
                temp[temp.length-1]=input.next();
                contacts_Name = temp;
                break;
            }while(true);

            phone_num:do{
                String[] temp=new String[contacts_Number.length+1];
                for (int i = 0; i < contacts_Number.length; i++){
                    temp[i]=contacts_Number[i];
                }
                System.out.print("Number         : ");
                String input_temp = input.next();
                if ((input_temp.length()!=10)&&(input_temp.length()!=10)){
                    System.out.print("\b\b\b\b\b\b\b\b\b\b\b");
                    continue phone_num;
                }                
                temp[temp.length-1]=input_temp;
                contacts_Number = temp; 
                break phone_num;
            }while(true);
        }

        public static void Check_Num(String input_temp){
            if((input_temp.charAt(0)==0)&&(input_temp.length()==10)){
                return;
            }
            System.out.println("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
        }
        
        
        public static void main(String[] args) {
            Scanner input =new Scanner(System.in);
            System.out.println("==================================================================================================================");
            System.out.println("\n\n\n");
            System.out.println("[01] ADD Contacts");
            System.out.println("[02] UPDATE Contacts");
            System.out.println("[03] DELETE Contacts");
            System.out.println("[04] SEARCH Contacts");
            System.out.println("[05] LIST Contacts");
            System.out.println("[06] EXIT\n\n");
            
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
            System.out.println(Arrays.toString(contacts_Number));
    }
}