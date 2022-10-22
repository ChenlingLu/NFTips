package io.nftips.kunpeng.orm.generator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import io.nftips.kunpeng.orm.entity.BaseEntity;

import java.util.Collections;

/**
 * @author zhoujunwen
 * @date 2022-09-2022/9/19 下午3:45
 **/
public class CodeGenerator {

    public static void main(String[] args) {
        DataSourceConfig.Builder dcb = new DataSourceConfig.Builder("jdbc:mysql://gateway01.us-west-2.prod.aws.tidbcloud.com:4000/kunpeng?useSSL=false&enabledTLSProtocols=TLSv1.2,TLSv1.3&useOldAliasMetadataBehavior=true&useUnicode=true&characterEncoding=utf-8","2devWAbVPi2zf2g.root", "Mohuang@Youwo")
                .dbQuery(new MySqlQuery())
                .schema("kunpeng")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());

        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        FastAutoGenerator generator = FastAutoGenerator
                .create(dcb)
                .globalConfig(builder -> {
                    builder.author("zhoujunwen") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir() //禁止打开输出目录
                            .dateType(DateType.TIME_PACK)
                            .commentDate("yyyy-MM-dd HH:ss:mm")
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("io.nftips.kunpeng.orm") // 设置父包名
                            .moduleName("") // 设置父包模块名
                            .entity("entity") //设置entity包名
                            .other("dto") // 设置dto包名
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath  + "/src/main/resources/mapper")); // 设置mapperXml生成路径

                })
                .templateConfig(builder -> {
                })
                /*.injectionConfig(consumer -> {
                    Map<String, String> customFile = new HashMap<>();
                    // mapper
                    customFile.put("mapper.xml", "/templates/mapper.xml.ftl");
                    consumer.customFile(customFile);
                })*/
                .strategyConfig(builder -> {
                    builder.enableCapitalMode()
                            .enableSkipView()
                            .disableSqlFilter()
                            /*.likeTable(new LikeTable("USER"))
                            .addInclude("t_simple")
                            .addTablePrefix("t_", "c_")
                            .addFieldSuffix("_flag")*/
                            // 实体策略配置
                            .entityBuilder()
                            .superClass(BaseEntity.class)
                            //.disableSerialVersionUID()
                            //.enableChainModel()
                            .enableLombok()
                            //.enableRemoveIsPrefix()
                            .enableTableFieldAnnotation()
                            // .enableActiveRecord()
                            //.versionColumnName("version")
                            //.versionPropertyName("version")
                            //.logicDeleteColumnName("deleted")
                            //.logicDeletePropertyName("deleteFlag")
                            .naming(NamingStrategy.underline_to_camel)
                            .columnNaming(NamingStrategy.underline_to_camel)
                            .addSuperEntityColumns("gmtCreate", "gmtModify")
                            //.addIgnoreColumns("age")
                            .addTableFills(new Column("gmt_create", FieldFill.INSERT))
                            .addTableFills(new Property("gmtModify", FieldFill.INSERT_UPDATE))
                            .idType(IdType.AUTO)
                            .formatFileName("%sEntity")
                            // 控制器策略配置
                            .controllerBuilder()
                            //.superClass(BaseController.class)
                            .enableHyphenStyle()
                            .enableRestStyle()
                            .formatFileName("%sController2")
                            // mapper策略配置
                            .mapperBuilder()
                            .superClass(BaseMapper.class)
                            .enableMapperAnnotation()
                            .enableBaseResultMap()
                            .enableBaseColumnList()
                            .formatMapperFileName("%sMapper2")
                            .formatXmlFileName("%sMapper2")
                            // service策略配置
                            .serviceBuilder()
                            .superServiceClass(IService.class)
                            .superServiceImplClass(ServiceImpl.class)
                            .formatServiceFileName("%sService2")
                            .formatServiceImplFileName("%sServiceImpl2")
                            .build();
                });

        generator.execute();
    }
}
