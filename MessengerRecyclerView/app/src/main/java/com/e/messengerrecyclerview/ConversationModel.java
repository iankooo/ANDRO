package com.e.messengerrecyclerview;

public class ConversationModel {
    private String message;
    private boolean isEmitter;

    public ConversationModel(String message, boolean isEmitter){
        this.message = message;
        this.isEmitter = isEmitter;
    }
    public String getMessage(){
        return this.message;
    }
    public boolean isEmitter(){
        return this.isEmitter;
    }
}
