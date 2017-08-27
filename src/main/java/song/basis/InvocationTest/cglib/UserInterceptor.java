package song.basis.InvocationTest.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Song on 2017/8/25.
 */
public class UserInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //method.invoke(o,objects);
        //methodProxy.invoke(o,objects);
        methodProxy.invokeSuper(o,objects);
        return null;
    }
}
