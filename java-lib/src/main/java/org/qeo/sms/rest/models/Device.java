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

import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

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
    private Otc mOtc;

    private static final String NAME = "name";
    private static final String ID = "id";
    private static final String STATE = "state";
    private static final String TYPE = "type";
    private static final String REALM = "realm";
    private static final String USER = "user";
    private static final String OTC = "otc";
    private static final String DEVICE_ID = "device_id";

    /**
     * Constructor to create a device object.
     * 
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
     * Constructor to create a device object from it's JSON representation.
     * 
     * { "name" : "DeviceAdam1", "id" : 3222, "state" : "CREATING", "type" : "device", "realm" : 6575425569096907932,
     * "user" : 1643, "otc" : { ... }, "device_id" : ""
     * 
     * @param userJson JSON representation of a device
     * @throws JSONException
     * @throws ParseException
     */
    public Device(JSONObject deviceJson)
        throws JSONException
    {
        mId = deviceJson.getLong(ID);
        mRealmId = deviceJson.getLong(REALM);
        mUserId = deviceJson.getLong(USER);
        mType = deviceJson.getString(TYPE);
        mName = deviceJson.getString(NAME);
        mState = getState(deviceJson.getString(STATE));
        mDeviceId = deviceJson.getString(DEVICE_ID);
        mOtc = null;

        // Enrolled and 
        if (deviceJson.has(OTC)) {
            try {
                mOtc = new Otc(deviceJson.getJSONObject(OTC));
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else {
            mOtc = null;
        }
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

    @Override
    public String toString()
    {
        return "Device [mId=" + mId + ", mRealmId=" + mRealmId + ", mUserId=" + mUserId + ", mType=" + mType
            + ", mName=" + mName + ", mState=" + mState + ", mDeviceId=" + mDeviceId + ", mOtc=" + mOtc + "]";
    }

    /**
     * Helper function to convert string to device state enum representation.
     * 
     * @param state string representation of the state
     * @return DeviceState enum representation
     */
    private DeviceState getState(String state)
    {
        if (state.equals("CREATING")) {
            return DeviceState.CREATING;
        }
        else if (state.equals("ENROLLED")) {
            return DeviceState.ENROLLED;
        }
        else if (state.equals("REVOKED")) {
            return DeviceState.REVOKED;
        }
        else if (state.equals("CREATE_FAILED")) {
            return DeviceState.CREATE_FAILED;
        }
        else {
            return null;
        }
    }
}
