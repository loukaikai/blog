/*package com.blog.util;

import org.mybatis.generator.api.PluginAdapter;

*//**
 * 避免MyBatiis重复生成的工具
 *
 * @author:wmyskxz
 * @create:2018-06-14-上午 9:50
 *//*
public class OverIsMergeablePlugin extends PluginAdapter {
    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean sqlMapGenerated(GeneratedXmlFile sqlMap, IntrospectedTable introspectedTable) {
        try {
            Field field = sqlMap.getClass().getDeclaredField("isMergeable");
            field.setAccessible(true);
            field.setBoolean(sqlMap, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
*/