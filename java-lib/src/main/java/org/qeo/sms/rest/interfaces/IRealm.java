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

import org.qeo.sms.rest.exceptions.MaxRealmReachedException;
import org.qeo.sms.rest.exceptions.UnknownRealmIdException;
import org.qeo.sms.rest.models.Realm;

/**
 * 
 */
public interface IRealm
{

    /**
     * Retrieve all realms of a Qeo administrator.
     * 
     * @return a list of Realms
     */
    public ArrayList<Realm> getRealms();

    /**
     * Create a single realm of a Qeo administrator.
     * 
     * @param realmName the name you want to assign to the realm
     * @return the new realm
     * @throws MaxRealmReachedException when the maximum number of realms (25) is reached
     */
    public Realm createRealm(String realmName)
        throws MaxRealmReachedException;

    /**
     * Modify a single realm of a Qeo administrator.
     * 
     * @param realmId the id the realm to be modified
     * @param realmName the name you want to assign to the realm
     * @throws UnknownRealmIdException when an unknown realm id is used
     */
    public void modifyRealm(long realmId, String realmName)
        throws UnknownRealmIdException;

    /**
     * Delete a single realm of a Qeo administrator.
     * 
     * @param realmId the id the realm to be deleted
     * @throws UnknownRealmIdException when an unknown realm id is used
     */
    public void deleteRealm(long realmId)
        throws UnknownRealmIdException;
}
