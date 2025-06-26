动态代理：在程序的执行过程中，使用jdk的反射机制，创建代理类对象（不用创建类文件），并动态的指定要代理的目标类（代理的目标类是活动的，可变的）。
换句话说：动态代理是一种创建java对象的能力，让你不用创建TaoBao类，就能创建代理对象

动态代理的实现：
1.jdk动态代理：使用java反射包中的类和接口实现动态代理的功能。   如果接口中有多个方法需要被代理呢？？？？？
反射包 java.lang.reflect,里面有三个类，InvocationHandler,Method,Proxy
在实现动态代理之前，先了解反射怎么执行Method的；举例：HelloService helloservice=new HelloServiceImpl();
Object obj=method.invoke(helloservice,"参数值")

1）InvocationHandler接口（调用处理器），就一个方法invoke()
invoke():表示代理对象要执行的功能代码，你的代理类要执行的功能就写在invoke()方法中。
代理类完成的功能：
1，调用目标方法,执行目标方法的功能
2.功能增强，在目标方法调用时，增强功能

方法原型：public Object invoke(Object proxy, Method method, Object[] args)
参数：Object proxy：jdk创建的代理对象，无需赋值
     Method method ： 目标类中的方法，jdk提供method对象的
     Object[] args： 目标类中方法的参数，jdk提供的
怎么用：1.创建类实现接口InvocationHandler
2.重写invoke()方法，把原来静态代理中代理类要完成的功能写在这。
2）Method类：表示方法的，确切的来说就是目标类中的方法。
   作用：通过Method可以执行某个目标类的方法，Method.invoke()，这个invoke方法不是InvocationHandler的invoke方法，只是恰好重名而已
   method.invoke(目标对象，方法的参数)
   Object obj=method.invoke(helloservice,"参数值")
说明：method.invoke() 就是用来执行目标方法的，等同于静态代理中的->
//向厂家发送订单，告诉厂家，买了U盘，进行加价，这一步就是代理增强
float price=factory.sell(amount);
3)Proxy类：核心的对象，创建代理对象。之前创建的对象都是new类的构造方法()，现在我们是使用Proxy类的方法，代替new的使用。
  方法：静态方法newProxyInstance()
  作用是：创建代理对象，等同于静态代理中的TaoBao taoBao=new TaoBao();
    public static Object newProxyInstance(ClassLoader loader,
    Class<?>[] interfaces,
    InvocationHandler h)
  参数,1.ClassLoader loader 类加载器，负责向内存加载对象的，使用反射获取对象的ClassLoader。类a a.getClass().getClassLoader(),得到目标对象的类加载器
  2.Class<?>[] interfaces ： 接口，目标对象实现的接口，也是反射获取的
  3.InvocationHandler h，我们自己写的，代理类要完成的功能。
  返回值：就是代理对象

2.cglib动态代理，cglib是第三方的工具类库，创建代理对象
cglib的原理是继承，cglib通过继承目标类，创建它的子类，在子类中重写父类中同名的方法，实现功能的修改。因为cglib是继承，重写方法，所以要求目标类不能是final
的，cglib的要求目标类比较宽松，只要能继承就行了。在mybatis，spring框架中都有用到


3.实现动态代理的步骤
1）创建接口，定义目标类要完成功能
2）创建目标类实现接口
3）创建InvocationHandler接口的实现类，在invoke方法中完成代理类的功能
  1.调用目标方法
  2.增强功能
4）使用Proxy类的静态方法，创建代理对象。并把返回值转为接口类型
