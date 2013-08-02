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

import org.qeo.sms.rest.exceptions.UnknownRealmIdException;
import org.qeo.sms.rest.exceptions.UnknownRealmUserException;
import org.qeo.sms.rest.models.Device;

/**
 * 
 */
public interface IDevice
{

    /**
     * Retrieve all devices within a realm of a Qeo Administrator.
     * 
     * @param realmId the id of the realm
     * @return a list of Devices
     */
    public ArrayList<Device> getDevices(long realmId);

    /**
     * Retrieve all devices from a certain user within a realm of a Qeo Administrator.
     * 
     * @param realmId the id of the realm
     * @param userId the id of the user
     * @return a list of Devices
     */
    public ArrayList<Device> getDevices(long realmId, long userId);
    
    /**
     * @param realmId the id the realm where the device is added
     * @param userId the id the user of which the device is added
     * @param deviceName the name of the device to be added
     * @return the new device
     * @throws UnknownRealmIdException when an unknown realm id is used
     * @throws UnknownRealmUserException when an unknown realm - user combination is used
     */
    public Device createDevice(long realmId, long userId, String deviceName)
        throws UnknownRealmIdException, UnknownRealmUserException;

    /**
     * @param realmId the id the realm where the device is modified
     * @param userId the id the user of which the device is modified
     * @param deviceId the id of the device to be modified
     * @param deviceName the new name of the modified device
     * @throws UnknownRealmIdException when an unknown realm id is used
     * @throws UnknownRealmUserException when an unknown realm - user combination is used
     */
    public void modifyDevice(long realmId, long userId, long deviceId, String deviceName)
        throws UnknownRealmIdException, UnknownRealmUserException;

    /**
     * @param realmId the id the realm where the device is deleted
     * @param userId the id the user of which the device is deleted
     * @param deviceId the id of the device to be deleted
     * @throws UnknownRealmIdException when an unknown realm id is used
     * @throws UnknownRealmUserException when an unknown realm - user combination is used
     */
    public void deleteDevice(long realmId, long userId, long deviceId)
        throws UnknownRealmIdException, UnknownRealmUserException;
}
