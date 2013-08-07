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

import org.qeo.sms.rest.exceptions.RestApiException;
import org.qeo.sms.rest.models.User;

/**
 * Interface defining the methods applicable on a User.
 */
public interface IUser
{

    /**
     * Retrieve all Users within a Realm of a Qeo Administrator.
     * 
     * @param realmId the realmId
     * @return a list of Users
     * @throws RestApiException when an error occurred
     */
    ArrayList<User> getUsers(long realmId)
        throws RestApiException;

    /**
     * Create a user within a certain realm.
     * 
     * @param realmId the id the realm where the user gets created
     * @param userName the name of the new user
     * @return the new user
     * @throws RestApiException when an error occurred
     */
    User createUser(long realmId, String userName)
        throws RestApiException;

    /**
     * Modify a user within a certain realm.
     * 
     * @param realmId the id the realm where the user gets modified
     * @param userId the id of the user
     * @param userName the new name of the existing user
     * @return the modified user
     * @throws RestApiException when an error occurred
     */
    User modifyUser(long realmId, long userId, String userName)
        throws RestApiException;

    /**
     * Delete a user within a certain realm.
     * 
     * @param realmId the id the realm where the user gets deleted
     * @param userId the id of the user
     * @throws RestApiException when an error occurred
     */
    void deleteUser(long realmId, long userId)
        throws RestApiException;
}
