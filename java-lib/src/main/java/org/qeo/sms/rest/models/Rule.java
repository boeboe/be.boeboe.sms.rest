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

import java.util.ArrayList;

/**
 * 
 */
public class Rule
{
    private final String mName;
    private final String mType;
    private final ArrayList<Long> mUsers;
    private final long mRealmId;
    private final ArrayList<Long> mReadAccessUsers;
    private final ArrayList<Long> mWriteAccessUsers;

    /**
     * @param name the name of the rule
     * @param type the type of the rule
     * @param users the users of the rule
     * @param realmId the realmId
     * @param readAccessUsers the list of users with read access
     * @param writeAccessUsers the list of users with write access
     */
    public Rule(String name, String type, ArrayList<Long> users, long realmId, ArrayList<Long> readAccessUsers,
        ArrayList<Long> writeAccessUsers)
    {
        mName = name;
        mType = type;
        mUsers = users;
        mRealmId = realmId;
        mReadAccessUsers = readAccessUsers;
        mWriteAccessUsers = writeAccessUsers;
    }

    /**
     * @return the Name
     */
    public String getName()
    {
        return mName;
    }

    /**
     * @return the Type
     */
    public String getType()
    {
        return mType;
    }

    /**
     * @return the Users
     */
    public ArrayList<Long> getUsers()
    {
        return mUsers;
    }

    /**
     * @return the RealmId
     */
    public long getRealmId()
    {
        return mRealmId;
    }

    /**
     * @return the ReadAccessUsers
     */
    public ArrayList<Long> getReadAccessUsers()
    {
        return mReadAccessUsers;
    }

    /**
     * @return the WriteAccessUsers
     */
    public ArrayList<Long> getWriteAccessUsers()
    {
        return mWriteAccessUsers;
    }
}
