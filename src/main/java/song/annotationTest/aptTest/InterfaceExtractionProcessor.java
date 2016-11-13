package song.annotationTest.aptTest;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by Song on 2016/10/27.
 * 注解处理器
 */
public class InterfaceExtractionProcessor implements AnnotationProcessor{
    private final AnnotationProcessorEnvironment env;
    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<MethodDeclaration>();

    public InterfaceExtractionProcessor(AnnotationProcessorEnvironment env){
        this.env = env;
    }

    public void process() {
        for(TypeDeclaration td:env.getSpecifiedTypeDeclarations()){
            ExtractInterface ei = td.getAnnotation(ExtractInterface.class);
            if(null == ei) break;
            for(MethodDeclaration md : td.getMethods()){
                if(md.getModifiers().contains(Modifier.PUBLIC) && !md.getModifiers().contains(Modifier.STATIC)){
                    interfaceMethods.add(md);
                }
            }
            //生成Interface源文件
            if(0<interfaceMethods.size()){
                try {
                    PrintWriter writer = env.getFiler().createSourceFile(ei.value());
                    writer.println("package "+td.getPackage().getQualifiedName()+";");
                    writer.println("public interface "+ei.value()+" {");
                    for(MethodDeclaration m:interfaceMethods){
                        writer.print(" public ");
                        writer.print(m.getReturnType()+" ");
                        writer.print(m.getSimpleName()+" (");
                        int i=0;
                        for(ParameterDeclaration parm:m.getParameters()){
                            writer.print(parm.getType()+" "+parm.getSimpleName());
                            if(++i<m.getParameters().size()){
                                writer.print(", ");
                            }
                        }
                        writer.print(")");
                    }
                    writer.println("}");
                    writer.close();
                }catch (IOException e){
                    throw  new RuntimeException(e);
                }
            }
        }
    }
}
