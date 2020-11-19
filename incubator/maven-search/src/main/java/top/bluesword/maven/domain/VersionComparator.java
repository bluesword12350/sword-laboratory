package top.bluesword.maven.domain;

import java.util.Comparator;

/**
 * @author 李林峰
 */
public class VersionComparator implements Comparator<Version> {

    @Override
    public int compare(Version o1, Version o2) {
        return o1.compareTo(o2);
    }

}
