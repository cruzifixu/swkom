package at.fhtw.swen3.services.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Setter
@Getter
@Table(name = "webhook", schema="webhook")
public class WebHook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="url")
    private String url;

    @Column(name="type")
    private String type;

    @Column(name="data")
    private String data;

    public WebHook() {
        super();
        // TODO Auto-generated constructor stub
    }

    public WebHook(Long id, String url, String type, String data) {
        super();
        this.id = id;
        this.url = url;
        this.type = type;
        this.data = data;
    }
}