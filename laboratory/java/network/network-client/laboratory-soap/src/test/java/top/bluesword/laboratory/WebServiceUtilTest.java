package top.bluesword.laboratory;

import org.junit.jupiter.api.Test;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class WebServiceUtilTest {

    @Test
    void sendWebServiceRequest() throws MalformedURLException, ServiceException, RemoteException {
        System.out.println(WebServiceUtil.sendWebServiceRequest());
    }
}