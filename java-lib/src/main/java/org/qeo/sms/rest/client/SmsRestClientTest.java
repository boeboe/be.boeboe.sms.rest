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
import org.qeo.sms.rest.exceptions.MaxRealmReachedException;
import org.qeo.sms.rest.models.Realm;

/**
 * 
 */
public class SmsRestClientTest
{

    public final static String ACCESS_TOKEN = "e6aaf5bf3a8bc6b861b587e9daa6aab3df528709";

    /**
     * @param args
     * @throws JSONException
     */
    public static void main(String[] args)
    {
        SmsRestClient smsClient = new SmsRestClient(ACCESS_TOKEN);

        // Realm realm = new Realm(123, "realm", "BartRealm");
        // System.out.println("realm == " + realm.toString());
        // JSONObject realmJson = realm.toJson();
        // Realm newRealm = new Realm(realmJson);
        // System.out.println("newRealm == " + newRealm.toString());

        for (int i = 0; i <= 30; i++) {
            try {
                Realm newRealm = smsClient.createRealm("JsonRealmTest_" + i);
                System.out.println(newRealm.toString());
            }
            catch (MaxRealmReachedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }



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
