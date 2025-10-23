package Sub;

import Model.Message;

public class PrintSubscriber implements Subscriber{
    @Override
    public Runnable onReceivingMsg(Message message) {
        System.out.println(message.toString());
        return null;
    }
}
