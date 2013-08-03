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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 
 */
public class SmsRestUtils
{

    public static JSONObject execRestGet(String accessToken, URI uri)
    {
        final DefaultHttpClient httpClient;
        httpClient = new DefaultHttpClient();

        // HttpHost proxy = new HttpHost("127.0.0.1", 3128);
        // httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);

        HttpGet request = new HttpGet(uri);
        request.addHeader("Accept", "application/json");
        request.addHeader("Authorization", "Bearer " + accessToken);

        try {
            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new RuntimeException("Unexpected server response " + response.getStatusLine() + " for "
                    + request.getRequestLine());
            }

            InputStream inputStream = response.getEntity().getContent();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

            String output = stringBuilder.toString();
            JSONObject json = new JSONObject(output);
            httpClient.getConnectionManager().shutdown();
            return json;
        }
        catch (IOException e) {
            httpClient.getConnectionManager().shutdown();
            throw new RuntimeException("Problem reading remote response for " + request.getRequestLine(), e);
        }
        catch (JSONException e) {
            httpClient.getConnectionManager().shutdown();
            throw new RuntimeException("Problem JSONParsing remote response for " + request.getRequestLine(), e);
        }
    }

    /**
     * A helper method to convert JSONArrays to ObjectArrays of Class clazz.
     * 
     * @param jsonArray the JSONArray to convert
     * @return clazzArray and array of Objects from type clazz
     * @throws JSONException exception during JSON parsing
     */
    @SuppressWarnings("unchecked")
    public static <K> ArrayList<K> getObjectArray(JSONArray jsonArray, Class<K> clazz)
    {
        K[] result = (K[]) Array.newInstance(clazz, jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                result[i] = clazz.getConstructor(JSONObject.class).newInstance(jsonArray.getJSONObject(i));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<K>(Arrays.asList(result));
    }
}
