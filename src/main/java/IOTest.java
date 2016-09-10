import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by Song on 2016/7/26.
 */
public class IOTest {
    public static void main(String [] args){
        File path = new File(".");
        String [] list;
        if(args.length==0)
            list = path.list();
        else
            list = path.list(new DriFilter(args[0]));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String item:list)
            System.out.println(item);

    }
}

class DriFilter implements FilenameFilter{
    private Pattern pattern;
    public DriFilter(String regx){
        pattern = Pattern.compile(regx);
    }
    /**
     * Tests if a specified file should be included in a file list.
     *
     * @param dir  the directory in which the file was found.
     * @param name the name of the file.
     * @return <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}