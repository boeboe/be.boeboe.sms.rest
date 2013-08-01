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
public class Device
{
    private final long mId;
    private final long mRealmId;
    private final long mUserId;
    private final String mType;
    private final String mName;
    private final DeviceState mState;
    private final String mDeviceId;
    private final Otc mOtc;

    /**
     * @param id
     * @param realmId
     * @param userId
     * @param type
     * @param name
     * @param state
     * @param deviceId
     * @param otc
     */
    public Device(long id, long realmId, long userId, String type, String name, DeviceState state, String deviceId,
        Otc otc)
    {
        mId = id;
        mRealmId = realmId;
        mUserId = userId;
        mType = type;
        mName = name;
        mState = state;
        mDeviceId = deviceId;
        mOtc = otc;
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
     * @return the UserId
     */
    public long getUserId()
    {
        return mUserId;
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

    /**
     * @return the State
     */
    public DeviceState getState()
    {
        return mState;
    }

    /**
     * @return the DeviceId
     */
    public String getDeviceId()
    {
        return mDeviceId;
    }

    /**
     * @return the Otc
     */
    public Otc getOtc()
    {
        return mOtc;
    }
}
