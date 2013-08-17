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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 */
public class Otc
{
    private final String mCode;
    private final Date mDate;

    private static final String CODE = "code";
    private static final String DATE = "date";
    private static final DateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    /**
     * Constructor to create a otc object.
     * 
     * @param code
     * @param date
     */
    public Otc(String code, Date date)
    {
        mCode = code;
        mDate = date;
    }

    /**
     * Constructor to create a otc object from it's JSON representation.
     * 
     * { "date" : "2013-08-02T17:11:59.761+0200", "code" : "93756321" }
     * 
     * @param otcJson JSON representation of a otc
     * @throws JSONException
     * @throws ParseException
     */
    public Otc(JSONObject otcJson)
        throws JSONException, ParseException
    {
        mCode = otcJson.getString(CODE);
        mDate = sDateFormat.parse(otcJson.getString(DATE));
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

    @Override
    public String toString()
    {
        return "Otc [mCode=" + mCode + ", mDate=" + mDate + "]";
    }

}
