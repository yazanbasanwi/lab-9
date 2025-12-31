package edu.kau.fcit.cpit252.observers;

public class WhatsappObserver extends Observer{

public WhatsappObserver (String recpient){      
super.setRecipient(recpient);}

    @Override
    public void update(String message){
        System.out.println("Whatsapp observer :" + super.getRecipient() + "" + message);
    }   
}
