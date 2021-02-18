package top.bluesword.maven.api;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import top.bluesword.maven.domain.Pack;
import top.bluesword.maven.domain.Pom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李林峰
 */
public class PomParser {

    public static Pom parse(String pomXml) throws DocumentException {
        Document document = DocumentHelper.parseText(pomXml);
        List<Element> dependenciesPom = document.getRootElement().element("dependencies").elements("dependency");
        List<Pack> dependencies = new ArrayList<>();
        for (Element dependency : dependenciesPom) {
            Pack pack = Pack.builder()
                    .groupId(dependency.elementText("groupId"))
                    .artifactId(dependency.elementText("artifactId"))
                    .version(dependency.elementText("version"))
                    .build();
            dependencies.add(pack);
        }
        return Pom.builder()
                .dependencies(dependencies)
                .build();
    }

}
