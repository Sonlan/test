package song.basis.annotationTest.aptTest;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Song on 2016/10/27.
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory{
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }

    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("song.annotationTest.aptTest.ExtractInterface");
    }

    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
        return new InterfaceExtractionProcessor(annotationProcessorEnvironment);
    }
}
