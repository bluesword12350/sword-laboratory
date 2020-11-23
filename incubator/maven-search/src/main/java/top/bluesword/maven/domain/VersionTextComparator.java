package top.bluesword.maven.domain;

import java.util.Comparator;

/**
 * @author 李林峰
 */
public class VersionTextComparator implements Comparator<String> {

    @Override
    public int compare(String v1, String v2) {
        return Version.parse(v1).compareTo(Version.parse(v2));
    }

}
