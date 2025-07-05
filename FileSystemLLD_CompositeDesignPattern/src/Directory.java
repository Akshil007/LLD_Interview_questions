import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    private List<FileSystem> fileSystemList;
    private String name;
    private FSType type;

    @Override
    public String getName() {
        return name;
    }

    public FSType getType() {
        return type;
    }

    public List<FileSystem> getFileSystemList() {
        return fileSystemList;
    }

    public Directory(String name) {
        this.fileSystemList = new ArrayList<>();
        this.name = name;
        type = FSType.DIRECTORY;
    }

    @Override
    public void ls() {
        System.out.println("Current directory:" + name);
        for(FileSystem fs: fileSystemList){
            fs.ls();
        }
    }

    @Override
    public void mkdir(String name) {
        FileSystem newDirectory = new Directory(name);
        fileSystemList.add(newDirectory);
    }

    @Override
    public void touch(String name) {
        FileSystem newFile = new File(name);
        fileSystemList.add(newFile);
    }

    @Override
    public void rm(String name) {
        for(FileSystem fs: fileSystemList){
            if(name.equals(fs.getName())) {
                fileSystemList.remove(fs);
                break;
            }
        }
    }

    @Override
    public void vi(String content) {
        throw new RuntimeException("Not supported operation in dir");
    }

    @Override
    public void cat() {
        throw new RuntimeException("Not supported operation in dir");
    }
}
