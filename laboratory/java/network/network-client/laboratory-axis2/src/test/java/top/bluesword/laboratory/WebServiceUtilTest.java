package top.bluesword.laboratory;

import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

class WebServiceUtilTest {

    @Test
    void sendWebServiceRequest() throws RemoteException {
        System.out.println(WebServiceUtil.request());
    }
}