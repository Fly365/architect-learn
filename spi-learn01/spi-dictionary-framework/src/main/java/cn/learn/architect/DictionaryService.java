package cn.learn.architect;

import cn.learn.architect.spi.Dictionary;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * @author Fly365
 * @date 2022-04-02
 */
public class DictionaryService {

    private static DictionaryService service;

    private ServiceLoader<Dictionary> loader;

    private DictionaryService(){
        //ServiceLoader是Java原生api的重要入口类
        // 其入参是一个接口，返回的ServiceLoader<Dictionary> loader可以加载出其实现类的实例
        loader = ServiceLoader.load(Dictionary.class);
    }

    /**实现单例*/
    public static synchronized DictionaryService getInstance(){
        if(service == null){
            service = new DictionaryService();
        }
        return service;
    }

    /**
     * 扫描 目录META-INF/services/dictionary.spi.Dictionary下描述的
     * 所有的 Dictionary 的实现类，依次查找入参的 word
     * 其中目录层级META-INF/services是 java spi 默认约定的目录
     */
    public String getDefinition(String world){
        String definition = null;
        Iterator<Dictionary> dictionaries = loader.iterator();
        try {
            while (definition == null && dictionaries.hasNext()){
                Dictionary dictionary = dictionaries.next();
                definition = dictionary.getDefinition(world);
            }
        } catch (ServiceConfigurationError serviceError) {
            definition = null;
            serviceError.printStackTrace();
        }
        return definition;
    }

}
