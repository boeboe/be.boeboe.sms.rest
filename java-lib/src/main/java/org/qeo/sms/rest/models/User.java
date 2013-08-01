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
public class User
{
    private final long mId;
    private final long mRealmId;
    private final String mType;
    private final String mName;

    /**
     * @param id
     * @param realmId
     * @param type
     * @param name
     */
    public User(long id, long realmId, String type, String name)
    {
        mId = id;
        mRealmId = realmId;
        mType = type;
        mName = name;
    }

    /**
     * @return the Id
     */
    public long getId()
    {
        return mId;
    }

    /**
     * @return the RealmId
     */
    public long getRealmId()
    {
        return mRealmId;
    }

    /**
     * @return the Type
     */
    public String getType()
    {
        return mType;
    }

    /**
     * @return the Name
     */
    public String getName()
    {
        return mName;
    }
}
