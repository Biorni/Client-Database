class ClientList
{
    private Client first;            // ref to first Client on list

    // -------------------------------------------------------------
    public ClientList()              // constructor
    {
        first = null;               // no Clients on list yet

    }
    // -------------------------------------------------------------
    public boolean isEmpty()       // true if list is empty
    {
        return (first==null);

    }
    // -------------------------------------------------------------

    // insert at start of list
    public void insertFirst(int clientId,String name,TransactionsList transactionsDetails)
    {                           // make new Client
        Client newClient = new Client(clientId,name,transactionsDetails);
        newClient.next = first;       // newClient --> old first
        first = newClient;            // first --> newClient

    }

    // -------------------------------------------------------------
    public Client find(int key) //check if the student id number entered exists
    {
        Client current= first;
        while(current.clientId !=key)
        {
            if(current.next==null) //if it doesn't exist return null
                return null;
            else
                current=current.next; //else return the link required
        }
        return current;
    }

    public Client delete(int key)
    {

        Client current1 = first;
        Client previous1 = null;
        while(current1.clientId != key) 
        {
            if(current1.next==null)
            {
                return null;
            }

            else {
                previous1 = current1;
                current1 = current1.next;
            }
        }
        if(current1== first) 
            first = first.next;
        else 

            previous1.next = current1.next;

        return current1;
    }

    // -------------------------------------------------------------
    public void displayFirst()
    {
        System.out.println("Client lists (first-->last): ");
        Client current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayClient();   // print data
            current = current.next;  // move to next Client
        }
        System.out.println("");

    }

    // -------------------------------------------------------------
}  // end class ClientList
