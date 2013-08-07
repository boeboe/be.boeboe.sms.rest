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

import java.net.URI;

import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

/**
 * Extension of a standard HTTP Delete message with support for attaching a HTTP body.
 */
@NotThreadSafe
public class HttpDeleteWithBody
    extends HttpEntityEnclosingRequestBase
{

    /** HTTP message signature: DELETE. */
    public static final String METHOD_NAME = "DELETE";

    @Override
    public String getMethod()
    {
        return METHOD_NAME;
    }

    /**
     * @param uri the URI to send this HTTP Delete towards.
     */
    public HttpDeleteWithBody(final String uri)
    {
        super();
        setURI(URI.create(uri));
    }

    /**
     * @param uri the URI to send this HTTP Delete towards.
     */
    public HttpDeleteWithBody(final URI uri)
    {
        super();
        setURI(uri);
    }

    /**
     * Default constructor.
     */
    public HttpDeleteWithBody()
    {
        super();
    }
}
