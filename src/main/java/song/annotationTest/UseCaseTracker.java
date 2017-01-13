package song.annotationTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Song on 2016/10/25.
 * UseCase处理器
 */
public class UseCaseTracker {
    public static void trackUseCase(List<Integer> useCases,Class<?> cl){
        for (Method m :cl.getDeclaredMethods()){
            UseCase useCase = m.getAnnotation(UseCase.class);
            if(null != useCase){
                System.out.println("Found UseCase: id("+useCase.id()+") description("+useCase.description()+")");
                useCases.remove(new Integer(useCase.id()));
            }
        }
        for(int i:useCases){
            System.out.println("Warming: Missing UseCase-"+i);
        }
    }

    public static void main(String [] args){
        List<Integer> useCases = new ArrayList<Integer>(Arrays.asList(47,48,49,50));
        trackUseCase(useCases,PasswdUtils.class);
    }
}
