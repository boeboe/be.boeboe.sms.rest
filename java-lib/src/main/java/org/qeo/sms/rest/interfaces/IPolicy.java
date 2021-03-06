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
import org.qeo.sms.rest.models.Policy;

/**
 * Interface defining the methods applicable on a Policy.
 */
public interface IPolicy
{

    /**
     * Retrieve the Policy of every User in the Realm of a Qeo Administrator.
     * 
     * @param realmId the realmId
     * @return a list of Policies
     * @throws RestApiException when an error occurred
     */
    ArrayList<Policy> getPolicies(long realmId)
        throws RestApiException;

    /**
     * Retrieve the Policy of a single User in the Realm of a Qeo Administrator.
     * 
     * @param realmId the realmId
     * @param userId the userId
     * @return the Policy for that user
     * @throws RestApiException when an error occurred
     */
    Policy getPolicyUser(long realmId, long userId)
        throws RestApiException;
}
