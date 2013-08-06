/************** COPYRIGHT AND CONFIDENTIALITY INFORMATION *********************
 **                                                                          **
 ** Copyright (c) 2013 Technicolor                                           **
 ** All Rights Reserved                                                      **
 **                                                                          **
 ** This program contains proprietary information which is a trade           **
 ** secret of TECHNICOLOR and/or its affiliates and also is protected as     **
 ** an unpublished work under applicable Copyright laws. Recipient is        **
 ** to retain this program in confidence and is not permitted to use or      **
 ** make copies thereof other than as permitted in a written agreement       **
 ** with TECHNICOLOR, UNLESS OTHERWISE EXPRESSLY ALLOWED BY APPLICABLE LAWS. **
 **                                                                          **
 ******************************************************************************/
package org.qeo.sms.rest.interfaces;

import java.util.ArrayList;

import org.qeo.sms.rest.exceptions.UnknownRealmIdException;
import org.qeo.sms.rest.exceptions.UnknownRealmUserException;
import org.qeo.sms.rest.models.User;

/**
 * 
 */
public interface IUser
{

    /**
     * Retrieve all Users within a Realm of a Qeo Administrator.
     * 
     * @return a list of Users
     */
    public ArrayList<User> getUsers(long realmId);

    /**
     * @param realmId the id the realm where the user gets created
     * @param userName the name of the new user
     * @return the new user
     * @throws UnknownRealmIdException when an unknown realm id is used
     */
    public User createUser(long realmId, String userName)
        throws UnknownRealmIdException;
    
    /**
     * @param realmId the id the realm where the user gets modified
     * @param userId the id of the user
     * @param userName the new name of the existing user
     * @return the modified user
     * @throws UnknownRealmIdException when an unknown realm id is used
     * @throws UnknownRealmUserException when an unknown realm - user combination is used
     */
    public User modifyUser(long realmId, long userId, String userName)
        throws UnknownRealmIdException, UnknownRealmUserException;

    /**
     * @param realmId the id the realm where the user gets deleted
     * @param userId the id of the user
     * @throws UnknownRealmIdException when an unknown realm id is used
     * @throws UnknownRealmUserException when an unknown realm - user combination is used
     */
    public void deleteUser(long realmId, long userId)
        throws UnknownRealmIdException, UnknownRealmUserException;
}
