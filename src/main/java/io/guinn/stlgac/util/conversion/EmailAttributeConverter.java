package io.guinn.stlgac.util.conversion;

import io.guinn.stlgac.GACObject;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EmailAttributeConverter extends GACObject implements AttributeConverter<InternetAddress, String> {

    @Override
    public String convertToDatabaseColumn(InternetAddress internetAddress) {
        return internetAddress != null ? internetAddress.getAddress() : "";
    }

    @Override
    public InternetAddress convertToEntityAttribute(String dbData) {
        try {
            return new InternetAddress(dbData);
        } catch (AddressException e) {
            return null;
        }
    }
}
