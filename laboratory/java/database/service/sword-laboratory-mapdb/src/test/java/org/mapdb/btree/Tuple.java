package org.mapdb.btree;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
@AllArgsConstructor
public class Tuple implements Comparable<Tuple>{

    private String firstName;

    private String Name;

    private Integer age;

    @Override
    public int compareTo(@NotNull Tuple o) {
        return o.age-this.age;
    }
}
