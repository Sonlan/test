package song.basis.annotationTest.DBUtils;

/**
 * Created by Song on 2016/10/25.
 * JavaBean 测试DB标签
 */
@DBTable(name = "member")
public class Member {
    @SQLString(30) String firstName;
    @SQLString(50) String lastName;
    @SQLInteger int age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handler;

    static  int memberCount;
    public Member(String fname,String lname,int age,String handler){
        this.firstName = fname;
        this.lastName = lname;
        this.age = age;
        this.handler = handler;
    }
    @Override
    public String toString(){
        return handler;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getHandler() {
        return handler;
    }

}
