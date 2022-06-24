package top.bluesword.laboratory.mock;

import top.bluesword.laboratory.domain.*;
import top.bluesword.laboratory.domain.person.PersonSummary;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public final class DataModelMock {

    public static DataModel mock() {
        DataModel dataModel = new DataModel();
        dataModel.setCode("code");
        dataModel.setName("name1");
        dataModel.setType(TypeEnum.CANDIDATE);
        dataModel.setDate(Instant.now());
        dataModel.setContext(mockContext());
        dataModel.setOwner(mockOwner());
        return dataModel;
    }

    private static PersonSummary mockOwner() {
        PersonSummary personSummary = new PersonSummary();
        personSummary.setName("龙仔");
        personSummary.setIdentityCode("1321564");
        return personSummary;
    }

    public static DataContext mockContext() {
        DataContext dataContext = new DataContext();
        dataContext.setBriefIntroduction("基本数据模型");
        dataContext.setFragments(mockFormatList());
        return dataContext;
    }

    public static List<DataFragment> mockFormatList() {
        List<DataFragment> fragments = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            fragments.add(mockFormat(i));
        }
        return fragments;
    }

    public static DataFragment mockFormat(int i) {
        DataFragment dataFragment = new DataFragment();
        dataFragment.setTitle("简介");
        dataFragment.setContent("第"+i+"个片段");
        dataFragment.setIndex(i);
        dataFragment.setExternalLinks(mockExternalLinks());
        return dataFragment;
    }

    private static List<ExternalLink> mockExternalLinks() {
        List<ExternalLink> externalLinks = new ArrayList<>();
        ExternalLink externalLink = new ExternalLink();
        externalLink.setName("外链");
        externalLink.setUrl("https://external.link");
        externalLinks.add(externalLink);
        return externalLinks;
    }

}
