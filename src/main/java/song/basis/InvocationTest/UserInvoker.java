package song.basis.InvocationTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Song on 2017/8/25.
 */
public class UserInvoker implements InvocationHandler {
    private IUser user;
    public UserInvoker(IUser user){
        this.user = user;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin");
        String str = (String) method.invoke(user,args);
        System.out.println("end");
        return str;
    }
}
