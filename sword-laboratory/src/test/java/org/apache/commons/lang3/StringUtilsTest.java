package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;

/**
 * @author 李林峰
 */
class StringUtilsTest {

    @Test
    void join(){
        System.out.println(StringUtils.join("","asf", null, "123","5648"));
        System.out.println(StringUtils.join( null,null,null));
    }

}
