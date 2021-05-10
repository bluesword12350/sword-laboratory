package top.bluesword.jdk.internal.org.objectweb.asm;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;

class ClassWriterTest {

    @Test
    void test() throws IOException {
        writeAsmSumOfTwoNumbers();
        writeAsmMain();
    }

    private void writeAsmSumOfTwoNumbers() throws IOException {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"AsmSumOfTwoNumbers", null, "java/lang/Object", null);
        {
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL,"java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            // 添加方法；修饰符、方法名、描述符、签名、异常
            MethodVisitor methodVisitor=classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sum", "(II)I", null, null);
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 2);
            methodVisitor.visitInsn(Opcodes.IADD);
            // 返回
            methodVisitor.visitInsn(Opcodes.IRETURN);
            // 设置操作数栈的深度和局部变量的大小
            methodVisitor.visitMaxs(2, 3);
            methodVisitor.visitEnd();
        }
        // 类完成
        classWriter.visitEnd();
        FileOutputStream fileOutputStream = new FileOutputStream("target/AsmSumOfTwoNumbers.class");
        try(fileOutputStream) {
            fileOutputStream.write(classWriter.toByteArray());
        }
    }

    private void writeAsmMain() throws IOException {
        ClassWriter classWriter = new ClassWriter(0);
        // 定义对象头；版本号、修饰符、全类名、签名、父类、实现的接口
        classWriter.visit(Opcodes.V11, Opcodes.ACC_PUBLIC,"AsmMain", null, "java/lang/Object", null);
        {
            // 添加方法；修饰符、方法名、描述符、签名、异常
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            // 执行指令；获取静态属性
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System","out", "Ljava/io/PrintStream;");
            // 加载常量 load constant
            methodVisitor.visitLdcInsn("你好，ASM。");
            // 调用方法
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

            // 创建对象
            methodVisitor.visitTypeInsn(Opcodes.NEW, "AsmSumOfTwoNumbers");
            methodVisitor.visitInsn(Opcodes.DUP);
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL,"AsmSumOfTwoNumbers", "<init>", "()V", false);

            methodVisitor.visitLdcInsn(15);
            methodVisitor.visitLdcInsn(16);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"AsmSumOfTwoNumbers","sum","(II)I",false);
            // 变量赋值
            methodVisitor.visitVarInsn(Opcodes.ISTORE, 1);

            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System","out", "Ljava/io/PrintStream;");
            // 加载变量
            methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL,"java/io/PrintStream", "println", "(I)V", false);

            // 返回
            methodVisitor.visitInsn(Opcodes.RETURN);
            // 设置操作数栈的深度和局部变量的大小
            methodVisitor.visitMaxs(3, 2);
            // 方法结束
            methodVisitor.visitEnd();
        }
        // 类完成
        classWriter.visitEnd();
        // 生成字节数组
        FileOutputStream fileOutputStream = new FileOutputStream("target/AsmMain.class");
        try(fileOutputStream) {
            fileOutputStream.write(classWriter.toByteArray());
        }
    }

}
