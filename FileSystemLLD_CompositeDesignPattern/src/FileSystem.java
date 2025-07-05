import java.util.List;

public interface FileSystem {
    void ls();
    void mkdir(String name);
    void touch(String name);
    void rm(String name);
    void vi(String content);
    void cat();
    String getName();
    List<FileSystem> getFileSystemList();
}
