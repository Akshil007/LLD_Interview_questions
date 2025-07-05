//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session = new Session();
        System.out.println(session.getCurrentDirectory().getName());

        session.pwd();

        // create a dir
        session.mkdir("user");
        session.ls();

        //cd
        session.cd("user");


        // touch
        session.touch("file1");
        session.cd("file1");
        session.vi("hello world!!");

        //cat
        session.cat();
        //unsupported operation
//        session.mkdir("file2");

        //cd back
        session.cd("../..");
        // file not found exception
//        session.cd("../user2");

        //rm
        session.cd("user");
        session.mkdir("dir2");
        session.touch("file3");
        session.ls();
        session.rm("file3");
        session.ls();

    }
}