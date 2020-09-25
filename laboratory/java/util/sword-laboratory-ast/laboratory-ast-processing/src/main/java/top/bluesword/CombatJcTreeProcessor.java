package top.bluesword;

import com.sun.tools.javac.api.JavacTrees;
import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Names;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * JCTree实战注解处理器
 * @author hu_pf
 **/
@SupportedSourceVersion(SourceVersion.RELEASE_11)
@SupportedAnnotationTypes("top.bluesword.CombatJCTree")
public class CombatJcTreeProcessor extends AbstractProcessor {

    private Messager messager;
    private JavacTrees javacTrees;
    private TreeMaker treeMaker;
    private Names names;

    /**
     *  1. Message 主要是用来在编译时期打log用的
     *  2. JavacTrees 提供了待处理的抽象语法树
     *  3. TreeMaker 封装了创建AST节点的一些方法
     *  4. Names 提供了创建标识符的方法
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        messager.printMessage(Diagnostic.Kind.NOTE,"sword-test-build");
        this.javacTrees = JavacTrees.instance(processingEnv);
        Context context = ((JavacProcessingEnvironment)processingEnv).getContext();
        this.treeMaker = TreeMaker.instance(context);
        this.names = Names.instance(context);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(CombatJCTree.class);
        for (Element e : elementsAnnotatedWith) {
            JCTree tree = javacTrees.getTree(e);
            tree.accept(new TreeTranslator() {
                @Override
                public void visitClassDef(JCTree.JCClassDecl jcClassDecl) {

                    List<JCTree> jcTrees = generateParameters();
                    jcTrees.forEach(jcTree -> {
                        messager.printMessage(Diagnostic.Kind.NOTE, jcTree.getTree().toString());
                        jcClassDecl.defs = jcClassDecl.defs.prepend(jcTree);
                    });
                    super.visitClassDef(jcClassDecl);
                }
            });
        }
        return true;
    }

    private List<JCTree> generateParameters(){
        List<JCTree> jcTrees = new ArrayList<>();

        // 生成参数 例如：private String age
        JCTree.JCVariableDecl jcVariableDecl = treeMaker.VarDef(treeMaker.Modifiers(Flags.PRIVATE), names.fromString("age"), treeMaker.Ident(names.fromString("String")), null);

        /*
        生成方法  例如：public void getAge(){
                String name = "BuXueWuShu";
                return this.age;
        }
         */
        ListBuffer<JCTree.JCStatement> statements = new ListBuffer<>();
        // 创建一个new语句 CombatJCTreeMain jcTreeMain = new CombatJCTreeMain();
        JCTree.JCNewClass jcTreeMain = treeMaker.NewClass(
                null,
                // 泛型参数列表
                com.sun.tools.javac.util.List.nil(),
                // 创建的类名
                treeMaker.Ident(names.fromString("CombatJCTreeMain")),
                // 参数列表
                com.sun.tools.javac.util.List.nil(),
                null
        );
        JCTree.JCVariableDecl jcVariableDecl1 = treeMaker.VarDef(
                treeMaker.Modifiers(Flags.PARAMETER),
                names.fromString("jcTreeMain"),
                treeMaker.Ident(names.fromString("CombatJCTreeMain")),
                jcTreeMain
        );
        statements.append(jcVariableDecl1);
        // 创建一个方法调用 jcTreeMain.test()

        // 定义发方法体 i++
        statements.append(treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER),names.fromString("i"),treeMaker.Ident(names.fromString("Integer")),treeMaker.Literal(1)));
        statements.append(treeMaker.Exec(treeMaker.Unary(JCTree.Tag.PREINC,treeMaker.Ident(names.fromString("i")))));
        // 定义方法体 add = "a"+"b"
        statements.append(treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER),names.fromString("add"),treeMaker.Ident(names.fromString("String")),null));
        statements.append(treeMaker.Exec(treeMaker.Assign(treeMaker.Ident(names.fromString("add")),treeMaker.Binary(JCTree.Tag.PLUS,treeMaker.Literal("a"),treeMaker.Literal("b")))));
        //add += "test"
        statements.append(treeMaker.Exec(treeMaker.Assignop(JCTree.Tag.PLUS_ASG, treeMaker.Ident(names.fromString("add")), treeMaker.Literal("test"))));
        // 定义方法体 String name = "BuXueWuShu"
        statements.append(treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER),names.fromString("name"),treeMaker.Ident(names.fromString("String")),treeMaker.Literal("BuXueWuShu")));

        /*
            创建一个if语句
            if("BuXueWuShu".equals(name)){
                add = "a" + "b";
            }else{
                add += "test";
            }
         */
        // "BuXueWuShu".equals(name)
        JCTree.JCMethodInvocation apply = treeMaker.Apply(
                com.sun.tools.javac.util.List.nil(),
                treeMaker.Select(
                        // . 左边的内容
                        treeMaker.Literal("BuXueWuShu"),
                        // . 右边的内容
                        names.fromString("equals")
                ),
                com.sun.tools.javac.util.List.of(treeMaker.Ident(names.fromString("name")))
        );
        //  add = "a" + "b"
        JCTree.JCExpressionStatement exec3 = treeMaker.Exec(treeMaker.Assign(treeMaker.Ident(names.fromString("add")), treeMaker.Binary(JCTree.Tag.PLUS, treeMaker.Literal("a"), treeMaker.Literal("b"))));
        //  add += "test"
        JCTree.JCExpressionStatement exec1 = treeMaker.Exec(treeMaker.Assignop(JCTree.Tag.PLUS_ASG, treeMaker.Ident(names.fromString("add")), treeMaker.Literal("test")));

        JCTree.JCIf anIf = treeMaker.If(
                // if语句里面的判断语句
                apply,
                // 条件成立的语句
                exec3,
                // 条件不成立的语句
                exec1
        );

        statements.append(anIf);

        // 定义方法体 return this.age
        statements.append(treeMaker.Return(treeMaker.Select(treeMaker.Ident(names.fromString("this")),names.fromString("age"))));
        JCTree.JCBlock body = treeMaker.Block(0, statements.toList());
        // 组成方法，第一个参数意思是public，第二个参数是方法名getAge，第三个参数是方法返回类型String
        JCTree.JCMethodDecl jcMethodDecl = treeMaker.MethodDef(treeMaker.Modifiers(Flags.PUBLIC), names.fromString("getAge"), treeMaker.Ident(names.fromString("String")), com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), com.sun.tools.javac.util.List.nil(), body, null);

        /*
            无参无返回值的方法生成
            public void test(){

            }
         */
        // 定义方法体
        ListBuffer<JCTree.JCStatement> testStatement = new ListBuffer<>();
        JCTree.JCBlock testBody = treeMaker.Block(0, testStatement.toList());

        JCTree.JCMethodDecl test = treeMaker.MethodDef(
                // 方法限定值
                treeMaker.Modifiers(Flags.PUBLIC),
                // 方法名
                names.fromString("test"),
                // 返回类型
                treeMaker.Type(new Type.JCVoidType()),
                com.sun.tools.javac.util.List.nil(),
                com.sun.tools.javac.util.List.nil(),
                com.sun.tools.javac.util.List.nil(),
                testBody,
                null
        );


        /*
            无参无返回值的方法生成
            public void test2(String name){
                name = "xxxx";
            }
         */
        ListBuffer<JCTree.JCStatement> testStatement2 = new ListBuffer<>();
        testStatement2.append(treeMaker.Exec(treeMaker.Assign(treeMaker.Ident(names.fromString("name")),treeMaker.Literal("xxxx"))));
        JCTree.JCBlock testBody2 = treeMaker.Block(0, testStatement2.toList());

        // 生成入参
        JCTree.JCVariableDecl param = treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER), names.fromString("name"),treeMaker.Ident(names.fromString("String")), null);
        com.sun.tools.javac.util.List<JCTree.JCVariableDecl> parameters = com.sun.tools.javac.util.List.of(param);

        JCTree.JCMethodDecl test2 = treeMaker.MethodDef(
                // 方法限定值
                treeMaker.Modifiers(Flags.PUBLIC),
                // 方法名
                names.fromString("test2"),
                // 返回类型
                treeMaker.Type(new Type.JCVoidType()),
                com.sun.tools.javac.util.List.nil(),
                // 入参
                parameters,
                com.sun.tools.javac.util.List.nil(),
                testBody2,
                null
        );

        /*
            有参有返回值
            public String test3(String name){
               return name;
            }
         */

        ListBuffer<JCTree.JCStatement> testStatement3 = new ListBuffer<>();
        testStatement3.append(treeMaker.Return(treeMaker.Ident(names.fromString("name"))));
        JCTree.JCBlock testBody3 = treeMaker.Block(0, testStatement3.toList());

        // 生成入参
        JCTree.JCVariableDecl param3 = treeMaker.VarDef(treeMaker.Modifiers(Flags.PARAMETER), names.fromString("name"),treeMaker.Ident(names.fromString("String")), null);
        com.sun.tools.javac.util.List<JCTree.JCVariableDecl> parameters3 = com.sun.tools.javac.util.List.of(param3);

        JCTree.JCMethodDecl test3 = treeMaker.MethodDef(
                // 方法限定值
                treeMaker.Modifiers(Flags.PUBLIC),
                // 方法名
                names.fromString("test4"),
                // 返回类型
                treeMaker.Ident(names.fromString("String")),
                com.sun.tools.javac.util.List.nil(),
                // 入参
                parameters3,
                com.sun.tools.javac.util.List.nil(),
                testBody3,
                null
        );


        jcTrees.add(jcVariableDecl);
        jcTrees.add(test);
        jcTrees.add(test2);
        jcTrees.add(test3);
        jcTrees.add(jcMethodDecl);
        return jcTrees;
    }


}
