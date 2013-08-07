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
package org.qeo.sms.rest.client;

import org.json.JSONException;
import org.qeo.sms.rest.exceptions.UnknownRealmIdException;
import org.qeo.sms.rest.exceptions.UnknownRealmUserException;
import org.qeo.sms.rest.models.Device;
import org.qeo.sms.rest.models.User;

/**
 * 
 */
public final class SmsRestClientTest
{

    /**
     * Default empty constructor.
     */
    private SmsRestClientTest()
    {
    }

    /** The OAUTH authentication token needed to use the SMS REST API . */
    public static final String ACCESS_TOKEN = "45e3cea8135d0142a8da0b2c886c9750f5467c36";

    /**
     * @param args command line arguments
     * @throws UnknownRealmUserException OK
     * @throws UnknownRealmIdException OK
     * @throws JSONException OK
     */
    public static void main(String[] args)
        throws UnknownRealmIdException, UnknownRealmUserException, JSONException
    {
        SmsRestClient smsClient = new SmsRestClient(ACCESS_TOKEN);
        long realmId = Long.parseLong("2209845187177181091");

        User user = smsClient.getUsers(realmId).get(0);

        for (int i = 0; i < 10; i++) {
            Device dev = smsClient.createDevice(realmId, user.getId(), "TestDevice_" + i);
            smsClient.modifyDevice(realmId, user.getId(), dev.getId(), "TestDeviceModified_" + i);
        }

        for (Device dev : smsClient.getDevices(realmId)) {
            smsClient.deleteDevice(realmId, dev.getUserId(), dev.getId());
        }


        // Realm realm = new Realm(123, "realm", "BartRealm");
        // System.out.println("realm == " + realm.toString());
        // System.out.println("newRealm == " + newRealm.toString());

        // 6162717526657293560
        //
        // long realmId = Long.parseLong("6162717526657293560");
        //
        //
        // try {
        // for (int i = 0; i <= 30; i++) {
        // // Realm newRealm = smsClient.createRealm("JsonRealmTest_" + i);
        // Realm newRealm = smsClient.modifyRealm(realmId, "JsonRealmTest_" + i);
        // System.out.println(newRealm.toString());
        // }
        // smsClient.deleteRealm(realmId);
        // }
        // // catch (MaxRealmReachedException e) {
        // // e.printStackTrace();
        // // }
        // catch (UnknownRealmIdException e) {
        // e.printStackTrace();
        // }

        // ArrayList<Realm> realmList = smsClient.getRealms();
        // for (Realm realm : realmList) {
        // System.out.println(realm.toString());
        // if (realm.getName().startsWith("JsonRealmTest")) {
        // long realmIdDelete = realm.getId();
        // smsClient.deleteRealm(realmIdDelete);
        // }
        //
        // }

        // try {
        // for (int i = 0; i < 10; i++) {
        // User user = smsClient.createUser(realmId, "TestUser_" + i);
        // System.out.println(user);
        // User modifyUser = smsClient.modifyUser(realmId, user.getId(), "TestUserModify_" + i);
        // System.out.println(modifyUser);
        // smsClient.deleteUser(realmId, modifyUser.getId());
        // }
        // }
        // catch (UnknownRealmIdException | UnknownRealmUserException e) {
        // e.printStackTrace();
        // }
        //
        // for (User u : smsClient.getUsers(realmId)) {
        // try {
        // smsClient.deleteUser(realmId, u.getId());
        // }
        // catch (UnknownRealmIdException | UnknownRealmUserException e) {
        // e.printStackTrace();
        // }
        // }

        // ArrayList<Realm> realmList = smsClient.getRealms();
        // for (Realm realm : realmList) {
        // System.out.println(realm);
        //
        // long realmId = realm.getId();
        //
        // ArrayList<User> userList = smsClient.getUsers(realmId);
        // for (User user : userList) {
        // System.out.println(user);
        //
        // long userId = user.getId();
        // ArrayList<Device> devicePerUserList = smsClient.getDevices(realmId, userId);
        // for (Device deviceUser : devicePerUserList) {
        // System.out.println("<user:" + userId + "> " + deviceUser);
        // }
        // }
        //
        // ArrayList<Device> deviceList = smsClient.getDevices(realmId);
        // for (Device device : deviceList) {
        // System.out.println(device);
        // }
        // }

    }
}
