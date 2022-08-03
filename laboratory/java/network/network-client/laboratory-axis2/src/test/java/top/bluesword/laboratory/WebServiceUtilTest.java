package top.bluesword.laboratory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;

@Slf4j
class WebServiceUtilTest {

    @Test
    void sendWebServiceRequest() throws RemoteException {
        String resp = WebServiceUtil.request();
        log.info(resp);
    }
}