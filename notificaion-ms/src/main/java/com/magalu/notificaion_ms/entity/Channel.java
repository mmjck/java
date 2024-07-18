package com.magalu.notificaion_ms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_channel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Channel {

    @Id
    private Long id;

    private String description;

    public enum Values {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH_NOTIFICATION(3L, "push_notification"),
        WHATSAPP(4L, "whatsapp");

        private Long id;
        private String description;

        Values(Long id, String description) {
            this.id = id;
            this.description = description;
        }

        public Channel toChannel() {
            return new Channel(id, description);
        }
    }

}
