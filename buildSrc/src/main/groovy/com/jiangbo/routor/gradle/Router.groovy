package com.jiangbo.routor.gradle


import org.gradle.api.Plugin
import org.gradle.api.Project

class Router implements Plugin<Project> {

    //实现 apply ，注入插件的逻辑
    @Override
    void apply(Project project) {
        println(" i am  root plugin ${project.name}")

        //2.注册
        project.getExtensions().create("router", RouterExtension)

        //配置阶段结束，才能拿到参数
        project.afterEvaluate {
            //4 获取
            RouterExtension extension = project["router"]
            println("  用户 设置的 lujing == " + extension.wikiDir)
        }


    }
}
