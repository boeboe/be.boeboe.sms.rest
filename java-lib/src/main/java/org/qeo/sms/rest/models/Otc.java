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

import java.util.Date;

/**
 * 
 */
public class Otc
{
    private final String mCode;
    private final Date mDate;

    /**
     * @param code
     * @param date
     */
    public Otc(String code, Date date)
    {
        mCode = code;
        mDate = date;
    }

    /**
     * @return the Code
     */
    public String getCode()
    {
        return mCode;
    }

    /**
     * @return the Date
     */
    public Date getdate()
    {
        return mDate;
    }
}
