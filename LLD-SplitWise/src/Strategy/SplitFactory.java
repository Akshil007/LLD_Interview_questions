package Strategy;


import Model.SplitType;


public class SplitFactory {
    private SplitFactory(){
    }

    public static SplitStrategy getSplitStrategy(SplitType splitType){
        switch (splitType){
            case EQUAL -> {
                return new EqualSplitStrategy();
            }
            default -> {
                throw new RuntimeException("unsupporetd splittype");
            }
        }
    }
}
