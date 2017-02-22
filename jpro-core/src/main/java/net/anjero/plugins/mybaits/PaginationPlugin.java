package net.anjero.plugins.mybaits;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;
import java.util.Properties;

/**
 * <pre>
 * add pagination using mysql limit.
 * This class is only used in ibator code generator.
 * </pre>
 */
public class PaginationPlugin extends PluginAdapter {
    private Logger log = Logger.getLogger(PaginationPlugin.class);

    public PaginationPlugin() {
        Properties properties = new Properties();
        properties.setProperty("log4j.rootCategory", "debug, R");
        properties.setProperty("log4j.appender.R", "org.apache.log4j.RollingFileAppender");
        //properties.setProperty("log4j.appender.R.File", "D:/mybatisGenerator.log");//the output file ,you can read from other config file
        properties.setProperty("log4j.appender.R.MaxFileSize", "1024000");//去掉K ,只忍数字
        properties.setProperty("log4j.appender.R.MaxBackupIndex", "2");
        properties.setProperty("log4j.appender.R.layout", "org.apache.log4j.PatternLayout");
        properties.setProperty("log4j.appender.R.layout.ConversionPattern", "%m%n");
        PropertyConfigurator.configure(properties);
    }

    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
                                              IntrospectedTable introspectedTable) {
        // add field, getter, setter for limit clause  
        addLimit(topLevelClass, introspectedTable, "limitStart");
        addLimit(topLevelClass, introspectedTable, "limitEnd");
        return super.modelExampleClassGenerated(topLevelClass,
                introspectedTable);
    }

    private String getBlank(int deep) {
        String s = "";
        for (int i = 0; i < deep; i++) {
            s += "   ";
        }
        return s;
    }

    private void printElement(Element element, int deep) {
        if (element instanceof XmlElement) {
            XmlElement element2 = (XmlElement) element;
            log.info(getBlank(deep) + "Element Name:" + element2.getName());
            deep += 1;
            for (Element c : element2.getElements()) {
                printElement(c, deep);
            }
            deep -= 1;
        } else {
            log.info(getBlank(deep) + "Element Type:" + element.getClass().getSimpleName());
        }

    }

    @Override
    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(
            XmlElement element, IntrospectedTable introspectedTable) {
        XmlElement isNotNullElement = new XmlElement("if"); //$NON-NLS-1$  
        isNotNullElement.addAttribute(new Attribute("test", "limitStart >= 0")); //$NON-NLS-1$ //$NON-NLS-2$  
        isNotNullElement.addElement(new TextElement("limit ${limitStart} , ${limitEnd}"));

        element.addElement(isNotNullElement);
        return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
    }

    private void addLimit(TopLevelClass topLevelClass,
                          IntrospectedTable introspectedTable, String name) {
        CommentGenerator commentGenerator = context.getCommentGenerator();
        Field field = new Field();
        field.setVisibility(JavaVisibility.PROTECTED);
        field.setType(FullyQualifiedJavaType.getIntInstance());
        field.setName(name);
        field.setInitializationString("-1");
        commentGenerator.addFieldComment(field, introspectedTable);
        topLevelClass.addField(field);
        char c = name.charAt(0);
        String camel = Character.toUpperCase(c) + name.substring(1);
        Method method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setName("set" + camel);
        method.addParameter(new Parameter(FullyQualifiedJavaType
                .getIntInstance(), name));
        method.addBodyLine("this." + name + "=" + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
        method = new Method();
        method.setVisibility(JavaVisibility.PUBLIC);
        method.setReturnType(FullyQualifiedJavaType.getIntInstance());
        method.setName("get" + camel);
        method.addBodyLine("return " + name + ";");
        commentGenerator.addGeneralMethodComment(method, introspectedTable);
        topLevelClass.addMethod(method);
    }

    /**
     * This plugin is always valid - no properties are required
     */
    public boolean validate(List<String> warnings) {
        return true;
    }

    public static void generate() {
        String config = PaginationPlugin.class.getClassLoader().getResource(
                "generatorConfiguration/mybatis_generator.xml").getFile();
        System.out.println(config);
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }

    public static void main(String[] args) {
        generate();
    }
}