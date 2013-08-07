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
package org.qeo.sms.rest.models;

/**
 * 
 */
public class Error
{
    private final int mStatus;
    private final int mCode;
    private final String mMessage;

    /**
     * @param status the status of the error
     * @param code the code of the error
     * @param message the message of the error
     */
    public Error(int status, int code, String message)
    {
        super();
        mStatus = status;
        mCode = code;
        mMessage = message;
    }

    /**
     * @return the Status
     */
    public int getStatus()
    {
        return mStatus;
    }

    /**
     * @return the Code
     */
    public int getCode()
    {
        return mCode;
    }

    /**
     * @return the Message
     */
    public String getMessage()
    {
        return mMessage;
    };
}
