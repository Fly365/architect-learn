package cn.learn.architect;

/**
 * 可见 spi 的核心机制是接口到具体实现类的关联由一个文件描述。
 * 总结 spi 的服务描述文件的要素。
 * 1、文件通常要放在某个约定的目录（上面 demo 中使用的java spi 规定的就是META-INF/services）
 * 2、文件名和文件内容要体现接口和实现类的关联（java spi 中该文件名需为接口名，文件内容为实现类全限定名）
 * 3、文件可以编写多份，都能被相关加载类加载（这样框架可以有内置的实现类，同时用户和第三方扩展包可以加入自己写的实现类扩展功能）
 *上面的demo 中，框架始终只面向 Dictionary 接口编写功能。具体的字典实现类由java spi 获取。而用户可以在不侵入框架代码的情况下，通过编写约定的描述文件，让框架加载用户自己编写的实现类，扩展功能实现插件化。
 * 当然除了用户（业务程序员）自己编写以外，引入第三方编写的插件 jar 包也可以实现相同的扩展效果。此时第三方的 jar包需包含：扩展的实现类+服务描述文件
 * 具体的 spi 实现过程中还有很多细节，比如要大量使用Map 做缓存以加快非首次访问的速度，比如接口的实现类都需要提供无参数构造器方便进行实例化等等。
 * @author Fly365
 * @date 2022-04-02
 */
public class AppMain {

    public static void main(String[] args){
        DictionaryService service = DictionaryService.getInstance();
        System.out.println(service.getDefinition("中文"));
    }


}
