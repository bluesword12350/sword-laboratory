package top.bluesword.laboratory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TimeZoneColumn;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import java.time.OffsetDateTime;

/**
 * 带偏移量的时间跨度
 * @author 李林峰
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffsetTimeSpan {

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "start_time_offset")
    private OffsetDateTime startTime;

    @TimeZoneStorage(TimeZoneStorageType.COLUMN)
    @TimeZoneColumn(name = "end_time_offset")
    private OffsetDateTime endTime;

}
