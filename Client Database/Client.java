 class Client
   {
   public int clientId;
   public String clientname;              // data item
   public TransactionsList transacDetails;                               // data item
   public TransactionsList transacdate;
   
   
   public Client next;              // next link in list
// -------------------------------------------------------------
   public Client(int clientId,String clientname,TransactionsList transacDetails)  // constructor
      {
      this.clientId=clientId;
      this.clientname=clientname;                 // initialize data
      this.transacDetails=transacDetails;
      

    }                           //  set to null)
// -------------------------------------------------------------
    
   public void displayClient()      // display ourself
      {
      System.out.println("Client id is : " +clientId);
      System.out.println("Client name is : " +clientname);
      transacDetails.displayList();
      }
      //Get methods for gettng client data and later modify it with set methods
       public int getclientId()
    {
        return clientId;
    }
    public String getname()
    {
        return clientname;
    }
    public TransactionsList gettransactionsDetails()
    {
        return transacDetails;
    }
    public TransactionsList getdate()
    {
        return transacdate;
    }
    public void setclientId(int newClientId)
    {
        clientId=newClientId;
    }
    
    public void setname(String newName)
    {
        clientname=newName;
    }
    public void settransactionsDetails(TransactionsList newTransactionsDetails)
    {
        transacDetails=newTransactionsDetails;
    }
    public void setdate(String newDate)
    {
        clientname=newDate;
    }
   }  // end class Link
