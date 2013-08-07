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
package org.qeo.sms.rest.exceptions;

/**
 * Exception thrown when a certain REST call returned with an error code.
 */
public class RestApiException
    extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * Exception thrown when a certain REST call returned with an error code.
     * 
     * @param status this parameter follows the HTTP error code returned by the server
     * @param code this parameter provides a more fine grained error specification
     * @param message human readable string associated with the error code
     */
    public RestApiException(int status, int code, String message)
    {
        super("RestApiException (status:" + status + ",code:" + code + ") occured: " + message);
    }
}
