package gr.aueb.mobileapp.service.exceptions;

import gr.aueb.mobileapp.model.MobileContact;

public class MobileContactNotFoundException extends Exception{
    private static final long serialVersionUID = 1L;

    public MobileContactNotFoundException(String phoneNumber) {
        super("The mobile contact with phone number " + phoneNumber + " was not found");
    }

    public MobileContactNotFoundException(long id) {
        super("The mobile contact with id " + id + " was not found");
    }

    public MobileContactNotFoundException(MobileContact mobileContact) {
        super("The mobile contact with phone number " + mobileContact.getPhoneNumber() + " was not found");
    }
}
