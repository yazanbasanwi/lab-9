package edu.kau.fcit.cpit252.observers;

public abstract class Observer {
    private String recipient;

    public String getRecipient() {
        return this.recipient;
    }

    public void setRecipient(String recipient) {
      this.recipient = recipient;
    }

    public abstract void update(String m);
    
}
