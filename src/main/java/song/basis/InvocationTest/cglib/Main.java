package song.basis.InvocationTest.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Song on 2017/8/25.
 */
public class Main {
    public static void main(String [] args){
        MethodInterceptor interceptor = new UserInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(interceptor);
        //enhancer.setSuperclass(User.class);
        enhancer.setInterfaces(new Class[]{IUser.class});
        IUser user = (IUser) enhancer.create();
        user.sayHellow();
    }
}
