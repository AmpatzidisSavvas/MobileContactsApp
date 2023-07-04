package gr.aueb.mobileapp.service;

import gr.aueb.mobileapp.dao.IMobileContactDAO;
import gr.aueb.mobileapp.dto.MobileContactDTO;
import gr.aueb.mobileapp.dto.UserDetailsDTO;
import gr.aueb.mobileapp.model.MobileContact;
import gr.aueb.mobileapp.model.UserDetails;
import gr.aueb.mobileapp.service.exceptions.MobileContactNotFoundException;
import gr.aueb.mobileapp.service.exceptions.PhoneNumberAlreadyExistsException;
import gr.aueb.mobileapp.service.exceptions.UserIdAlreadyExistException;

import java.util.List;

/**
 * This gr.aueb.mobileapp.service Layer class implements the Proxy Design Pattern
 */
public class MobileContactServiceImpl implements IMobileContactService {


    private final IMobileContactDAO dao;

    public MobileContactServiceImpl (IMobileContactDAO dao) {
        this.dao = dao;
    }


    @Override
    public MobileContact insertMobileContact(MobileContactDTO contactDTO)
            throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistException {

        MobileContact mobileContact = null;

        try {
            mobileContact = new MobileContact();

            if (dao.phoneNumberExists(contactDTO.getPhoneNumber())) {
                throw new PhoneNumberAlreadyExistsException(mobileContact);
            }
            if (dao.userIdExist(contactDTO.getId())) {
                throw new UserIdAlreadyExistException(mobileContact);
            }

            mapMobileContact(mobileContact, contactDTO);

            mobileContact = dao.insert(mobileContact);

        } catch (PhoneNumberAlreadyExistsException | UserIdAlreadyExistException e) {
            e.printStackTrace();
            throw e;
        }
        return mobileContact;
    }

    @Override
    public MobileContact updateMobileContact(long id, MobileContactDTO contactDTO)
            throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistException, MobileContactNotFoundException {

        MobileContact mobileContact = null;

        try {
            mobileContact = new MobileContact();

            if (id != contactDTO.getId() || !dao.userIdExist(id)){
                throw new MobileContactNotFoundException(id);
            }

            if (dao.phoneNumberExists(contactDTO.getPhoneNumber())) {
                if (!dao.get(contactDTO.getId()).equals(dao.get(contactDTO.getPhoneNumber()))) {
                    throw new PhoneNumberAlreadyExistsException(mobileContact);
                }
            }
            mapMobileContact(mobileContact, contactDTO);

            mobileContact = dao.update(id, mobileContact);

        } catch (PhoneNumberAlreadyExistsException | MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return mobileContact;
    }

    @Override
    public void deleteMobileContactByPhoneNumber(String phoneNumber) throws MobileContactNotFoundException {

        MobileContact mobileContact;

        try {
            mobileContact = new MobileContact();

            if (!dao.phoneNumberExists(phoneNumber)) {
                throw new MobileContactNotFoundException(mobileContact);
            }

            dao.delete(phoneNumber);

        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteMobileContactById(long id) throws MobileContactNotFoundException {

        MobileContact mobileContact;

        try {
            mobileContact = new MobileContact();

            if (!dao.userIdExist(id)) {
                throw new MobileContactNotFoundException(mobileContact);
            }

            dao.delete(id);

        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException {

        MobileContact mobileContact;

        try {
            mobileContact = dao.get(phoneNumber);
            if (mobileContact == null) {
                throw new MobileContactNotFoundException(phoneNumber);
            }
            return mobileContact;

        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MobileContact getMobileContact(long id) throws MobileContactNotFoundException {
        MobileContact mobileContact;

        try {
            mobileContact = dao.get(id);
            if (mobileContact == null) {
                throw new MobileContactNotFoundException(id);
            }
            return mobileContact;

        } catch (MobileContactNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<MobileContact> getAllMobileContacts() {
        return dao.getAll();
    }

    /**
     * Maps {@link MobileContactDTO} to {@link MobileContact}
     * @param mobileContact
     *          the {@link MobileContact} under creation
     * @param mobileContactDTO
     *          the Mobile Contact Data Transfer Object
     */
    private void mapMobileContact(MobileContact mobileContact, MobileContactDTO mobileContactDTO) {
        mobileContact.setId(mobileContactDTO.getId());
        mobileContact.setPhoneNumber(mobileContactDTO.getPhoneNumber());
        UserDetails userDetails = new UserDetails();
        mapUserDetails(userDetails, mobileContactDTO.getUserDetails());
        mobileContact.setUserDetails(userDetails);
    }

    /**
     * Maps {@link UserDetailsDTO} to {@link UserDetails}
     * @param userDetails
     *                  the {@link UserDetails} under creation
     * @param userDetailsDTO
     *          the User Details Data Transfer Object
     */
    private void mapUserDetails(UserDetails userDetails, UserDetailsDTO userDetailsDTO) {
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setFirstname(userDetailsDTO.getFirstname());
        userDetails.setLastname(userDetailsDTO.getLastname());
    }
}
