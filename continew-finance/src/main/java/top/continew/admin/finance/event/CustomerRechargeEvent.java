package top.continew.admin.finance.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.req.FinAccountTransactionReq;

/**
 * 客户充值事件，当客户充值后会发出此事件
 * @author yangwulang
 */
@Getter
public class CustomerRechargeEvent extends ApplicationEvent {
    private final FinAccountTransactionReq req;
    private final FinAccountTransactionDO entity;

    public CustomerRechargeEvent(Object source, FinAccountTransactionReq req, FinAccountTransactionDO entity) {
        super(source);
        this.req = req;
        this.entity = entity;
    }
}
