package org.qeo.sms.rest.client;

import java.net.URI;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.qeo.sms.rest.exceptions.MaxRealmReachedException;
import org.qeo.sms.rest.exceptions.UnknownRealmIdException;
import org.qeo.sms.rest.exceptions.UnknownRealmUserException;
import org.qeo.sms.rest.interfaces.IDevice;
import org.qeo.sms.rest.interfaces.IRealm;
import org.qeo.sms.rest.interfaces.IUser;
import org.qeo.sms.rest.models.Device;
import org.qeo.sms.rest.models.Realm;
import org.qeo.sms.rest.models.User;

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

/**
 * 
 */
public class SmsRestClient
    implements IRealm, IUser, IDevice
{
    private final static String BASE_URI = "http://join.qeodev.org:8080/qeo-rest-service/v1";
    private final static String REALMS_URI = BASE_URI + "/realms";

    private final URI mRealmsUri;

    private final String mAccessToken;

    public SmsRestClient(String accessToken)
    {
        mAccessToken = accessToken;
        
        mRealmsUri = URI.create(REALMS_URI);

    }

    @Override
    public ArrayList<Realm> getRealms()
    {
        ArrayList<Realm> realmsList = new ArrayList<>();
        JSONObject jsonRealms = SmsRestUtils.execRestGet(mAccessToken, mRealmsUri);

        try {
            realmsList = SmsRestUtils.getObjectArray(jsonRealms.getJSONArray("realms"), Realm.class);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return realmsList;
    }

    @Override
    public Realm createRealm(String realmName)
        throws MaxRealmReachedException
    {
        JSONObject realmJsonCreate = new JSONObject();
        try {
            realmJsonCreate.put("name", realmName);
            JSONObject jsonRealmResult = SmsRestUtils.execRestPost(mAccessToken, mRealmsUri, realmJsonCreate);
            return new Realm(jsonRealmResult);
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Realm modifyRealm(long realmId, String realmName)
        throws UnknownRealmIdException
    {
        JSONObject realmJsonCreate = new JSONObject();
        try {
            realmJsonCreate.put("id", realmId).put("name", realmName);
            JSONObject jsonRealmResult = SmsRestUtils.execRestPost(mAccessToken, mRealmsUri, realmJsonCreate);
            return new Realm(jsonRealmResult);
        }
        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteRealm(long realmId)
        throws UnknownRealmIdException
    {

    }

    @Override
    public ArrayList<User> getUsers(long realmId)
    {
        ArrayList<User> usersList = new ArrayList<>();

        URI mUsersUri = URI.create(REALMS_URI + "/" + realmId + "/users");
        JSONObject jsonRealms = SmsRestUtils.execRestGet(mAccessToken, mUsersUri);

        try {
            usersList = SmsRestUtils.getObjectArray(jsonRealms.getJSONArray("users"), User.class);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return usersList;
    }

    @Override
    public User createUser(long realmId, String userName)
        throws UnknownRealmIdException
    {
        return null;
    }

    @Override
    public void modifyUser(long realmId, long userId, String userName)
        throws UnknownRealmIdException, UnknownRealmUserException
    {

    }

    @Override
    public void deleteUser(long realmId, long userId)
        throws UnknownRealmIdException, UnknownRealmUserException
    {

    }

    @Override
    public ArrayList<Device> getDevices(long realmId)
    {
        ArrayList<Device> deviceList = new ArrayList<>();

        URI mUsersUri = URI.create(REALMS_URI + "/" + realmId + "/devices");
        JSONObject jsonRealms = SmsRestUtils.execRestGet(mAccessToken, mUsersUri);

        try {
            deviceList = SmsRestUtils.getObjectArray(jsonRealms.getJSONArray("devices"), Device.class);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return deviceList;
    }

    @Override
    public ArrayList<Device> getDevices(long realmId, long userId)
    {
        ArrayList<Device> deviceList = new ArrayList<>();

        URI mUsersUri = URI.create(REALMS_URI + "/" + realmId + "/devices?users=" + userId);
        JSONObject jsonRealms = SmsRestUtils.execRestGet(mAccessToken, mUsersUri);

        try {
            deviceList = SmsRestUtils.getObjectArray(jsonRealms.getJSONArray("devices"), Device.class);
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        return deviceList;
    }

    @Override
    public Device createDevice(long realmId, long userId, String deviceName)
        throws UnknownRealmIdException, UnknownRealmUserException
    {
        return null;
    }


    @Override
    public void modifyDevice(long realmId, long userId, long deviceId, String deviceName)
        throws UnknownRealmIdException, UnknownRealmUserException
    {

    }

    @Override
    public void deleteDevice(long realmId, long userId, long deviceId)
        throws UnknownRealmIdException, UnknownRealmUserException
    {

    }
}
