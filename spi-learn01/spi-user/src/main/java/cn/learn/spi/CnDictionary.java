package cn.learn.spi;

/**
 * @author Fly365
 * @date 2022-04-02
 */
public class CnDictionary implements cn.learn.architect.spi.Dictionary{
    @Override
    public String getDefinition(String world) {
        if(!world.matches("[a-zA-Z]+")){
            return "查找中文字典.....";
        }
        return null;
    }
}
