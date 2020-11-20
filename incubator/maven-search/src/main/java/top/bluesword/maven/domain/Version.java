package top.bluesword.maven.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 李林峰
 */
@Getter
public class Version implements Comparable<Version>{

    private final List<Integer> versionNumber;

    private final String suffix;

    Version(List<Integer> versionNumber, String suffix) {
        this.versionNumber = versionNumber;
        this.suffix = suffix;
    }

    public static Version parse(String versionText) {
        List<Integer> versionNumber = new ArrayList<>();
        boolean buildSuffix = false;
        StringBuilder numberBuilder = new StringBuilder();
        for (int i = 0; i < versionText.length(); i++) {
            char c = versionText.charAt(i);
            if (buildSuffix) {
                numberBuilder.append(c);
                continue;
            }
            if (c>='0' && c<='9') {
                numberBuilder.append(c);
            } else {
                versionNumber.add(Integer.valueOf(numberBuilder.toString()));
                numberBuilder = new StringBuilder();
                buildSuffix = c != '.';
                if (buildSuffix && c != '-') {
                    numberBuilder.append(c);
                }
            }
        }
        String suffix = null;
        if (buildSuffix) {
            suffix = numberBuilder.toString();
        } else {
            versionNumber.add(Integer.valueOf(numberBuilder.toString()));
        }
        return new Version(versionNumber,suffix);
    }

    public static String max(String v1,String v2) {
        return Version.parse(v1).compareTo(Version.parse(v2)) < 0 ? v2 : v1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(versionNumber.get(0));
        for (int i = 1; i < versionNumber.size(); i++) {
            builder.append('.').append(versionNumber.get(i));
        }
        if (Objects.nonNull(suffix)) {
            builder.append('-').append(suffix);
        }
        return builder.toString();
    }

    @Override
    public int compareTo(Version o) {
        List<Integer> oVersionNumber = o.getVersionNumber();
        for (int i = 0; i < this.versionNumber.size() && i < oVersionNumber.size(); i++) {
            int diff = this.versionNumber.get(i) - oVersionNumber.get(i);
            if (diff != 0) {
                return diff;
            }
        }
        int diff = this.versionNumber.size() - oVersionNumber.size();
        if (diff != 0) {
            return diff;
        }
        String oSuffix = o.getSuffix();
        if (Objects.isNull(this.suffix) && Objects.isNull(oSuffix)) {
            return 0;
        }
        if (Objects.isNull(this.suffix)) {
            return 1;
        }
        if (Objects.isNull(oSuffix)) {
            return -1;
        }
        return this.suffix.compareTo(oSuffix);
    }

}
