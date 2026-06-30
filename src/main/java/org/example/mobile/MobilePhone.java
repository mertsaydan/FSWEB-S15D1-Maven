package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;


    public MobilePhone(String myNumber, List<Contact> contacts) {
        this.myNumber = myNumber;

        this.myContacts = new ArrayList<>(contacts);
    }


    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }


    public int findContact(Contact contact) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            // İsim eşleşmesi üzerinden kontrol sağlıyoruz
            if (this.myContacts.get(i).getName().equalsIgnoreCase(contact.getName())) {
                return i;
            }
        }
        return -1;
    }


    public int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (this.myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addNewContact(Contact contact) {

        if (findContact(contact.getName()) >= 0) {
            return false;
        }

        this.myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            return false;
        }

        int checkNewContactPosition = findContact(newContact.getName());
        if (checkNewContactPosition >= 0 && checkNewContactPosition != foundPosition) {
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            return false;
        }
        this.myContacts.remove(foundPosition);
        return true;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            // Test senaryosundaki uyuşmazlığı tamamen çözmek için:
            Contact actualContact = this.myContacts.get(position);
            return actualContact;
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : this.myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}