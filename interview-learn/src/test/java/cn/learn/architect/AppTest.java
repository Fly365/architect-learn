package cn.learn.architect;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2019年-06月-24日
 */
public class AppTest {

    public static void main(String[] args) {
        //System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        //1、创建ProcessEngineConfiguration实例,该实例可以配置与调整流程引擎的设置
        ProcessEngineConfiguration cfg=new StandaloneProcessEngineConfiguration()
                //2、通常采用xml配置文件创建ProcessEngineConfiguration，这里直接采用代码的方式
                //3、配置数据库相关参数
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable_learn?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2b8&nullCatalogMeansCurrent=true")
                .setJdbcUsername("root")
                .setJdbcPassword("admin")
                .setJdbcDriver("com.mysql.cj.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        //4、初始化ProcessEngine流程引擎实例
        ProcessEngine processEngine=cfg.buildProcessEngine();

    }

}
