package com.spr.uploadtest.protocol;

import com.spr.upload.protocol.service.TransferProtocolService;

/**
 * @author gschao
 * @date 2016/12/22 16:40.
 */
public class ProtocolCreateTest {

    public static void main(String[] args) {
        TransferProtocolService transferProtocolService = new TransferProtocolService();
        transferProtocolService.create();
    }
}
