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
import org.qeo.sms.rest.models.Realm;

/**
 * Interface defining the methods applicable on a Realm.
 */
public interface IRealm
{

    /**
     * Retrieve all realms of a Qeo administrator.
     * 
     * @return a list of Realms
     * @throws RestApiException when an error occurred
     */
    ArrayList<Realm> getRealms()
        throws RestApiException;

    /**
     * Create a single realm of a Qeo administrator.
     * 
     * @param realmName the name you want to assign to the realm
     * @return the new realm
     * @throws RestApiException when an error occurred
     */
    Realm createRealm(String realmName)
        throws RestApiException;

    /**
     * Modify a single realm of a Qeo administrator.
     * 
     * @param realmId the id the realm to be modified
     * @param realmName the name you want to assign to the realm
     * @return the modified realm
     * @throws RestApiException when an error occurred
     */
    Realm modifyRealm(long realmId, String realmName)
        throws RestApiException;

    /**
     * Delete a single realm of a Qeo administrator.
     * 
     * @param realmId the id the realm to be deleted
     * @throws RestApiException when an error occurred
     */
    void deleteRealm(long realmId)
        throws RestApiException;
}
