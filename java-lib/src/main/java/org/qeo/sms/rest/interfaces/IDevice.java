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
package org.qeo.sms.rest.interfaces;

import java.util.ArrayList;

import org.qeo.sms.rest.exceptions.RestApiException;
import org.qeo.sms.rest.models.Device;

/**
 * Interface defining the methods applicable on a Device.
 */
public interface IDevice
{

    /**
     * Retrieve all devices within a realm of a Qeo Administrator.
     * 
     * @param realmId the id of the realm
     * @return a list of Devices
     * @throws RestApiException when an error occurred
     */
    ArrayList<Device> getDevices(long realmId)
        throws RestApiException;

    /**
     * Retrieve all devices from a certain user within a realm of a Qeo Administrator.
     * 
     * @param realmId the id of the realm
     * @param userId the id of the user
     * @return a list of Devices
     * @throws RestApiException when an error occurred
     */
    ArrayList<Device> getDevices(long realmId, long userId)
        throws RestApiException;

    /**
     * Create a device within a certain realm for a certain user.
     * 
     * @param realmId the id the realm where the device is added
     * @param userId the id the user of which the device is added
     * @param deviceName the name of the device to be added
     * @return the new device
     * @throws RestApiException when an error occurred
     */
    Device createDevice(long realmId, long userId, String deviceName)
        throws RestApiException;

    /**
     * Modify a device within a certain realm for a certain user.
     * 
     * @param realmId the id the realm where the device is modified
     * @param userId the id the user of which the device is modified
     * @param deviceId the id of the device to be modified
     * @param deviceName the new name of the modified device+
     * @return the modified device
     * @throws RestApiException when an error occurred
     */
    Device modifyDevice(long realmId, long userId, long deviceId, String deviceName)
        throws RestApiException;

    /**
     * Delete a device within a certain realm for a certain user.
     * 
     * @param realmId the id the realm where the device is deleted
     * @param userId the id the user of which the device is deleted
     * @param deviceId the id of the device to be deleted
     * @throws RestApiException when an error occurred
     */
    void deleteDevice(long realmId, long userId, long deviceId)
        throws RestApiException;
}
