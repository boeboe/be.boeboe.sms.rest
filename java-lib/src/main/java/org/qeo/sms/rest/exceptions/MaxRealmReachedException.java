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
package org.qeo.sms.rest.exceptions;

/**
 * Exception thrown when the maximum number of realms is reached (the current limit is 25).
 */
public class MaxRealmReachedException
    extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Exception thrown when the maximum number of realms is reached (the current limit is 25).
     */
    public MaxRealmReachedException()
    {
        super("Max number of realms reached");
    }
}
