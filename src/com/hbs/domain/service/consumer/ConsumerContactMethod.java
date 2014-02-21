package com.hbs.domain.service.consumer;

import com.hbs.domain.common.ContactMethod;

import javax.persistence.*;

/**
 * Created by Administrator on 14-2-18.
 */
@Entity
@DiscriminatorValue("C")
public class ConsumerContactMethod extends ContactMethod {
  private static final long serialVersionUID = 1L;
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, optional = false)
    @JoinColumn(name = "USER_ID")
    private Consumer consumer;

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}
