package cn.learn.spi;

/**
 * @author Fly365
 * @date 2022-04-02
 */
public class EnDictionary implements cn.learn.architect.spi.Dictionary{
    @Override
    public String getDefinition(String world) {
        if(world.matches("[a-zA-Z]+")){
            return "looking for english dictionary.....";
        }
        return null;
    }
}
