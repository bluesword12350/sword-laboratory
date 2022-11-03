package groovy.json

import org.junit.jupiter.api.Test

class JsonSlurperTest {

    @Test
    void test(){
        def file = new File("D:\\workspace\\bluesword\\sword-laboratory\\laboratory\\groovy\\laboratory-groovy\\data\\2022-11-02推送数据.json")
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parse(file)
        print object[0].customer_order_no
    }

}
