package groovy.json

import org.junit.jupiter.api.Test

class JsonSlurperTest {

    @Test
    void test(){
        def file = new File("data/test.json")
        def jsonSlurper = new JsonSlurper()
        def object = jsonSlurper.parse(file)
        print object[0].customer_order_no
    }

}
