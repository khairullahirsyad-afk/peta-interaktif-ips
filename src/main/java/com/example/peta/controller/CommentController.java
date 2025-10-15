package com.example.peta.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class CommentController {

    @MessageMapping("/sendComment")
    @SendTo("/topic/comments")
    public CommentMessage broadcastComment(CommentMessage message) {
        System.out.println("Komentar diterima dari " + message.getUser() + ": " + message.getText());
        return new CommentMessage(
                HtmlUtils.htmlEscape(message.getUser()),
                HtmlUtils.htmlEscape(message.getText())
        );
    }

    // Inner class untuk pesan komentar
    public static class CommentMessage {
        private String user;
        private String text;

        public CommentMessage() {
        }

        public CommentMessage(String user, String text) {
            this.user = user;
            this.text = text;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }
}
