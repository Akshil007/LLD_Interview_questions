//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cache<Integer, Integer> cache = new Cache<>(100);
        cache.put(1,10);
        int val = cache.get(1);
    }
}