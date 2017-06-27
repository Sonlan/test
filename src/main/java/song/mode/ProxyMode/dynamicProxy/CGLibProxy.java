package song.mode.ProxyMode.dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Song on 2017/6/24.
 */
public class CGLibProxy implements MethodInterceptor{

    //
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //before
        Object result = methodProxy.invoke(o,objects);
        //after
        return result;
    }

    public <T>T getProxy(Class<T> cls){
        return (T) Enhancer.create(cls,this);
    }
}
