package song.mode;

import java.util.ArrayList;

/**
 * Created by Song on 2016/8/29.
 */
public class CloneModel implements Cloneable{
    private ArrayList<String> arrayList = new ArrayList<String>();
    private String str;
    private int num_int = 0;
    private Integer num_integer = 0;

    public String getArrayList() {
        return arrayList.toString();
    }

    public void setArrayList(String str) {
        this.arrayList.add(str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum_int() {
        return num_int;
    }

    public void setNum_int(int num_int) {
        this.num_int = num_int;
    }

    public Integer getNum_integer() {
        return num_integer;
    }

    public void setNum_integer(Integer num_integer) {
        this.num_integer = num_integer;
    }

    @Override
    protected CloneModel clone(){
        CloneModel cloneModel = null;
        try{
            cloneModel = (CloneModel)super.clone();
            cloneModel.arrayList = (ArrayList<String>)this.arrayList.clone();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return cloneModel;
    }

    public static void main(String [] args){
        //原始对象赋值
        CloneModel model = new CloneModel();
        model.setArrayList("First");
        model.setNum_int(1);
        model.setNum_integer(1);
        model.setStr("First");
        //打印复制后的对象各成员变量值
        System.out.println("clone后，clone对象值：");
        CloneModel cloneModel = model.clone();
        System.out.println(cloneModel.getArrayList());
        System.out.println(cloneModel.getNum_int());
        System.out.println(cloneModel.getNum_integer());
        System.out.println(cloneModel.getStr());
        //改变复制后的对象各成员变量值
        cloneModel.setArrayList("Second");
        cloneModel.setNum_int(2);
        cloneModel.setNum_integer(2);
        cloneModel.setStr("Second");
        //打印原始对象成员变量值
        System.out.println("改变clone对象值之后，原始对象值：");
        System.out.println(model.getArrayList());
        System.out.println(model.getNum_int());
        System.out.println(model.getNum_integer());
        System.out.println(model.getStr());


    }
}
