package edu.kau.fcit.cpit252.observers;

public class FacebookObserver extends Observer{

public FacebookObserver (String recpient){
super.setRecipient(recpient);}




    @Override
    public void update(String message){
        System.out.println("Facebook observer :" + super.getRecipient() + "" + message);
    }
}
