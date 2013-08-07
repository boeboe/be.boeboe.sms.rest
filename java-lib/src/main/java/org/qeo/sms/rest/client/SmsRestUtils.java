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
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.qeo.sms.rest.exceptions.RestApiException;
import org.qeo.sms.rest.models.ApiError;


/**
 * Utility class with common methods used within SMS REST Client implementation.
 */
public final class SmsRestUtils
{
    private static final Log LOG = LogFactory.getLog("SmsRestUtils");

    /**
     * Default empty private constructor for utility class.
     */
    private SmsRestUtils()
    {
    }

    /**
     * Perform a REST/HTTP GET.
     * 
     * @param accessToken the OAUTH authentication token
     * @param uri the URI used within the REST call
     * @return JSONObject the JSON object retrieved by the GET
     * @throws RestApiException when the REST API returned a failure
     */
    public static JSONObject execRestGet(String accessToken, URI uri)
        throws RestApiException
    {
        final DefaultHttpClient httpClient;
        httpClient = new DefaultHttpClient();

        HttpGet request = new HttpGet(uri);
        request.addHeader("Accept", "application/json");
        request.addHeader("Authorization", "Bearer " + accessToken);

        HttpResponse response;
        try {
            response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                JSONObject jsonError = responseToJson(response);
                analyseJsonError(jsonError);
            }

            JSONObject json = responseToJson(response);
            httpClient.getConnectionManager().shutdown();
            return json;
        }
        catch (ClientProtocolException e1) {
            LOG.error("ClientProtocolException occured in execRestGet", e1);
        }
        catch (IOException e2) {
            LOG.error("IOException occured in execRestGet", e2);
        }

        httpClient.getConnectionManager().shutdown();
        LOG.error("Problem occured in execRestGet");
        return null;
    }

    /**
     * Perform a REST/HTTP POST.
     * 
     * @param accessToken the OAUTH authentication token
     * @param uri the URI used within the REST call
     * @param json the JSON body to be posted
     * @return JSONObject the JSON object retrieved by the POST
     * @throws RestApiException when the REST API returned a failure
     */
    public static JSONObject execRestPost(String accessToken, URI uri, JSONObject json)
        throws RestApiException
    {
        final DefaultHttpClient httpClient;
        httpClient = new DefaultHttpClient();

        HttpPost post = new HttpPost(uri);
        post.setHeader("Content-type", "application/json");
        post.addHeader("Authorization", "Bearer " + accessToken);

        try {
            post.setEntity(new StringEntity(json.toString(), "UTF8"));
            HttpResponse response = httpClient.execute(post);
            int status = response.getStatusLine().getStatusCode();

            if (!(status == HttpStatus.SC_CREATED || status == HttpStatus.SC_OK)) {
                JSONObject jsonError = responseToJson(response);
                analyseJsonError(jsonError);
            }

            JSONObject jsonReply = responseToJson(response);
            httpClient.getConnectionManager().shutdown();
            return jsonReply;
        }
        catch (UnsupportedEncodingException e1) {
            LOG.error("UnsupportedEncodingException occured in execRestPost", e1);
        }
        catch (ClientProtocolException e2) {
            LOG.error("ClientProtocolException occured in execRestPost", e2);
        }
        catch (IOException e3) {
            LOG.error("IOException occured in execRestPost", e3);
        }

        httpClient.getConnectionManager().shutdown();
        LOG.error("Problem occured in execRestPost");
        return null;
    }

    /**
     * Perform a REST/HTTP DELETE.
     * 
     * @param accessToken the OAUTH authentication token
     * @param uri the URI used within the REST call
     * @throws RestApiException when the REST API returned a failure
     */
    public static void execRestDelete(String accessToken, URI uri)
        throws RestApiException
    {
        final DefaultHttpClient httpClient;
        httpClient = new DefaultHttpClient();

        HttpDelete delete = new HttpDelete(uri);
        delete.setHeader("Content-type", "application/json");
        delete.addHeader("Authorization", "Bearer " + accessToken);

        HttpResponse response;
        try {
            response = httpClient.execute(delete);
            int status = response.getStatusLine().getStatusCode();

            if (status != HttpStatus.SC_OK) {
                JSONObject jsonError = responseToJson(response);
                analyseJsonError(jsonError);
            }
        }
        catch (ClientProtocolException e1) {
            LOG.error("ClientProtocolException occured in execRestDelete", e1);
        }
        catch (IOException e2) {
            LOG.error("IOException occured in execRestDelete", e2);
        }

        httpClient.getConnectionManager().shutdown();
    }

    /**
     * Perform a REST/HTTP DELETE with a HTTP body (not standard !!!).
     * 
     * @param accessToken the OAUTH authentication token
     * @param uri the URI used within the REST call
     * @param json the JSON body to be attached to the HTTP DELETE
     * @throws RestApiException when the REST API returned a failure
     */
    public static void execRestDeleteWithJson(String accessToken, URI uri, JSONObject json)
        throws RestApiException
    {
        final DefaultHttpClient httpClient;
        httpClient = new DefaultHttpClient();

        HttpDeleteWithBody delete = new HttpDeleteWithBody(uri);
        delete.setHeader("Content-type", "application/json");
        delete.addHeader("Authorization", "Bearer " + accessToken);

        try {
            delete.setEntity(new StringEntity(json.toString(), "UTF8"));
            HttpResponse response = httpClient.execute(delete);
            int status = response.getStatusLine().getStatusCode();

            if (status != HttpStatus.SC_OK) {
                JSONObject jsonError = responseToJson(response);
                analyseJsonError(jsonError);
            }
        }
        catch (UnsupportedEncodingException e1) {
            LOG.error("UnsupportedEncodingException occured in execRestDeleteWithJson", e1);
        }
        catch (ClientProtocolException e2) {
            LOG.error("ClientProtocolException occured in execRestDeleteWithJson", e2);
        }
        catch (IOException e3) {
            LOG.error("IOException occured in execRestDeleteWithJson", e3);
        }

        httpClient.getConnectionManager().shutdown();
    }

    /**
     * Analyze the JSON representation of the fault error returned on a certain REST Call and throw a proper exception.
     * 
     * @param jsonError
     * @throws RestApiException when a Rest API error value is returned
     */
    private static void analyseJsonError(JSONObject jsonError)
        throws RestApiException
    {
        ApiError restApiError;
        try {
            restApiError = new ApiError(jsonError);
            throw new RestApiException(restApiError.getStatus(), restApiError.getCode(), restApiError.getMessage());
        }
        catch (JSONException e) {
            LOG.error("JSONException occured in analyseJsonError", e);
        }
    }

    /**
     * Convert a HttpResponse Object to a JSON Object.
     * 
     * @param response the HttpResponse object.
     * @return JSON representation of the response body.
     */
    private static JSONObject responseToJson(HttpResponse response)
    {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream inputStream;
            try {
                inputStream = entity.getContent();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder stringBuilder = new StringBuilder();

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line);
                    }

                    String output = stringBuilder.toString();
                    JSONObject jsonReply = new JSONObject(output);

                    inputStream.close();
                    inputStreamReader.close();
                    bufferedReader.close();
                    return jsonReply;
                }
                catch (JSONException e1) {
                    LOG.error("JSONException occured in responseToJson", e1);
                }
                finally {
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStream.close();
                }
            }
            catch (IllegalStateException e2) {
                LOG.error("IllegalStateException occured in responseToJson", e2);
            }
            catch (IOException e3) {
                LOG.error("IOException occured in responseToJson", e3);
            }

        }
        return null;
    }

    /**
     * A helper method to convert JSONArrays to an array of objects of Class clazz.
     * 
     * @param jsonArray the JSONArray to convert
     * @param clazz the class of the target object for the JSON element
     * @param <K> whatever, check style is buggy
     * @return clazzArray and array of Objects from type clazz
     */
    @SuppressWarnings("unchecked")
    public static <K> ArrayList<K> getObjectArray(JSONArray jsonArray, Class<K> clazz)
    {
        K[] result = (K[]) Array.newInstance(clazz, jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                result[i] = clazz.getConstructor(JSONObject.class).newInstance(jsonArray.getJSONObject(i));
            }
            catch (InstantiationException e1) {
                LOG.error("InstantiationException occured in getObjectArray", e1);
            }
            catch (IllegalAccessException e2) {
                LOG.error("IllegalAccessException occured in getObjectArray", e2);
            }
            catch (IllegalArgumentException e3) {
                LOG.error("IllegalArgumentException occured in getObjectArray", e3);
            }
            catch (InvocationTargetException e4) {
                LOG.error("InvocationTargetException occured in getObjectArray", e4);
            }
            catch (NoSuchMethodException e5) {
                LOG.error("NoSuchMethodException occured in getObjectArray", e5);
            }
            catch (SecurityException e6) {
                LOG.error("SecurityException occured in getObjectArray", e6);
            }
            catch (JSONException e7) {
                LOG.error("JSONException occured in getObjectArray", e7);
            }
        }
        return new ArrayList<K>(Arrays.asList(result));
    }
}
