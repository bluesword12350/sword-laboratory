package top.bluesword.sequence;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 基于Twitter的SnowFlake算法的ID生成工具
 * @author 李林峰
 */
public class Snowflake {

    private final long dataCenterId;
    private final long workerId;
    private final long sequenceMask;
    private final int dataCenterIdShift;
    private final int sequenceShift;
    private final int timestampShift;
    private final int timestampStep;
    private long lastTimestamp = -1L;
    private long sequence = 0L;

    private final int sequenceBits;
    private final int workerIdBits;
    private final int dataCenterIdBits;

    private final long maxDataCenterId;
    private final long maxWorkerId;

    /**
     * @param sequenceBits 序列号二进制位数
     * @param dataCenterIdBits 数据中心ID二进制位数
     * @param workerIdBits 机器ID二进制位数
     * @param dataCenterId 数据中心ID
     * @param workerId 机器ID
     * @param timestampStep 时间戳步长（毫秒）
     */
    public Snowflake(int sequenceBits, int dataCenterIdBits, int workerIdBits,
                     long dataCenterId, long workerId, int timestampStep) {
        if (timestampStep<1) throw new RuntimeException("时间戳步长不可以小于1毫秒");
        this.timestampStep = timestampStep;
        this.maxDataCenterId = ~(-1L << dataCenterIdBits);
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new RuntimeException(String.format("数据中心ID不可以大于  %d 或小于 0", maxDataCenterId));
        }
        this.maxWorkerId = ~(-1L << workerIdBits);
        if (workerId > maxWorkerId || workerId < 0) {
            throw new RuntimeException(String.format("工作机器ID不可以大于  %d 或小于 0", maxWorkerId));
        }
        this.dataCenterId = dataCenterId;
        this.workerId = workerId;
        this.sequenceMask = ~(-1L << sequenceBits);
        this.dataCenterIdShift = workerIdBits;
        this.sequenceShift = dataCenterIdBits + workerIdBits;
        this.timestampShift = sequenceShift + sequenceBits;
        this.sequenceBits = sequenceBits;
        this.workerIdBits = workerIdBits;
        this.dataCenterIdBits = dataCenterIdBits;
    }

    /**
     * @param sequenceBits 序列号二进制位数
     * @param timestampStep 时间戳步长
     */
    public Snowflake(int sequenceBits, int timestampStep) {
        this(sequenceBits,0,0, 0,0,timestampStep);
    }

    /**
     * 基于Snowflake创建分布式ID生成器(单机部署)
     */
    public Snowflake() {
        this(1, 1);
    }

    public long getMaxDataCenterId() {
        return this.maxDataCenterId;
    }

    public long getMaxWorkerId() {
        return this.maxWorkerId;
    }

    /**
     * 获取ID
     * @return ID
     */
    public synchronized Long nextId() {
        long timestamp = getTimestamp();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("时间回退，请在 %d 秒后申请ID",lastTimestamp - timestamp));
        }
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) timestamp = getNextTimestamp();
        } else sequence = 0L;
        lastTimestamp = timestamp;
        return (((timestamp) << timestampShift) |
                (sequence<<sequenceShift) |
                (dataCenterId << dataCenterIdShift) |
                workerId)
                & (-1L >>> 1);
    }

    private long getTimestamp(){
        return System.currentTimeMillis()/timestampStep;
    }

    /**
     * 保证返回的时间在参数之后(阻塞直到获得新的时间戳)
     */
    private long getNextTimestamp() {
        long timestamp = getTimestamp();
        while (timestamp <= lastTimestamp) timestamp = getTimestamp();
        return timestamp;
    }

    public SnowflakeData parse(long snowflake){
        final int longBinarySize = 64;
        final long now = (System.currentTimeMillis() / timestampStep);
        final long dataCenterIdLeft = this.workerIdBits;
        final long sequenceLeft = dataCenterIdLeft+this.dataCenterIdBits;
        final long timestampLeft = sequenceLeft+this.sequenceBits;
        final long timestampSize = (longBinarySize-timestampLeft-1);
        final long start = now & (-1L<<timestampSize);
        final long end = start + (1L<<timestampSize);
        final long workerId = snowflake & (-1L>>>(longBinarySize-dataCenterIdLeft));
        final long dataCenterId = (snowflake & (-1L>>>(longBinarySize-sequenceLeft)))>>>dataCenterIdLeft;
        final long sequence = (snowflake & (-1L>>>(longBinarySize-timestampLeft)))>>>sequenceLeft;
        final Instant timestamp = Instant.ofEpochMilli(((snowflake>>>timestampLeft) | start)*timestampStep);
        return new SnowflakeData(sequence,workerId,dataCenterId,timestamp,Instant.ofEpochMilli(start*timestampStep),Instant.ofEpochMilli(end*timestampStep));
    }

    public static class SnowflakeData {

        private final long sequence;

        private final long workerId;

        private final long dataCenterId;

        private final ZonedDateTime timestamp;

        private final ZonedDateTime start;

        private final ZonedDateTime end;

        public SnowflakeData(long sequence, long workerId, long dataCenterId, Instant timestamp, Instant start, Instant end) {
            ZoneId zoneId = ZoneId.systemDefault();
            this.sequence = sequence;
            this.workerId = workerId;
            this.dataCenterId = dataCenterId;
            this.timestamp = ZonedDateTime.ofInstant(timestamp,zoneId);
            this.start = ZonedDateTime.ofInstant(start,zoneId);
            this.end = ZonedDateTime.ofInstant(end,zoneId);
        }

        @Override
        public String toString() {
            return "SnowflakeData{" +
                    "sequence=" + sequence +
                    ", workerId=" + workerId +
                    ", dataCenterId=" + dataCenterId +
                    ", timestamp=" + timestamp +
                    ", start=" + start +
                    ", end=" + end +
                    '}' ;
        }

        public long getSequence() {
            return sequence;
        }

        public long getWorkerId() {
            return workerId;
        }

        public long getDataCenterId() {
            return dataCenterId;
        }

        public ZonedDateTime getTimestamp() {
            return timestamp;
        }

        public ZonedDateTime getStart() {
            return start;
        }

        public ZonedDateTime getEnd() {
            return end;
        }
    }

}