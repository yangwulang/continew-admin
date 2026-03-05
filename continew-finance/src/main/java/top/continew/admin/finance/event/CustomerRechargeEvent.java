/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.finance.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import top.continew.admin.finance.model.entity.FinAccountTransactionDO;
import top.continew.admin.finance.model.req.FinAccountTransactionReq;

/**
 * 客户充值事件，当客户充值后会发出此事件
 * 
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
