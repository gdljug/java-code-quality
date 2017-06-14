package application;

import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaField;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class QDoxAnalizer {

    public void runAnalysis() {

        try {

            String sourcePath = "/home/skuarch/JavaProjects/java-code-quality/spring-qdox/src/main/java";
            File file = new File(sourcePath + "/application/IndexController.java");

            JavaProjectBuilder jpb = new JavaProjectBuilder();
            jpb.addSource(file);

            List<JavaClass> classes = getJavaClasses(jpb);

            classes.forEach((classe) -> {

                List<String> imports = classe.getSource().getImports();

                imports.forEach((impo) -> {

                    if (impo.equalsIgnoreCase("org.springframework.web.bind.annotation.RestController")) {
                        List<JavaField> fields = classe.getFields();
                        fields.forEach((field) -> {

                            try {
                                
                                String canonnicalName = field.getType()
                                        .getCanonicalName()
                                        .replace(".", "/")
                                        .concat(".java");
                                JavaProjectBuilder jpb1 = new JavaProjectBuilder();
                                File file1 = new File(sourcePath + "/" + canonnicalName);
                                jpb1.addSource(file1);
                                
                                List<JavaClass> classesField = getJavaClasses(jpb1);
                                
                                classesField.forEach((javaClass) -> {
                                    List<String> importsField = javaClass.getSource().getImports();
                                    
                                    importsField.forEach((imp) -> {
                                        if(imp.equalsIgnoreCase("org.springframework.stereotype.Repository")) {
                                            try {
                                                throw new Exception("invalid use of repository !!");
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    });
                                    
                                });
                                
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        });
                    }

                });

            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private List<JavaClass> getJavaClasses(JavaProjectBuilder jpb) {

        return jpb.getClasses()
                .stream()
                .collect(Collectors.toList());

    }

}
