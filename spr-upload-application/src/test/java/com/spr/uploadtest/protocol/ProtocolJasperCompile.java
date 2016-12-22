package com.spr.uploadtest.protocol;

import com.spr.upload.protocol.reportutil.ReportUtils;

/**
 * @author gschao
 * @date 2016/12/21 14:24.
 */
public class ProtocolJasperCompile {

    public static void main(String[] args) {
        try {
            System.out.println(ReportUtils.convertJrxmltoJasper("classpath:"+"cgagreement.jrxml"));
            System.out.println(ReportUtils.convertJrxmltoJasper("classpath:"+"lending_services_agreement_stable.jrxml"));
            System.out.println(ReportUtils.convertJrxmltoJasper("classpath:"+"transferofclaimsAgreement_stable.jrxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
