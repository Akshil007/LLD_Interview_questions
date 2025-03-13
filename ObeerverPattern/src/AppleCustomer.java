public class AppleCustomer implements Customer{
    String name;
    AppleCustomer(String s){
        name = s;
    }

    @Override
    public void update() {
        System.out.println("for " + name + " iphones are available");
    }

//    printlnublic void notifyMe(){
//
//    }
}
