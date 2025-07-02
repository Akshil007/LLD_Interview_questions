public class NullObject implements Vehicle{
    @Override
    public void start() {
        System.out.println("No engine, because null selected");
    }
}
