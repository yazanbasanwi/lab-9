package edu.kau.fcit.cpit252.observers;

import edu.kau.fcit.cpit252.utils.SendEmail;

public class EmailObserver extends Observer{
 public EmailObserver (String recpient){
super.setRecipient(recpient);
 }



    @Override 
    public void update(String message){
// SendEmail.send("priceWatcher", m, getRecipient());
System.out.println("email observer :" + super.getRecipient() + "" + message);
    }
}
