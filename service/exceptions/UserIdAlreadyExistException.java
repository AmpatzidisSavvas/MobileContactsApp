package gr.aueb.mobileapp.service.exceptions;

import gr.aueb.mobileapp.model.MobileContact;

public class UserIdAlreadyExistException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserIdAlreadyExistException (MobileContact mobileContact) {
        super("Mobile contact with id " + mobileContact.getId() + " already exists");
    }
}
