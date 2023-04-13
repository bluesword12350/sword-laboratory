package top.bluesword.laboratory.model.mock;


import top.bluesword.laboratory.model.Journey;

public class JourneyMock {

    public static Journey mock(){
        Journey journey = new Journey();
        journey.setTimeSpan(OffsetTimeSpanMock.mock());
        return journey;
    }

}
