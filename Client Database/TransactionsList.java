class TransactionsList
   {
   public Transactions firsttransac;            // ref to first Transactions on list
   

// -------------------------------------------------------------
   public TransactionsList()              // constructor
      {
      firsttransac = null;               // no Transactionss on list yet
      
      }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      {
      return (firsttransac==null);
      
      }
// -------------------------------------------------------------

     
                                  // insert at start of list
   public void insert(String date,double amount)
      {                           // make new Transactions
      Transactions newTransactions = new Transactions(date,amount);
      newTransactions.next = firsttransac;       // newTransactions --> old first
      firsttransac = newTransactions;            // first --> newTransactions
      }
     
      
// -------------------------------------------------------------

      public Transactions find(String key) //check if the student id number entered exists
{
    Transactions current= firsttransac;
    
    while(current!=null)//if there is no match
    {
        if(current.getdate().equals(key))
    
         //if it doesn't exist return null
        return current;
        else
        current=current.next; //else return the link required
    }
    return null;
}


// -------------------------------------------------------------
   public void displayList()
      {
      System.out.println("Transactions list for client (first-->last): ");
      Transactions current = firsttransac;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayTransactions();   // print data
         current = current.next;  // move to next Transactions
         }
      System.out.println("");
      
     
    }
  

 
// -------------------------------------------------------------
   }  // end class TransactionsList
