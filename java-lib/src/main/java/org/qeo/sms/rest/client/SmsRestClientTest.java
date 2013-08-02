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

import java.util.ArrayList;

import org.qeo.sms.rest.models.Device;
import org.qeo.sms.rest.models.Realm;
import org.qeo.sms.rest.models.User;

/**
 * 
 */
public class SmsRestClientTest
{

    public final static String ACCESS_TOKEN = "7c18c5d522389abcdf482893352bda60af6c60df";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        SmsRestClient smsClient = new SmsRestClient(ACCESS_TOKEN);

        ArrayList<Realm> realmList = smsClient.getRealms();
        for (Realm realm : realmList) {
            System.out.println(realm);

            long realmId = realm.getId();

            ArrayList<User> userList = smsClient.getUsers(realmId);
            for (User user : userList) {
                System.out.println(user);

                long userId = user.getId();
                ArrayList<Device> devicePerUserList = smsClient.getDevices(realmId, userId);
                for (Device deviceUser : devicePerUserList) {
                    System.out.println("<user:" + userId + "> " + deviceUser);
                }
            }

            ArrayList<Device> deviceList = smsClient.getDevices(realmId);
            for (Device device : deviceList) {
                System.out.println(device);
            }
        }
    }
}
