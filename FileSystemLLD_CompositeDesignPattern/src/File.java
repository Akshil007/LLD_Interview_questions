import java.util.List;

public class File implements FileSystem{
    private String name;
    private FSType type;
    private String content;

    public File(String name) {
        this.name = name;
        type = FSType.FILE;
        content = "";
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<FileSystem> getFileSystemList() {
        throw new RuntimeException("unsupported operation from file");
    }

    public FSType getType() {
        return type;
    }


    @Override
    public void ls() {
        System.out.println("File name:" + name);
    }

    @Override
    public void mkdir(String name) {
        throw new RuntimeException("Can not create directory inside file");
    }

    @Override
    public void touch(String name) {
        throw new RuntimeException("Can not create file inside file");
    }

    @Override
    public void rm(String name) {
        throw new RuntimeException("Can not remove file inside file");
    }

    @Override
    public void vi(String content) {
        this.content = content;
    }

    @Override
    public void cat() {
        System.out.println(content);
    }


}
