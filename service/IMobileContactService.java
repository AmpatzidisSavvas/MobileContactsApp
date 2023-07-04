package gr.aueb.mobileapp.service;

import gr.aueb.mobileapp.dto.MobileContactDTO;
import gr.aueb.mobileapp.model.MobileContact;
import gr.aueb.mobileapp.service.exceptions.MobileContactNotFoundException;
import gr.aueb.mobileapp.service.exceptions.PhoneNumberAlreadyExistsException;
import gr.aueb.mobileapp.service.exceptions.UserIdAlreadyExistException;

import java.util.List;

public interface IMobileContactService {

    /**
     *Creates a {@link MobileContact} based on the data carried by the {@link MobileContactDTO}
     * @param contactDTO
     *                  the DTO object that contains the mobile contact data
     * @return
     *          the resulting Mobile Contact
     * @throws PhoneNumberAlreadyExistsException
     *         if the {@link MobileContactDTO} 's phone number already exists
     *         in the Datasource
     * @throws UserIdAlreadyExistException
     *          if the {@link MobileContactDTO} 's id already exists
     *          in the Datasource
     */
    MobileContact insertMobileContact(MobileContactDTO contactDTO)
            throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistException;

    /**
     *Updates a {@link MobileContact} based on the data carried by the {@link MobileContactDTO}
     * @param id
     *          the {@link MobileContactDTO}'s id
     * @param contactDTO
     *                  the DTO object that contains the mobile contact data.
     * @return
     *          the resulting MobileContact
     * @throws PhoneNumberAlreadyExistsException
     *          if the {@link MobileContactDTO} 's phone number already exists
     *      *         in the Datasource
     * @throws UserIdAlreadyExistException
     *          if the {@link MobileContactDTO} 's id already exists
     *      *          in the Datasource
     *
     * @throws MobileContactNotFoundException
     *          if the {@link MobileContactDTO} Mobile Contact is not
     *          exist
     */
    MobileContact updateMobileContact(long id, MobileContactDTO contactDTO)
        throws PhoneNumberAlreadyExistsException, UserIdAlreadyExistException, MobileContactNotFoundException;

    /**
     *Removes a {@link MobileContact}
     * @param phoneNumber
     *                  the phone number of the {@link MobileContact}
     *                  needed to be removed
     * @throws MobileContactNotFoundException
     *          if the {@link MobileContact}'s phone number does not lead
     *          to an existing {@link MobileContact} in the Datasource
     */
    void deleteMobileContactByPhoneNumber(String phoneNumber) throws MobileContactNotFoundException;

    /**
     *Removes a {@link MobileContact}
     * @param id
     *          the id of the {@link MobileContact}
     *          needed to be removed
     * @throws MobileContactNotFoundException
     *          if the {@link MobileContact}'s id does not lead
     *          to an existing {@link MobileContact} in the Datasource
     */
    void deleteMobileContactById(long id) throws MobileContactNotFoundException;

    /**
     *Returns a {@link MobileContact} based on input phone number
     * @param phoneNumber
     *          the phone number of the {@link MobileContact}
     *          needed to be returned
     * @return
     *          the resulting {@link MobileContact}
     * @throws MobileContactNotFoundException
     *          if the {@link MobileContact}'s phone number does not lead
     *          an existing {@link MobileContact} in the Datasource
     */
    MobileContact getMobileContact(String phoneNumber) throws MobileContactNotFoundException;

    /**
     *Returns a {@link MobileContact} based on input id
     * @param id
     *          id of the {@link MobileContact}
     *          needed to be returned
     * @return
     *          the resulting {@link MobileContact}
     * @throws MobileContactNotFoundException
     *          if the {@link MobileContact}'s id does not lead
     *          to an existing {@link MobileContact} in the Datasource
     */
    MobileContact getMobileContact(long id) throws MobileContactNotFoundException;

    /**
     *Returns all the {@link MobileContact} instances of the Datasource
     * @return
     *          the resulting {@link List<MobileContact>}
     */
    List<MobileContact> getAllMobileContacts();
}


