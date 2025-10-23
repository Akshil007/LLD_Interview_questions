package Sub;

import Model.Message;

public interface Subscriber {
    Runnable onReceivingMsg(Message message);
}
