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

/**
 * 
 */
public class SmsRestClientTest
{

    public final static String ACCESS_TOKEN = "c934847457d796426f027fbbd50e7f6637882ddd";

    /**
     * @param args
     * @throws JSONException
     */
    public static void main(String[] args)
    {
        SmsRestClient smsClient = new SmsRestClient(ACCESS_TOKEN);
        long realmId = Long.parseLong("2209845187177181091");

        // Realm realm = new Realm(123, "realm", "BartRealm");
        // System.out.println("realm == " + realm.toString());
        // JSONObject realmJson = realm.toJson();
        // Realm newRealm = new Realm(realmJson);
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
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        //
        // for (User u : smsClient.getUsers(realmId)) {
        // try {
        // smsClient.deleteUser(realmId, u.getId());
        // }
        // catch (UnknownRealmIdException | UnknownRealmUserException e) {
        // // TODO Auto-generated catch block
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
