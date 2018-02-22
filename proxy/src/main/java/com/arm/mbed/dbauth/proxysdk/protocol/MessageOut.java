// ----------------------------------------------------------------------------
//   The confidential and proprietary information contained in this file may
//   only be used by a person authorized under and to the extent permitted
//   by a subsisting licensing agreement from ARM Limited or its affiliates.
//
//          (C)COPYRIGHT 2018 ARM Limited or its affiliates.
//              ALL RIGHTS RESERVED
//
//   This entire notice must be reproduced on all copies of this file
//   and copies of this file may only be made by a person if such person is
//   permitted to do so under the terms of a subsisting license agreement
//   from ARM Limited or its affiliates.
// ----------------------------------------------------------------------------
package com.arm.mbed.dbauth.proxysdk.protocol;

import com.upokecenter.cbor.CBORObject;

public class MessageOut {

    private final MessageTypeEnum type;
    protected final byte[] payload;

    protected MessageOut(MessageTypeEnum type) {
        this.type = type;
        this.payload = null;
    }

    protected MessageOut(MessageTypeEnum type, byte[] payload) {
        this.type = type;
        this.payload = payload;
    }

    public byte[] getEncoded() {
        CBORObject cborPayload = CBORObject.NewArray().Untag();
        cborPayload.Add(CBORObject.FromObject(type.getValue()).Untag());
        if (null != payload) {
            cborPayload.Add(CBORObject.FromObject(payload).Untag());
        }
        return cborPayload.EncodeToBytes();
    }

}
