package home.microservice.nonblocking.contact;

import home.microservice.nonblocking.contact.dao.Tables;
import home.microservice.nonblocking.contact.dao.tables.Address;
import home.microservice.nonblocking.contact.dao.tables.Contact;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private DSLContext context;

    public List<ContactDomainDTO> getAllContacts(){
        Result<Record> records = context
                .select()
                .from(Contact.CONTACT)
                .innerJoin(Address.ADDRESS).on(Contact.CONTACT.ADDRESS_ID.eq(Address.ADDRESS.ID))
                .limit(0, 10)
                .fetch();
        return records.stream()
                .map(r -> new ContactDomainDTO(r.into(Tables.CONTACT), r.into(Tables.ADDRESS)))
                .collect(Collectors.toList());
    }

    public ContactDomainDTO getOneContact(Long id){
        Record r = context
                .select()
                .from(Contact.CONTACT)
                .innerJoin(Address.ADDRESS).on(Contact.CONTACT.ADDRESS_ID.eq(Address.ADDRESS.ID))
                .where(Contact.CONTACT.ID.eq(id))
                .fetchOne();
        return new ContactDomainDTO(r.into(Tables.CONTACT), r.into(Tables.ADDRESS));
    }
}
