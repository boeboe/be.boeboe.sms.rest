package org.qeo.sms.rest.client;

import java.net.URI;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.qeo.sms.rest.exceptions.MaxRealmReachedException;
import org.qeo.sms.rest.exceptions.UnknownRealmIdException;
import org.qeo.sms.rest.interfaces.IRealm;
import org.qeo.sms.rest.models.Realm;

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
    implements IRealm
{
    private final static String BASE_URI = "http://join.qeodev.org:8080/qeo-rest-service/v1";
    private final static String REALMS_URI = BASE_URI + "/realms";

    private final URI mBaseUri;
    private final URI mRealmsUri;

    private final String mAccessToken;

    public SmsRestClient(String accessToken)
    {
        mAccessToken = accessToken;
        
        mBaseUri = URI.create(BASE_URI);
        mRealmsUri = URI.create(REALMS_URI);

    }

    // public IScapSyncCceDetails getCceDetails(String id) {
    // URI detailsUri = URI.create(fCceUri + id);
    // JSONObject jsonDetailsResult = ScapSyncUtils.execRestGet(detailsUri);
    // return new ScapSyncCceDetailsRest(jsonDetailsResult);
    // }
    
    @Override
    public ArrayList<Realm> getRealms()
    {
        JSONObject jsonRealms = SmsRestUtils.execRestGet(mAccessToken, mRealmsUri);

        try {
            Realm[] realmsArray = SmsRestUtils.getObjectArray(jsonRealms.getJSONArray("realms"), Realm.class);
            for (Realm r : realmsArray) {
                System.out.println("SmsRestClient.getRealms(r): " + r.toString());
            }
        }
        catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        


        // Realm realm

        return null;
    }

    @Override
    public Realm createRealm(String realmName)
        throws MaxRealmReachedException
    {
        return null;
    }

    @Override
    public void modifyRealm(long realmId, String realmName)
        throws UnknownRealmIdException
    {

    }

    @Override
    public void deleteRealm(long realmId)
        throws UnknownRealmIdException
    {

    }

}
