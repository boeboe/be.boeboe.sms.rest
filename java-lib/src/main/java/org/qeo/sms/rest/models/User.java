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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Qeo User.
 */
public class User
{
    private final long mId;
    private final long mRealmId;
    private final String mType;
    private final String mName;

    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String TYPE = "type";
    private static final String REALM = "realm";

    /**
     * Constructor to create a user object.
     * 
     * @param id the id of the user
     * @param realmId the realmId to which the user belongs to
     * @param type the type of the user (always "user")
     * @param name the name of the user
     */
    public User(long id, long realmId, String type, String name)
    {
        mId = id;
        mRealmId = realmId;
        mType = type;
        mName = name;
    }

    /**
     * Constructor to create a user object from it's JSON representation.
     * 
     * { "name" : "Adam", "id" : 1643, "type" : "user", "realm" : 6575425569096907932 }
     * 
     * @param userJson JSON representation of a user
     * @throws JSONException when a JSON parsing exception occurred
     */
    public User(JSONObject userJson)
        throws JSONException
    {
        mId = userJson.getLong(ID);
        mType = userJson.getString(TYPE);
        mName = userJson.getString(NAME);
        mRealmId = userJson.getLong(REALM);
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

    @Override
    public String toString()
    {
        return "User [mId=" + mId + ", mRealmId=" + mRealmId + ", mType=" + mType + ", mName=" + mName + "]";
    }
}
