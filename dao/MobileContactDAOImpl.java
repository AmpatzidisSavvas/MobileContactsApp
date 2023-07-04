package gr.aueb.mobileapp.dao;

import gr.aueb.mobileapp.model.MobileContact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobileContactDAOImpl implements IMobileContactDAO {

    //Storage
    private static final List<MobileContact> contacts = new ArrayList<>();

    /**
     *Insert a new {@link MobileContact} instance in the
     * ArrayList Datasource
     * @param mobileContact
     *                      the gr.aueb.mobileapp.model that contains mobile data
     * @return
     *          the added {@link MobileContact}
     */
    @Override
    public MobileContact insert(MobileContact mobileContact) {

        if (mobileContact == null) return null;
        contacts.add(mobileContact);
        return mobileContact;
    }

    /**
     * Update a {@link MobileContact} instance in the ArrayList
     * based on the id
     * @param id
     *          id of the {@link MobileContact} instance that we want to update
     * @param mobileContact
     *                      the gr.aueb.mobileapp.model that contains the mobile data
     *
     * @return
     *          null if the id of the {@link MobileContact} instance
     *          is different from the input id
     */
    @Override
    public MobileContact update(long id, MobileContact mobileContact) {

        if (id != mobileContact.getId()) return null;
        int positionToUpdate = getIndexById(id);
        return contacts.set(positionToUpdate, mobileContact);
    }

    /**
     *Removes a {@link MobileContact} from the Datasource based on the id
     * @param id
     *             the {@link MobileContact} 's id needed to be removed
     */
    @Override
    public void delete(long id) {

        contacts.removeIf((contact) -> contact.getId() == id);
    }

    /**
     *Removes a {@link MobileContact} from the Datasource based on the phone number
     * @param phoneNumber
     *                  the {@link MobileContact} 's phone number needed to be removed
     */
    @Override
    public void delete(String phoneNumber) {
        contacts.removeIf((contact) -> contact.getPhoneNumber().equals(phoneNumber));
    }

    /**
     *Returns a {@link MobileContact} from the datasource based on the input id
     * @param id
     *          the {@link MobileContact} 's id to be returned
     * @return
     *          null  if the Mobile Contact will not exist
     */
    @Override
    public MobileContact get(long id) {
        int position = getIndexById(id);
        if (position == -1) return null;
        return contacts.get(position);
    }

    /**
     *Returns a {@link MobileContact} from the datasource based on the input phone number
     * @param phoneNumber
     *                  the {@link MobileContact} 's phone number to be returned
     * @return
     *           null  if the Mobile Contact will not exist
     */
    @Override
    public MobileContact get(String phoneNumber) {
        int position = getIndexByPhoneNumber(phoneNumber);
        if (position == -1) return null;
        return contacts.get(position);
    }

    /**
     *Returns all the instances from the ArrayList Datasource
     * @return
     *          all instances from the ArrayList Datasource
     */
    @Override
    public List<MobileContact> getAll() {
//      return new ArrayList<>(contacts);
        return Collections.unmodifiableList(contacts);
    }


    /**
     *Checks if the phone number already exists in the ArrayList Database
     * @param phoneNumber
     *                  the phone number to be searched
     * @return
     *          true if the phone number exists in the ArrayList Database
     */
    @Override
    public boolean phoneNumberExists(String phoneNumber) {
        return getIndexByPhoneNumber(phoneNumber) != -1;
    }

    /**
     *Checks if the id already exists in the ArrayList Database
     * @param id
     *          the id to be searched
     * @return
     *          true if the id exists in the ArrayList Database
     */
    @Override
    public boolean userIdExist(long id) {
        return getIndexById(id) != -1;
    }

    /**
     *Returns the position in the ArrayList Datasource of the
     * Mobile Contact containing the input id
     * @param id
     *          the {@link MobileContact} id to be checked
     * @return
     *          the resulting position of the -1 if the
     *          phone number will not exist
     */
    private int getIndexById(long id) {
        int position = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getId() == id) {
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     *Returns the position in the ArrayList Datasource of the
     *      * Mobile Contact containing the input phone number
     * @param phoneNumber
     *                      the {@link MobileContact} phone number to be checked
     * @return
     *          the resulting position of the -1 if the
     *          phone number will not exist
     */
    private int getIndexByPhoneNumber(String phoneNumber) {
        int position = -1;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getPhoneNumber().equals(phoneNumber)) {
                position = i;
                break;
            }
        }
        return position;
    }
}
