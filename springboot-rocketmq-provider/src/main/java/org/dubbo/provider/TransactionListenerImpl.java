package org.dubbo.provider;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

// rocketmq事务消息
@RocketMQTransactionListener
class TransactionListenerImpl implements RocketMQLocalTransactionListener {

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        // 执行本地事务，如果是COMMIT则消息发送成功，如果是ROLLBACK则直接丢弃消息，如果是UNKNOWN则调用checkLocalTransaction()
        try {
            System.out.println("executeLocalTransaction");
        }catch (Exception e){
            e.printStackTrace();
            return RocketMQLocalTransactionState.UNKNOWN;
        }
        return RocketMQLocalTransactionState.COMMIT;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        // 检查本地事务（最多调用15次，如果全部失败则ROLLBACK丢弃消息）
        System.out.println("checkLocalTransaction");
        return RocketMQLocalTransactionState.COMMIT;
    }
}