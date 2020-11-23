package top.bluesword.maven.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class Version implements Comparable<Version>{

    private final String versionText;

    private final List<Integer> versionNumber;

    private final String suffix;

    private Version(String versionText) {
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
                if (numberBuilder.length() > 0) {
                    versionNumber.add(Integer.valueOf(numberBuilder.toString()));
                    numberBuilder = new StringBuilder();
                }
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
        this.versionText = versionText;
        this.versionNumber = versionNumber;
        this.suffix = suffix;
    }

    public static Version parse(String versionText) {
        return new Version(versionText);
    }

    public static String max(String v1,String v2) {
        return Version.parse(v1).compareTo(Version.parse(v2)) < 0 ? v2 : v1;
    }

    @Override
    public String toString() {
        return versionText;
    }

    private List<Integer> getVersionNumber() {
        return versionNumber;
    }

    private String getSuffix() {
        return suffix;
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
