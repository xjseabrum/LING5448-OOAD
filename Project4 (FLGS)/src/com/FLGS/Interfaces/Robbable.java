// This interface is used to allow the Store class to
// be able to be robbed.

package com.FLGS.Interfaces;

import com.FLGS.Utils.StoreUtils;

public interface Robbable {

    StoreUtils.Record rob(StoreUtils.Record record);
    void settleInsurance(StoreUtils.Record record);
}
