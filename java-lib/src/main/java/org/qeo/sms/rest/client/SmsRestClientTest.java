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

/**
 * 
 */
public class SmsRestClientTest
{

    public final static String ACCESS_TOKEN = "3224fc930632040580df359fabd687dc0e10c638";

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        SmsRestClient smsClient = new SmsRestClient(ACCESS_TOKEN);

        smsClient.getRealms();

    }

}
