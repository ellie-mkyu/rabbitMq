package com.test.rabbitmqpublish.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class SendingModel {
    private final String username;
    private final String message;

    @Builder
    public SendingModel(
            String username,
            String message
    ) {
        this.username = username;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SendingModel that = (SendingModel) o;
        return Objects.equals(username, that.username) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, message);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SendingModel{");
        sb.append("username='").append(username).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
