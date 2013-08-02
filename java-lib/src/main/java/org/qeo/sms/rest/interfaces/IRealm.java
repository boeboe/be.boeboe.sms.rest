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

import org.qeo.sms.rest.models.Realm;

/**
 * 
 */
public interface IRealm
{

    /**
     * Retrieve all Realms of a Qeo Administrator.
     * 
     * @return a list of Realms
     */
    public ArrayList<Realm> getRealms();

    /**
     * Create a single Realm of a Qeo administrator.
     * 
     * @param name the name you want to assign to the realm
     * @return the id of the newly created realm
     */
    public long createRealm(String name);

    /**
     * Modify a single Realm of a Qeo administrator.
     * 
     * @param id the id the realm to be modified
     * @param name the name you want to assign to the realm
     */
    public void modifyRealm(long id, String name);
}
