package top.bluesword.maven.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 李林峰
 */
public class Version {

    private final List<Integer> versionNumber;

    private final String suffix;

    private Version(List<Integer> versionNumber, String suffix) {
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
        }
        return new Version(versionNumber,suffix);
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
}
