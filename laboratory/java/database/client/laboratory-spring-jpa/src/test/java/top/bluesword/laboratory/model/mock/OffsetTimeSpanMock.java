package top.bluesword.laboratory.model.mock;

import top.bluesword.laboratory.model.OffsetTimeSpan;

import java.time.OffsetDateTime;

public class OffsetTimeSpanMock {

    public static OffsetTimeSpan mock(){
        return new OffsetTimeSpan(
                OffsetDateTime.now(),
                OffsetDateTime.now()
        );
    }
}
