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

import java.util.ArrayList;

/**
 * 
 */
public class Policy
{
    private final ArrayList<Rule> mRules;

    /**
     * @param rules the rules of a policy
     */
    public Policy(ArrayList<Rule> rules)
    {
        mRules = rules;
    }

    /**
     * @return the Rules
     */
    public ArrayList<Rule> getRules()
    {
        return mRules;
    }
}
