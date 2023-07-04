package gr.aueb.mobileapp.dao;

import gr.aueb.mobileapp.model.MobileContact;

import java.util.List;

public interface IMobileContactDAO {

    /**
     *Insert a new {@link MobileContact} instance in the Datasource
     * @param mobileContact
     *                      the gr.aueb.mobileapp.model that contains the mobile data
     * @return
     *          the resulting {@link MobileContact}
     */
    MobileContact insert(MobileContact mobileContact);

    /**
     *Updates a {@link MobileContact}
     *
     * @param id
     *          id of the Mobile Contact that we want to update
     * @param mobileContact
     *                      the gr.aueb.mobileapp.model that contains the mobile data
     * @return
     *          the updated {@link MobileContact}
     */
    MobileContact update(long id, MobileContact mobileContact);

    /**
     *Removes a {@link MobileContact} from the Datasource based on the id
     * @param id
     *          the id of the {@link MobileContact} needed to be removed
     */
    void delete(long id);

    /**
     *Removes a {@link MobileContact} from the Datasource based on the phoneNumber
     * @param phoneNumber
     *                  the phoneNumber of the {@link MobileContact} needed to be removed
     */
    void delete(String phoneNumber);

    /**
     * Returns a {@link MobileContact} from the datasource based on the input id
     * @param id
     *          the {@link MobileContact} 's id to be returned
     * @return
     *          the resulting {@link MobileContact}
     */
    MobileContact get(long id);

    /**
     *Returns a {@link MobileContact} from the datasource based on the input phoneNumber
     * @param phoneNumber
     *                  the {@link MobileContact} 's phoneNumber to be returned
     * @return
     *          the resulting {@link MobileContact}
     */
    MobileContact get(String phoneNumber);

    /**
     * Returns all the {@link MobileContact} instances from the datasource
     * @return
     *          the resulting {@link MobileContact}
     */
    List<MobileContact> getAll();


    /**
     *Checks if the phone number already exists in the datasource
     *  as part of the {@link MobileContact}
     * @param phoneNumber
     *                  the phone number to be searched
     * @return
     *          returns true if the phone number exists in a
     *          {@link MobileContact} in datasource
     */
    boolean phoneNumberExists(String phoneNumber);

    /**
     *Checks if the id already exists in the datasource
     * as parts of the {@link MobileContact}
     * @param id
     *          the id to be searched
     * @return
     *          true if the id exists in a {@link MobileContact}
     *          in datasource
     */
    boolean userIdExist(long id);
}
