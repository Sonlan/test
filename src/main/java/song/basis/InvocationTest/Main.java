package song.basis.InvocationTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Song on 2017/8/25.
 */
public class Main {
    public static void main(String [] args){
        IUser user = new User();
        InvocationHandler invocationHandler = new UserInvoker(user);
        IUser userProxy = (IUser) Proxy.newProxyInstance(user.getClass().getClassLoader(),user.getClass().getInterfaces(),invocationHandler);
        System.out.println(userProxy.sayHellow());
    }
}
