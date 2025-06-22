public class Starttest {
    public int add(){
        return 3;
    }

    public static void main(String[] args) {

        /**
         * `getClass().getClassLoader().getResource("")`获取的是编译后的classes目录的路径，而不是源代码目录。
         * 在Windows环境下，路径分隔符是`\`，但在Java代码中，路径分隔符通常使用`/`。
         *
         * mvc 动态规划
         *
         *
         * classpath是什么路径？
         * 1.classpath指的是类路径，也就是编译之后的target文件夹下的WEB-INF/class文件夹。
         *
         * 2.resources文件夹存放的是各种配置文件，当项目被编译时resources下的所有配置文件均被放在 WEB-INF/class文件夹下。也就是类路径下。
         */
        System.out.println(Starttest.class.getClassLoader().getResource("")); //file:/C:/Users/xl/IdeaProjects/CodeLearning/MockitoLearning/target/classes/
    }
}
