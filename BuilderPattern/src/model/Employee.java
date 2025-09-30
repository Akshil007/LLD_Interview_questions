package model;

public class Employee {
    private String name;
    private int id;
    private String address;
    private String moNumber;


    private Employee(Builder builder){
        name = builder.name;
        id = builder.id;
        address = builder.address;
        moNumber = builder.moNumber;
    }

    public static class Builder {
        private String name;
        private int id;
        private String address;
        private String moNumber;

        public Builder name(String s){
            this.name = s;
            return this;
        }
        public Builder id(int s){
            this.id = s;
            return this;
        }
        public Builder address(String s){
            this.address = s;
            return this;
        }
        public Builder moNumber(String s){
            this.moNumber = s;
            return this;
        }
        public Employee build(){
            return new Employee(this);
        }
    }
}
