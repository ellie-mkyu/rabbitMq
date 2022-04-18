package com.test.rabbitmq;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Getter
public class ReceivedMessageModel {
    private final String username;
    private final String message;

    public ReceivedMessageModel(
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
        ReceivedMessageModel that = (ReceivedMessageModel) o;
        return Objects.equals(username, that.username) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, message);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ReceivedMessageModel{");
        sb.append("username='").append(username).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
