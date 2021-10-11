class Transactions
   {
   
   public String transacdate; 
   public Double transacamount;               // data item
   
   
   public Transactions next;              // next link in list
// -------------------------------------------------------------
   public Transactions(String transacdate,double transacamount)  // constructor
      {
                      // initialize data
      this.transacdate=transacdate;                 // ('next' is automatically
      this.transacamount=transacamount;
      
      
    
    
    
    }                           //  set to null)
// -------------------------------------------------------------
   public void displayTransactions()      // display ourself
      {
      System.out.println("Client date of transaction is : "+transacdate);
      System.out.println("Client amount of transaction is : "+transacamount);
      }
       //Get methods for gettng transactions data and later modify it with set methods
      public String getdate()
    {
        return transacdate;
    }
    public double getamount()
    {
        return transacamount;
    }
    public void setdate(String newDate)
    {
        transacdate=newDate;
    }
    public void setamount(Double newAmount)
    {
        transacamount=newAmount;
    }
   }  // end class Link
