package org.revo.fogserver.Domain;

public class Message {
    private int value;

    public Message() {
    }

    public Message(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "value=" + value +
                '}';
    }
}
