package top.bluesword.web.laboratory.mock;

import top.bluesword.web.laboratory.domain.DataFragment;
import top.bluesword.web.laboratory.domain.DataModel;
import top.bluesword.web.laboratory.domain.TypeEnum;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public final class DataModelMock {

    public static DataModel mock() {
        DataModel dataModel = new DataModel();
        dataModel.setKey("key%");
        dataModel.setName("name1");
        dataModel.setType(TypeEnum.CANDIDATE);
        dataModel.setDate(Instant.now());
        dataModel.setFragments(mockFormatList());
        return dataModel;
    }

    public static List<DataFragment> mockFormatList() {
        List<DataFragment> fragments = new ArrayList<>();
        fragments.add(mockFormat());
        return fragments;
    }

    private static DataFragment mockFormat() {
        DataFragment dataFragment = new DataFragment();
        dataFragment.setTitle("简介");
        dataFragment.setContent("第一个片段");
        dataFragment.setIndex(1);
        return dataFragment;
    }

}
