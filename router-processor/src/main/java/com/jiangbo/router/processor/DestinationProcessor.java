package com.jiangbo.router.processor;

import com.google.auto.service.AutoService;
import com.jiangbo.router.annotations.Destination;

import java.io.Writer;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 * 项目名称：DBAndroid
 * 类描述：
 *
 * @auther jiangbo
 * 创建时间：2021-03-28
 */
@AutoService(Processor.class)
public class DestinationProcessor extends AbstractProcessor {


    private static final String TAG = DestinationProcessor.class.getSimpleName();

    /**
     * 编译器找到我们关心的注解 之后会 回掉当前的 方法
     *
     * @param set              编译器 帮我们手机到的注解信息
     * @param roundEnvironment 当前的 编译器环境
     * @return
     */

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            return false;
        }
        System.out.println(TAG + "          =======    start    ");

        //获取 所有 标记了 Destination  注解的类的信息
        Set<Element> allDestationElement = (Set<Element>) roundEnvironment.getElementsAnnotatedWith(Destination.class);

        System.out.println(TAG + "     ===== allDestationElement size is  " + allDestationElement.size());

        //没有收集到 信息 ，返回false
        if (allDestationElement.size() < 1) {
            return false;
        }


        // 生成的类名字
        String className = "RouterMapping_" + System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();

        builder.append("package com.jiangbo.mygradle.mapping;\n\n");
        builder.append("import java.util.HashMap;\n\n");
        builder.append("import java.util.Map;\n\n");
        builder.append("public class ").append(className).append(" { \n\n");

        builder.append("     public static Map<String, String> get() {\n\n");
        builder.append("        Map<String, String> mapping = new HashMap<>();\n\n");


        // 便利所有的注解信息，挨个获取详细的信息
        for (Element element : allDestationElement) {
            final TypeElement typeElement = (TypeElement) element;
            //尝试在当前类上面获取 注解信息
            final Destination destination = typeElement.getAnnotation(Destination.class);

            if (destination == null) {
                continue;
            }


            final String url = destination.url();
            final String description = destination.description();
            //拿到当前注解处理器的全类名字
            final String realPath = typeElement.getQualifiedName().toString();

            System.out.println(TAG + "      =========     " + "url    === " + url
                    + "    description=====  " + description + "realPath ==== " + realPath);


            builder.append("        mapping.put(")
                    .append("\"" + url + "\"")
                    .append(",")
                    .append("\"" + realPath + "\"")
                    .append(");\n\n");


        }

        builder.append("        return mapping;\n\n");
        builder.append("     }\n\n");
        builder.append("  }\n\n");


        String mappingFullClassName = "com.jiangbo.router.mapping." + className;
        System.out.println(TAG + "===== mappingFullClassName =====" + mappingFullClassName);
        System.out.println(TAG + "===== class Content =====\n" + builder);
        //写入 自动生成的 类的文件中

        try {
            JavaFileObject source = processingEnv.getFiler().createSourceFile(mappingFullClassName);
            Writer writer = source.openWriter();
            writer.write(builder.toString());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException("error create file");
        }

        System.out.println(TAG + "===== finish =====");
        return false;
    }

    /**
     * 告诉编译器 ，当前注解处理器支持的注解类型
     *
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Collections.singleton(Destination.class.getCanonicalName());
    }
}
