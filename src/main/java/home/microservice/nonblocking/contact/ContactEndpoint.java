package home.microservice.nonblocking.contact;

import io.advantageous.qbit.annotation.PathVariable;
import io.advantageous.qbit.annotation.RequestMapping;
import io.advantageous.qbit.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@RequestMapping("/contacts")
@Component
public class ContactEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(ContactEndpoint.class);

    @Autowired
    private ContactService service;

    @RequestMapping(value = "",  method = RequestMethod.GET, contentType = "application/json")
    public List<ContactDomainDTO> get(){
        return service.getAllContacts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, contentType = "application/json")
    public ContactDomainDTO getOne(@PathVariable("id") Long id){
        return service.getOneContact(id);}
}
