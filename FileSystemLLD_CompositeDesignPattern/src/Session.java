import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Session {
    private FileSystem currentDirectory;
    private Stack<FileSystem> stack;

    public Session() {
        FileSystem root = new Directory("root");
        currentDirectory = root;
        stack = new Stack<>();
        stack.push(root);
    }

    public FileSystem getCurrentDirectory() {
        return currentDirectory;
    }

    public void cd(String path){
        String[] dirs = path.split("/");
        for(String part: dirs){
            if(part.equals("..")){
                stack.pop();
            } else {
                currentDirectory = stack.peek();
                List<FileSystem> dirList = currentDirectory.getFileSystemList();
                boolean found = false;
                for(FileSystem fs: dirList){
                    if(fs.getName().equals(part)){
                        stack.push(fs);
                        currentDirectory = fs;
                        found  = true;
                        break;
                    }
                }
                if(!found){
                    throw new RuntimeException("File not found ");
                }

            }
        }
        currentDirectory = stack.peek();
        pwd();
    }

    public void pwd(){
        List<FileSystem> printList = new ArrayList<>(stack);
        for(FileSystem fs: printList){
            System.out.print("/"+fs.getName());
        }
        System.out.println();
    }

    public void ls() {
        currentDirectory.ls();
    }


    public void mkdir(String name) {
        currentDirectory.mkdir(name);
    }

    public void touch(String name) {
        currentDirectory.touch(name);
    }


    public void rm(String name) {
        currentDirectory.rm(name);
    }

    public void vi(String content) {
        currentDirectory.vi(content);
    }

    public void cat() {
        currentDirectory.cat();
    }

}
