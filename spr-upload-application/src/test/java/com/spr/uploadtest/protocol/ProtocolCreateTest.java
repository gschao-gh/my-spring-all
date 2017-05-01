package com.spr.uploadtest.protocol;

import com.spr.upload.ireport.service.LendingProtocolService;
import com.spr.upload.ireport.service.TransferProtocolService;

/**
 * @author gschao
 * @date 2016/12/22 16:40.
 */
public class ProtocolCreateTest {

    public static void main(String[] args) {
        TransferProtocolService transferProtocolService = new TransferProtocolService();
        LendingProtocolService lendingProtocolService = new LendingProtocolService();
        transferProtocolService.create();
        lendingProtocolService.create();
    }
}
