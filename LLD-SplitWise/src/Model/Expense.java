package Model;

import java.util.List;
import java.util.UUID;

public class Expense {
    String id;
    String description;
    User paidBy;
    String groupId;
    double amount;
    List<User> participants;
    SplitType splitType;
    List<Split> splits;

    private Expense(Builder builder) {
        this.id = builder.id;
        this.splitType = builder.splitType;
        this.participants = builder.participants;
        this.amount = builder.amount;
        this.paidBy = builder.paidBy;
        this.description = builder.description;
    }

    // builder pattern
    public static class Builder{
        String id = UUID.randomUUID().toString();
        String description = "";
        User paidBy;
        double amount;
        List<User> participants;
        SplitType splitType;

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }

        public Builder setSplitType(SplitType splitStrategy) {
            this.splitType = splitStrategy;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public Expense build(){
            return new Expense(this);
        }
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public String getId() {
        return id;
    }


    public List<User> getParticipants() {
        return participants;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public String getDescription() {
        return description;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
