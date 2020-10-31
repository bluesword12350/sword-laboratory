package org.mapdb.btree;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.jetbrains.annotations.NotNull;
import org.mapdb.DataInput2;
import org.mapdb.DataOutput2;
import org.mapdb.serializer.GroupSerializer;
import org.mapdb.serializer.GroupSerializerObjectArray;

import java.io.IOException;

public class TupleSerializer extends GroupSerializerObjectArray<Tuple> implements GroupSerializer<Tuple> {

    private final Schema<Tuple> schema = RuntimeSchema.getSchema(Tuple.class);

    @Override
    public void serialize(@NotNull DataOutput2 out, @NotNull Tuple value) throws IOException {
        LinkedBuffer buffer = LinkedBuffer.allocate(512);
        byte[] bytes = ProtostuffIOUtil.toByteArray(value, schema, buffer);
        out.packInt(bytes.length);
        out.write(bytes);
    }

    @Override
    public Tuple deserialize(@NotNull DataInput2 input, int available) throws IOException {
        int size = input.unpackInt();
        byte[] ret = new byte[size];
        input.readFully(ret);
        Tuple fooParsed = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(ret, fooParsed, schema);
        return fooParsed;
    }
}
