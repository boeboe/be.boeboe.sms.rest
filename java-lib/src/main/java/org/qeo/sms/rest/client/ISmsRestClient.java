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
package org.qeo.sms.rest.client;

import java.util.ArrayList;

import org.qeo.sms.rest.models.Device;
import org.qeo.sms.rest.models.Policy;
import org.qeo.sms.rest.models.Realm;
import org.qeo.sms.rest.models.User;

/**
 * 
 */
public interface ISmsRestClient
{

    /**
     * Retrieve all Realms of a Qeo Administrator.
     * 
     * @return a list of Realms
     */
    public ArrayList<Realm> getRealms();

    /**
     * Retrieve all Users within a Realm of a Qeo Administrator.
     * 
     * @return a list of Users
     */
    public ArrayList<User> getUsers(long realmId);

    /**
     * Retrieve all Devices within a Realm of a Qeo Administrator.
     * 
     * @return a list of Devices
     */
    public ArrayList<Device> getDevices(long realmId);

    /**
     * Retrieve the Policy of every User in the Realm of a Qeo Administrator.
     * 
     * @return a list of Policies
     */
    public ArrayList<Policy> getPolicies(long realmId);

    /**
     * Retrieve the Policy of a single User in the Realm of a Qeo Administrator.
     * 
     * @return the Policy for that user
     */
    public Policy getPolicyUser(long realmId, long userId);
}
