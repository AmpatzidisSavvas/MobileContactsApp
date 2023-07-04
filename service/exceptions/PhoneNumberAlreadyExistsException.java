package gr.aueb.mobileapp.service.exceptions;

import gr.aueb.mobileapp.model.MobileContact;

public class PhoneNumberAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public PhoneNumberAlreadyExistsException (MobileContact mobileContact) {

        super("Mobile contact with mobile phone number " + mobileContact.getPhoneNumber() + " already exists");
    }
}
