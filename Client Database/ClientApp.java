/* Biorni Prifti 12/6/2018
 The program presents the user with the menu :
1. Insert new client info 
2. Remove existing client info
3. Retrieve,edit and save  client info like his/her name,his date of each transaction the amount in euros for each transaction.
4. Display a listing of all transactions placed by a particular client sorted by descending order amount.
5. Display a listing of all transactions placed by a particular client sorted by ascending order amount.
6. Exit

Disclaimer: All the class objects in this project (Except ClientApp) have been created using premade code found in Moodle page of the course or online.
All rights reserved
20170263@student.act.edu
 */

import java.io.*; //import java package
import java.util.*; // java package
import java.util.Scanner; //import java Scanner for user inputs
import java.util.LinkedList; //import java package to create an array list with client info
import java.util.Collections; //used in sorting option
import java.util.List; //used in sorting option

class ClientApp
{
    public static void main(String[] args) throws IOException
    {
        // Prepare for input
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));  // Variable (object) reading the keystrokes and transalting the input stream
        Scanner sc = new Scanner (System.in);      //reads input from keyboard  
        String inData;

        //Declared and initialized variables

        int clientId=0;
        String clientname=null;
        String transacdate=null;
        double transacamount=0;

        //variables needed for the menu
        int numclient=0; //used for number of clients to add in the first option
        int choice=0;  //used for the user choice in the first option
        int choose=0;  //used in the third menu for the user to chose which field he wants to modify
        int pick=0; //used in the fourth menu for the user to chose which field he wants to sort
        int choice7=0;//used of the menu in the 7th option, to choose to check or uncheck a client
        int numberSearching=0;
        int idSearching=0;

        //Create LinkedList 
        //ClientList ClientCheck=new ClientList();
        //TransactionsList DetailsCheck=new TransactionsList();
        ClientList theList = new ClientList();  // make new list to hold client information
        TransactionsList transactionsDetails=new TransactionsList(); // make new list to hold transactions information

        //The first list of transactions for the first client
        TransactionsList transactionsDetails1=new TransactionsList();
        transactionsDetails1.insert("07/09/2018",323.5);
        transactionsDetails1.insert("11/05/2017",3425.2);
        transactionsDetails1.insert("24/08/2014",5292.3);


        //First client with the her transactions
        theList.insertFirst(12,"Lefteris Maragakis",transactionsDetails1);

        //The second list of transactions for the second client
        TransactionsList transactionsDetails2=new TransactionsList();
        transactionsDetails2.insert("30/01/2017",424.5);
        transactionsDetails2.insert("23/10/2018",754.34);
        transactionsDetails2.insert("18/06/2017",15.2);
        transactionsDetails2.insert("25/11/2018",67);

        //Second client with the her transactions
        theList.insertFirst(19,"Erika Sholla",transactionsDetails2);

        //Third transactions list for the third client
        TransactionsList transactionsDetails3=new TransactionsList();
        transactionsDetails3.insert("12/06/2014",452.3);
        transactionsDetails3.insert("01/08/2017",730.4);

        //Third client with her transactions
        theList.insertFirst(16,"Biorni Prifti",transactionsDetails3);

        //Fourth transactions list for the fourth client
        TransactionsList transactionsDetails4=new TransactionsList();
        transactionsDetails4.insert("24/09/2015",121.2);
        transactionsDetails4.insert("12/11/2015",234.5);
        transactionsDetails4.insert("31/10/2015",231.7);
        transactionsDetails4.insert("07/11/2016",845.4);
        transactionsDetails4.insert("15/09/2018",42.3);
        transactionsDetails4.insert("22/11/2017",120.6);

        //Fourth client with his transactions
        theList.insertFirst(17,"Daniel Kalemi",transactionsDetails4);

        // Program starts here!!
        while ( true )
        {    
            System.out.println("Welcome! Chose one of the following options: ");
            System.out.println("1. Add new client data ");
            System.out.println("2. Remove client from database ");
            System.out.println("3. Edit,modify,save existing client data ");
            System.out.println("4. List of all transactions of a client in desending order");
            System.out.println("5. List of all transactions of a client in ascending order");
            System.out.println("6. Exit");
            System.out.println("Your choice: ");

            // Read the user's choice and handles any other option than integers
            try{

                choice = sc.nextInt(); //here the users choice is received and parsed
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("Invalid option! Try again ");

            }

            sc.nextLine(); //reads the next line

            switch (choice)  //menu that present the user with options required
            {       
                case 1:  //first option that adds info about a client
                try{
                    do //do-while loop is used to prevent user from entering not accepted number
                    {
                        System.out.println("How many clients should we add? ");
                        numclient = sc.nextInt(); //user choice received and parsed
                        if(numclient<0)
                        {
                            System.out.println("There is a removing button for that");
                        }
                    }while(numclient<0);
                }   
                catch(Exception e)
                {
                    System.out.println("Write a number");
                }

                for(int e=0 ; e<numclient ; e++) //going through the loop to add clients
                {
                    do
                    {
                        System.out.println("Enter the client's id: ");
                        clientId = sc.nextInt(); //user choice received and parsed
                        if(clientId<0)
                        {
                            System.out.println("There is no negative number client's ID!! Please try again");
                        }

                    }while(clientId<0);

                    System.out.println("Enter the client last date of visit(DD/MM/YY): ");
                    transacdate = sc.next(); //user choice received and parsed

                    do
                    {
                        System.out.println("Enter client's amount of transaction (euro): ");
                        transacamount = sc.nextDouble(); //user choice received and parsed
                        if(transacamount<0)
                        {
                            System.out.println("We like positivity here! Make the number such");
                        }
                    }while(transacamount<0);

                    System.out.println("Enter the client's first and last name: ");
                    sc.nextLine(); //reads the next line
                    clientname=sc.nextLine(); //user choice received and parsed

                    System.out.println(); //blank row 
                    transactionsDetails.insert(transacdate,transacamount); //insert the inputs in the transaction list for each client
                    theList.insertFirst(clientId,clientname,transactionsDetails); //insert the inputs on the clients list

                }
                theList.displayFirst(); //display client information 
                break;

                case 2: //second option of the menu that removes a client from the database
                do
                {
                    System.out.println("Enter the id number of the client that needs to be removed: ");
                    numberSearching=sc.nextInt(); //user choice received and parsed
                    if(numberSearching<0)
                    {
                        System.out.println("No negative ID in record");
                    }
                }while(numberSearching<0);

                Client delete = theList.delete(numberSearching); //delete the input provided from the user for a client
                //if deletion happened is different from null then display the deleted client id
                if(delete !=null)
                {
                    System.out.println("Dleted client: " +delete.clientId); 

                }
                else {
                    System.out.println("Couldn't delete");

                }

                theList.displayFirst(); //Displays the clients information

                break;
                case 3:
                //Third option that provides the user with retrieving, editing and save it
                do
                {
                    System.out.println("Enter the ID of the client you would like to retrieve: ");
                    idSearching=sc.nextInt(); //user choice received and parsed
                    //error trapping if the user gives the wrong input
                    if(idSearching<0)
                    {
                        System.out.println("No negarive ID in record");
                    }
                }while(idSearching<0);

                Client looking=theList.find(idSearching); // looking throught clients lists for the user input id
                //if the user input for the client id exists, display its information
                if(looking!=null)
                {
                    System.out.println("Current client that is being viewed: "+looking.clientId);
                    looking.displayClient();
                    do
                    {
                        System.out.println("Choose which to modify:");
                        System.out.println("1. Client name and last name");
                        System.out.println("2. Client date of transaction");
                        System.out.println("3.Client amount of transaction");
                        System.out.println("4. Exit");
                        //try and catch exception that handles any type of user input other than integeres
                        try
                        {

                            choose = sc.nextInt(); //user choice received and parsed
                        }

                        catch (InputMismatchException exception)
                        {
                            System.out.println("Must be an integer");
                        }
                        System.out.println(" ");
                        sc.nextLine(); //reads the next line
                        switch(choose)  //submenu 
                        {

                            case 1:
                            //option of the submenu that changes the name of the client
                            System.out.print("\n");
                            System.out.print("Option 1!\n\n");
                            System.out.println("Previous name: " +looking.getname() );
                            System.out.println("Enter the new  name: ");

                            clientname=sc.nextLine(); //user choice received and parsed
                            System.out.println("Change completed. ");
                            //method used to change the input provided from the client
                            looking.setname(clientname);

                            looking.displayClient();
                            break;

                            case 2:
                            //option of the submenu that changes the date of the transaction list 
                            String newdate=null;
                            System.out.print("\n");
                            System.out.print("Option 2!\n\n");
                            System.out.print("Entered the desired date(dd/mm/yyyy): ");

                            transacdate=sc.next(); //user choice received and parsed

                            System.out.println();
                            //if the input of the user exists in the first transaction list, change it and display it
                            if(transactionsDetails1.find(transacdate)!=null)
                            {

                                //Read date
                                System.out.println(" Enter new date for transaction (dd/mm/year)");

                                newdate = sc.next(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                transactionsDetails1.find(transacdate).getdate();
                                transactionsDetails1.find(transacdate).setdate(newdate);
                                transactionsDetails1.displayList();
                            }
                            //if the input of the user exists in the second transaction list, change it and display it
                            if(transactionsDetails2.find(transacdate)!=null)
                            {

                                //Read date
                                System.out.println(" Enter new transaction date (dd/mm/year)");

                                newdate = sc.next(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                transactionsDetails2.find(transacdate).getdate();
                                transactionsDetails2.find(transacdate).setdate(newdate);
                                transactionsDetails2.displayList();
                            }
                            //if the input of the user exists in the third transaction list, change it and display it
                            if(transactionsDetails3.find(transacdate)!=null)
                            {

                                //Read date
                                System.out.println(" Enter transaction date (dd/mm/year)");

                                newdate = sc.next(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                transactionsDetails3.find(transacdate).getdate();
                                transactionsDetails3.find(transacdate).setdate(newdate);
                                transactionsDetails3.displayList();
                            }
                            //if the input of the user exists in the third transaction list, change it and display it
                            if(transactionsDetails.find(transacdate)!=null)
                            {

                                //Read date
                                System.out.println(" Enter new transaction date (dd/mm/year)");

                                newdate = sc.next(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                transactionsDetails.find(transacdate).getdate();
                                transactionsDetails.find(transacdate).setdate(newdate);
                                transactionsDetails.displayList();
                            }
                            else
                                System.out.println("Date not found");
                            break;

                            case 3:
                            //option of the submenu to change the amount in a transaction list
                            double newamount=0;

                            System.out.print("\n");
                            System.out.print("Option 3!\n\n");
                            System.out.print("Chose which transaction to change by entering the date ");
                            transacdate=sc.next();
                             //user choice received and parsed

                            System.out.println();

                            if(transactionsDetails1.find(transacdate)!=null)
                            {
                                

                                System.out.println(" Enter ammount: ");

                                transacamount= sc.nextDouble(); //user choice received and parsed
                                transactionsDetails1.find(transacdate).getamount() ;
                                //Read date

                                System.out.println(" Enter new ammount: ");

                                newamount= sc.nextDouble(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                
                                transactionsDetails1.find(transacdate).setamount(newamount);
                                transactionsDetails1.displayList();

                            }
                            if(transactionsDetails2.find(transacdate)!=null)
                            {
                                //System.out.println(+transactionsDetails1.date1);
                                //transactionsDetails1.displayList();

                                System.out.println(" Enter transaction ammount ");

                                transacamount= sc.nextDouble(); //user choice received and parsed
                                transactionsDetails2.find(transacdate).getamount() ;
                                //Read date

                                System.out.println("Enter new ammount ");

                                newamount= sc.nextDouble(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                //transactionsDetails1.find(date).getamount() ;
                                transactionsDetails2.find(transacdate).setamount(newamount);
                                transactionsDetails2.displayList();

                            }
                            if(transactionsDetails3.find(transacdate)!=null)
                            {
                                

                                System.out.println(" Enter ammount: ");

                                transacamount= sc.nextDouble(); //user choice received and parsed
                                transactionsDetails3.find(transacdate).getamount() ;
                                

                                System.out.println(" Enter new ammount ");

                                newamount= sc.nextDouble(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                
                                transactionsDetails3.find(transacdate).setamount(newamount);
                                transactionsDetails3.displayList();
                            }
                            if(transactionsDetails.find(transacdate)!=null)
                            {
                                

                                System.out.println(" Enter transactions ammount ");

                                transacamount= sc.nextDouble(); //user choice received and parsed
                                transactionsDetails.find(transacdate).getamount() ;
                                //Read amount

                                System.out.println(" Enter new ammount: ");

                                newamount= sc.nextDouble(); //user choice received and parsed
                                //methods used to get input provided from client and change it
                                
                                transactionsDetails.find(transacdate).setamount(newamount);
                                transactionsDetails.displayList();
                            }

                            else
                                System.out.println("Not found");
                            break;

                            case 4:
                            //...exit program
                            System.out.print("\n");
                            System.out.print("Exiting");
                            break;

                        }
                    }
                    while(choose>4);
                    //looking.displayClient();
                }
                else 
                    System.out.println("Couldnt find client: "+looking.clientId);

                break;

                case 4:
                MaxHeap maxheap= new MaxHeap(40);
                
                do
                {
                    System.out.println("Enter the ID of the client you would like to retrieve: ");
                    idSearching=sc.nextInt(); //user choice received and parsed
                    //error trapping if the user gives the wrong input
                    if(idSearching<0)
                    {
                        System.out.println("No negarive ID in record");
                    }
                }while(idSearching<0);
                
                Client heap=theList.find(idSearching);
                if(heap!=null)
                {
                    System.out.println("Client exists.");
                    
                    Transactions current = heap.transacDetails.firsttransac;
                    
                    while(current!=null)
                    {
                        maxheap.insert(current.transacamount);
                        
                        current=current.next;
                        
                    }
                    
                    while(!maxheap.isEmpty())
                    {
                        System.out.println(maxheap.pop());
                    }
                    
                    
                }
                
                break;

                case 5:
                
                Tree tree= new Tree();
                do
                {
                    System.out.println("Enter the ID of the client you would like to retrieve: ");
                    idSearching=sc.nextInt(); //user choice received and parsed
                    //error trapping if the user gives the wrong input
                    if(idSearching<0)
                    {
                        System.out.println("No negarive ID in record");
                    }
                }while(idSearching<0);
                
                Client thetree=theList.find(idSearching);
                if(thetree!=null)
                {
                    System.out.println("Client exists.");
                    
                    Transactions current1 = thetree.transacDetails.firsttransac;
                    
                    while(current1!=null)
                    {
                        tree.insert(current1.transacamount);
                        
                        current1=current1.next;
                        
                    }
                    
                   tree.traverse(2);
                    
                }
                
                break;

                case 6:
                System.exit(0);
                break;
                
             

                default:
                System.out.println("Invalid option! Chose from 1 to 12");
                break; 
            }
        }
    }
}

