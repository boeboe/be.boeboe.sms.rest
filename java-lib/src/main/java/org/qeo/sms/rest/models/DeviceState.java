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
package org.qeo.sms.rest.models;

import java.util.Locale;

/**
 * Enumeration representation of the different enrollment states in which a device can be.
 */
public enum DeviceState {
    /** The device is not yet enrolled. An OTC might still be available to enroll this device. */
    CREATING,
    /** The device contacted the server, successfully enrolled a certificate and is Qeo ready. */
    ENROLLED,
    /** The device got revoked. It no longer can talk Qeo. */
    REVOKED,
    /** When the device failed to register itself with its OTC on the server. */
    CREATE_FAILED;

    @Override
    public String toString()
    {
        // only capitalize the first letter
        String s = super.toString();
        return s.substring(0, 1) + s.substring(1).toLowerCase(Locale.ENGLISH);
    }
}
