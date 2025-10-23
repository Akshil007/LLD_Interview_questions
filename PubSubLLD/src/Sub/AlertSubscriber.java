package Sub;

import Model.Message;

public class AlertSubscriber implements Subscriber{
    @Override
    public Runnable onReceivingMsg(Message message) {
        System.out.println("Alert devs, we have received a new msg: " + message.toString());
        return null;
    }
}
