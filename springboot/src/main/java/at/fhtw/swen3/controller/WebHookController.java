package at.fhtw.swen3.controller;

import java.util.ArrayList;
import java.util.List;

import at.fhtw.swen3.persistence.repositories.WebhookRepository;
import at.fhtw.swen3.services.dto.WebHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks")
public class WebHookController {
    private final static Logger logger = LoggerFactory.getLogger(WebHookController.class);

    private final WebhookRepository webHookRepository;

    @Autowired
    public WebHookController(WebhookRepository webHookRepository) {
        super();
        this.webHookRepository = webHookRepository;
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.TEXT_MARKDOWN_VALUE)
    public ResponseEntity<String> addWebHook(@RequestBody WebHook webHook){
        logger.info("New webhook for " + webHook.getType() + " is registered");
        List<WebHook> webhooks = webHookRepository.findByTypeAndData(
                webHook.getType(),
                webHook.getData());
        if(webhooks != null && webhooks.contains(webHook)){
            return new ResponseEntity<>("Webhook already exists", HttpStatus.OK);
        }
        webHookRepository.save(webHook);
        return new ResponseEntity<>("Successfully", HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WebHook>> getAllWebHooks(){
        List<WebHook> webhooks = new ArrayList<>();
        webHookRepository.findAll().iterator().forEachRemaining(webhooks::add);
        return new ResponseEntity<List<WebHook>>(webhooks, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,
            value ="/components/{type}/{data}",
            produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebHook> getWebHooksByCompanyNameAndType(
            @PathVariable String type,
            @PathVariable String data){
        List<WebHook> webhooks = webHookRepository.findByTypeAndData(
                type, data);
        return new ResponseEntity<WebHook>(webhooks.get(0), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            value ="/components/{types}/{data}",
            produces=MediaType.TEXT_MARKDOWN_VALUE)
    public ResponseEntity<String> removeWebHook(
            @PathVariable String type,
            @PathVariable String data){
        List<WebHook> webhooks = webHookRepository.findByTypeAndData(
                type, data);
        if(!webhooks.isEmpty()){
            webHookRepository.delete(webhooks.get(0));
            return new ResponseEntity<>("WebHook was successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Webhook doesn't exist.", HttpStatus.OK);
    }
    /*

    @RequestMapping(method = RequestMethod.DELETE,value ="/ids/{id}",
            produces=MediaType.TEXT_MARKDOWN_VALUE)
    public ResponseEntity<String> removeWebHookById(@PathVariable Long id){
        WebHook webhook= webHookRepository.findOne(id);
        if(webhook != null){
            webHookRepository.delete(webhook);
            return new ResponseEntity<>("WebHook was successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Webhook doesn't exist.", HttpStatus.OK);
    }
    */
}
